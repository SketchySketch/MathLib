package line

import angle.*
import kotlin.math.tan

open class LineDeclaration {
  var start: Point?
  var end: Point?
  var k: Double
  var b: Double

  constructor(A: Point, B: Point) {
    start = A
    end = B
    k = (A.y - B.y) / (A.x - B.x)
    b = A.y - A.x * k
  }

  constructor(A: Point, slope: Double) {
    start = A
    end = null
    k = slope
    b = A.y - k * A.x
  }

  constructor(slope: Double, y_intercept: Double) {
    start = null
    end = null
    k = slope
    b = y_intercept
  }

  constructor(angle: Deg, A: Point) {
    start = A
    end = null
    k = tan(angle.rad.degree)
    b = A.y - k * A.x
  }

  constructor(angle: Rad, A: Point) {
    start = A
    end = null
    k = tan(angle.degree)
    b = A.y - k * A.x
  }
}