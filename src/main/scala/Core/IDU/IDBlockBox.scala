package Core.IDU
import chisel3._
import chisel3.util._

//ct_idu_id_decd include ct_idu_id_decd_special
class ct_idu_id_decd extends BlackBox {
  val io = IO(new Bundle{
    val cp0_idu_cskyee = Input(Bool())
    val cp0_idu_frm = Input(UInt(3.W))
    val cp0_idu_fs = Input(UInt(2.W))
    val cp0_idu_vill = Input(Bool())
    val cp0_idu_vs = Input(UInt(2.W))
    val cp0_idu_vstart = Input(UInt(7.W))
    val cp0_idu_zero_delay_move_disable = Input(Bool())
    val cp0_yy_hyper = Input(Bool())
    val x_inst = Input(UInt(32.W))
    val x_vl = Input(UInt(8.W))
    val x_vlmul = Input(UInt(2.W))
    val x_vsew = Input(UInt(2.W))
    val x_dst_reg = Output(UInt(5.W))
    val x_dst_vld = Output(Bool())
    val x_dst_x0 = Output(Bool())
    val x_dste_vld = Output(Bool())
    val x_dstf_reg = Output(UInt(5.W))
    val x_dstf_vld = Output(Bool())
    val x_dstv_reg = Output(UInt(5.W))
    val x_dstv_vld = Output(Bool())
    val x_fence_type = Output(UInt(3.W))
    val x_fmla = Output(Bool())
    val x_fmov = Output(Bool())
    val x_illegal = Output(Bool())
    val x_inst_type = Output(UInt(10.W))
    val x_length = Output(Bool())
    val x_mla = Output(Bool())
    val x_mov = Output(Bool())
    val x_split_long_type = Output(UInt(10.W))
    val x_split_short_type = Output(UInt(7.W))
    val x_src0_reg = Output(UInt(5.W))
    val x_src0_vld = Output(Bool())
    val x_src1_reg = Output(UInt(5.W))
    val x_src1_vld = Output(Bool())
    val x_src2_vld = Output(Bool())
    val x_srcf0_reg = Output(UInt(5.W))
    val x_srcf0_vld = Output(Bool())
    val x_srcf1_reg = Output(UInt(5.W))
    val x_srcf1_vld = Output(Bool())
    val x_srcf2_reg = Output(UInt(5.W))
    val x_srcf2_vld = Output(Bool())
    val x_srcv0_reg = Output(UInt(5.W))
    val x_srcv0_vld = Output(Bool())
    val x_srcv1_reg = Output(UInt(5.W))
    val x_srcv1_vld = Output(Bool())
    val x_srcv2_vld = Output(Bool())
    val x_srcvm_vld = Output(Bool())
    val x_vmb = Output(Bool())
    val x_vmla = Output(Bool())
  })
}

class ct_idu_id_fence extends BlackBox{
  val io = IO(new Bundle{
    val cp0_idu_icg_en = Input(Bool())
    val cp0_yy_clk_en = Input(Bool())
    val cpurst_b = Input(Bool())
    val ctrl_fence_id_inst_vld = Input(Bool())
    val ctrl_fence_id_stall = Input(Bool())
    val ctrl_fence_ir_pipe_empty = Input(Bool())
    val ctrl_fence_is_pipe_empty = Input(Bool())
    val dp_fence_id_bkpta_inst = Input(Bool())
    val dp_fence_id_bkptb_inst = Input(Bool())
    val dp_fence_id_fence_type = Input(UInt(3.W))
    val dp_fence_id_inst = Input(UInt(32.W))
    val dp_fence_id_pc = Input(UInt(15.W))
    val dp_fence_id_vl = Input(UInt(8.W))
    val dp_fence_id_vl_pred = Input(Bool())
    val dp_fence_id_vlmul = Input(UInt(2.W))
    val dp_fence_id_vsew = Input(UInt(3.W))
    val forever_cpuclk = Input(Bool())
    val iu_idu_div_busy = Input(Bool())
    val iu_yy_xx_cancel = Input(Bool())
    val pad_yy_icg_scan_en = Input(Bool())
    val rtu_idu_flush_fe = Input(Bool())
    val rtu_idu_pst_empty = Input(Bool())
    val rtu_idu_rob_empty = Input(Bool())
    val fence_ctrl_id_stall = Output(Bool())
    val fence_ctrl_inst0_vld = Output(Bool())
    val fence_ctrl_inst1_vld = Output(Bool())
    val fence_ctrl_inst2_vld = Output(Bool())
    val fence_dp_inst0_data = Output(UInt(178.W))
    val fence_dp_inst1_data = Output(UInt(178.W))
    val fence_dp_inst2_data = Output(UInt(178.W))
    val fence_top_cur_state = Output(UInt(3.W))
    val idu_had_pipeline_empty = Output(Bool())
    val idu_hpcp_fence_sync_vld = Output(Bool())
    val idu_rtu_fence_idle = Output(Bool())
  })
}

