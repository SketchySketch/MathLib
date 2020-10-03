package vector

import kotlin.math.sqrt

class Vector3D(var x: Double, var y: Double, var z: Double) {
  fun module() = sqrt(x * x + y * y + z * z)
  fun unitVector() = Vector3D(
      x / module(),
      y / module(),
      z / module()
  )
}