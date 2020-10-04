# MathLib
Some utilities for math.

# Instructions
## 1. Usage
Copy the contents inside the `src` folder into your project root, then import when needed.

## 2. Notice
Notice that all angles the functions return is an instance of class `Rad` by default. use `.deg` to convert it into an instance `Deg()`.

## Currently Maintained
### Line
Lang: Kotlin

Sub-classes: Point, LineDecl, Line

Basic calculations of points and linear functions.

### Vector
Lang: Kotlin

Sub-classes: Vector2D, Vector3D

Calculations about vectors. Overrided operators provided.

### Equation
Lang: Kotlin

Sub-classes: EquationSolver

A basic solution for equations.

### Angle
Lang: Kotlin

Sub-classes: Deg, Rad

Used to differ angles from numbers.

### BigOperator
Lang: Kotlin

Functions: sigma(), pi()

Sigma and Pi operator.
