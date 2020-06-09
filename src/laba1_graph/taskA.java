package laba1_graph;

import java.io.*;
import java.util.*;

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

    public static void main(String args[]) throws FileNotFoundException {
        FastScanner in = new FastScanner(new File("chvatal.in"));
        int n = in.nextInt();
        boolean a[][] = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '0') {
                    a[i][j] = a[j][i] = false;
                } else {
                    a[i][j] = a[j][i] = true;
                }
            }
        }
        ArrayDeque<Integer> g = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            g.add(i);
        }
        int x;
        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(a[i][j]) {
                    System.out.print(1);
                } else {
                    System.out.print(0);
                }
            }
            System.out.println();
        }*/
        int first, second;
        for (int k = 0; k <= n * (n - 1); k++) {
            first = g.getFirst();
            g.pollFirst();
            second = g.getFirst();
            g.addFirst(first);
            if (!a[first][second]) {
                int[] b = new int[n];
                int count = 0;
                for (Object h : g.toArray()) {
                    b[count] =(Integer) h;
                    count++;
                }
                int i = 2;
                //System.out.print((a[b[0]][b[i]]) + " " + (a[b[1]][b[i+1]]));
                while ((i < n - 1) && ((!a[b[0]][b[i]]) || (!a[b[1]][b[i+1]]))) {
                    i++;
                }
                if (i == n - 1) {
                    i = 2;
                    while (!a[b[0]][b[i]]) {
                        i++;
                    }
                }
                i++;
                for (int j = 1; j < (i+1)/2; j++) {
                    x = b[j];
                    b[j] = b[i - j];
                    b[i - j] = x;
                }
                //System.out.println("******" + i);
                //for (int p = 0; p < n; p++) {
                  // System.out.print(b[p]);
                //}
                //System.out.println("******");
                g.clear();
                for (int j = 0; j < n; j++) {
                    g.addLast(b[j]);
                }
            }
            g.addLast(g.getFirst());
            g.pollFirst();
        }
        PrintWriter out = new PrintWriter(new File("fullham.out"));
        int[] b = new int[n];
        int c = 0;
        for (Object h : g.toArray()) {
            b[c] =(Integer) h;
            c++;
        }
        for (int i = 0; i < n; i++) {
            out.print(b[i] + 1 + " ");
        }
        out.close();
    }
}
