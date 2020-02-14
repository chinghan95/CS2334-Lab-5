# Lab 5: An Exceptional Calculator

For this lab, we will write a simple calculator that uses exceptions to handle invalid user input.
Below is an example run of the program.
The user enters each expression that follows the prompt `"Input: "`.
```
Java Calculator
---------------

Input formats:
1. OP x, where OP is log, sin, cos, or tan.
2. x OP y, where OP is +, -, *, /, or ^.

Input: 2 + 2
4.0

Input: 3 / 4
0.75

Input: 2 ^ 4x
Cannot parse "4x" as a double.

Input: 2 ^ 4
16.0

Input: 5 mod 2
Invalid operator: mod

Input: 7
Invalid number of tokens: 1

Input: 2 + 5 - 10
Invalid number of tokens: 5

Input: log 1000
6.907755278982137

Input: sin 3.14
0.0015926529164868282

Input: tan -1
-1.5574077246549023

Input: cot 1
Invalid operator: cot

Input: quit
Goodbye!
```
The user input loop is implemented in the Driver class, which has been provided for you.
Your task is to write the classes Calculator, CalculatorNumTokensException, and CalculatorOperatorException.

### Exception Classes

The classes CalculatorNumTokensException and CalculatorOperatorException both inherit from the Java API Exception class.
They are used by methods of the Calculator class to interrupt a calculation if the expression entered by the user is invalid.
The CalculatorNumTokensException is thrown if the expression has less than 2 or more than 3 tokens.
(A token in this context is a sequence of characters with no spaces. For instance, "sin 3.4" consists of 2 tokens, "sin" and "3.4".)
The CalculatorOperatorException is thrown if the expression has an invalid operator.

### Calculator Class

The Calculator class is a utility class used by the Driver class.
It consists only of public static methods.
Complete the body of each method by following the instructions in the starter code.
