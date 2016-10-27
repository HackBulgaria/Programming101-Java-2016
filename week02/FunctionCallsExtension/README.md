# Function Calls with our Functions

In order to solve that problem, it is a good idea to solve [Function Calls first](../7-Function-Calls)

Now, in the previous problem, we had predefined functions. This is easy. **Now, we are going to read our functions from the input.**

## Function language

We are going to use a very simple function language:

* All functions are defined over the integers.
* All functions are one liners - there are not going to be functions on multiple lines.
* All functions are going to have **1 argument**
* All functions can only do expressions involving valid integers, the argument and the `+` and `-` operations. Brackets, `*` and other operations are not in our language.
* **Functions can include function calls to other functions.**
* **In our function language everyting is separated by exactly one `" "`** You can count on that.

Here are some example functions, that are valid:

```
f x = x + 1
inc x = x + 1
dec x = x - 1
f2 x = 1
f3 x = x + 1 - 2
f4 x = inc(x) + inc(1)
```

Our functions have the following form:

```
<function name> <argument-name> = <function-body>
```

* `<function-name>` can be 1 or more characters from `[a-z]`
* `<argument-name>` can be 1 or more characters from `[a-z]`
* `<function-body> = <values> | <function-calls> | <operations>` where `|` means or.
* `<values>` are valid integers values. For example: `1`, `12`, `123`
* `<function-calls>` are in the form `<function-name>(<arguments>)`
* `<operations>` can be only `+` and `-`

## The new problem

Now, we have to make a Java program that:

* Reads one integer `n`
* On the next `n` lines - reads `n` fuctions
* After this, reads one line consisting of function composition - lets call the composition `h`
* On the last line, it reads an integer `x`

The program should output the result of `h(x)`.

## Examples

* The output is always going to be valid.
* There won't be functions with the same name as the arguments.

Watch carefully. There are a few corner cases here:

Example input:

```
2
inc x = x + 1
dec x = x - 1
inc . inc . dec
5
```

The output should be:

```
6
```

We are calling:

```
inc(inc(dec(5)) = inc(inc(4)) = inc(5) = 6
```

---

Another input:

```
1
const x = 1
const . const . const
100
```

The output should be:

```
1
```

Here `const` is a constant function. We can have all valid integer values for `x` but the result is always 1.

---

Another input:

```
1
const x = 1 + 1 - 1
const . const . const
100
```

The output should be:

```
1
```

Again, we have a constant function but this time - there is an expression to be calculated.

---

Another input:

```
2
inc x = x + 1
dec x = inc(x) - 2
dec . dec
2
```

The result should be:

```
0
```

Now, the definition of `dec` uses `inc`. We must call `inc` with the `x` value passed to `dec`.

---

Another input:

```
2
inc x = x + 1
dec x = x - inc(0)
dec . dec
2
```

The output should be:

```
0
```

Now, we are calling `inc` again but this time with a specific value - `0`. This is not `x`!
