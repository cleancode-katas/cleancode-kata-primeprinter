package com.cleancode.knuth;

public class PrimePrinter {

    private static final int numberOfPrimes = 1000;
    private static final int linesPerPage = 50;
    private static final int columns = 4;

    public static void main(String[] args) {
        PrimePrinterHelper primePrinterHelper = new PrimePrinterHelper();
        int primes[] = primePrinterHelper.generatePrimes();
        new NumberPrinter(linesPerPage, columns).print(primes, numberOfPrimes);
    }
}
