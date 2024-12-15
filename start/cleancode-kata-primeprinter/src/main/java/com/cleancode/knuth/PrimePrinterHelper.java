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
}