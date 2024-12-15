package com.cleancode.knuth;

public class PrimeGenerator {
    private final int ordmax = 30;
    private int[] primes;
    private int candidate;
    private int primeIndex;
    private boolean possiblyPrime;
    private int ord;
    private int square;
    private int n;
    private int[] multiples;

    public PrimeGenerator(int numberOfPrimes) {
        this.primes = new int[numberOfPrimes + 1];
        this.multiples = new int[ordmax + 1];
        generatePrimes(numberOfPrimes);
    }

    private void generatePrimes(int numberOfPrimes) {
        primeIndex = 1;
        candidate = 1;
        ord = 2;
        square = 9;
        n = 0;

        primes[1] = 2;

        while (primeIndex < numberOfPrimes) {
            findNextPrime();
            primeIndex++;
            primes[primeIndex] = candidate;
        }
    }

    private void findNextPrime() {
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
    }

    public int[] getPrimes() {
        return primes;
    }
}