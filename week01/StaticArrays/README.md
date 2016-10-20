# 10-Static-Array

In a `com.hackbulgaria.programming51.week3` package do the following:

## Define a `class Arr` where you

### Define the following

* `public static String toString(int[] a)` method that recieves an integer array and returns a string of the array, separated by ","
* `public static void sort(int[] a)` method that recieves an array of int and sorts it
* `public static int[] reverse(int[] a)` method that recieves an integer array and returns the reversed array
* `public static String join(int[] a, String glue)` method that recieves an array of int and a string and returns a String of the array elements with 'glue' between them
* `public static int sum(int[] a)` method that returns the sum of all the elements in 'a'
* `public static int[] range(int a, int b)` that returns an array of int with elements in the range between a and b
* `public static int[] filterOdd(int[] a)` method that returns an array with only the Odd numbers from 'a'

## Examples

You can open [Arr.java](Arr.java) and take the boilerplate code from it.


### Example for `toString(int [] a)`

```java
  int [] a = {1,2,3,4,5};
  System.out.println(Arr.toString(a));
```

Should print:

```
  1, 2, 3, 4, 5
```

### Example for `sort(int [] a)`

```java
  int [] a = {3,1,-40,200,5};
  Arr.sort(a);
  System.out.println(Arr.toString(a));
```

Should print:

```
  -40, 1, 3, 5, 200
```

### Example for `reverse(int [] a)`

```java
  int [] a = {3,1,-40,200,5};
  a = Arr.reverse(a);
  System.out.println(Arr.toString(a));
```

Should print:

```
  5, 200, -40, 1, 3
```

### Example for `join(int [] a, String glue)`

```java
  int [] a = {3,1,-40,200,5};
  System.out.println(Arr.join(a, ": "));
  System.out.println(Arr.join(a, "->"));
```

Should print:

```
  3: 1: -40: 200: 5
  3->1->-40->200->5
```

### Example for `sum(int [] a)`

```java
  int [] a = {1,2,3,4,5};
  int b = Arr.sum(a);
  System.out.println(b);
```

Should print:

```
  15
```

### Example for `range(int a, int b)`

```java
  int [] a = Arr.range(10, 20);
  System.out.println(Arr.join(a, ", "));
```

Should print:

```java
  10, 11, 12, 13, 14, 15, 16, 17, 18, 19
```

### Example for `filterOdd(int [] a)`

```java
  int [] a = {2,3,4,8,9,11,13,15};
  int [] temp = Arr.filterOdd(a);
  System.out.println(Arr.join(temp, ", "));
```

Should print:

```
  3, 9, 11, 13, 15
```