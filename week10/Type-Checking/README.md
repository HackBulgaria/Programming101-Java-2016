# Type Checking

We are going to define a dead-simple functional language, where we can define 1-argument functions and give them **type signatures**.

## The language

The language looks like this:

```
f :: A -> B
```

This is the type signature for functional with name `f` which takes 1 argument of type `A` and returns a result of type `B`.

We are not interested in the body of the function. **We are going to work only with type signatures.**

Few things to have in mind:

* The syntax rules are going to be fixed: `<fname> :: T1 -> T2`.
  * There is exactly 1 ` ` between `<fname>` and `::` and `::` and the types.
  * There is exactly 1 ` ` between `T1` and `->` and `->` and `T2`.
* We are going to have only 1 argumented functions.
* Function names can be camel-cased and will always start with a lower case.
* Type names are always starting with a capital letter.

## Function composition

Our language will support function composition:

```
f :: A -> B
g :: B -> A

f . g
```

Function composition is a binary operation between functions that returns a new function.

For example, if we have two 1-argumented functions `f` and `g`, then `h = f . g` is a new function.

When we call `h`: we do the following: `h(x) = f(g(x))`

## The problem

You are given some function definitions in our language & exactly 1 functiom composition, as the last thing in the input.

You need to output `True` or `False` **if the given function composition is valid.**

Given function composition is valid if all types are matching properly.

For example:

```
f :: String -> Int
g :: Int -> String

f . g
```

If we are to call the composition `f . g`:

* `g` takes `Int` and returns `String`
* We are calling `f` with the result from `g`. `g` takes `String` as an input => **everything's OK and this is a valid composition.**

Lets see another example:


```
f :: String -> Int
g :: Int -> String

f . f
```

* First, we are calling `f` which will return `Int`
* Then, we will try to call `f` with `Int`, but `f` requires `String`. We have type mismatch => **this is not a valid composition**

---

**You need to write a program, that reads from the standard input some definitions & one function composition.**

Your program should output `True` to the standard output, if the given composition is valid, according to the types. Otherwise - `False`.

The format of the input will be:

* First `n` lines are going to be function definitions
* The last line will be the function composition.
* Between the definitions and the composition, there will be **exactly 1 empty line**

### Example input:

```
f :: String -> Int
g :: Int -> String

f . g
```

Example output:

```
True
```