package laba1_functions;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class task_D {

    public static long factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return factorial(n - 1) * n;
    }

    public static long getAtIndex(int index, long[][] p, int t) {
        if (index >= p.length) {
            if (t == 0) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return p[index][t];
        }
    }

    public static long getAtIndex(int index, long[] p) {
        if (index >= p.length) {
            return 0;
        } else {
            return p[index];
        }
    }

    public static long[][] sumPolynomial(long[][] p, long[][] q) {
        int max = Math.max(p.length, q.length);
        long[][] res = new long[max][2];
        for (int i = 0; i < max; i++) {
            long firstD = getAtIndex(i, p, 1);
            long secondD = getAtIndex(i, q, 1);
            long firstN = getAtIndex(i, p, 0);
            long secondN = getAtIndex(i, q, 0);
            long gcd = gcd(firstD, secondD);
            res[i][0] = firstN * (secondD / gcd) + secondN * (firstD / gcd);
            res[i][1] = firstD * (secondD / gcd);
            gcd = gcd(res[i][0], res[i][1]);
            res[i][0] /= gcd;
            res[i][1] /= gcd;
        }
        return res;
    }

    public static long[][] multiplePolynomial(long[][] p, long[][] q) {
        int max = Math.max(p.length, q.length);
        long[][] res = new long[Math.min(2 * max + 1, 11)][2];
        for (int i = 0; i < res.length; i++) {
            long k = 0;
            for (int j = 0; j <= i; j++) {
                k = k + (getAtIndex(j, p, 0) * getAtIndex(i - j, q, 0));
            }
            res[i][0] = k;
            res[i][1] = 1;
        }
        return res;
    }

    public static long gcd (long a, long b) {
        return Long.parseLong(new BigInteger(String.valueOf(a)).gcd(new BigInteger(String.valueOf(b))).toString());
    }

    public static long pow(long a, int pow) {
        if (pow == 0) {
            return 1;
        }
        if (pow % 2 == 0) {
            long prev = pow(a, pow / 2);
            return (prev * prev);
        }
        return (pow(a, pow - 1) * a);
    }

    public static void main(String[] args) {
        //input
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int r = in.nextInt();
        int k = in.nextInt();
        long[] p = new long[k+1];
        for (int i = 0; i < p.length; i++) {
            p[i] = in.nextInt();
        }
        in.close();
        long [][] ans;
        long [][]answer = new long[k][2];
        for (int i = 0; i < k; i++) {
            answer[i][1] = 1;
        }
        for (int i = 0; i <= k; i++) {
            ans = new long[][]{new long[]{1, 1}, new long[]{0, 1}};
            for (int j = 1; j <= k; j++) {
                ans = multiplePolynomial(ans, new long[][]{new long[]{-i + j, 1},new long[]{1, 1}});
            }
            for (int l = 0; l < ans.length; l++) {
                ans[l][1] = factorial(k) * pow(r, i);
                ans[l][0] *= getAtIndex(i, p);
                long gcd = gcd(ans[l][1], ans[l][0]);
                ans[l][1] /= gcd;
                ans[l][0] /= gcd;
            }
            answer = sumPolynomial(ans, answer);
        }
        for (int i = 0; i <= k; i++) {
            out.print(answer[i][0] + "/" + answer[i][1] + " ");
        }
        out.close();
    }
}
