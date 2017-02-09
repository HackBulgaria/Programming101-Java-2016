## Concurrent architecture showcase - Google Chrome

Modern websites contain a lot of dynamic content and use JavaScript extensively to provide a rich browsing experience. Sadly, modern websites also tend to consume a lot of CPU and contain a lot of bugs. This wouldn't be a problem if browsers rendered one page at a time, but every contemporary browser provides so called tabs to open several websites at once. The problem with this is that if a single tab crashed, the entire browser crashes as well.

Google Chrome addresses this problem by using a multiprocess architecture, using three types of processes:

- Browser process

  The browser process is responsible for managing the user interface as
  well as disk and network I/O. A new browser process is created when
  Chrome is started. Only one browser process is created.

- Renderer process

  Renderer processes contain logic for rendering web pages - HTML, Javascript, images, and so on. As
  a general rule, a new renderer process is created for each website opened
  in a new tab, and so several renderer processes may be active at the same
  time.

- Plugin process

  A plugin process is created for each plugin in use.

The advantage of the multiprocess approach is that websites run in
isolation from one another. If one website crashes, only its renderer process
is affected, all other processes remain unharmed. Furthermore, renderer
processes run in a sandbox, which means that access to disk and network
I/O is restricted, minimizing the effects of any security exploits.

## Sudoku solution validator

A Sudoku puzzle comprises of a 9x9 grid in which each row and column, as well as each of the nine 3x3 subgrids, must contain the digits in the range [1; 9]. Design a multithreaded application that determines whether a certain solution to a Sudoku puzzle is valid.

Points to think about:
- What types of threads will be needed?
- Which logic shouldn't be separated into a thread?
- How will you collect results?

Your solution must provide a class which accepts a sudoku board as a two-dimensional 9x9 array and returns a boolean value that represents whether the array is a valid solution.

Hint: you could write a Runnable that checks a row/column/3x3 box and execute one for each row/column/3x3 box

## The dining philosophers

Five silent philosophers sit at a round table with bowls of spaghetti. Forks are placed between each pair of adjacent philosophers.

Each philosopher must alternately think and eat. However, a philosopher can only eat spaghetti when they have both left and right forks. Each fork can be held by only one philosopher and so a philosopher can use the fork only if it is not being used by another philosopher. After an individual philosopher finishes eating, they need to put down both forks so that the forks become available to others. A philosopher can take the fork on their right or the one on their left as they
become available, but cannot start eating before getting both forks.

Eating is not limited by the remaining amounts of spaghetti or stomach space; an infinite supply and an infinite demand are assumed.

You must design a concurrent program such that no no philosopher will starve - each can forever continue to alternate between eating and thinking, assuming that no philosopher can know when others may want to eat or think.

Source: Wikipedia

