package laba1_graph;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class taskD {

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
    public static ArrayList<Integer> ans = new ArrayList<>();

    public static void dfs (int v, boolean used[], List<List<Integer>> g) {
        used[v] = true;
        for (int u : g.get(v)) {
            if (!used[u])
                dfs(u, used, g);
        }
        ans.add(v);
    }

    public static void main (String []args) throws FileNotFoundException {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(new File("guyaury.out"));
        int n = in.nextInt();
        if (n == 1) {
            out.print(n);
            out.close();
            return;
        } else if (n == 2) {
            n = in.nextInt();
            if (n == 1) {
                out.print(2 + " " + 1);
            } else {
                out.print(1 + " " + 2);
            }
            out.close();
            return;
        }
        boolean a[][] = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            a[i][i] = true;
        }
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '0') {
                    a[j][i] = true;
                    a[i][j] = false;
                } else {
                    a[i][j] = true;
                    a[j][i] = false;
                }
            }
        }
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                if (!a[i][j]) {
                    g.get(i).add(j);
                }
            }
        }
        for (int j = 0; j < n; j++) {
            boolean used[] = new boolean[n];
            ans.clear();
            dfs(j, used, g);
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
            if (ans.size() == n) {
                if (a[ans.get(n - 1)][ans.get(0)]) {
                    break;
                }
            }
        }
        for (int i = 0; i < ans.size(); i++) {
            out.print(ans.get(i) + 1 + " ");
        }
        out.close();
    }
}
