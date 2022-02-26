package Core.RTU

import chisel3.stage.{ChiselGeneratorAnnotation, ChiselStage}

object PregMain extends App {
  (new ChiselStage).execute(
    args,
    Seq(
      ChiselGeneratorAnnotation(() => new PstPreg)
    )
  )
}
