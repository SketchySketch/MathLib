package function.commonFunc

class Constant(val value: Double) : Function() {
    override fun derivative(): Function {
        return Constant(0.0)
    }
    override fun getFun(): (Double) -> Double {
        return {_ -> value}
    }
}