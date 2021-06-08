package progscala3.introscala.shapes

import scala.util.chaining.*

object ProcessMessages:                                              // <1>
  def apply(message: Message): Message =                             // <2>
    message match                                                    // <3>
      case Exit =>
        println(s"ProcessMessage: exiting...")
        Exit
      case Draw(shape) =>
        shape.pipe { s =>
          s.draw(str => println(s"ProcessMessage: $str"))
          Response(s"ProcessMessage: $s drawn")
        }
      case Response(unexpected) =>
        Response(s"ERROR: Unexpected Response: $unexpected").tap { r =>
          println(s"ProcessMessage: $r")
        }
