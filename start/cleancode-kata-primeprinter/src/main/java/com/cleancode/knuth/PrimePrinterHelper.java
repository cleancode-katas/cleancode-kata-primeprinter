package com.cleancode.knuth;

public class PrimePrinterHelper {
    private final int numberOfNumbers;
    private int[] primes;
    private final int ordmax = 30;
    private int primeIndex;
    private int candidate;
    private boolean possiblyPrime;
    private int ord;
    private int square;
    private int n;
    private int[] multiples;
    private int pageNumber;
    private int pageOffset;
    private int rowOffset;
    private int column;
    private int linesPerPage;

    public PrimePrinterHelper(int numberOfNumbers) {
        this.numberOfNumbers = numberOfNumbers;
        this.primes = new int[numberOfNumbers + 1];
        this.multiples = new int[ordmax + 1];
        generatePrimes();
    }

    private void generatePrimes() {
        primeIndex = 1;
        candidate = 1;
        ord = 2;
        square = 9;
        n = 0;

        primes[1] = 2;

        while (primeIndex < numberOfNumbers) {
            boolean JPRIME;
            do {
                candidate += 2;
                if (candidate == square) {
                    ord++;
                    square = primes[ord] * primes[ord];
                    multiples[ord - 1] = candidate;
                }
                n = 2;
                JPRIME = true;
                while (n < ord && JPRIME) {
                    while (multiples[n] < candidate)
                        multiples[n] += primes[n] + primes[n];
                    if (multiples[n] == candidate)
                        JPRIME = false;
                    n++;
                }
            } while (!JPRIME);
            primeIndex++;
            primes[primeIndex] = candidate;
        }
    }

    public int[] getPrimes() {
        return primes;
    }

    public void printPrimes(int[] numbers, int numberOfNumbers) {
        int pagenumber = 1;
        int pageoffset = 1;
        while (pageoffset <= numberOfNumbers) {
            System.out.print("The First ");
            System.out.print(Integer.toString(numberOfNumbers));
            System.out.print(" Prime Numbers === Page ");
            System.out.print(Integer.toString(pagenumber));
            System.out.println("\n");
            for (int rowoffset = pageoffset; rowoffset <= pageoffset + linesPerPage - 1; rowoffset++) {
                for (int column = 0; column <= this.column - 1; column++) {
                    if (rowoffset + column * linesPerPage <= numberOfNumbers) {
                        System.out.printf("%10d", numbers[rowoffset + column * linesPerPage]);
                    }
                }
                System.out.println();
            }
            System.out.println("\f");
            pagenumber++;
            pageoffset += linesPerPage * this.column;
        }
    }
}