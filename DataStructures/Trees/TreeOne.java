package Trees;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;


public class TreeOne {
	static long m = 100000007;
	 private void solve() {
			
			int n = nextInt();
			int c = nextInt();
			int[] parent = new int[n + 1];	
			int[] color = new int[n + 1];
			parent[1] = 1;
			for (int i = 2; i <= n; i++) {
				parent[i] = nextInt();
			}
			for (int i = 1; i <= n; i++) {
				color[i] =nextInt();
			}
			pw.print(-1 + " ");
			for (int i = 2; i <= n; i++) {
				int col = color[i];
				int j = i;
				int par = parent[j];
				while (color[par] != col) {
					par = parent[par];
					if (par == 1 && color[par] != col) {
						break;
					}
				}
				if (color[par] == col) {
					pw.print(par + " ");
				} else {
					pw.print(-1 + " ");
				}
			}
			pw.close();
		}
/*	 
		static ArrayList<Long> a = new ArrayList<>();
		static boolean arr[] = new boolean[100001];
	 
		public static void sieve(int n) {
			if (n >= 2) {
				long i;
				for (i = 2; i < n; i++) {
					if (arr[(int) i] == false) {
						a.add(i);
						
						markmulti(arr, i, n);
					}
				}
				
			}
		}
	 
		private static void markmulti(boolean[] arr, long l, int n) {
			int i = 2, num;
			while ((num = (int) (i * l)) <= n) {
				arr[num] = true;
				i++;
			}
		}
	 
		// pair object x,y
		static class pair {
			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + x;
				result = prime * result + y;
				return result;
			}
	 
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				pair other = (pair) obj;
				if (x != other.x)
					return false;
				if (y != other.y)
					return false;
				return true;
			}
	 
			int x, y;
	 
			public pair(int x, int y) {
				this.x = x;
				this.y = y;
			}
		}
	 
		// gcd int no
		static int gcd(int n, int r) {
			return r == 0 ? n : gcd(r, n % r);
		}
	 
		static long[][] modPow(long[][] M, long exp) {
			long[][] result = new long[][] { { 1, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 } };
			long[][] pow = M;
			while (exp != 0) {
				if ((exp & 1) == 1) {
					result = multiply(result, pow);
				}
				exp >>>= 1;
				pow = multiply(pow, pow);
			}
			return result;
		}
	 
		static long[][] multiply(long[][] A, long[][] B) {
			long[][] C = new long[4][4];
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					long value = 0;
					for (int k = 0; k < 4; k++) {
						value += A[i][k] * B[k][j];
					}
					C[i][j] = value % m;
				}
			}
			return C;
		}
	 
		// gcd long numbers
		static long gcd(long n, long r) {
			return r == 0 ? n : gcd(r, n % r);
		}
*/

	 
	
	 
	  public static void main(String[] args) throws Exception { new TreeOne().run(); }
	  
	InputStream is;
    PrintWriter pw;
    String INPUT = "";
    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        pw = new PrintWriter(System.out);
        long s = System.currentTimeMillis();
        solve();
        pw.flush();
        if(!INPUT.isEmpty())tr(System.currentTimeMillis()-s+"ms");
    }
   
	private byte[] inbuf = new byte[1024];
    public int lenbuf = 0, ptrbuf = 0;
 
    private int readByte() {
        if(lenbuf == -1)throw new InputMismatchException();
        if(ptrbuf >= lenbuf){
            ptrbuf = 0;
            try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
            if(lenbuf <= 0)return -1;
        }
        return inbuf[ptrbuf++];
    }
 
    private boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
    private boolean isSpaceString(int c){return !(c >= 32 && c <= 126); }
    private int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }
 
    private double nextDouble() { return Double.parseDouble(nextString()); }
    private char nextChar() { return (char)skip(); }
   
    private String nextString() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while(!(isSpaceChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }
 	
    private String nextLine() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while(!(isSpaceString(b))){ // when nextLine)
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }
    private char[] nextString(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while(p < n && !(isSpaceChar(b))){
            buf[p++] = (char)b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }
 
    private char[][] nextMap(int n, int m) {
        char[][] map = new char[n][];
        for(int i = 0;i < n;i++)map[i] = nextString(m);
        return map;
    }
 
    private int[] nextArray(int n) {
        int[] a = new int[n];
        for(int i = 0;i < n;i++)a[i] = nextInt();
        return a;
    }

    private int nextInt() {
        int num = 0, b;
        boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if(b == '-'){
            minus = true;
            b = readByte();
        }
 
        while(true){
            if(b >= '0' && b <= '9'){
                num = num * 10 + (b - '0');
            }else{
                return minus ? -num : num;
            }
            b = readByte();
        }
    }
 
    private long nextLong() {
        long num = 0;
        int b;
        boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if(b == '-'){
            minus = true;
            b = readByte();
        }

        while(true){
            if(b >= '0' && b <= '9'){
                num = num * 10 + (b - '0');
            }else{
                return minus ? -num : num;
            }
            b = readByte();
        }
    }
  
    private void tr(Object... o) { if(INPUT.length() > 0)System.out.println(Arrays.deepToString(o)); }
}

