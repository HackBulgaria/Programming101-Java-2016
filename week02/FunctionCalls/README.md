# Function Calls

We have defined 4 functions - f1, f2, f3 and f4 as follows:

* `f1(x) = f2(x) + f3(x)`
* `f2(x) = 2 * x`
* `f3(x) = x + 1`
* `f4(x) = 2 * f1(x)`

All functions are working with integers.

For example:

```
f1(1) = f2(1) + f3(1) = 2 * 1 + 2 + 1 = 4
f2(1) = 2 * 1 = 2
f3(1) = 1 + 1 = 2
f4(1) = 2 * f1(1) = 10
```

**Function composition** is an expression of functions, separated by `.`

For example:

```
f1 . f2 . f3 . f4
```

The idea is that **composition of functions** returns new function. Lets say:

```
h = f1 . f2 . f3 . f4
```

Now if we call `h` with some argument `x`, we are going to get the result:

```
h(x) = f1(f2(f3(f4(x))))
```

You are about to write a Java program, that reads one function composition expression (of `f1`, `f2`, `f3`, `f4`) and value for the argument.

The program should output the result of calling the function composition with the argument.

## Boilerplate

```java
import java.util.Scanner;

public class Parser {
  
  public static int evaluate(String formula, int x) {
    // implementation
    return x;
  }
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    String input = scanner.nextLine();
    int x = scanner.nextInt();
    
    System.out.println(evaluate(input, x));

  }

}
```

## Examples

* On the first line, read one `String`. Functions are going to be separated by `" . "`.
* Read one more integer.

**Input**

```
f2
1
```

**Output**

```
2
```

This one is easy. We need only to call `f2(1)` which is equal to `1 + 1 = 2`.

---

**Input**

```
f2 . f2
1
```

**Output**

```
4
```

Now, we need to call `f2(f2(1))`, which is equal to `f2(2) = 4`

---

**Input**

```
f1 . f2 . f3 . f4
5
```

**Output**

```
199
```

This is a more complex example. We are going to expand it, so you get the idea:

```
We need to compute: f1(f2(f3(f4(5))))

First, we need to know the result of the most inner function: f4(5)

f4(5) = 2 * f1(5)
f1(5) = f2(5) + f3(5)
f2(5) = 10
f3(5) = 6

=>

f1(5) = 10 + 6 = 16

=>

f4(5) = 32

Now the expression is:

f1(f2(f3(32)))

f3(32) = 33

Now the expression is:

f1(f2(33))

f2(33) = 66

Now, we need to know f1(66)

f1(66) = f2(66) + f3(66)
f2(66) = 132
f3(66) = 67

f1(66) = 199
```