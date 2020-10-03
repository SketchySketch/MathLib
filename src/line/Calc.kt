package line

import kotlin.math.*

fun nSector(A: Point, B: Point, n: Int): MutableList<Point> {
  val deltaX = A.x - B.x
  val deltaY = A.y - B.y
  val ls: MutableList<Point> = mutableListOf()
  for (i in 1 until n) {
    ls.add(Point(
        B.x + i * deltaX / n,
        B.x + i * deltaY / n
    ))
  }
  return ls
}

fun rotate(A: Point, O: Point, angle: Double): Point {
  val a = A.x
  val b = A.y
  val x = O.x
  val y = O.y
  val theta = angle / 180 * PI
  return Point(
      cos(theta) * (a - x) - sin(theta) * (b - y) + x,
      sin(theta) * (a - x) + cos(theta) * (b - y) + y
  )
}

fun rotate(l: Line, O: Point, angle: Double): Line {
  val theta = angle / 180 * PI
  val k = tan(theta + atan(l.k))
  val anchor = rotate(l.pointOnLineX(0.0), O, angle)
  return Line(anchor, k)
}

fun intersect(l1: Line, l2: Line): Point = l1.pointOnLineX((l2.b - l1.b) / (l1.k - l2.k))
