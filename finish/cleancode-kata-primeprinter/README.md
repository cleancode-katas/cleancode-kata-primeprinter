# Clean Code Kata - PrimePrinter

Code used to demonstrate in a workshop how clean code principles can be
applied to existing legacy code.

Observation

- Study PrimePrinterTest class
- Standard testing approach from
- Michel Feathers book working effectively with legacy code
- called a Characterization test
- create test based on output of program

Observation

- whole bunch of variables
- used by whole bunch of code
- when you have whole bunch of vars used by whole bunch of code
- what you have is a class hidden in the code
- may be more than one class

Activity

- Convert the function code into class PrimePrinterHelper
- refactoring Extract to Method Object
- make the invoke method non static
- correct code in main to created object and call method
- tests should pass