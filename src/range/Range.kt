package range

fun discreteRange(range: ClosedFloatingPointRange<Double>, step: Double): ArrayList<Double> {
    val arr = arrayListOf<Double>()
    var t = range.start
    while (t <= range.endInclusive) {
        arr.add(t)
        t += step
    }
    return arr
}
