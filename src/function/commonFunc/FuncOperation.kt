package function.commonFunc

// Operations
class FuncPlus(private val left: Function, private val right: Function) : Function() {
    override fun derivative(): Function {
        return FuncPlus(left.derivative(), right.derivative())
    }

    override fun getFun(): (Double) -> Double {
        return { x -> left.getFun()(x) + right.getFun()(x) }
    }
}

class FuncUnaryMin(private val left: Function) : Function() {
    override fun derivative(): Function {
        return FuncUnaryMin(left.derivative())
    }

    override fun getFun(): (Double) -> Double {
        return { x -> -left.getFun()(x) }
    }
}

class FuncProd(private val left: Function, private val right: Function) : Function() {
    override fun derivative(): Function {
        return FuncPlus(FuncProd(left.derivative(), right), FuncProd(left, right.derivative()))
    }

    override fun getFun(): (Double) -> Double {
        return { x -> left.getFun()(x) * right.getFun()(x) }
    }
}

class FuncDiv(private val left: Function, private val right: Function) : Function() {
    override fun derivative(): Function {
        return FuncDiv(FuncPlus(FuncProd(left.derivative(), right), FuncUnaryMin(FuncProd(left, right.derivative()))), FuncProd(right, right))
    }

    override fun getFun(): (Double) -> Double {
        return { x -> left.getFun()(x) / right.getFun()(x) }
    }
}

// Operators
operator fun Function.plus(func: Function) = FuncPlus(this, func)
operator fun Function.minus(func: Function) = FuncPlus(this, -func)
operator fun Function.times(func: Function) = FuncProd(this, func)
operator fun Function.div(func: Function) = FuncDiv(this, func)
operator fun Function.unaryMinus() = FuncUnaryMin(this)

operator fun Function.plus(v: Double) = FuncPlus(this, Constant(v))
operator fun Function.minus(v: Double) = FuncPlus(this, -Constant(v))
operator fun Function.times(v: Double) = FuncProd(this, Constant(v))
operator fun Function.div(v: Double) = FuncProd(this, Constant(1 / v))

operator fun Double.plus(func: Function) = FuncPlus(Constant(this), func)
operator fun Double.minus(func: Function) = FuncPlus(Constant(this), -func)
operator fun Double.times(func: Function) = FuncProd(Constant(this), func)
operator fun Double.div(func: Function) = FuncDiv(Constant(this), func)

// Shorthands
val xx = Polynomial(arrayListOf(1.0, 0.0))
fun linear(k: Double, b: Double) = Polynomial(arrayListOf(k, b))
fun quadratic(a: Double, b: Double, c: Double) = Polynomial(arrayListOf(a, b, c))
