// src/main/scala/progscala3/fp/datastructs/LazyListFibonacci.scala
package progscala3.fp.datastructs

import scala.math.BigInt

object Fibonacci:
  val fibs: LazyList[BigInt] =
    BigInt(0) #::
      BigInt(1) #::
      fibs.zip(fibs.tail).map((fm, fn) => fm + fn)
