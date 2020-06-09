package laba2_matroid;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class taskB {

    public static class Pair implements Comparable<Pair> {
        int first;
        int second;
        long cost;
        int num;

        public Pair(int a, int b, long c, int num) {
            this.first = a;
            this.second = b;
            this.cost = c;
            this.num = num;
        }

        @Override
        public int compareTo(Pair o) {
            return Long.compare(o.cost, this.cost);
        }
    }

        public static class cnm {
            int[] set; // ссылки
            int[] rnk; // ранги

            public cnm(int size) {
                set = new int[size];
                rnk = new int[size];
                for (int i = 0; i < size; i++) {
                    set[i] = i;
                }
            }

            public int setOf(int x) {
                if (x == set[x]) {
                    return x;
                } else {
                    return set[x] = setOf(set[x]);
                }
            }

            public boolean union(int i, int j) {
                if ((i = setOf(i)) == (j = setOf(j))) {
                    return false;
                }
                if (rnk[i] > rnk[j]) {
                    set[j] = i;
                } else {
                    set[i] = j;
                    if (rnk[i] == rnk[j]) {
                        rnk[j]++;
                    }
                }
                return true;
            }
        }

        public static void main(String[] args) throws FileNotFoundException {
            Scanner in = new Scanner(new File("C:\\Users\\Daniel\\IdeaProjects\\DiscreteMath\\src\\probability\\destroy.in"));
            PrintWriter out = new PrintWriter(new File("destroy.out"));
            int n = in.nextInt();
            int m = in.nextInt();
            long s = in.nextLong();
            Pair ar[] = new Pair[m];
            int first, second;
            long cost;
            int count = 0;
            ArrayList<Integer> a = new ArrayList<>();
            int x[] = new int[m];
            for (int i = 0; i < m; i++) {
                first = in.nextInt() - 1;
                second = in.nextInt() - 1;
                cost = in.nextLong();
                ar[i] = new Pair(first, second, cost, i + 1);
            }
            Arrays.sort(ar);
            cnm gr = new cnm(n);
            for (int i = 0; i < m; i++) {
                if (!gr.union(ar[i].first, ar[i].second)) {
                    a.add(i);
                }
            }
            for (int i = a.size() - 1; i >= 0; i--) {
                if (s >= ar[a.get(i)].cost) {
                    s -= ar[a.get(i)].cost;
                    x[count] = ar[a.get(i)].num;
                    count++;
                }
            }
            out.println(count);
            Arrays.sort(x);
            for (int i = x.length - count; i < x.length; i++) {
                out.print(x[i] + " ");
            }
            out.close();
        }
    }
