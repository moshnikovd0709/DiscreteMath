package probability;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class taskD {

    public static double[][] mul(double[][] a, double[][] b) {
        int n = a.length;
        double[][] c = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    public static void main (String args[]) throws FileNotFoundException {
        Scanner in = new Scanner(new File("C:\\Users\\Daniel\\IdeaProjects\\DiscreteMath\\src\\probability\\destroy.in"));
        int n = in.nextInt();
        double a[][] = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = Double.parseDouble(in.next());
            }
        }
        in.close();
        for (int k = 0; k < 20; k++) {
            a = mul(a, a);
        }
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + a[0][i];
        }
        PrintWriter out = new PrintWriter("markchain.out");
        for (int i = 0; i < n; i++) {
            out.println(a[0][i] / sum);
        }
        out.close();
    }
}
