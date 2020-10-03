package equation

class EquationSolver(lower: Double, upper: Double, function: (Double) -> Double, epsilon: Double) {
  private var l = lower
  private var h = upper
  val f = function
  private val e = epsilon

  init {
    if (l > h) throw LowerLimitHigherThanUpperException()
  }

  fun solve(): Double {
    if (f(l) * f(h) > 0) throw SameSignOnEachSideException()
    var pivot = (l + h) / 2
    while (f(pivot) !in -e..e) {
      pivot =
          if (f(pivot) * f(l) < 0) (l + pivot) / 2
          else (h + pivot) / 2
    }
    return pivot
  }

  fun getRange() = l..h
  class SameSignOnEachSideException : Throwable()
  class LowerLimitHigherThanUpperException : Throwable()
}
