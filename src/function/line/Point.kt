package function.line

import angle.Deg
import angle.Rad
import kotlin.math.atan
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

class Point(var x: Double, var y: Double) {


    constructor(r: Double, theta: Deg) : this(
            r * cos(theta.rad().degree),
            r * sin(theta.rad().degree)
    )

    constructor(r: Double, theta: Rad) : this(
            r * cos(theta.degree),
            r * sin(theta.degree)
    )

    fun getCoord(isPolar: Boolean = false): List<Double> {
        return if (isPolar) {
            listOf(sqrt(x * x + y * y), atan(y / x))
        } else {
            listOf(x, y)
        }
    }
}
