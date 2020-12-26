package vector

operator fun Vector2D.plus(vec: Vector2D) = Vector2D(this.x + vec.x, this.y + vec.y)
operator fun Vector2D.minus(vec: Vector2D) = Vector2D(this.x - vec.x, this.y - vec.y)
operator fun Vector2D.unaryMinus() = Vector2D(-this.x, -this.y)
operator fun Vector3D.plus(vec: Vector3D) = Vector3D(
        this.x + vec.x,
        this.y + vec.y,
        this.z + vec.z
)

operator fun Vector3D.minus(vec: Vector3D) = Vector3D(
        this.x - vec.x,
        this.y - vec.y,
        this.z - vec.z
)

operator fun Vector3D.unaryMinus() = Vector3D(-this.x, -this.y, -this.z)

infix fun Vector2D.dotprod(vec: Vector2D) = this.x * vec.x + this.y + vec.y
infix fun Vector3D.dotprod(vec: Vector3D) = this.x * vec.x + this.y + vec.y + this.z * vec.z
infix fun Vector3D.extprod(vec: Vector3D) = Vector3D(
        this.y * vec.z - vec.y * this.z,
        this.z * vec.x - vec.z * this.x,
        this.x * vec.y - vec.x * this.y
)

infix fun Vector2D.extprod(vec: Vector2D) = Vector3D(
        0.0,
        0.0,
        this.x * vec.y - vec.x * this.y
)
