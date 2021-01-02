package function.commonFunc

import java.lang.StrictMath.pow

class Power(val inner: Function, val power: Double) : Function() {
    override fun derivative(): Function {
        return inner.derivative() * Power(inner, power - 1) * power
    }
    override fun getFun(): (Double) -> Double {
        return {x -> pow(inner.getFun()(x), power)}
    }
}
