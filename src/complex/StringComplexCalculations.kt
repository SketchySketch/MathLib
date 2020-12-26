package complex

infix fun String.cadd(z: Complex): Complex? = parseComplex(this).plus(z)
infix fun String.cmin(z: Complex): Complex? = parseComplex(this).minus(z)
infix fun String.ctime(z: Complex): Complex? = parseComplex(this).times(z)
infix fun String.cdiv(z: Complex): Complex? = parseComplex(this).div(z)
infix fun String.cadd(z: String): Complex? = parseComplex(z) + parseComplex(this)
infix fun String.cmin(z: String): Complex? = parseComplex(z) + parseComplex(this)
infix fun String.ctime(z: String): Complex? = parseComplex(z) + parseComplex(this)
infix fun String.cdiv(z: String): Complex? = parseComplex(z) + parseComplex(this)
