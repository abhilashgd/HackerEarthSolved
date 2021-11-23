package HashTable;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.LinkedList;


public class DifficultChars {
	
	  public static void main(String[] args) throws Exception { new DifficultChars().solve(); }
	  
		InputStream is;
	    PrintWriter pw;
	    String INPUT = "";
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
      private int nextInt() {
        int num = 0, b; boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if(b == '-'){minus = true;b = readByte();}
 
        while(true){
            if(b >= '0' && b <= '9'){num = num * 10 + (b - '0');}
            else{return minus ? -num : num;} b = readByte();
        }
    }
      private boolean isSpaceChar(int c) { return !(c >= 97 && c <= 122); }
      private int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }
      private char nextChar() { return (char)skip(); }
      private String nextLine() {
          int b = skip();
          StringBuilder sb = new StringBuilder();
          while(!(isSpaceChar(b))){ 
              sb.appendCodePoint(b);
              b = readByte();
          }
          return sb.toString();
      }
      private void tr(Object... o) { if(INPUT.length() > 0)System.out.println(Arrays.deepToString(o)); }
    
    void solve() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        pw = new PrintWriter(System.out);
        long s = System.currentTimeMillis();
        int T=nextInt();
        
        
        while(T-->0)
        {
        	int[] a = new int[123];
        	char[] arr=nextLine().toCharArray();
        	for(int i=0;i<arr.length;i++)
        			a[arr[i]]++;
        	
        	LinkedList<Points> ll = new LinkedList<Points>();
        	for(int i=97;i<123;i++)
        		ll.add(new Points(i,a[i]));
        	Collections.sort(ll, new Comparator<Points>(){
        						 public int compare(Points o1, Points o2) {
        						 int result = Integer.compare(o1.getCount(), o2.getCount());
        						 if(result==0)
        							 return Integer.compare(o2.getChar(), o1.getChar());
        						 return result;}});		
        	for(int i=0;i<ll.size();i++)
        		pw.print((char)ll.get(i).getChar()+" ");
        	pw.println();
        }
        
        pw.flush();
        if(!INPUT.isEmpty())tr(System.currentTimeMillis()-s+"ms");
    }
    class Points{
    	private int ch;
    	private int count;
    	public Points(int ch, int count) {
			this.count=count;
			this.ch=ch;
		}
    	public int getChar(){return this.ch;}
    	public int getCount(){return this.count;}
    }
    

}

