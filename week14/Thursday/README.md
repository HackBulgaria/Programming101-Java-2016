# First steps in concurrency

## The Runnable

Everybody loves abstraction! Thats why we have the Runnable interface. It has only one method - void run().
It represents basically a task (a unit of work) that someone should do.

Lets define(implement) our task.
We would like to make prime factorization of a number.

## The Thread

Now that we have work to do it is time to give it to someone that has to execute it.
In оur case this will be a Thread.
We can pass our Runnable implementation to the Thread constructor.
Now the Thread know about the work it should do.
What remains is to start the Thread.

Well just .start() it!


## Use thread pools

Creating several threads can be a bit tedious and if we make new treads for every new task it can be expensive.
We can reuse threads - when they are ready with their task we can reuse them 

Luckily Java provides us with the ExecutorService classes.
It manages the threads for us.
One such ExecutorService can be created with Executors.newCachedThreadPool()

It will create and maintain the needed number of threads for the tasks we send to it.
For example if we give the pool 2 tasks that have to be executed concurrently it will create and manage the threads for us.

Lets try to run our tasks via cachedThreadPool.
Lets try to execute 3 tasks using Executors.newFixedThreadPool(2)

## Create Callable<T>

What if we want to return some kind of a result from our task?
We can implement the Callable<> Interface.

Just like the Runnable interface it has only one method.
In this case this is the call()

Later we can submit our Callable objects to the ExecutorService that will manage the threads that will execute the task.

## Future<T> for results

After we submit our task for execution we will receive an Future<T> which we can use to check if the task is done using isDone().
Or to block and wait for the result using .get() method.



## Parallel closest point calculations

Create a static method generatePoints() which returns a List<Point> - create your Point impl (with maybe different implementations (dimensions))
Implement it, generating a 100 000 points (in java that is written 100_000) points with random coordinates - ranging from 0 to 10_000.

Now, for each of those points, I'd like you to find it's nearest point. Do this in a method calculateClosestPoint(List<Point> generatedPoints)
For now it should only print the closest point for each of the points.

It takes a while. By calculations, it should take like lots of seconds to complete (depending on your CPU speed).

Now lets introduce some multithreading to speed it up.
Declare and implement a method doCalculations(List<Point> inPoints, int indexFrom, int indexTo) Move calculations logic from calculateClosestPoint to doCalculations, but work strictly from indexFrom, to indexTo.

Now in calculateClosestPoint(List<Point> generatedPoints) method, start two Threads that call doCalculations, in their run methods, one from 0 to half of the elements, the other from half of the elements to the last of them.

Measure speedup between the two implementations (See System.currentTimeMillis()).

Introduce a third and forth thread. Does your implementation go faster?

Think how to generalize the number of threads and how to implement it.

Lets change our implementation and use a pool to handle the treads instead of us.

Lets change again our implementation.
Lets make our thread to return the closest point instead of printing.
Finally we should gather the closest point of each point in a Map<Point, Point>

## Getting some practice - The Impatient Project Manager
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
