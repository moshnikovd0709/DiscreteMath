package laba1_functions;

import java.io.PrintWriter;
import java.util.Scanner;

public class task_C {

    public static int getMaxDeg(long[] p) {
        int deq = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i] != 0) {
                deq = i;
            }
        }
        return deq;
    }

    public static long getAtIndex(int index, long[] p) {
        if (index >= p.length || index < 0) {
            return 0;
        } else {
            return p[index];
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        long []a = new long[k];
        long []c = new long[k];
        for (int i = 0; i < k; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < k; i++) {
            c[i] = in.nextInt();
        }
        in.close();
        //solve
        PrintWriter out = new PrintWriter(System.out);
        long secondAns[] = new long[k + 1];
        secondAns[0] = 1;
        for (int i = 1; i <= k; i++) {
            secondAns[i] = -c[i - 1];
        }
        long firstAns[] = new long[k];
        for (int i = 0; i < k; i++) {
            long x = 0;
            for (int j = 1; j < k + 1; j++) {
                x += getAtIndex(j - 1, c) * getAtIndex(i - j, a);
            }
            firstAns[i] = a[i] - x;
        }
        //print answer
        out.println(getMaxDeg(firstAns));
        for (int i = 0; i <= getMaxDeg(firstAns); i++) {
            out.print(firstAns[i] + " ");
        }
        out.println();
        out.println(getMaxDeg(secondAns));
        for (int i = 0; i <= getMaxDeg(secondAns); i++) {
            out.print(secondAns[i] + " ");
        }
        out.close();
    }
}
