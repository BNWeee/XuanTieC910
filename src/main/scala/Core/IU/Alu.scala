package Core.IU


import Core.IUConfig
import Utils.{LookupTree, SignExt}
import chisel3._
import chisel3.util._

object ALUOpType {
  def add  = "b1000000".U
  def sll  = "b0000001".U
  def slt  = "b0000010".U
  def sltu = "b0000011".U
  def xor  = "b0000100".U
  def srl  = "b0000101".U
  def or   = "b0000110".U
  def and  = "b0000111".U
  def sub  = "b0001000".U
  def sra  = "b0001101".U
  def lui  = "b0001111".U

  def addw = "b1100000".U
  def subw = "b0101000".U
  def sllw = "b0100001".U
  def srlw = "b0100101".U
  def sraw = "b0101101".U
  def isWordOp(func: UInt) = func(5)  //if 32bit
}

class AluOut extends Bundle {
  val data = UInt(64.W)
  val data_vld = Bool()
  val fwd_data = UInt(64.W)
  val fwd_vld = Bool()
  val preg = UInt(7.W)
}

class AluIO extends Bundle{
  val in  = Input(new IduRfPipe0)
  val flush = Input(Bool())
  val out = Output(new AluOut)
}

class Alu extends Module with IUConfig{
  val io = IO(new AluIO)
  //----------------------------------------------------------
  //              Pipe2 EX1 Instruction valid
  //----------------------------------------------------------
  val alu_ex1_inst_vld = RegInit(false.B)
  val alu_ex1_fwd_vld  = RegInit(false.B)
  val flush = io.flush
  val fwd_vld = io.in.alu_short && io.in.sel && io.in.dstv_vld
  when(flush){
    alu_ex1_inst_vld := false.B
    alu_ex1_fwd_vld  := false.B
  }.otherwise{
    alu_ex1_inst_vld := io.in.sel
    alu_ex1_fwd_vld  := fwd_vld
  }
  //----------------------------------------------------------
  //               Pipe2 EX1 Instruction Data
  //----------------------------------------------------------
  val pipe1_en = WireInit(true.B) // TODO add gate_sel
  val ex1_pipe = RegEnable(io.in, pipe1_en)

  val (src1, src2, op) = (io.in.src0,io.in.src1, io.in.opcode)
  //----------------------------------------------------------
  //                    add && shift TODO misc
  //----------------------------------------------------------
  val shamt = Mux(ALUOpType.isWordOp(op), src2(4, 0), src2(5, 0))
  val res = LookupTree(op, List(
    ALUOpType.add   ->   (src1 + src2),
    ALUOpType.sll   ->   (src1 << shamt),
    ALUOpType.slt   ->   Cat(0.U((XLEN - 1).W), src1.asSInt < src2.asSInt),
    ALUOpType.sltu  ->   (src1 < src2),
    ALUOpType.xor   ->   (src1 ^ src2),
    ALUOpType.srl   ->   (src1 >> shamt),
    ALUOpType.or    ->   (src1 | src2),
    ALUOpType.and   ->   (src1 & src2),
    ALUOpType.sub   ->   (src1 - src2),
    ALUOpType.sra   ->   (src1.asSInt >> shamt).asUInt,
    ALUOpType.addw  ->   (src1 + src2),
    ALUOpType.subw  ->   (src1 - src2),
    ALUOpType.sllw  ->   (src1 << shamt),
    ALUOpType.srlw  ->   (src1(31,0) >> shamt),
    ALUOpType.sraw  ->   (src1(31,0).asSInt >> shamt).asUInt,
    ALUOpType.lui  ->    src2
  ))
  //==========================================================
  //                  Complete Bus signals
  //==========================================================
  // deal alu complete bus signal in cbus : ATTENSION  alu sel is en, means alu complete

  //==========================================================
  //                   Result Bus signals
  //==========================================================
  //----------------------------------------------------------
  //                      Result Bus
  //----------------------------------------------------------
  io.out.data_vld := ex1_pipe.dstv_vld && alu_ex1_inst_vld
  io.out.fwd_vld  := alu_ex1_fwd_vld
  io.out.fwd_data := Mux(ALUOpType.isWordOp(op), SignExt(res(31,0), 64), res)
  io.out.preg     := ex1_pipe.dst_preg
  io.out.data     := Mux(ALUOpType.isWordOp(op), SignExt(res(31,0), 64), res)
}

