package HashTable;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Set;


public class XSquare {
	
	  public static void main(String[] args) throws Exception { new XSquare().solve(); }
	  
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
       
        while(T-->0)
        {
        	int oc=0;
        	str=nextLine();
        	char[] arr =str.toCharArray();
        	int len=arr.length;
        	for(int i=0;i<len;i++)
        		if(hT.isEmpty())
        			hT.put(arr[i], 1);
        		else if(hT.containsKey(arr[i]))
        				hT.put(arr[i],hT.get(arr[i])+1);
        		else
        			hT.put(arr[i], 1);
        	 Set<Character> hTKeys = hT.keySet();
        	 Iterator<Character> itr =hTKeys.iterator();
        	 while(itr.hasNext()){
        		 char temp = itr.next();
        		 if(hT.get(temp)==1)
        			 oc++;
        		 else if(hT.get(temp)%2!=0)
        			 oc++;
        	 }
        	if(oc==1 && len>1)
        		pw.println(0);
        	else if((oc-1)==-1)
        		pw.println(0);
        	else
        		pw.println(oc-1);
        	
        	hT.clear();
        }
        
        pw.flush();
        if(!INPUT.isEmpty())tr(System.currentTimeMillis()-s+"ms");
    }
    
}

