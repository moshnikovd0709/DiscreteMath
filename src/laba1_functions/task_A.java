package laba1_functions;

import java.io.PrintWriter;
import java.util.Scanner;

public class task_A {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int m = in.nextInt();
        int min = Math.min(n, m);
        int max = Math.max(n, m);
        long polynomial_P[] = new long[Math.max(1001, max + min + 1)];
        long polynomial_Q[] = new long[Math.max(1001, max + min + 1)];
        for (int i = 0; i <= n; i++) {
            polynomial_P[i] = in.nextInt();
        }
        for (int i = 0; i <= m; i++) {
            polynomial_Q[i] = in.nextInt();
        }
        in.close();
        out.println(max);
        //sum
        for (int i = 0; i <= max; i++) {
            out.print(((polynomial_P[i] + polynomial_Q[i]) % MOD) + " ");
        }
        out.println();
        //multiple
        out.println(max + min);
        for (int i = 0; i <= max + min; i++) {
            long k = 0;
            for (int j = 0; j <= i; j++) {
                k = ((k + ((polynomial_P[j] * polynomial_Q[i - j]) % MOD)) + MOD) % MOD;
            }
            out.print(k + " ");
        }
        out.println("-------");
        long[] p = task_B.multiplePolynomial(polynomial_P, polynomial_Q);
        for (long x : p) {
            out.print(x + " ");
        }
        out.println("-------");
        //divide
        long[] polynomial_C = new long[1000];
        for (int i = 0; i < 1000; i++) {
            polynomial_C[i] = polynomial_P[i];
            long k = 0;
            for (int j = 1; j <= i; j++) {
                k = (k + polynomial_Q[j] * polynomial_C[i - j]) % MOD;
            }
            polynomial_C[i] -= k;
            polynomial_C[i] = (polynomial_C[i] % MOD + MOD) % MOD;
        }
        for (int i = 0; i < polynomial_C.length; i++) {
            out.print(polynomial_C[i] + " ");
        }
        out.close();
    }
}