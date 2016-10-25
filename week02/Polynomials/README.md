# Polynomial

## What is a polynomial?

In mathematics, a polynomial is an expression consisting of variables and coefficients which only employs the operations of addition, subtraction, multiplication, and non-negative integer exponents.

... but you don't need all that for this task.

A polynomial is an expression of the following type:

* x<sup>2</sup> - 4x + 7
* 2x<sup>4</sup> + 3x<sup>2</sup> - 10x + 3
* 4x<sup>10</sup> - 7x<sup>9</sup> + 5x<sup>8</sup> ...... - 3x<sup>2</sup> + 8x + 5
* A<sub>n</sub>x<sup>n</sup> + A<sub>n-1</sub>x<sup>n-1</sup> + A<sub>n-2</sub>x<sup>n-2</sup> + ... + A<sub>2</sub>x<sup>2</sup> + A<sub>1</sub>x<sup>1</sup> + A<sub>0</sub>x<sup>0</sup> (... if that explains it better)

At the moment we're interested in Polynomials with only one variable.

## The task

### 1. Requirements

Model a Java program that handles Polynomials.

* Add, substract and multiplicate Polynomials
    * `P1 + P2 = P3` where P3 is a result polynom
    * `P1 - P2 = P3` where P3 is a result polynom
    * `P1 * P2 = P3` where P3 is a result polynom
* Method for multiplicating the polynomial by a constant
    * `P1 * c = P3` where c is a constant and P3 is a result polynom
* Method for returning the first derivative of a Polynomial
    * `(P1)' = P3` where P3 is a polynom and is the first derivative of P1
    * For example the Polynomial `2x^4 + 3x^2 - 10x + 3` has a first derivative `8x^3 + 6x - 10`
* Method for evaluating a Polynomial
* The Polynomial should be **immutable**
* The Polynomial should be parametrised by a Generic type that is a valid number. For example Integer or Double

### 2. Hints

Implementing the following methods will probably make your task easier:

* `add(..)` for adding a member to the polynomial
* `fromString("..")` a static method to return a polynomial from a string
    * For example the string `2x^4 + 3x^2 - 10x + 3`
