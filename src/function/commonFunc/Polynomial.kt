package function.commonFunc

import java.lang.StrictMath.pow

<<<<<<< HEAD
class Polynomial(val coefficient: ArrayList<Double>) : Function() {
=======
class Polynomial(private val coefficient: ArrayList<Double>) : Function() {
>>>>>>> pre-production
    override fun derivative(): Polynomial {
        val arr = arrayListOf<Double>()
        for (i in 0 until coefficient.size - 1) {
            arr.add((coefficient.size - 1 - i) * coefficient[i])
        }
        return Polynomial(arr)
    }

    override fun getFun(): (Double) -> Double {
<<<<<<< HEAD
        return fun (x: Double): Double {
=======
        return fun(x: Double): Double {
>>>>>>> pre-production
            var res = 0.0
            for (i in 0 until coefficient.size) {
                res += coefficient[i] * pow(x, (coefficient.size - 1 - i).toDouble())
            }
            return res
        }
    }
}
