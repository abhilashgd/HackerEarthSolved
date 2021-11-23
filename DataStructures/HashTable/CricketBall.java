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

public class CricketBall {
	
	
	 private void solve() {
		 int T=nextInt();
		 sBuilder str = new sBuilder();
		 while(T-->0)
		 {
		 int N=nextInt();
		 Table table = new Table();
		
		 for(int i=0;i<N;i++)
			 table.add(nextInt());
		 int K=nextInt();
		 int count = table.count(K);
		 table.clear();
		 str.setOutput(count);
		 }
		 str.getOutput();
	}
	
class Table{
	private Hashtable<Integer,Integer> hT = new Hashtable<Integer,Integer>();
	
	int get(int key){return hT.get(key);}
	
	public void add(int key) {
		
		if(hT.isEmpty())
			hT.put(key, 1);
		else if(hT.containsKey(key))
		 	hT.put(key, hT.get(key)+1);
		else
	 		 hT.put(key, 1);
	}
	
	public int count(int K){
		int count=0,val;
		Set<Integer> hTKeys = hT.keySet();
		Iterator<Integer> itr = hTKeys.iterator();
		int elem,pairEle;
		while(itr.hasNext()){
			elem=itr.next();
			val=this.get(elem);
			pairEle = K-elem;
		if((elem*2)==K)
			 count += recSum(val);
		else if(hTKeys.contains(pairEle))
					count += val*this.get(pairEle);
		itr.remove();
		}
		hT.clear();
	return count;	
	}
	
	int recSum(int val){
		if(val==2)
			return 1;
		else if(val>2)
			return val-1+recSum(val-1);
		return 0;
	}
	
	public void clear() { hT.clear();}
 
}

class sBuilder{
	private StringBuilder sb =new StringBuilder();
	
	void setOutput(int val){
		sb.append(val+"\n");
	}
	
	void getOutput(){
		pw.println(sb.toString());
	}
	
	
}

	  public static void main(String[] args) throws Exception { new CricketBall().run(); }
	  
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
 
    private String nextLine() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while(!(isSpaceString(b))){ // when nextLine)
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

