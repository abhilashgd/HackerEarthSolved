package HashTable;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class PoliceThieves {

	 @SuppressWarnings("unchecked")
	private void solve() {
			
		 int T=nextInt();
		 
		 while(T-->0){
			 int count=0;
			 int N=nextInt();
			 int K=nextInt();
			 for(int i=0;i<N;i++){
				 ArrayList<Integer> p=new ArrayList<Integer>();
				 TreeSet<Integer> t = new TreeSet<Integer>();
				 
				 for(int j=0;j<N;j++){if(nextChar()=='P'){p.add(j);}else t.add(j);}
				 pw.print(p+" "+t+" ");
				 if(p.size()>0){
					 for(int k=0;k<p.size();k++){
						 int pCurrPos=p.get(k);
						 if(t.floor(pCurrPos)!=null){
							 Set<Integer> set =t.subSet(0, t.floor(pCurrPos)+1);
							 Iterator<Integer> itr=set.iterator();
							 boolean flag=true;
							 while(itr.hasNext())
							 {
								 int temp=itr.next();
									if(pCurrPos-temp<=K){//pw.print(" "+(pCurrPos-temp)+" ");
										count++;t.remove(temp);//pw.print(" "+set+" ");
										flag=false;break;
										} 
							 }
							 if(!flag)continue;
							
						}if(t.ceiling(pCurrPos)!=null){
							 TreeSet<Integer> set = (TreeSet<Integer>) t.subSet(t.ceiling(pCurrPos),t.last()+1);
							 Iterator<Integer> itr=set.descendingIterator();//pw.print(" "+set+" ");
							 boolean flag=true;
							 while(itr.hasNext())
							 {
								 int temp=itr.next();
									if(temp-pCurrPos<=K){//pw.print(" "+(temp-pCurrPos)+" ");pw.print(" "+set+" ");
										count++;t.remove(temp);
										flag=false;break;
										} 
							 }
							 if(!flag)continue;
						}
					 }
				 }
				 pw.println(count);
			 }
			 pw.println(count);
		 }
		 
		 
		}

	 
	  public static void main(String[] args) throws Exception { new PoliceThieves().run(); }
	  
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
 
    private char nextChar() { return (char)skip(); }
   
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

