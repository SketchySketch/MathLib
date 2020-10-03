package complex

import angle.*
import kotlin.math.acos

class Complex (var re: Double, var im: Double) {
  var arg = Rad(acos(re / im))
}