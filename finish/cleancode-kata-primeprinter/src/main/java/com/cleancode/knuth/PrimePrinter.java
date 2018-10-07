package com.cleancode.knuth;

public class PrimePrinter {

    private static final int numberOfPrimes = 1000;

    public static void main(String[] args) {
        PrimePrinterHelper primePrinterHelper = new PrimePrinterHelper();
        int primes[] = primePrinterHelper.invoke();
        primePrinterHelper.printNumbers(primes, numberOfPrimes);
    }
}
