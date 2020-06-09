package labaSecond;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class taskB {
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

    static boolean flag = false;

    public static void main(String args[]) throws FileNotFoundException {
        FastScanner in = new FastScanner(new File("C:\\Users\\Daniel\\IdeaProjects\\DiscreteMath\\src\\probability\\destroy.in"));
        String s = in.nextLine();
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int first;
        int second;
        String letter;
        char a;
        int states[] = new int[n + 1];
        for (int i = 0; i < k; i++) {
            states[in.nextInt()] = 1;
        }
        int machine[][][] = new int[n + 1][29][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < 29; j++) {
                machine[i][j][0] = 1;
            }
        }
        for (int i = 0; i < m; i++) {
            first = in.nextInt();
            second = in.nextInt();
            letter = in.next();
            a = letter.charAt(0);
            machine[first][a - 96][machine[first][a - 96][0]] = second;
            machine[first][a - 96][0]++;
        }
        ArrayList<Integer> current = new ArrayList<>();
        ArrayList<Integer> help = new ArrayList<>();
        current.add(1);
        PrintWriter out = new PrintWriter("problem2.out");
        String[] numbers = s.split("");
        for (int i = 0; i < s.length(); i++) {
            a = numbers[i].charAt(0);
            for (int h = 0; h < current.size(); h++) {
                for (int j = 1; j < machine[current.get(h)][a - 96][0]; j++) {
                    help.add(machine[current.get(h)][a - 96][j]);
                }
            }
            current.clear();
            for (int u = 0; u < help.size(); u++) {
                current.add(help.get(u));
            }
            help.clear();
        }
        for (int i = 0; i < current.size(); i++) {
            if (states[current.get(i)] == 1) {
                flag = true;
            }
        }
        if (flag) {
            out.println("Accepts");
        } else {
            out.println("Rejects");
        }
        out.close();
    }
}
