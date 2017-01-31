# Multithreading

## Oracle's concurency trail

Have a look at this:
http://docs.oracle.com/javase/tutorial/essential/concurrency/index.html

Try to answer these questions:
* What is the difference between process and thread?
* What is Runnable? Whats is Thread?
* What are the most important methods in Thread ?
* What is starvation, livelock and deadlock ?
* What is thread interference and memory consistency errors ?

## Example in Tutorialspoint

http://www.tutorialspoint.com/java/java_multithreading.htm


## Tasks

### The Impatient Project Manager
In the software company `ИшлемеSoft` there is a very grumpy and impatient `Project Manager` that assigns a lot of tasks to his `Developers` and expects them to be done in time. Sometimes, they aren't skilled enough, they get distracted or piss off the Project Manager and fail their tasks. Let's present this scenario using `Threads`.


- Write a class Task

It represents a task for a `Developer` and has a description and a working time (in seconds for the sake of example).
The expected completion time for a task is the working time, adjusted by the skill of the `Developer`.
  
  
- Write an enum Skill

It should represent the skill of a developer using a time multiplier that adjusts the time a developer takes to complete a certain task.

  
- Write a class Developer that implements Runnable

It should have a name, `Skill` and a list of `Tasks`. A `Developer` completes his tasks sequentially in the `run` method, but he might get distracted and take longer to complete a task. Generate a random distraction multiplier in the range [1; 2) to adjust the time taken. Do not forget the skill multiplier as well.


- Write a class ProjectManager that instantiates a Developer

A `Project Manager` comes up with the tasks for the `Developers` and assigns them. He has a patience threshold, provided as a command-line argument in the range [1, 2). If a `Developer` takes more than the expected time for a task, the `Project Manager` must fire him. (use interrupts for this). Think of a good way to implement an algorithm to check for task completion without wasting computing resources.

## The Producer-Consumer Problem

https://en.wikipedia.org/wiki/Producer%E2%80%93consumer_problem

