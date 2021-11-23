package BasicProgramming;

import java.io.*;
import java.math.BigInteger;
import java.util.*;
 
public class Ratio {
 
    public static void main(String[] args) throws IOException {
        InputReaderOne in = new InputReaderOne();
        PrintWriter out = new PrintWriter(System.out);
        int t = 1;
        t = in.nextInt();
        Solver s = new Solver();
        while (t-- > 0) s.solve(in, out);
        out.close();
    }
}
 
class Solver {
    void solve(InputReaderOne in, PrintWriter out) {
        int n = in.nextInt();
        long sum_a = 0, sum_b = 0;
        int[] a = new int[n];
        boolean[] isA = new boolean[n];
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            char e = in.next().charAt(0);
            if (e == 'A') {
                sum_a += x;
            } else {
                sum_b += x;
            }
            a[i] = x;
            isA[i] = e == 'A';
        }
        if (sum_a == 0 || sum_b == 0) {
            out.println(Math.max(sum_a, sum_b));
            return;
        }
        long g = gcd(sum_a, sum_b);
        long ra = sum_a / g, rb = sum_b / g;
        int ans = 0;
        long currA = 0, currB = 0;
        for (int i = 0; i < n; i++) {
            if (isA[i]) {
                if (currB % rb == 0 && currB != 0) {
                    long div = currB / rb;
                    long req = div * ra;
                    if (req < currA) {
                        currA += a[i];
                    }
                    else if (a[i] >= req - currA) {
                        req -= currA;
                        ++ans;
                        currA = 0;
                        currB = 0;
                        currA += a[i] - req;
                    } else {
                        currA += a[i];
                    }
                } else {
                    currA += a[i];
                }
            } else {
                if (currA % ra == 0 && currA != 0) {
                    long div = currA / ra;
                    long req = div * rb;
                    if (req < currB) {
                        currB += a[i];
                    }
                    else if (a[i] >= req - currB) {
                        req -= currB;
                        ++ans;
                        currB = 0;
                        currA = 0;
                        currB += a[i] - req;
                    } else {
                        currB += a[i];
                    }
                } else {
                    currB += a[i];
                }
            }
//            out.println(ans + " " + currA + " " + currB);
        }
        out.println(ans);
    }
 
    private long gcd(long a, long b) {
        while (b > 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
 
class InputReaderOne {
    BufferedReader br;
    StringTokenizer st;
 
    public InputReaderOne() {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = null;
    }
 
    public String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return st.nextToken();
    }
 
    public int nextInt() {
        return Integer.parseInt(next());
    }
 
    public long nextLong() {
        return Long.parseLong(next());
    }
 
    public String nextLine() throws IOException {
        return br.readLine();
    }
 
    public double nextDouble() {
        return Double.parseDouble(next());
    }
}