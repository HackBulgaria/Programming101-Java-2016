# Parse an .ini file to json

In a `class Parser`, implement a method that reads an `.ini` file and parses it to json.

## What's an INI file?

The INI file format is an informal standard for configuration files for some platforms or software. INI files are simple text files with a basic structure composed of sections, properties, and values.

An INI file looks something like this:

```
[panda]
  name=Stamat
  lazyness=95
  cuteness=123

[unicorn]
  name=Pencho
  age=0.3 bilion
  horns=1
  probability=0.1e-50000
```

## What's a JSON file?

JSON (JavaScript Object Notation) is a lightweight data-interchange format. It is easy for humans to read and write. It is easy for machines to parse and generate. It is based on a subset of the JavaScript Programming Language, Standard ECMA-262 3rd Edition - December 1999.

A JSON file looks something like this:

```
{
  "panda": {
    "name": "Stamat",
    "lazyness": "95",
    "cuteness": "123"
  },
  "unicorn": {
    "name": "Pencho",
    "age": "0.3 bilion",
    "horns": "1",
    "probability": "0.1e-50000"
  }
}
```

## Gotchas

 * There can be multiple blank lines all over the file for readability purposes, they should just be ignored when parsing it.
 * Spaces around equal signs and trailing spaces should be ok, although it's a good idea to warn that other parsers might not be as benevolent as ours.
 * Lines starting with a semicolon(`;`) are comments, and should be ignored when parsing.

## Help at your side

In order to help you with this task we created a `class Listify` that reads a file and returns its contents as a `String[]`

```java
package listify;

import java.util.List;
import java.util.LinkedList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Consumer;

public class Listify {
	public static String[] readToArray(String filename) {
		List<String> contents = new LinkedList<>();
		try{
			contents = read(filename);
		}catch(IOException e){
			e.printStackTrace();
			return null;
		}
		return contents.toArray(new String[contents.size()]);
	}

	private static List<String> read(String filename) throws java.io.IOException {
		return Files.readAllLines(Paths.get(filename));
	}
}
```
