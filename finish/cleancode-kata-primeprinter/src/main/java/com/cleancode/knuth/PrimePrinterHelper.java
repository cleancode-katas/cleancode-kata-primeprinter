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

    public void invoke() {
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
        pagenumber = 1;
        pageoffset = 1;
        while (pageoffset <= numberOfPrimes) {
            System.out.print("The First ");
            System.out.print(Integer.toString(numberOfPrimes));
            System.out.print(" Prime Numbers === Page ");
            System.out.print(Integer.toString(pagenumber));
            System.out.println("\n");
            for (rowoffset = pageoffset; rowoffset <= pageoffset + linesPerPage -1; rowoffset++) {
                for (column = 0; column <= columns - 1; column++)
                    if (rowoffset + column * linesPerPage <= numberOfPrimes)
                        System.out.printf("%10d", primes[rowoffset + column * linesPerPage]);
                System.out.println();
            }
            System.out.println("\f");
            pagenumber++;
            pageoffset += linesPerPage * columns;

        }
    }
}
