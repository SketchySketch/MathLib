package function.commonFunc

import java.lang.StrictMath.pow
import kotlin.math.ln

class Exponential(private val base: Double, private val exp: Function) : Function() {
    override fun derivative(): Function {
        return ln(base) * Exponential(base, exp) * exp.derivative()
    }

    override fun getFun(): (Double) -> Double {
        return { x -> pow(base, exp.getFun()(x)) }
    }
}
