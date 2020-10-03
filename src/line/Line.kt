package line

import angle.*

class Line : LineDeclaration {
  constructor(A: Point, B: Point) : super(A, B)
  constructor(A: Point, slope: Double) : super(A, slope)
  constructor(slope: Double, y_intercept: Double) : super(slope, y_intercept)
  constructor(angle: Deg, A: Point) : super(angle, A)
  constructor(angle: Rad, A: Point) : super(angle, A)

  fun pointOnLineX(x: Double): Point {
    return Point(x, k * x + b)
  }

  fun pointOnLineY(y: Double): Point {
    return Point((y - b) / k, y)
  }

  fun perpendicular(H: Point): Line {
    return Line(H, -1 / k)
  }
}
