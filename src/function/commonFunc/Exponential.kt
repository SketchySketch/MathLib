package function.commonFunc

import java.lang.StrictMath.pow
import kotlin.math.ln

class Exponential(val base: Double, val exp: Function) : Function() {
    override fun derivative(): Function {
        return ln(base) * Exponential(base, exp) * exp.derivative()
    }
    override fun getFun(): (Double) -> Double {
        return {x -> pow(base, exp.getFun()(x))}
    }
}
