package laba1_functions;

import java.io.PrintWriter;
import java.util.Scanner;

public class task_B {

    public final static int MOD = 998244353;

    public static long binpow(long a, int n) {
        if (n == 0)
            return 1;
        if (n % 2 == 1)
            return (binpow(a, n - 1) * a) % MOD;
        else {
            long b = binpow(a, n / 2) % MOD;
            return (b * b) % MOD;
        }
    }

    public static long[] binpow(long[] a, int n) {
        if (n == 0)
            return new long[]{1};
        if (n == 1)
            return a;
        if (n % 2 == 1) {
            return multiplePolynomial(binpow(a, n - 1), a);
        }
        long[] b = binpow(a, n / 2);
        return multiplePolynomial(b, b);
    }

    public static long getAtIndex(int index, long[] p) {
        if (index >= p.length) {
            return 0;
        } else {
            return p[index];
        }
    }

    public static long[] sumPolynomial(long[] p, long[] q) {
        int max = Math.max(p.length, q.length);
        long[] res = new long[max];
        for (int i = 0; i < max; i++) {
            res[i] = ((getAtIndex(i, p) + getAtIndex(i, q)) % MOD);
        }
        return res;
    }

    public static long[] multiplePolynomial(long[] p, long[] q) {
        int max = Math.max(p.length, q.length);
        long[] res = new long[Math.min(2 * max + 1, 101)];
        for (int i = 0; i < res.length; i++) {
            long k = 0;
            for (int j = 0; j <= i; j++) {
                k = (k + ((getAtIndex(j, p) * getAtIndex(i - j, q) % MOD)) + MOD) % MOD;
            }
            res[i] = k;
        }
        return res;
    }

    public static long getConstForSqrt(long prev, int n) {
        long ans = (((-prev * 4 * n) % MOD) * n) % MOD;
        ans = (ans * (1 - 2 * n)) % MOD;
        ans = (ans * binpow(3 - 2 * n, MOD - 2)) % MOD;
        ans = (((ans * binpow(2 * n, MOD - 2)) % MOD) * binpow(2 * n - 1, MOD - 2)) % MOD;
        ans = (ans % MOD + MOD) % MOD;
        return ans;
    }

    public static long getConstForSqrt1(int n) {
        return (((((((binpow(-4, n) * factorial(n)) % MOD) * factorial(n)) % MOD) * (1 - 2 * n)) % MOD) * binpow(factorial(2 * n), MOD - 2)) % MOD;
    }

    public static long factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return (factorial(n - 1) * n) % MOD;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int m = in.nextInt();
        long polynomial_P[] = new long[n+1];
        for (int i = 0; i <= n; i++) {
            polynomial_P[i] = in.nextInt();
        }
        in.close();
        //sqrt(1+p)
        long[] answer = new long[m];
        answer[0] = 1;
        long cons;
        for (int i = 1; i < m; i++) {
            cons = getConstForSqrt1(i);
            long poly[] = binpow(polynomial_P, i);
            long c[] = new long[]{binpow(cons, MOD - 2) % MOD};
            poly = multiplePolynomial(poly, c);
            answer = sumPolynomial(answer, poly);
        }
        for (int i = 0; i < m; i++) {
            out.print(answer[i] + " ");
        }
        out.println();
        //e^p
        cons = 1;
        answer = new long[m];
        for (int i = 1; i < m; i++) {
            long poly[] = binpow(polynomial_P, i);
            long c[] = new long[]{binpow(cons, MOD - 2) % MOD};
            poly = multiplePolynomial(poly, c);
            answer = sumPolynomial(answer, poly);
            cons = (((cons * (i + 1)) % MOD) + MOD) % MOD;
        }
        answer[0] = 1;
        for (int i = 0; i < m; i++) {
            out.print(answer[i] + " ");
        }
        out.println();
        //log(p+1)
        cons = 1;
        answer = new long[m];
        for (int i = 1; i < m; i++) {
            long poly[] = binpow(polynomial_P, i);
            long c[] = new long[]{(binpow(i, MOD - 2) * cons) % MOD};
            poly = multiplePolynomial(poly, c);
            answer = sumPolynomial(answer, poly);
            cons = -cons;

        }
        for (int i = 0; i < m; i++) {
            out.print(answer[i] + " ");
        }
        out.println();
        out.close();
    }
}