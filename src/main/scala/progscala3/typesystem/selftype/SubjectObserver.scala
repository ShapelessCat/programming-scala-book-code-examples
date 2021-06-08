// src/main/scala/progscala3/typesystem/selftype/SubjectObserver.scala
package progscala3.typesystem.selftype

abstract class SubjectObserver:
  type S <: Subject                                                  // <1>
  type O <: Observer

  trait Subject:
    self: S =>                                                       // <2>
    private var observers = List.empty[O]

    def addObserver(observer: O): Unit =
      observers ::= observer

    def notifyObservers(): Unit =                                    // <3>
      observers.foreach(_.receiveUpdate(self))

  trait Observer:
    def receiveUpdate(subject: S): Unit
