import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test {

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        FastScanner(InputStream f) {
            br = new BufferedReader(new InputStreamReader(f));
        }

        String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                return null;
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main (String args[]) {
        FastScanner in = new FastScanner(System.in);
        int first = in.nextInt();
        int second = in.nextInt();
        String letter = in.next();
        System.out.println(first);
        System.out.println(second);
        System.out.println(letter);
    }
}
