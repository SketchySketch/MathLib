package function.arrayFunc

import function.line.Line
import function.line.Point
import range.discreteRange
import kotlin.math.*

class ArrayFunc(var l: Double, var h: Double, var f: (Double) -> Double, var dx: Double = 0.001) {
    var indices: ClosedFloatingPointRange<Double>
    var array: ArrayList<Double>

    constructor(l: Double, h: Double, values: ArrayList<Double>) : this(
            l,
            h,
            fun(x: Double): Double {
                val left = floor(x / (l - h) / (values.size - 1)).toInt()
                val right = ceil(x / (l - h) / (values.size - 1)).toInt()
                return Line(Point(left * (l - h) / (values.size - 1), values[left]), Point(right * (l - h) / (values.size - 1), values[right])).pointOnLineX(x).y
            },
            dx = (l - h) / (values.size - 1)
    )

    init {
        if (l > h || dx > (h - l)) throw IndexOutOfBoundsException("No enough indices")
        this.indices = l..h
        val arr = arrayListOf<Double>()
        var temp = l
        while (temp <= h) {
            arr.add(f(temp))
            temp += dx
        }
        this.array = arr
    }

    fun derivative(x: Double, epsilon: Double = dx): Double {
        return (f(x + epsilon) - f(x)) / epsilon
    }

    fun derivative(): ArrayFunc {
        return ArrayFunc(
                l,
                h,
                { x -> derivative(x) },
                dx
        )
    }

    fun tangent(x: Double, epsilon: Double = dx): Line {
        return Line(Point(x, f(x)), derivative(x, epsilon = epsilon))
    }

    fun integrate(lower: Double = l, higher: Double = h, epsilon: Double = dx): Double {
        var integral = 0.0
        for (i in discreteRange(lower..higher, epsilon)) {
            integral += epsilon * f(i)
        }
        return integral
    }

    fun curveLength(lower: Double = l, higher: Double = h, epsilon: Double = dx): Double {
        return ArrayFunc(
                lower + epsilon,
                higher - epsilon,
                { x -> sqrt(1 + derivative(x) * derivative(x)) },
                epsilon
        ).integrate()
    }

    fun area(lower: Double = l, higher: Double = h, epsilon: Double = dx): Double {
        var area = 0.0
        for (i in discreteRange(lower..higher, epsilon)) {
            area += epsilon * abs(f(i))
        }
        return area
    }
}

fun constFunc(value: Double, range: ClosedFloatingPointRange<Double>) = ArrayFunc(range.start, range.endInclusive, { value })

operator fun ArrayFunc.get(value: Double): Double = if (value in l..h) {
    f(value)
} else throw IndexOutOfBoundsException("Out of range")

operator fun ArrayFunc.plus(f: ArrayFunc): ArrayFunc = ArrayFunc(l, h, { x -> f(x) + f.f(x) }, min(dx, f.dx))
operator fun ArrayFunc.minus(f: ArrayFunc): ArrayFunc = ArrayFunc(max(l, f.l), min(h, f.h), { x -> f(x) - f.f(x) }, min(dx, f.dx))
operator fun ArrayFunc.times(f: ArrayFunc): ArrayFunc = ArrayFunc(max(l, f.l), min(h, f.h), { x -> f(x) * f.f(x) }, min(dx, f.dx))
operator fun ArrayFunc.div(f: ArrayFunc): ArrayFunc = ArrayFunc(max(l, f.l), min(h, f.h), { x -> f(x) / f.f(x) }, min(dx, f.dx))
operator fun ArrayFunc.unaryMinus(): ArrayFunc = ArrayFunc(l, h, { x -> -f(x) }, dx)
operator fun ArrayFunc.unaryPlus(): ArrayFunc = this
