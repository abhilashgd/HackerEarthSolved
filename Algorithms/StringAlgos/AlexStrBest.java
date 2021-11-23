package StringAlgos;
import java.util.*;
import java.io.*;
 
public class AlexStrBest {
	long MOD = 1000000007;
	InputReader in;
	BufferedReader br;
	PrintWriter out;
 
	public static void main(String[] args) throws java.lang.Exception {
		AlexStrBest solver = new AlexStrBest();
		solver.in = new InputReader(System.in);
		solver.br = new BufferedReader(new InputStreamReader(System.in));
		solver.out = new PrintWriter(System.out);
		solver.solve();
		solver.out.flush();
		solver.out.close();
	}
 
	boolean[] valid;
	public void solve() {
        String s = in.readString();
        int k = in.readInt();
        int[] a = new int[30];
        for(int i=0;i<=26;i++) a[i] = 0;
        for(int i=0;i<k;i++){
            int b = s.charAt(i)-'a';
            a[b]++;
        }
        StringBuilder ans = new StringBuilder("");
        int j = k;
        while(j <= s.length()){
            int i = 0;
            while(true){
                if(a[i] >= 1){
                    ans.append((char)(i+97));
                    a[i]--;
                    break;
                }
                i++;
            }
            if(j < s.length()){
                int b = s.charAt(j)-'a';
                a[b]++;
            }
            j++;
        }
        int i = 0;
        while(true){
            int flag = 0;
            i=0;
            while(i <= 26){
                if(a[i] >= 1){
                    ans.append((char)(i+97));
                    a[i]--;
                    flag = 1;
                    break;
                }
                i++;
            }
            if(flag == 0){
                break;
            }
        }
        out.println(ans);
	}
}
 
class InputReader {
	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;
	private SpaceCharFilter filter;
 
	public InputReader(InputStream stream) {
		this.stream = stream;
	}
 
	public int read() {
		if (numChars == -1)
			throw new InputMismatchException();
		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (numChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}
 
	public int readInt() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		int res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}
 
	public void readInt(int[] A) {
		for (int i = 0; i < A.length; i++)
			A[i] = readInt();
	}
 
	public long readLong() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		long res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}
 
	public void readLong(long[] A) {
		for (int i = 0; i < A.length; i++)
			A[i] = readLong();
	}
 
	public double readDouble() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		double res = 0;
		while (!isSpaceChar(c) && c != '.') {
			if (c == 'e' || c == 'E')
				return res * Math.pow(10, readInt());
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		}
		if (c == '.') {
			c = read();
			double m = 1;
			while (!isSpaceChar(c)) {
				if (c == 'e' || c == 'E')
					return res * Math.pow(10, readInt());
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				m /= 10;
				res += (c - '0') * m;
				c = read();
			}
		}
		return res * sgn;
	}
 
	public char[] readCharA() {
		return readString().toCharArray();
	}
 
	public String readString() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isSpaceChar(c));
		return res.toString();
	}
 
	public boolean isSpaceChar(int c) {
		if (filter != null)
			return filter.isSpaceChar(c);
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}
 
	public String next() {
		return readString();
	}
 
	public interface SpaceCharFilter {
		public boolean isSpaceChar(int ch);
	}
 
}