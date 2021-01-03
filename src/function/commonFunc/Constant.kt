package function.commonFunc

<<<<<<< HEAD
class Constant(val value: Double) : Function() {
    override fun derivative(): Function {
        return Constant(0.0)
    }
    override fun getFun(): (Double) -> Double {
        return {_ -> value}
=======
class Constant(private val value: Double) : Function() {
    override fun derivative(): Function {
        return Constant(0.0)
    }

    override fun getFun(): (Double) -> Double {
        return { _ -> value }
>>>>>>> pre-production
    }
}