package Stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.util.StringTokenizer;

 
public class Solution implements Runnable {
 
	static final long MOD = (long) 1e9 + 7;
	static final Reader in = new Reader();
	static final PrintWriter out = new PrintWriter(System.out);
 
	public static void main(String[] args) {
		new Thread(null, new Solution(), "persefone", 1 << 28).start();
	}
 
	StringBuilder solve(int[] a, int n) {
		int[] f = new int[100001];
		for (int i = 0; i < n; i++) 
			f[a[i]]++;
		int[] b = new int[n];
		for (int i = 0; i < n; i++) 
			b[i] = f[a[i]];
		int[] right = new int[n];
		right[n - 1] = -1;
		for (int i = n - 2; i > -1; i--) {
			if (b[i + 1] > b[i]) {
				right[i] = i + 1; 
			} else {
				int k = right[i + 1];
				while (k != -1) {
					if (b[k] > b[i])
						break;
					k = right[k];
				}
				right[i] = k;
			}
		}
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int x = (right[i] != -1) ? a[right[i]] : -1;
			s.append(x);
			s.append(" ");
		}
		return s;
		
	}
	
	@Override
	public void run() {
		for (int t = in.nextInt(); t > 0; t--) {
			int n = in.nextInt();
			int[] a = in.nextIntArray(n);
			out.println(solve(a, n));
		}
		out.close();
	}
 
	
	static class Pair {
		int x, y;
 
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override 
		public String toString() {
			return x + " " + y;
		}
	}
 
	static class Reader {
		BufferedReader br;
		StringTokenizer st;
 
		Reader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
 
		//
		boolean isReady() {
			try {
				return br.ready();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
		}
 
		//
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
 
		//
		int nextInt() {
			return Integer.parseInt(next());
		}
 
		//
		long nextLong() {
			return Long.parseLong(next());
		}
 
		//
		int[] nextIntArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}
 
		//
		String nextLine() {
			String s = "";
			try {
				s = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return s;
		}
	}
}