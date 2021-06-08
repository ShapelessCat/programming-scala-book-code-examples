package progscala3.introscala.shapes

@main def ProcessShapesDriver(): Unit =                              // <1>
  val messages = Seq(                                                // <2>
    Draw(Circle(Point.origin, 1.0)),
    Draw(Rectangle(Point.origin, 2, 5)),
    Response("Say hello to pi: 3.14159"),
    Draw(Triangle(Point.origin, Point.onAxisX(2.0), Point(1.0, 2.0))),
    Exit
  )

  messages.foreach { message =>                                      // <3>
    val response = ProcessMessages(message)
    println(response)
  }
