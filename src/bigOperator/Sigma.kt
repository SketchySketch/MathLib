package bigOperator

import java.math.BigDecimal

fun sigma(function: (Int) -> BigDecimal, range: IntRange): BigDecimal {
  var s = BigDecimal(0.0)
  for (i in range) {s += function(i)}
  return s
}

fun sigma(function: (Any) -> BigDecimal, range: List<Any>): BigDecimal {
  var s = BigDecimal(0.0)
  for (i in range) {s += function(i)}
  return s
}

fun pi(function: (Int) -> BigDecimal, range: IntRange): BigDecimal {
  var s = BigDecimal(0.0)
  for (i in range) {s *= function(i)}
  return s
}

fun pi(function: (Any) -> BigDecimal, range: List<Any>): BigDecimal {
  var s = BigDecimal(0.0)
  for (i in range) {s *= function(i)}
  return s
}
