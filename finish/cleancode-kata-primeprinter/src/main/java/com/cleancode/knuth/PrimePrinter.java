package com.cleancode.knuth;

public class PrimePrinter {

    private static final int NUMBER_OF_PRIMES = 1000;
    private static final int LINES_PER_PAGE = 50;
    private static final int COLUMN_COUNT = 4;

    public static void main(String[] args) {
        PrimeGenerator primeGenerator = new PrimeGenerator();
        NumberPrinter numberPrinter = new NumberPrinter(LINES_PER_PAGE, COLUMN_COUNT);

        int primes[] = primeGenerator.generatePrimes(NUMBER_OF_PRIMES);
        numberPrinter.print(primes, NUMBER_OF_PRIMES);
    }
}
