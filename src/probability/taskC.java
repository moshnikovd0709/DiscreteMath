package probability;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class taskC {
    public static void main (String args[]) throws FileNotFoundException {
        Scanner in = new Scanner(new File("lottery.in"));
        int n = in.nextInt();
        int m = in.nextInt();
        int cur;
        int prev = 0;
        int ben;
        long amount = 1;
        double sum;
        double answer = n;
        for (int i = 0; i < m; i++) {
            cur = in.nextInt();
            ben = in.nextInt();
            amount = amount * cur;
            if (amount < 0) {
                break;
            }
            sum = ben - prev;
            sum = sum / amount;
            answer = answer - sum;
            prev = ben;
        }
        PrintWriter out = new PrintWriter("lottery.out");
        out.println(answer);
        out.close();
    }
}
