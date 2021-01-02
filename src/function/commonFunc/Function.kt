package function.commonFunc

abstract class Function {
    abstract fun derivative(): Function
    abstract fun getFun(): (Double) -> Double
}
