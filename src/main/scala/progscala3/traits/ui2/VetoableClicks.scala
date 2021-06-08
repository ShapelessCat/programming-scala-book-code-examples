// src/main/scala/progscala3/traits/ui2/VetoableClicks.scala
package progscala3.traits.ui2

trait VetoableClicks(val maxAllowed: Int = 1) extends Clickable:     // <1>
  private var count = 0                                              // <2>

  abstract override def click(): String =
    count.synchronized { count += 1 }
    if count <= maxAllowed                                           // <3>
    then super.click()
    else s"Max allowed clicks $maxAllowed exceeded. Received $count clicks!"

  def resetCount(): Unit =                                           // <4>
    count.synchronized { count = 0 }
