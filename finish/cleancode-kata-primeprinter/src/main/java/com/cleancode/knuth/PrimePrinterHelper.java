package com.cleancode.knuth;

public class PrimePrinterHelper {

    private final int numberOfPrimes = 1000;
    private final int linesPerPage = 50;
    private final int columns = 4;
    private final int ordmax = 30;
    private final int[] primes = new int[numberOfPrimes +1];
    private int pagenumber;
    private int pageoffset;
    private int rowoffset;
    private int column;
    private int candidate;
    private int primeIndex;
    private boolean possiblyPrime;
    private int ord;
    private int square;
    private int n;
    private final int[] mult = new int[ordmax +1];

    public int[] generatePrimes() {
        n = 0;

        candidate =1;
        primeIndex =1;
        primes[1] = 2;
        ord = 2;
        square = 9;

        while (primeIndex < numberOfPrimes) {
            do {
                candidate += 2;
                if( candidate == square) {
                    ord++;
                    square = primes[ord]* primes[ord];
                    mult[ord -1]= candidate;
                }
                n =2;
                possiblyPrime =true;
                while (n < ord && possiblyPrime) {
                    while (mult[n]< candidate)
                        mult[n] += primes[n] + primes[n];
                    if (mult[n] == candidate)
                        possiblyPrime =false;
                    n++;
                }
            } while (!possiblyPrime);
            primeIndex++;
            primes[primeIndex]= candidate;
        }
        return primes;
    }

    public void printNumbers(int numbers[], int numberOfNumbers) {
        new NumberPrinter(linesPerPage, columns, numbers, numberOfNumbers).invoke();
    }

}
