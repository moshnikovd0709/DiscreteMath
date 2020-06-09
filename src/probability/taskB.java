package probability;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class taskB {
    public static void main (String args[]) throws FileNotFoundException {
        Scanner in = new Scanner(new File("C:\\Users\\Daniel\\IdeaProjects\\DiscreteMath\\src\\probability\\shooter.in"));
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        double sum = 0;
        double cur;
        double []a = new double[n];
        for (int i = 0; i < n; i++) {
            cur = Double.parseDouble(in.next());
            cur = 1 - cur;
            cur = Math.pow(cur, m);
            a[i] = cur;
            sum = sum + cur;
        }
        in.close();
        double answer = a[k - 1];
        answer = answer / sum;
        PrintWriter out = new PrintWriter("shooter.out");
        out.println(answer);
        out.close();
    }
}
