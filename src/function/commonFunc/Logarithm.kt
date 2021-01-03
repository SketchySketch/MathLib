package function.commonFunc

import kotlin.math.ln
import kotlin.math.log

class Logarithm(private val base: Double, private val inner: Function) : Function() {
    override fun derivative(): Function {
        return inner.derivative() / (ln(base) * inner)
    }

    override fun getFun(): (Double) -> Double {
        return { x -> log(inner.getFun()(x), base) }
    }
}