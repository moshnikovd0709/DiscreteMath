package laba2_matroid;

import java.io.*;
import java.util.*;

public class taskD {

    public static boolean flag = true;
    public static boolean third = false;

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

    public static void main(String[] args) throws FileNotFoundException {
        FastScanner in = new FastScanner(new File("C:\\Users\\Daniel\\IdeaProjects\\DiscreteMath\\src\\probability\\cycles.in"));
        PrintWriter out = new PrintWriter(new File("check.out"));
        int n = in.nextInt();
        int m = in.nextInt();
        int amount, num;
        HashSet<Long> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            long el = 0;
            amount = in.nextInt();
            for (int j = 0; j < amount; j++) {
                num = in.nextInt() - 1;
                el |= (1 << num);
            }
            set.add(el);
        }
        HashMap<Long, Integer> ones = new HashMap<>();
        for (Long s : set) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (((s >> j) & 1) == 1) {
                    count++;
                }
            }
            ones.put(s, count);
        }
        //first
        if (!set.contains(0L)) {
            flag = false;
        }
        //second
        loop:   for (long el : set) {
            for (int j = 0; j < n; j++) {
                long x = ((el >> j) & 1);
                if (x != 0) {
                    x = (1 << j);
                    el -= x;
                    if (!set.contains(el)) {
                        flag = false;
                        break loop;
                    }
                    el += x;
                }
            }
        }
        //third
        loop:   for (long el : set) {
            for (long el2 : set) {
                third = false;
                if (ones.get(el) > ones.get(el2)) {
                    for (int j = 0; j < n; j++) {
                        long x = ((el >> j) & 1);
                        if (x != 0) {
                            x  = (1 << j);
                            if (((el2 >> j) & 1) == 0) {
                                el2 += x;
                                if (set.contains(el2)) {
                                    third = true;
                                }
                                el2 -= x;
                            }
                        }
                    }
                    if (!third) {
                        flag = false;
                        break loop;
                    }
                }
            }
        }
        if (flag) {
            out.println("YES");
        } else {
            out.println("NO");
        }
        out.close();
    }
}
