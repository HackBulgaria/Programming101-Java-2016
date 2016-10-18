# Are two words anagrams?

In a class `Anagrams`, implement a static method `boolen areAnagrams(String a, String b)`.

For anagrams, check here - https://en.wikipedia.org/wiki/Anagram

For example, `listen` and `silent` are anagrams.

The program should read two words from the standard input and output:

* `ANAGRAMS` if the words are anagrams of each other
* `NOT ANAGRAMS` if the two words are not anagrams of each other

**Consider lowering the case of the two words since the case does not matter. `SILENT` and `listen` are also anagrams.**

## Boilerplate

```java
import java.util.Scanner;

public class Anagrams {

  public static boolean areAnagrams(String a, String b) {
    return false;  
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String a = scanner.next();
    String b = scanner.next();

    if (areAnagrams(a, b)) {
      System.out.println("ANAGRAMS");
    } else {
      System.out.println("NOT ANAGRAMS");
    }
  }
}
```

## Examples

Input:

```
silent listen
```

Output:

```
ANAGRAMS
```

---

Input:

```
TOP_CODER COTO_PRODE
```

Output:

```
NOT ANAGRAMS
```

---

Input:

```
kilata cvetelina_yaneva
```

Output:

```
NOT ANAGRAMS
```

Also, should not make songs together.

---

Input:

```
BRADE BEARD
```

Output:

```
ANAGRAMS
```
