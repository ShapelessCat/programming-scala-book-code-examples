// src/main/scala/progscala3/rounding/FileSizes.scala
package progscala3.rounding

import scala.io.Source
import scala.util.Using

/** Usage: scala rounding.FileSizes filename1 filename2 ... */
@main def FileSizes(fileNames: String*): Unit =
  val sizes = fileNames.map { fileName =>
    Using.resource(Source.fromFile(fileName)) {
      _.getLines().size
    }
  }
  println(s"Returned sizes: ${sizes.mkString(", ")}")
  println(s"Total size: ${sizes.sum}")
