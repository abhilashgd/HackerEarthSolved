package Trees;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class TreeTwo {
	
	 private void solve() {
			
			int N = nextInt();
			Enumeration<Integer> e;
			int a=0,b=0;
			int[] temp = new int[N];
			int key=0;
			@SuppressWarnings("rawtypes")
			List<Integer>[] list = new LinkedList[N+1];
			
			for(int i=1;i<=N;i++)
				list[i] = new LinkedList<Integer>();
			
			
			Hashtable<Integer,LinkedList<Integer>> table = new Hashtable<Integer,LinkedList<Integer>>();
			Stack<Integer> stack = new Stack<Integer>();
			for(int i=0;i<N-1;i++)
				{
					key=nextInt(); if(i==0) a=key;
					list[key].add(nextInt());
					table.put(key, (LinkedList<Integer>) list[key]);
				}
			e=table.keys();
			int x=0,size;
			while(e.hasMoreElements())
			{
				x=e.nextElement();
				size=table.get(x).size();
				
				for(int i=0;i<size;i++)
				{
					int temp1 = table.get(x).get(i);
					if(!table.containsKey(temp1) && !stack.contains(temp1)){
						stack.push(temp1);break;
					}
				}
			}
			if(stack.size()<2){
			b=stack.pop();
			pw.print(a+" "+b);
				
			}else{
				b=stack.pop();
				a=stack.pop();
				pw.print(a+" "+b);
			}
			
			stack.clear();
			pw.close();
		}
	 
	 
	
	 
	 
	 
	  public static void main(String[] args) throws Exception { new TreeTwo().run(); }
	  
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