class ct_idu_id_split_long extends BlackBox{
  val io = IO(new Bundle{
    val cp0_idu_icg_en = Input(Bool())
    val cp0_idu_vstart = Input(UInt(7.W))
    val cp0_yy_clk_en = Input(Bool())
    val cpurst_b = Input(Bool())
    val ctrl_split_long_id_inst_vld = Input(Bool())
    val ctrl_split_long_id_stall = Input(Bool())
    val dp_split_long_bkpta_inst = Input(Bool())
    val dp_split_long_bkptb_inst = Input(Bool())
    val dp_split_long_inst = Input(UInt(32.W))
    val dp_split_long_no_spec = Input(Bool())
    val dp_split_long_pc = Input(UInt(15.W))
    val dp_split_long_type = Input(UInt(10.W))
    val dp_split_long_vl = Input(UInt(8.W))
    val dp_split_long_vl_pred = Input(Bool())
    val dp_split_long_vlmul = Input(UInt(2.W))
    val dp_split_long_vsew = Input(UInt(3.W))
    val forever_cpuclk = Input(Bool())
    val iu_yy_xx_cancel = Input(Bool())
    val pad_yy_icg_scan_en = Input(Bool())
    val rtu_idu_flush_fe = Input(Bool())
    val split_long_ctrl_id_stall = Output(Bool())
    val split_long_ctrl_inst_vld = Output(UInt(4.W))
    val split_long_dp_dep_info = Output(UInt(17.W))
    val split_long_dp_inst0_data = Output(UInt(178.W))
    val split_long_dp_inst1_data = Output(UInt(178.W))
    val split_long_dp_inst2_data = Output(UInt(178.W))
    val split_long_dp_inst3_data = Output(UInt(178.W))
  })
}

class ct_idu_id_split_short extends BlackBox{
  val io = IO(new Bundle{
    val dp_split_short_bkpta_inst = Input(Bool())
    val dp_split_short_bkptb_inst = Input(Bool())
    val dp_split_short_inst = Input(UInt(32.W))
    val dp_split_short_no_spec = Input(Bool())
    val dp_split_short_pc = Input(UInt(15.W))
    val dp_split_short_type = Input(UInt(7.W))
    val dp_split_short_vl = Input(UInt(8.W))
    val dp_split_short_vl_pred = Input(Bool())
    val dp_split_short_vlmul = Input(UInt(2.W))
    val dp_split_short_vsew = Input(UInt(3.W))
    val split_short_dp_dep_info = Output(UInt(4.W))
    val split_short_dp_inst0_data = Output(UInt(178.W))
    val split_short_dp_inst1_data = Output(UInt(178.W))
  })
}

class ct_idu_ir_decd extends BlackBox{
  val io = IO(new Bundle{
    val x_illegal = Input(Bool())
    val x_opcode = Input(UInt(32.W))
    val x_type_alu = Input(Bool())
    val x_type_staddr = Input(Bool())
    val x_type_vload = Input(Bool())
    val x_vsew = Input(UInt(3.W))

    val x_alu_short = Output(Bool())
    val x_bar = Output(Bool())
    val x_bar_type = Output(UInt(4.W))
    val x_csr = Output(Bool())
    val x_ecall = Output(Bool())
    val x_fp = Output(Bool())
    val x_load = Output(Bool())
    val x_mfvr = Output(Bool())
    val x_mtvr = Output(Bool())
    val x_pcall = Output(Bool())
    val x_pcfifo = Output(Bool())
    val x_rts = Output(Bool())
    val x_store = Output(Bool())
    val x_str = Output(Bool())
    val x_sync = Output(Bool())
    val x_unit_stride = Output(Bool())
    val x_vamo = Output(Bool())
    val x_vdiv = Output(Bool())
    val x_vec = Output(Bool())
    val x_viq_srcv12_switch = Output(Bool())
    val x_vmla_short = Output(Bool())
    val x_vmla_type = Output(UInt(3.W))
    val x_vmul = Output(Bool())
    val x_vmul_unsplit = Output(Bool())
    val x_vsetvl = Output(Bool())
    val x_vsetvli = Output(Bool())
  })
}


