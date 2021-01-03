package function.commonFunc

import java.lang.StrictMath.pow

class Polynomial(private val coefficient: ArrayList<Double>) : Function() {
    override fun derivative(): Polynomial {
        val arr = arrayListOf<Double>()
        for (i in 0 until coefficient.size - 1) {
            arr.add((coefficient.size - 1 - i) * coefficient[i])
        }
        return Polynomial(arr)
    }

    override fun getFun(): (Double) -> Double {
        return fun(x: Double): Double {
            var res = 0.0
            for (i in 0 until coefficient.size) {
                res += coefficient[i] * pow(x, (coefficient.size - 1 - i).toDouble())
            }
            return res
        }
    }
}
