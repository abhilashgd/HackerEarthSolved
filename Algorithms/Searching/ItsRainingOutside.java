package Searching;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.TreeSet;


public class ItsRainingOutside {

	 private void solve() {
		 int T=nextInt();
		 StringBuilder sb = new StringBuilder();
		 while(T-->0){
			 int n=nextInt();
			 int m=nextInt();
			 TreeSet<Integer> A = new TreeSet<Integer>();
			 TreeSet<Integer> B = new TreeSet<Integer>();
			 for(int i=0;i<n;i++) A.add(nextInt());
			 for(int i=0;i<m;i++) B.add(nextInt());
			 int count=0,size=B.size();
			 Iterator<Integer> itr = B.iterator();
			 boolean rFlag=true,lFlag=true;
			 int sum=0,low=0,high=0;
			 while(itr.hasNext()){
				 int temp = itr.next(); 
				 if(n>=m){
				 if(!A.contains(temp)){
					 if(A.ceiling(temp)==null && lFlag)
					 {	  
						  low=A.last();high=B.last();
						  sum+=(high-low-1);
						  lFlag=false;break;
					 }else if(A.floor(temp)==null && rFlag){
						 high=A.first();low=temp;count++;
						 sum+=(high-low);
						 rFlag=false;
					 }else if(A.ceiling(temp)!=null && A.floor(temp)!=null){
						 low =A.floor(temp);
						 high=A.ceiling(temp);
						 if((temp-low)<(high-temp))
							 { 
							 	sum+=(temp-low);count++;
								if(count<B.size()/2){ A.add(temp);
								 A.remove(low);}
							 }
						 else
						 {
							sum+=(high-temp); count++;
							if(count>B.size()/2){ A.add(temp);
							 A.remove(high);}
						 }
					 }					
				 }
				 }else{
					 if(!A.contains(temp)){
						 if(A.ceiling(temp)==null && lFlag)
						 {	  
							  low=A.last();high=B.last();
							  sum+=(high-low-1);
							  lFlag=false;
						 }else if(A.floor(temp)==null && rFlag){
							 high=A.first();low=temp;count++;
							 sum+=(high-low);
							 rFlag=false;
						 }else if(A.ceiling(temp)!=null && A.floor(temp)!=null){
							 low =A.floor(temp);
							 high=A.ceiling(temp);
							 if((temp-low)<(high-temp))
								 { 
								 	sum+=(temp-low);count++;
									
								 }
							 else
							 {
								sum+=(high-temp); count++;
								{ A.add(temp);
								 A.remove(high);}
							 }
						 }					
					 }
				 }
					 
			 }
			 sb.append(sum+"\n");
		 }
	
		 pw.println(sb.toString());
	}

	public static void main(String[] args) throws Exception { new ItsRainingOutside().run(); }
	  
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

