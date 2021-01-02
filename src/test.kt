import function.commonFunc.*
import kotlin.math.E

fun main() {
    val f = Power(xx, 3.0).derivative()
    println(f.getFun()(2.0))
    val g = Exponential(E, xx)
    println(g.getFun()(1.0))
}
