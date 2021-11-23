package BasicProgramming;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
public class MagicalWorld {
	 static boolean[] isPrime;
	private void solve() {
		int T = nextInt();
		sieveTill(130);
		StringBuilder sb = new StringBuilder();
		while(T-->0){
			int N=nextInt();
			String input=nextString();
			for(int i=0;i<input.length();i++){
				char ch=input.charAt(i);
				if(ch<65)
					sb.append('C');
				else if(ch<97 && ch>93)
					sb.append('a');
				else if(ch>90 && ch<=93 && ch<97)
					sb.append('Y');
				else if(ch>122)
					sb.append('q');
				else if(isPrime[ch])
					sb.append(ch);
				
				else{
					int j=(int)ch-1;
					int jCount=0;
					int k=(int)ch+1;
					int kCount=0;
					if(Character.isUpperCase(ch)){
					while(!isPrime[j] &j>=65)
						{j--;jCount++;}
					while(!isPrime[k] & k<=90)
						{k++;kCount++;}
					if(jCount==kCount)
						sb.append((char)j);
					else if(jCount<kCount && j!=64)
						sb.append((char)j);
					else if(k==91)
						sb.append((char)j);
					else
						sb.append((char)k);
					}
					
					if(Character.isLowerCase(ch)){
						while(!isPrime[j] &j>=97)
							{j--;jCount++;}
						while(!isPrime[k] & k<=122)
							{k++;kCount++;}
						if(jCount==kCount)
							sb.append((char)j);
						else if(jCount<kCount && j!=96)
							sb.append((char)j);
						else if(k==123)
							sb.append((char)j);
						else
							sb.append((char)k);
						}
				}
			}
			sb.append("\n");
		}
		pw.println(sb.toString());
	}

	 void sieveTill(int N) {
	        isPrime = new boolean[N+1];
	        for(int i = 0; i <= N;++i) {
	            isPrime[i] = true;
	        }
	        isPrime[0] = false;
	        isPrime[1] = false;
	        for(int i = 2; i * i <= N; ++i) {
	             if(isPrime[i] == true) {                    //Mark all the multiples of i as composite numbers
	                 for(int j = i * i; j <= N ;j += i)
	                     isPrime[j] = false;
	            }
	        }
	    }
  private boolean isNotVowel(char ch) {
		if(ch!='A' && ch!='E' && ch!='I' && ch!='O' && ch!='U' && ch!='Y' )
			return true;
		return false;
	}


public static void main(String[] args) throws Exception { new MagicalWorld().run(); }
	
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