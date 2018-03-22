
# Barrier implementation
In this repository you will find several types of barrier implementations. The solutions will consist on incrementing and decrementing a number so the solution has to be 0.

# 1. Coordinators
By using a coordinator and as many workers as processes we need, we can create a barrier. To implement this, we'll need two arrays, both originally initialized to 0.

> int arrive[0.. N-1]

> int continue[0..N-1]

The coordinator will assign an id to every worker, in such a way that even workers, including the one with id 0, are the one in charge of decrementing the number and the odd ones are in charge of incrementing it.
Each worker, after modifying the number, will set it's flagg arrive to 1, and wait till its's continue flag is 1. After this they will clean their continue flag. The coordinator will wait to every process to arrive and then set their continue flag to 1.

|**Process i**           | **Coordinator**|
|:------------           |:---------------|
|`increment or decrement`|for(int i=0 to n-1)**{**|
|arrive[i] = 1           |   while(arrive[i] == 0);|
|while(continue[i] == 0);|   arrive[i] = 0 **}**|
|continue[i] = 0         |for(int i = 0 to n-1)**{**|
|                        |   continue[i] = 1 **}**|

# 2. Symmetric barrier
By ussing this symetric barrier we don't need a coordinator. It consist in having several stages, where each proccess coordinates with the one that is 2^0 possitions to the left, then with the one that is 2^1 possitions to the left and so one...
The goal of this piece of code is to compute the prefix of an array, being the initial array the represented in the first row, we get the second one:

| 1 | 2 | 3 | 4 | 5 | 6 |
|:--|:--|:--|:--|:--|:--|
| 1 | 3 | 6 | 10 | 15 | 21 |

The process is the following:

|Stage 0 |1  |2  |3  |4  |5  |6  |
|:------|:--|:--|:--|:--|:--|:--|
|Stage 1| 1 | 3 | 5 | 7 | 9 | 11 |
|Stage 2| 1 | 3 | 6 | 10 | 14 | 18 |
|Stage 3| 1 | 3 | 6 | 10 | 15 | 21 |

To achieve this solution we'll need several arrays:

> int initial[N], sum[N], old[N]

In the fist one we'll save the original array and the second one will be the solution in every stage, while the third one is the one in charge of saving the changes so any process can take an old value of a certain possition.
