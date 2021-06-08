// src/main/scala/progscala3/rounding/Path.scala
package progscala3.rounding

import java.io.File
import scala.annotation.targetName

case class Path(value: String, separator: String = Path.defaultSeparator):  // <1>
  val file = File(value)

  override def toString: String = file.getPath                              // <2>

  @targetName("concat") infix def / (node: String): Path =                  // <3>
    copy(value + separator + node)                                          // <4>

  infix def append(node: String): Path = this / node                        // <5>

object Path:
  val defaultSeparator = sys.props("file.separator")
