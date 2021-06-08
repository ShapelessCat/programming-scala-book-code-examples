// src/main/scala/progscala3/concurrency/futures/FutureCallbacks.scala
package progscala3.concurrency.futures

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Try, Success, Failure}

case class ThatsOdd(i: Int) extends RuntimeException(s"odd $i received!")  // <1>

val doComplete: Try[String] => Unit =                                      // <2>
  case s: Success[String] => println(s)                                    // <3>
  case f: Failure[String] => println(f)

@main def TryFuturesCallbacks =
  val futures = (0 to 9).map {                                             // <4>
    case i if i % 2 == 0 => Future.successful(i.toString)
    case i               => Future.failed(ThatsOdd(i))
  }
  futures.map(_.onComplete(doComplete))                                    // <5>
