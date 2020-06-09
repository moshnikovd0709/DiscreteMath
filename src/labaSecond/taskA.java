package labaSecond;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class taskA {
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

        public static boolean flag = false;

        public static void main(String args[]) throws FileNotFoundException {
            FastScanner in = new FastScanner(new File("C:\\Users\\Daniel\\IdeaProjects\\DiscreteMath\\src\\probability\\destroy.in"));
            int n = in.nextInt();
        int cont_big = 64;
        int cont_small = 96;
        int start = in.next().charAt(0) - cont_big;
        TreeSet<Integer> current = new TreeSet<>();
        TreeSet<Integer> help = new TreeSet<>();
        current.add(start);
        String s;
        char first;
        char second;
        char third;
        boolean machine[][][] = new boolean[27][27][27];
        for (int i = 0; i < n; i++)  {
            s = in.nextLine();
            if (s.length() == 6) {
                first = s.charAt(0);
                second = s.charAt(5);
                machine[first - cont_big][second - cont_small][0] = true;
            } else {
                first = s.charAt(0);
                second = s.charAt(5);
                third = s.charAt(6);
                machine[first - cont_big][second - cont_small][third - cont_big] = true;
            }
        }
        int m = in.nextInt();
        PrintWriter out = new PrintWriter("automaton.out");
        for (int i = 0; i < m; i++) {
            s = in.nextLine();
            String[] letters = s.split("");
            for (int j = 0; j < letters.length - 1; j++) {
                for (int y : current) {
                    for (int k = 1; k < 27; k++) {
                        if (machine[y][letters[j].charAt(0) - cont_small][k] == true) {
                            help.add(k);
                        }
                    }
                }
                current.clear();
                for (int y : help) {
                    current.add(y);
                }
                help.clear();
            }
            for (int y : current) {
                if (machine[y][letters[letters.length - 1].charAt(0) - cont_small][0] == true) {
                    flag = true;
                }
            }
            if (flag) {
                out.println("yes");
            } else {
                out.println("no");
            }
            flag = false;
            current.clear();
            current.add(start);
        }
        out.close();
    }
}
