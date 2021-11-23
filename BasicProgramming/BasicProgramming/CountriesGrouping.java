package BasicProgramming;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class CountriesGrouping {
	
	 private void solve() {
		 StringBuilder sb = new StringBuilder();
		 int T=nextInt();
		 while(T-->0){
			 int N=nextInt();
			 int count=0,temp;
			 TreeMap<Integer,Integer> tree = new TreeMap<Integer,Integer>();
			 while(N-->0)
			 {
				  temp=nextInt();
				 if(temp==1)
					 count++;
				 else{
					 if(tree.isEmpty())
						 tree.put(temp, 1);
					 else if(tree.containsKey(temp))
						 tree.put(temp, tree.get(temp)+1);
					 else
						 tree.put(temp, 1);
				 }
			 }
			 Set<Integer> keys = tree.keySet();
			 Iterator<Integer> itr = keys.iterator();
			 pw.println(tree.size());
			 boolean flag=true;
			 while(itr.hasNext()){
				 temp=itr.next();
				 if(tree.get(temp)%temp==0)
				 	count=count+tree.get(temp)/temp;
				 else{
					 flag=false;break;
				 }
			 }
			 if(!flag)
				 sb.append("Invalid Data\n");
			 else
				 sb.append(count+"\n");
		 }
		 pw.print(sb.toString());
	     pw.flush();
	     pw.close();
		}
	
	public static void main(String[] args) throws Exception { new CountriesGrouping().run(); }
	  
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

