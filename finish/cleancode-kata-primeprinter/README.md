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

Activity

- Move PrimePrinterHelper class to top level

Activity

- M to numberOfPrimes - introduce field, 
initialize into field declaration
- RR to linesPerPage, introduce field, 
init in field declaration
- CC to columns, introduce field, 
               init in field declaration
- ordmax, introduce field, init in declaration
- P to primes, introduce field, 
               init in field declaration
- PAGENUMBER to pagenumber, introduce field, 
               init in field declaration
- PAGEOFFSET to pageoffset, introduce field, 
               init in field declaration
- ROWOFSET to rowoffset, introduce field, 
               init in field declaration
- C to column, introduce field, 
               init in field declaration
- J to candidate, introduce field, 
               init in field declaration
- K to primeIndex, introduce field, 
               init in field declaration
- JPRIME to possiblyPrime, introduce field, 
               init in field declaration
- ORD to ord, introduce field, 
               init in field declaration
- SQUARE to square, introduce field, 
               init in field declaration
- N to n, introduce field, 
               init in field declaration
- MULT to multiples, introduce field, 
               init in field declaration
               
Activity

- Extract the number printing logic to method
- name the method printPrimes
- add parameters to pass primes and numberOfPrimes

Activity

- rename parameter primes to numbers
- rename param numberOfPrimes to numberOfNumbers
- return primes from invoke method
- take out the printPrimes call
- shift the numberOfPrimes field to PrimePrinter, make static
- pull variable for PrimePrinterHelper
- call method printNumbers by passing primes and numberOfPrimes 

Activity

- rename invoke to generatePrimes
- extract printNumbers method into method object named NumberPrinter
- Move the new inner class NumberPrinter to top level
- do not pass outer class in new class constructor
- ignore the missing variables warning and continue
- add int before pagenumber and pageoffset
- add int before rowoffset and column
- pass int linesPerPage, int columns in constructor, make them fields
- pass the values in the call to printNumbers

Activity

- rename NumberPrinter.invoke to print
- pass numbers and numberOfNumbers in print method
- adjust the calling code by changing params
- check tests pass
- move the code in printNumbers method to main
- new NumberPrinter(linesPerPage, columns).print(numbers, numberOfNumbers);
- copy the linesPerPage and columns fields to PrimePrinter class
- adjust the params in the call to NumberPrinter
- remove unused fields in classes

Activity

- rename PrimePrinterHelper to PrimeGenerator
- add numberOfPrimes param to generatePrime method
- pass numberOfPrimes in calling logic

Activity

- In PrimeGenerator generatePrimes method
- select the inner do-while loop code
- extract method named findNextPrime
- Extract local variable for NumberPrinter object
- rearrange lines in main method
- rename final variables to CAPS

               