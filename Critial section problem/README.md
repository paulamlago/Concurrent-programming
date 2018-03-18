# Critical section problem
In this repository you'll find several **solutions to the critical section problem**, in this case, we want to create several processes that increment a number and some others that decrement it, so the solution after executing them must be 0. We need to implement some kind of control over the processes so we don't run into data looses.

## 1. Rompe-empate

### 1.1. Two processes

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


### 1.2. N processes
    
In order to solve the critical section problem for a program with N processes, we will need several arrays

> Int\[ ] in, last;

As in the last solution, we'll use variables in and last, and we'll assign an id for each process.

## 2. Ticket

This solution consists in giving a certain turn to each process, by taking the last number avaliable at the time of arriving to the critical section. Having also a 'next' variable, each process waits before accessing the critical section till their turn arrives. Each process squeme should be:

>int[] turn

>int number, next

|**Process i**|
|:------------|
|turn[i] = number|          
|number = number + 1|
|while(turn[i] != next)**;**|
|**CS**|
|next = next + 1|

## 3. Bakery

This solution seems similar to the Ticket, nevertheless it doesn't use the 'number' and 'next' variables, instead, it traverses the 'turn' array to get the higher one, so it knows that it's turn is the higher one + 1. 
To replace the next variable, before accessing the critical section, it traverses the turn array in shuch a way that if it finds a smaller turn, the process keeps waiting because the other one has arrived before, till there's no smaller turn in the array and it can access the critical section. Just by using the turn array it achieves the same result.

> int[ ] turn, from 0 to n -1 processes

The general scheme of this algorithm is the next one:

| **Process i**        |
|:------------|
|<turn[ i ] = max(turn)>|
|`for(j = 0 to n)` {while(turn[ i ] >= turn[ j ] && turn[ j ] != 0)**;**}|
|**CS**|
|turn[ i ] = -1 |


## 4. Test and set
This is the only solution in this repository that is not fair since we can't ensure that every process access the cs.
It's based on having a boolean variable to check if there's any process running the cs.

> Boolean lock = false

Then, every process will wait till that lock is false (not taken), in that moment the process will call the function:

> Boolean TS(Boolean lock)

This will return the value of the lock and will change it's value to True, saying that this process is taking the lock, so it'll enter the cs. This is the structure of the code:

|**Process i**|
|:------------|
|while(lock);|
|while(`TS(lock)`){|
|    while(lock); } |
|**CS**|
|lock = false|
