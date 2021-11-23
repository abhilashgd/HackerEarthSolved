package HashTable;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
 
class Test {
	static long m = 100000007;
 
	public static void main(String[] args) throws IOException {
		Reader r = new Reader();
		PrintWriter o = new PrintWriter(System.out, false);
		int n = r.nextInt();
		int c = r.nextInt();
		int[] parent = new int[n + 1];
		int[] color = new int[n + 1];
		parent[1] = 1;
		for (int i = 2; i <= n; i++) {
			parent[i] = r.nextInt();
		}
		for (int i = 1; i <= n; i++) {
			color[i] = r.nextInt();
		}
		o.print(-1 + " ");
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
				o.print(par + " ");
			} else {
				o.print(-1 + " ");
			}
		}
		o.close();
	}
 
	static ArrayList<Long> a = new ArrayList<>();
	static boolean arr[] = new boolean[100001];
 
	public static void sieve(int n) {
		if (n >= 2) {
			long i, j = 0;
			for (i = 2; i < n; i++) {
				if (arr[(int) i] == false) {
					a.add(i);
					j++;
					markmulti(arr, i, n);
				}
			}
			// System.out.println(j);
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
 
	// input/output
	static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;
 
		public Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}
 
		public Reader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}
 
		public final String readString() throws IOException {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.append((char) c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}
 
		private boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
 
		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}
 
		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}
 
		public double nextDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (c == '.')
				while ((c = read()) >= '0' && c <= '9')
					ret += (c - '0') / (div *= 10);
			if (neg)
				return -ret;
			return ret;
		}
 
		public int[] readIntArray(int size) throws IOException {
			int[] arr = new int[size];
			for (int i = 0; i < size; i++)
				arr[i] = nextInt();
			return arr;
		}
 
		public long[] readLongArray(int size) throws IOException {
			long[] arr = new long[size];
			for (int i = 0; i < size; i++)
				arr[i] = nextInt();
			return arr;
		}
 
		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}
 
		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}
 
		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}
}