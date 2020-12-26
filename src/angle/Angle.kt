package angle

import kotlin.math.PI

class Deg(var degree: Double) {
    fun rad() = Rad(degree / 180 * PI)
}

class Rad(var degree: Double) {
    fun deg() = Deg(degree * 180 / PI)
}

fun Double.deg() = Deg(this)
fun Double.rad() = Rad(this)
operator fun Deg.plus(ang: Deg) = (this.degree + ang.degree).deg()
operator fun Rad.plus(ang: Rad) = (this.degree + ang.degree).rad()
operator fun Deg.minus(ang: Deg) = (this.degree - ang.degree).deg()
operator fun Rad.minus(ang: Rad) = (this.degree - ang.degree).rad()
operator fun Deg.unaryMinus() = (-this.degree).deg()
operator fun Rad.unaryMinus() = (-this.degree).rad()
operator fun Deg.compareTo(ang: Deg) = this.degree.compareTo(ang.degree)
operator fun Rad.compareTo(ang: Rad) = this.degree.compareTo(ang.degree)
