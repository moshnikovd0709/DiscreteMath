package laba2_matroid;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class taskC {

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

    public static int n;
    public static ArrayList<ArrayList<Integer>> g = new ArrayList<>();
    public static int[] mt;
    public static boolean[] used;

    public static class Pair implements Comparable<Pair> {
        int v;
        int w;

        public Pair(int a, int b) {
            this.v = a;
            this.w = b;
        }

        @Override
        public int compareTo(Pair o) {
            return Long.compare(o.w, this.w);
        }
    }

    public static boolean try_kun (int v) {
        if (used[v]) {
            return false;
        }
        used[v] = true;
        for (int i = 0; i < g.get(v).size(); i++) {
            int to = g.get(v).get(i);
            if (mt[to] == -1 || try_kun (mt[to])) {
                mt[to] = v;
                return true;
            }
        }
        return false;
    }

    public static void main(String []args) throws FileNotFoundException {
        FastScanner in = new FastScanner(new File("C:\\Users\\Daniel\\IdeaProjects\\DiscreteMath\\src\\probability\\cycles.in"));
        PrintWriter out = new PrintWriter(new File("matching.out"));
        n = in.nextInt();
        int size;
        used = new boolean[n];
        mt = new int[n];
        int or[] = new int[n];
        int w[] = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = in.nextInt();
            mt[i] = -1;
        }
        Pair[] a = new Pair[n];
        for(int i = 0 ; i < n; i++) {
            a[i] = new Pair(i, w[i]);
        }
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            or[i] = a[i].v;
        }
        for (int i = 0; i < n; i++) {
            size = in.nextInt();
            g.add(new ArrayList<>());
            for (int j = 0; j < size; j++) {
                g.get(i).add(in.nextInt() - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            int v = or[i];
            for (int j = 0; j < n; j++) {
                used[j] = false;
            }
            try_kun(v);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            if (mt[i] != -1) {
                ans[mt[i]] = i;
            }
        }
        for (int i = 0; i < n; i++) {
            out.print((ans[i] + 1) + " ");
        }
        out.close();
    }
}
