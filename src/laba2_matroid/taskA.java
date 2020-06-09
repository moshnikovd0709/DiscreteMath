package laba2_matroid;

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

    public static class Pair implements Comparable<Pair> {
        int deadline;
        int fair;

        public Pair (int a, int b) {
            this.deadline = a;

   this.fair = b;
    }
        @Override
        public int compareTo(Pair o) {
            if (fair - o.fair > 0) {
                return -1;
            } else if (fair - o.fair < 0) {
                return 1;
            } else {
                if (deadline >= o.deadline) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    }

    public static void main (String []args) throws FileNotFoundException {
        FastScanner in = new FastScanner(new File("C:\\Users\\Daniel\\IdeaProjects\\DiscreteMath\\check.out"));
        PrintWriter out = new PrintWriter(new File("destroy.out"));
        int n = in.nextInt();
        int d,w;
        Pair[] ar = new Pair[n];
        for (int i = 0; i < n; i++) {
            d = in.nextInt();
            w = in.nextInt();
            ar[i] = new Pair(d, w);
        }
        Arrays.sort(ar);
        long count = 0;
        Map<Pair, Integer> ans = new HashMap<>();
        TreeSet<Integer> num = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            num.add(i);
        }
        for (int i = 0; i < n; i++) {
            if (num.lower(ar[i].deadline) != null) {
                ans.put(ar[i], num.lower(ar[i].deadline));
                num.remove(num.lower(ar[i].deadline));
            } else {
                ans.put(ar[i], num.last());
                num.remove(num.last());
            }
        }
        for (int i = 0; i < ar.length; i++) {
            if (ans.get(ar[i]) >= ar[i].deadline) {
                count += ar[i].fair;
            }
        }
        //for (int i = 0; i < ar.length; i++) {
          //  out.println(ans.get(ar[i]) + " " + ar[i].deadline + " " + ar[i].fair);
        //}
        out.print(count);
        out.close();
    }
}
