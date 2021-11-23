package Graphs;

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Random;
import java.io.IOException;
import java.util.InputMismatchException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.io.BufferedReader;
import java.io.InputStream;

public class LISLDSJavaBest {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        FastPrinter out = new FastPrinter(outputStream);
        LISAndLDS solver = new LISAndLDS();
        solver.solve(1, in, out);
        out.close();
    }
    static class LISAndLDS {
        public void solve(int testNumber, FastScanner in, FastPrinter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            in.nextInt();
            int[] vEdges = new int[m];
            int[] uEdges = new int[m];
            for (int i = 0; i < m; i++) {
                vEdges[i] = in.nextInt() - 1;
                uEdges[i] = in.nextInt() - 1;
            }
            int[][] edges = GraphUtils.getEdgesUndirectedUnweighted(n, vEdges, uEdges);
            int[] answer = solve2(n, edges);
            out.println(answer.length);
            for (int i = 0; i < answer.length; i++) {
                if (i > 0) out.print(' ');
                out.print(answer[i] + 1);
            }
            out.println();
        }
        private int[] solve2(int n, int[][] edges) {
            long start = System.currentTimeMillis();
            Random rng = new Random(12323L);
            int[] answer = new int[]{0};
            long best = Long.MIN_VALUE;
            int[] fInc = new int[n + 1];
            int[] fDec = new int[n + 1];
            while (System.currentTimeMillis() - start < 3500) {
                for (int[] e : edges) ArrayUtils.shuffle(e);
                int v = rng.nextInt(n);
                Arrays.fill(fInc, Integer.MAX_VALUE);
                Arrays.fill(fDec, Integer.MIN_VALUE);
                fInc[0] = Integer.MIN_VALUE;
                fDec[0] = Integer.MAX_VALUE;
                LISAndLDS.Answer ans = new LISAndLDS.Answer(Long.MIN_VALUE, -1, -1);
                ans.dfs(v, fInc, 0, fDec, 0, edges, v);
                if (ans.best > best) {
                    best = ans.best;
                    answer = ans.getPath(ans.from, ans.to, edges);
                }
            }
            return answer;
        }
        static class Answer {
            long best;
            int from;
            int to;
            int[] path;
            int cn;
            boolean[] used;
            public Answer(long best, int from, int to) {
                this.best = best;
                this.from = from;
                this.to = to;
            }
            int[] getPath(int v, int t, int[][] edges) {
                if (path == null) {
                    path = new int[edges.length];
                    used = new boolean[edges.length];
                    cn = 0;
                }
                path[cn++] = v;
                if (v == t) {
                    return Arrays.copyOf(path, cn);
                }
                used[v] = true;
                for (int to : edges[v]) {
                    if (used[to]) continue;
                    int[] got = getPath(to, t, edges);
                    if (got != null) return got;
                }
                --cn;
                return null;
            }
            void dfs(int v, int[] fInc, int bestInc, int[] fDec, int bestDec, int[][] edges, int start) {
                if (used == null) {
                    used = new boolean[edges.length];
                }
                int curInc;
                int oldIncValue;
                int curDec;
                int oldDecValue;
                {
                    int left = 0;
                    int right = bestInc + 1;
                    while (left < right - 1) {
                        int mid = (left + right) >>> 1;
                        if (fInc[mid] < v) {
                            left = mid;
                        } else {
                            right = mid;
                        }
                    }
                    oldIncValue = fInc[right];
                    fInc[right] = v;
                    curInc = right;
                }
                {
                    int left = 0;
                    int right = bestDec + 1;
                    while (left < right - 1) {
                        int mid = (left + right) >>> 1;
                        if (fDec[mid] > v) {
                            left = mid;
                        } else {
                            right = mid;
                        }
                    }
                    oldDecValue = fDec[right];
                    fDec[right] = v;
                    curDec = right;
                }
                used[v] = true;
                for (int to : edges[v]) {
                    if (used[to]) continue;
                    dfs(to, fInc, Math.max(bestInc, curInc), fDec, Math.max(bestDec, curDec), edges, start);
                }
                long curValue = (long) Math.max(bestInc, curInc) * Math.max(bestDec, curDec);
                if (curValue > best) {
                    best = curValue;
                    from = start;
                    to = v;
                }
                fInc[curInc] = oldIncValue;
                fDec[curDec] = oldDecValue;
            }
        }
    }
    static class FastScanner extends BufferedReader {
        public FastScanner(InputStream is) {
            super(new InputStreamReader(is));
        }
        public int read() {
            try {
                int ret = super.read();
                return ret;
            } catch (IOException e) {
                throw new InputMismatchException();
            }
        }
        static boolean isWhiteSpace(int c) {
            return c >= 0 && c <= 32;
        }
        public int nextInt() {
            int c = read();
            while (isWhiteSpace(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int ret = 0;
            while (c >= 0 && !isWhiteSpace(c)) {
                if (c < '0' || c > '9') {
                    throw new NumberFormatException("digit expected " + (char) c
                            + " found");
                }
                ret = ret * 10 + c - '0';
                c = read();
            }
            return ret * sgn;
        }
        public String readLine() {
            try {
                return super.readLine();
            } catch (IOException e) {
                return null;
            }
        }
    }
    static class GraphUtils {
        public static int[][] getEdgesUndirectedUnweighted(int n, int[] v, int[] u) {
            int[][] edges = new int[n][];
            int[] deg = getDegreeUndirected(n, v, u);
            for (int i = 0; i < n; i++) {
                edges[i] = new int[deg[i]];
            }
            int m = v.length;
            Arrays.fill(deg, 0);
            for (int i = 0; i < m; i++) {
                edges[v[i]][deg[v[i]]++] = u[i];
                edges[u[i]][deg[u[i]]++] = v[i];
            }
            return edges;
        }
        public static int[] getDegreeUndirected(int n, int[] v, int[] u) {
            int[] deg = new int[n];
            for (int i : v) {
                deg[i]++;
            }
            for (int i : u) {
                deg[i]++;
            }
            return deg;
        }
    }
    static class FastPrinter extends PrintWriter {
        public FastPrinter(OutputStream out) {
            super(out);
        }
        public FastPrinter(Writer out) {
            super(out);
        }
    }
    static class ArrayUtils {
        static final long seed = System.nanoTime();
        static final Random rand = new Random(seed);
        public static void shuffle(int[] a) {
            for (int i = 0; i < a.length; i++) {
                int j = rand.nextInt(i + 1);
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
    }
}