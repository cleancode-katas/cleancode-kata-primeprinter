package com.cleancode.knuth;

public class PrimePrinterHelper {
    private int[] primes;

    public PrimePrinterHelper(int M) {
        PrimeGenerator primeGenerator = new PrimeGenerator(M);
        this.primes = primeGenerator.getPrimes();
    }

    public int[] getPrimes() {
        return primes;
    }
}

public class PrimePrinter {
    public static void main(String[] args) {
        int M = 100;
        PrimePrinterHelper primePrinterHelper = new PrimePrinterHelper(M);
        int[] primes = primePrinterHelper.getPrimes();

        for (int prime : primes) {
            if (prime != 0) {
                System.out.print(prime + " ");
            }
        }
    }
}