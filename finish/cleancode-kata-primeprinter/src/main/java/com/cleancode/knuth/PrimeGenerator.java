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
    private final int[] mult = new int[ordmax +1];

    public int[] generatePrimes(int numberOfPrimes) {
        n = 0;
        primes = new int[numberOfPrimes +1];
        candidate =1;
        primeIndex =1;
        primes[1] = 2;
        ord = 2;
        square = 9;

        while (primeIndex < numberOfPrimes) {
            findNextPrime();
            primeIndex++;
            primes[primeIndex]= candidate;
        }
        return primes;
    }

    private void findNextPrime() {
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
    }
}
