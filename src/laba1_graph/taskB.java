package laba1_graph;

public class taskB {
    public static void main(String[] args) {
        int n = 6;
        int a[] = new int[n];
        int i = 2;
        int x;
        for (int k = 0; k < n; k++) {
            a[k] = k;
        }
        for (int j = 1; j <= (i+1)/2; j++) {
            x = a[j];
            a[j] = a[i - j];
            a[i - j] = x;
        }
        for (int k = 0; k < n; k++) {
            System.out.print(a[k]);
        }
    }
}
