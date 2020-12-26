package complex

import angle.Deg
import angle.Rad
import angle.rad
import vector.Vector2D
import kotlin.math.*

class Complex(var re: Double, var im: Double) {
    constructor (mod: Double, arg: Rad) : this(
            cos(arg.degree),
            sin(arg.degree)
    )

    constructor (mod: Double, arg: Deg) : this(
            cos(arg.rad().degree),
            sin(arg.rad().degree)
    )

    fun conjugate(): Complex = Complex(this.re, -this.im)
    fun module(): Double = sqrt(re * re + im * im)
    fun arg(): Rad = if (re != 0.0 || im != 0.0) Rad(acos(re / this.module())) else (0.0).rad()
    fun asVector(): Vector2D = Vector2D(re, im)

    fun get(z: Complex): String {
        return z.re.toString() + "+" + z.im.toString() + "i"
    }
}

fun parseComplex(str: String): Complex {
    val z = Complex(0.0, 0.0)
    var t = ""
    for (i in str.indices) {
        if (i == 0) {
            t += str[i]
            continue
        }
        if (str[i] == '+' || str[i] == '-') {
            z.re += t.toDouble()
            t = ""
            continue
        }
        if (str[i] == 'i') {
            z.im += t.toDouble()
            break
        }
        t += str[i]
    }
    return z
}

val ii = Complex(0.0, 1.0)
val c0 = Complex(0.0, 0.0)

fun Re(z: Complex): Double = z.re
fun Im(z: Complex): Double = z.im

operator fun Complex.plus(z: Complex): Complex = Complex(this.re + z.re, this.im + z.im)
operator fun Complex.minus(z: Complex): Complex = Complex(this.re - z.re, this.im - z.im)
operator fun Complex.unaryMinus(): Complex = Complex(-this.re, -this.im)
operator fun Complex.plus(z: Double): Complex = Complex(this.re + z, this.im)
operator fun Complex.minus(z: Double): Complex = Complex(this.re + z, this.im)
operator fun Complex.times(z: Complex): Complex = Complex(this.re * z.re - this.im * z.im, this.im * z.re + this.re * z.im)
operator fun Complex.times(z: Double): Complex = Complex(this.re * z, this.im * z)
operator fun Complex.div(z: Complex): Complex = Complex((this.re * z.re + this.im * z.im) / (z.re * z.re + z.im * z.im), (this.im * z.re + this.re * z.im) / (z.re * z.re + z.im * z.im))
operator fun Complex.div(z: Double): Complex = this * (1 / z)
operator fun Double.plus(z: Complex) = z + this
operator fun Double.minus(z: Complex) = -z + this
operator fun Double.times(z: Complex) = -z * this
operator fun Double.div(z: Complex) = (Complex(1.0, 0.0) / z) * this

fun ln(z: Complex): Complex = ii * z.arg().degree + ln(z.module())
