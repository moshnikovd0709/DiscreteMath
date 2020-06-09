import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

    public class stack {
        static class MyQueue {
            int maxSize;
            String[] queArray;
            int front;
            int rear;
            int nItems;

            public MyQueue(int sizeQueue) {
                maxSize = sizeQueue;
                queArray = new String[maxSize];
                front = 0;
                rear = -1;
                nItems = 0;
            }

            public void push(String element) {
                queArray[++rear] = element;
                nItems++;
            }

            public String pop() {
                nItems--;
                return queArray[front++];
            }


            public boolean isEmpty() {
                return (nItems == 0);
            }

            public boolean isFull() {
                return (nItems == maxSize);
            }
        }

        public static void main(String[] args) throws FileNotFoundException {
            Scanner sc = new Scanner(new File("destroy.in"));
            PrintWriter out = new PrintWriter(new File("output.txt"));
            int n = sc.nextInt();
            MyQueue []a = new MyQueue[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = new MyQueue((int) 1e5);
            }
            int x;
            String s;
            while (sc.hasNext()) {
                x = sc.nextInt();
                s = sc.next();
                a[x].push(s);
            }
            for (int i = 1; i <= n; i++) {
                while (!a[i].isEmpty()) {
                    out.println(i + " " + a[i].pop());
                }
            }
            sc.close();
            out.close();
        }
    }
