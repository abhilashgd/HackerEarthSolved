import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class GiftVouchers {
	static final int MAX=1000000;
	 private void solve() {
			
		 int N=nextInt();
		 int M=nextInt();
		 int K=nextInt();
		 int count=0;
		 TreeSet<Integer>[] set = new TreeSet[MAX];
		 for(int i=0;i<MAX;i++)
			 set[i]=new TreeSet<Integer>();
		 int flightID=0;
		 while(M-->0){
			 int x=nextInt();
			 int y=nextInt();
			 boolean flag=true;
			 if(flightID==0){
				 set[flightID].add(x);
				 set[flightID].add(y);
				// pw.println(set[flightID]);
				 flightID++;
				 }
			 else{
				 for(int i=0;i<=flightID;i++){
					 if(set[i].contains(x)||set[i].contains(y)){
						 set[i].add(x);set[i].add(y);
						 flag=false;
						// pw.println(set[i]);
						 break;
						 
					 }
				 }
				 if(flag){
					 set[flightID].add(x);
					 set[flightID].add(y);
					// pw.println(set[flightID]);
					 flightID++;
					 }
			 }
		 }
		 int arr[] = new int[N];
		 int j=0,mK=K;
		 for(int i=0;i<flightID;i++){
			 mK=K;
			 if(set[i].size()>=K){
				 count++;
				 Iterator<Integer> itr = set[i].iterator();
				 while(itr.hasNext() && mK>1){
					 mK--;itr.next();
				 }
				 arr[j]=itr.next();j++;
			 }
		 }
		 pw.println(count);
		 for(int i=0;i<j;i++){
			 pw.print(arr[i]+" ");
		 }
		}
	 
	  public static void main(String[] args) throws Exception { new GiftVouchers().run(); }
	  
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

