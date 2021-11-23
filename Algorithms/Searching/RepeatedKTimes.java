package Searching;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

	public class RepeatedKTimes {

		 private void solve() {
			
			 TreeMap<Integer,Integer> tree = new TreeMap<Integer,Integer>();
			 int N=nextInt();int num=0;
			 while(N-->0){
				 num = nextInt();
				 if(tree.isEmpty())
					 tree.put(num, 1);
				 else if(tree.containsKey(num))
					 tree.put(num, tree.get(num)+1);
				 else
					 tree.put(num,1);
			 }
			int K=nextInt();
			Set<Integer> set = tree.keySet();
			 Iterator<Integer> itr= set.iterator();
			 while(itr.hasNext()){
				 num=itr.next();
				 if(tree.get(num)==K)
					 {
					 	pw.print(num);
					 	break;
					 }
			 }
		 }
		public static void main(String[] args) throws Exception { new RepeatedKTimes().run(); }
		  
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