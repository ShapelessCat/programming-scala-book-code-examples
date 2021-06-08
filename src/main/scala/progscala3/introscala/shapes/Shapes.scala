package progscala3.introscala.shapes

case class Point(x: Double = 0.0, y: Double = 0.0)                                   // <1>
object Point:
  val origin = Point(0.0, 0.0)

  def onAxisX(x: Double): Point =
    Point(x, y = 0.0)

  def onAxisY(y: Double): Point =
    Point(x = 0.0, y)
end Point

abstract class Shape:                                                                // <2>
  /**
   * Draw the shape.
   * @param f is a function to which the shape will pass a
   * string version of itself to be rendered.
   */
  def draw(f: String => Unit): Unit = f(s"draw: $this")                              // <3>

case class Circle(center: Point, radius: Double)                      extends Shape  // <4>
case class Rectangle(lowerLeft: Point, height: Double, width: Double) extends Shape  // <5>
case class Triangle(point1: Point, point2: Point, point3: Point)      extends Shape  // <6>
