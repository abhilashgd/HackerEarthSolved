package Sorting;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Iterator;
//import java.util.TreeMap;
import java.util.TreeSet;

public class Save {

	 private void solve() {
			
		 int N=nextInt();
		 int K=N;
	    TreeSet<Integer> vac = new TreeSet<Integer>();
		TreeSet<Integer> pat = new TreeSet<Integer>();
		boolean flag=false;
		 while(N-->0)
			vac.add(nextInt());
		 while(K-->0)
			 pat.add(nextInt());
		 Iterator<Integer> vi =vac.iterator();
		 Iterator<Integer> pi =pat.iterator();
		 while(vi.hasNext() && pi.hasNext())
			 if(vi.next()>pi.next())
				 flag=true;
			 else
				 {
				 flag=false;break;
				 }
		 if(flag)
			 pw.println("Yes");
		 else
			 pw.println("No");

	}
	 
	 
	  public static void main(String[] args) throws Exception { new Save().run(); }
	  
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

