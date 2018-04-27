# Practice Questions

## 1) Max value(MaxValue.java)

Write a program called MaxValue.java that finds the maximum value in an array of ints using 4 threads. Your main should be similar as the one in the above-linked SumThread example, though you should construct your array of random numbers instead of increasing numbers. You may assume in your threaded code that the array has at least 4 elements.

## 2) Reverse hello(ReverseHello.java)

Write a program called ReverseHello.java that creates a thread (let's call it Thread 1). Thread 1 creates another thread (Thread 2); Thread 2 creates Thread 3; and so on, up to Thread 50. Each thread should print "Hello from Thread <num>!", but you should structure your program such that the threads print their greetings in reverse order.

## 3) Shared counter(SharedCounter.java)

Write a program called SharedCounter.java in which 10 threads each increment a shared int counter 10 times. When all the threads have finished, print the final value of the counter. If the initial value is zero, do you always get 100? Arrange for your code to sometimes print the wrong answer. (Hint: try using some well-placed calls to Thread.yield() or Thread.sleep().)


