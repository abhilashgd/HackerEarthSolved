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


public class StringInitial {
	
	  public static void main(String[] args) throws Exception { new StringInitial().solve(); }
	  
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
      private boolean isSpaceChar(int c) { return !(c >= 32 && c <= 126); }
      private int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }
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
        String str;
        Hashtable<Character,Integer>hT=new Hashtable<Character,Integer>();
        for(int i=97;i<123;i++)
        	hT.put((char)i, i-97);
        for(int i=49;i<58;i++)
        	hT.put((char)i, i-49+26);
        hT.put('0',35);
        for(int i=65;i<91;i++)
        	hT.put((char)i, i-65+26+10);
        
        while(T-->0)
        {
        	int sum=0;
        	str=nextLine();
        	String[] arr = str.split(" ");
        	int len=arr.length;
        	for(int i=0;i<len;i++)
        		for(int j=0;j<arr[i].length();j++)
        				sum+=j+hT.get(arr[i].charAt(j));
        	sum*=len;
        	pw.println(sum);
        }
        
        pw.flush();
        if(!INPUT.isEmpty())tr(System.currentTimeMillis()-s+"ms");
    }
   
}

