package function.commonFunc

import java.lang.StrictMath.pow

<<<<<<< HEAD
class Power(val inner: Function, val power: Double) : Function() {
    override fun derivative(): Function {
        return inner.derivative() * Power(inner, power - 1) * power
    }
    override fun getFun(): (Double) -> Double {
        return {x -> pow(inner.getFun()(x), power)}
=======
class Power(private val inner: Function, private val power: Double) : Function() {
    override fun derivative(): Function {
        return inner.derivative() * Power(inner, power - 1) * power
    }

    override fun getFun(): (Double) -> Double {
        return { x -> pow(inner.getFun()(x), power) }
>>>>>>> pre-production
    }
}
