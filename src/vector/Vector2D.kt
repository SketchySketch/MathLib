package vector

import kotlin.math.*
import angle.*
import line.*

class Vector2D(var x: Double, var y: Double) {
  var module = sqrt(x * x + y * y)
  var angle = atan(y / x).rad()

  constructor(mod: Double, deg: Deg): this(cos(deg.toRad().degree), sin(deg.toRad().degree)) {
    module = mod
    angle = deg.rad
  }

  constructor(mod: Double, rad: Rad): this(cos(rad.degree), sin(rad.degree)) {
    module = mod
    angle = rad
  }

  fun to3D() = Vector3D(x, y, 0.0)

  fun unitVector() = Vector2D(1.0, angle as Deg)
  fun perpendicularVector(length: Double) = Vector2D(length, ((angle as Deg).degree + 90.0).deg())
  fun line(A: Point) = Line(angle as Deg, A)
  fun rotate(ang: Deg) = Vector2D(module, angle as Deg + ang)
  fun rotate(ang: Rad) = Vector2D(module, angle as Rad + ang)
}
