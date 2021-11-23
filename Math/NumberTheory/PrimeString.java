package NumberTheory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.Arrays;

public class PrimeString {
	 static boolean[] isPrime;
	 StringBuilder sb = new StringBuilder();
	 private void solve() {
		final int MAX=1000000;
		sieveTill(MAX);
		int T=nextInt();
		for(int i=0;i<T;i++)
			isPrimeString(nextString());
		pw.print(sb.toString());
}
	 private void isPrimeString(String arr) {
		 TreeMap<Character,Integer> tree = new TreeMap<Character,Integer>();
				char[] temp =arr.toCharArray();
				int len = temp.length;
				boolean flag=true;
				for(int j=0;j<len;j++){
					char ch=temp[j];
					if(tree.isEmpty())
						tree.put(ch, 1);
					else if(tree.containsKey(ch))
						tree.put(ch, tree.get(ch)+1);
					else
						tree.put(ch,1);
				}
				if(isPrime[tree.size()])
				{
					Set<Character> set = tree.keySet();
					Iterator<Character> itr =set.iterator();
					
					while(itr.hasNext()){
						char ch = itr.next();
						if(isPrime[tree.get(ch)]){
							continue;
						}
						else{
							flag=false;
							break;
						}
							
					}
				}
				else
					flag=false;
				tree.clear();
				if(flag)
					sb.append("YES"+"\n");
				else
					sb.append("NO"+"\n");
	}
	void sieveTill(int N) {
	        isPrime = new boolean[N+1];
	        for(int i = 0; i <= N;++i) {
	            isPrime[i] = true;
	        }
	        isPrime[0] = false;
	        isPrime[1] = false;
	        for(int i = 2; i * i <= N; ++i) {
	             if(isPrime[i] == true) {
	                 for(int j = i * i; j <= N ;j += i)
	                     isPrime[j] = false;
	            }
	        }
	    }
	 
	 
	public static void main(String[] args) throws Exception { new PrimeString().run(); }
	  
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
   private int[] nextArray(int n) {
        int[] a = new int[n];
        for(int i = 0;i < n;i++)a[i] = nextInt();
        return a;
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
   
    private void tr(Object... o) { if(INPUT.length() > 0)System.out.println(Arrays.deepToString(o)); }
}
