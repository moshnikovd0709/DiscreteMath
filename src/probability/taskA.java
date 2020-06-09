package probability;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class taskA {
    public static void main (String args[]) throws FileNotFoundException {
        Scanner in = new Scanner(new File ("C:\\Users\\Daniel\\IdeaProjects\\DiscreteMath\\src\\probability\\exam.in"));
        int k = in.nextInt();
        int n = in.nextInt();
        int m;
        int p;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            m = in.nextInt();
            p = in.nextInt();
            sum += (p * m);
        }
        in.close();
        double answer = sum;
        answer = answer / n / 100;
        PrintWriter out = new PrintWriter("exam.out");
        out.println(answer);
        out.close();
    }
}
