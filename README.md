# Concurrent-programming
 Algorithims developed in concurrent programming, a subject taken in the third year of computer science 

## **1. Rompe-empate**

###   1.1. Two processes

In the first part of the exercise we consider two processes and we need to solve the critical section problem. In order to do that we use two variables, globally declared as:

> bool in1 = False, in2 = False;

This variables will tell us which process is already trying to access or have accessed the critical section.
We will need another variable in order to know which one is the last one that has tried to access, in that way, we will avoid deadlocks.

> int last;

| **Process 1** | **Process 2** |
|:-------------|:-------------|
|in1 = True     |in2 = True     |
|last = 1       |last = 2       |
|while (in2 && last == 1); | while (in1 && last == 2); |
|**CS**|**CS**|
|in1 = False    | in2 = False|


###   1.2. N processes
    
In order to solve the critical section problem for a program with N processes, we will need several arrays

> Int[ ] in, last;

As in the last solution, we'll use variables in and last, and we'll assign an id for each process.
