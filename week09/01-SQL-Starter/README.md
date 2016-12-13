# First steps in Databases and SQL

## Tables, tables everywhere! SELECT, UPDATE, INSERT, DELETE

Now, we know that our languages table looks like this:

| id      | language  | answer  | answered | guide |
| ------------- |:-------------:| --- | --- |-----:|
1|Python|google|0|A folder named Python was created. Go there and fight with program.py!
2|Go|200 OK|0|A folder named Go was created. Go there and try to make Google Go run.
3|Java|object oriented programming|0|A folder named Java was created. Can you handle the class?
4|Haskell|Lambda|0|Something pure has landed. Go to Haskell folder and see it!
5|C#|NDI=|0|Do you see sharp? Go to the C# folder and check out.
6|Ruby|https://www.ruby-lang.org/bg/|0|Ruby, ruby, rubyyy, aaahaaaahaa! (music). Go to Ruby folder!
7|C++|header files|0|Here be dragons! It's C++ time. Go to the C++ folder.
8|JavaScript|Douglas Crockford|0|NodeJS time. Go to JavaScript folder and Node your way!


A ```SELECT``` statement, returns a list of rows. We ```SELECT``` by giving the name of the columns we want.

Run the following SELECT statements in the sqilite3 shell:


```sql
SELECT id FROM languages;
```

```sql
SELECT id, language FROM languages;
```

```sql
SELECT id, language, answer, answered FROM languages;
```

```sql
SELECT id, language FROM languages WHERE answered = 0;
```

```sql
SELECT id, language FROM languages WHERE answered = 1;
```

__Now, lets update few languages to be answered. We will change the answered value for each language from 0 to 1:__


```sql
UPDATE languages SET answered = 1 WHERE language = "Python";
```

```sql
SELECT id, language FROM languages WHERE answered = 1;
```

Now, if we run the ```polyglot.py``` program and give the ```list``` command, we will see:

```
DONE [1] - Python
NOT_DONE [2] - Go
NOT_DONE [3] - Java
NOT_DONE [4] - Haskell
NOT_DONE [5] - C#
NOT_DONE [6] - Ruby
NOT_DONE [7] - C++
NOT_DONE [8] - JavaScript
```

As you can see, if we control the data, we control the program!

__Now, let's insert a new language in our table!__

Execute the following statements:


```sql
INSERT INTO languages(id, language, answer, answered, guide) VALUES(9, "PHP", "$$$", 0, "Can you handle this piece of PHP?");
```

```sql
SELECT language FROM languages;
```

Now, if we go to our Polyglot program, again, we will see that PHP was added too:

```
DONE [1] - Python
NOT_DONE [2] - Go
NOT_DONE [3] - Java
NOT_DONE [4] - Haskell
NOT_DONE [5] - C#
NOT_DONE [6] - Ruby
NOT_DONE [7] - C++
NOT_DONE [8] - JavaScript
NOT_DONE [9] - PHP
```

Now, to finish the cycles of SQL statements, we are going to ```DELETE``` the added PHP language

We can achieve that by running the following query:

```sql
DELETE FROM languages WHERE language = "PHP";
```

Now, if we run:

```sql
SELECT language FROM languages;
```

We wont see PHP!

### SUID = CRUD

We were talking about CRUD operations - Create, Read, Update, Delete of a given object.

If we take a look at the SQL query statements, we can relate:

* `SELECT` = Read
* `UPDATE` = Update
* `INSERT` = Create
* `DELETE` = Delete
