package com.cleancode.knuth;

public class PrimeGenerator {
    private final int M;
    private int[] primes;

    public PrimeGenerator(int M) {
        this.M = M;
        this.primes = new int[M + 1];
        generatePrimes();
    }

    private void generatePrimes() {
        final int ORDMAX = 30;
        int K = 1;
        int J = 1;
        int ORD = 2;
        int SQUARE = 9;
        int N = 0;
        int[] MULT = new int[ORDMAX + 1];

        primes[1] = 2;

        while (K < M) {
            boolean JPRIME;
            do {
                J += 2;
                if (J == SQUARE) {
                    ORD++;
                    SQUARE = primes[ORD] * primes[ORD];
                    MULT[ORD - 1] = J;
                }
                N = 2;
                JPRIME = true;
                while (N < ORD && JPRIME) {
                    while (MULT[N] < J)
                        MULT[N] += primes[N] + primes[N];
                    if (MULT[N] == J)
                        JPRIME = false;
                    N++;
                }
            } while (!JPRIME);
            K++;
            primes[K] = J;
        }
    }

    public int[] getPrimes() {
        return primes;
    }
}