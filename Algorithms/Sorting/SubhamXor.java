package Sorting;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class SubhamXor {
		TreeMap<Integer,Integer> hs = new TreeMap<Integer,Integer>();
	 private void solve() {
		
		 StringBuilder sb = new StringBuilder();
		 int N=nextInt();
		 hs.put(nextInt(), 1);
		 while(N-->1)
			 add(nextInt());
		int count = getCount();	 
		sb.append(count);
		 
		 pw.print(sb.toString());	 
	     pw.flush();
	     pw.close();
		}
	 
	 
	private int getCount() {
		int count =0;
		Set<Integer> set = hs.keySet();
		Iterator<Integer> itr = set.iterator();
		
		while(itr.hasNext()){
			int temp = itr.next();
			int tc = hs.get(temp);
			//pw.println(temp+" "+tc);
			if(tc>1)
				count+=((tc-1)*tc)/2;
		}
		hs.clear();
		return count;
	}


	private void add(int elem) {
		
		 if(hs.containsKey(elem))
			{hs.put(elem,hs.get(elem)+1);}
		else
			{hs.put(elem,1);}
		
	}


	public static void main(String[] args) throws Exception { new SubhamXor().run(); }
	  
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
    private int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }
    private String nextString() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while(!(isSpaceChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
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
    private void tr(Object... o) { if(INPUT.length() > 0)System.out.println(Arrays.deepToString(o)); }
}