class ct_idu_is_pipe_entry extends BlackBox {
  val io = IO(new Bundle{
    val cp0_idu_icg_en = Input(Bool())
    val cp0_yy_clk_en = Input(Bool())
    val cpurst_b = Input(Bool())
    val ctrl_xx_rf_pipe0_preg_lch_vld_dupx = Input(Bool())
    val ctrl_xx_rf_pipe1_preg_lch_vld_dupx = Input(Bool())
    val ctrl_xx_rf_pipe6_vmla_lch_vld_dupx = Input(Bool())
    val ctrl_xx_rf_pipe7_vmla_lch_vld_dupx = Input(Bool())
    val dp_xx_rf_pipe0_dst_preg_dupx = Input(UInt(7.W))
    val dp_xx_rf_pipe1_dst_preg_dupx = Input(UInt(7.W))
    val dp_xx_rf_pipe6_dst_vreg_dupx = Input(UInt(7.W))
    val dp_xx_rf_pipe7_dst_vreg_dupx = Input(UInt(7.W))
    val forever_cpuclk = Input(Bool())
    val iu_idu_div_inst_vld = Input(Bool())
    val iu_idu_div_preg_dupx = Input(UInt(7.W))
    val iu_idu_ex2_pipe0_wb_preg_dupx = Input(UInt(7.W))
    val iu_idu_ex2_pipe0_wb_preg_vld_dupx = Input(Bool())
    val iu_idu_ex2_pipe1_mult_inst_vld_dupx = Input(Bool())
    val iu_idu_ex2_pipe1_preg_dupx = Input(UInt(7.W))
    val iu_idu_ex2_pipe1_wb_preg_dupx = Input(UInt(7.W))
    val iu_idu_ex2_pipe1_wb_preg_vld_dupx = Input(Bool())
    val lsu_idu_ag_pipe3_load_inst_vld = Input(Bool())
    val lsu_idu_ag_pipe3_preg_dupx = Input(UInt(7.W))
    val lsu_idu_ag_pipe3_vload_inst_vld = Input(Bool())
    val lsu_idu_ag_pipe3_vreg_dupx = Input(UInt(7.W))
    val lsu_idu_dc_pipe3_load_fwd_inst_vld_dupx = Input(Bool())
    val lsu_idu_dc_pipe3_load_inst_vld_dupx = Input(Bool())
    val lsu_idu_dc_pipe3_preg_dupx = Input(UInt(7.W))
    val lsu_idu_dc_pipe3_vload_fwd_inst_vld = Input(Bool())
    val lsu_idu_dc_pipe3_vload_inst_vld_dupx = Input(Bool())
    val lsu_idu_dc_pipe3_vreg_dupx = Input(UInt(7.W))
    val lsu_idu_wb_pipe3_wb_preg_dupx = Input(UInt(7.W))
    val lsu_idu_wb_pipe3_wb_preg_vld_dupx = Input(Bool())
    val lsu_idu_wb_pipe3_wb_vreg_dupx = Input(UInt(7.W))
    val lsu_idu_wb_pipe3_wb_vreg_vld_dupx = Input(Bool())
    val pad_yy_icg_scan_en = Input(Bool())
    val rtu_idu_flush_fe = Input(Bool())
    val rtu_idu_flush_is = Input(Bool())
    val vfpu_idu_ex1_pipe6_data_vld_dupx = Input(Bool())
    val vfpu_idu_ex1_pipe6_fmla_data_vld_dupx = Input(Bool())
    val vfpu_idu_ex1_pipe6_mfvr_inst_vld_dupx = Input(Bool())
    val vfpu_idu_ex1_pipe6_preg_dupx = Input(UInt(7.W))
    val vfpu_idu_ex1_pipe6_vreg_dupx = Input(UInt(7.W))
    val vfpu_idu_ex1_pipe7_data_vld_dupx = Input(Bool())
    val vfpu_idu_ex1_pipe7_fmla_data_vld_dupx = Input(Bool())
    val vfpu_idu_ex1_pipe7_mfvr_inst_vld_dupx = Input(Bool())
    val vfpu_idu_ex1_pipe7_preg_dupx = Input(UInt(7.W))
    val vfpu_idu_ex1_pipe7_vreg_dupx = Input(UInt(7.W))
    val vfpu_idu_ex2_pipe6_data_vld_dupx = Input(Bool())
    val vfpu_idu_ex2_pipe6_fmla_data_vld_dupx = Input(Bool())
    val vfpu_idu_ex2_pipe6_vreg_dupx = Input(UInt(7.W))
    val vfpu_idu_ex2_pipe7_data_vld_dupx = Input(Bool())
    val vfpu_idu_ex2_pipe7_fmla_data_vld_dupx = Input(Bool())
    val vfpu_idu_ex2_pipe7_vreg_dupx = Input(UInt(7.W))
    val vfpu_idu_ex3_pipe6_data_vld_dupx = Input(Bool())
    val vfpu_idu_ex3_pipe6_vreg_dupx = Input(UInt(7.W))
    val vfpu_idu_ex3_pipe7_data_vld_dupx = Input(Bool())
    val vfpu_idu_ex3_pipe7_vreg_dupx = Input(UInt(7.W))
    val vfpu_idu_ex5_pipe6_wb_vreg_dupx = Input(UInt(7.W))
    val vfpu_idu_ex5_pipe6_wb_vreg_vld_dupx = Input(Bool())
    val vfpu_idu_ex5_pipe7_wb_vreg_dupx = Input(UInt(7.W))
    val vfpu_idu_ex5_pipe7_wb_vreg_vld_dupx = Input(Bool())
    val x_create_data = Input(UInt(271.W))
    val x_create_dp_en = Input(Bool())
    val x_create_gateclk_en = Input(Bool())
    val x_entry_vld = Input(Bool())

    val x_read_data = Output(UInt(271.W))
  })
}