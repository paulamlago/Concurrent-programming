# Peers
Concurrent programming solution that consists in several processes called **workers** that compute the same problem and have a certain communication between them, and a **Coordinator**.

## 1. Matrix multiplication

We will work with the next example:

 ![Matrix](https://www.ditutor.com/matrices/images/54.gif)
 
 To get to that solution, the coordinator assings an id (from 0 to n - 1, being n the size of the matrix) for each worker and sends a row from matrix a and a colum for matrix b to each of them so they can compute the row number id of the final matrix. To do so, the worker will need to have every B column so there will be needed a communication method between processes.
 
 For instance, worker with id = 1 will receive the row number 1 of matrix A: 
 
 > 3 0 0
 
 And column number 1 of matrix B:
 
 > 0 2 1
 
 So, in order to compute the hole row of the final matrix it will need to ask for the remaining columns of matrix B so it can get to:
 
 > 3 0 3
