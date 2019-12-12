# Exercise_2

Exercise 2 contained an assignment to write a program that handles forward propagation in a neural network. I decided to write mine in Scala, since I needed to practice it anyway for an exam I had.

Featuring:

* apologetic O(n^3) algorithms
* the worst variable naming scheme since assembler was a thing
* lots of ```Array[Array[Double]]```
* three of the best activation functions there are

Anyway:    
This program is split into two files:

### ```ToolBox.scala```

this utility class contains all the utility functions one needs to do a forward propagation:

* printing of a matrix
* transposition of a matrix
* scalar product of two matrices (a vector is just a 1-dimensional matrix)
* applying an activation function to a matrix

### ```MainApp.scala```

entry point for the program, containing some random values I used for testing. Feel free to fork it and write a neat interface.

### How to run this:

1) Install [Scala](https://www.scala-lang.org/download/)
2) ```$ scalac ToolBox.scala MainApp.scala```
3) ```$ scala MainApp```
