package ArrayMultiDimensional;

import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.InputMismatchException;


 public class PrasunDetective {
	 static DataOutputStream dos;
	 
	 private void solve() throws IOException {
		 dos = new DataOutputStream(System.out);
		
		 StringBuilder sb=new StringBuilder();
		 String msg=nextString();
		 
		 	 @SuppressWarnings("unchecked")
			 Hashtable<Character,Integer> table = new Hashtable<Character,Integer>();
			
		 	 for(int i=0;i<msg.length();i++){
					 char ch=msg.charAt(i);
					 	if(ch==' ')
					 		continue;
					 	else if(!table.containsKey(ch))
					 			table.put(ch, 1);
					 	else
					 		table.put(ch, table.get(ch)+1);
		 	 }
		 	 
		String guess=nextString();
		boolean flag=true;
			 for(int k=0;k<guess.length();k++){
				 char ch=Character.toLowerCase(guess.charAt(k));
				 if(ch==' ')
				 		continue;
				 else if(table.containsKey(ch) && table.get(ch)>0 ){
					 table.put(ch, table.get(ch)-1);
				 }
				 else{
					 sb.append("NO");
					 sb.append("\n");flag=false;
					 break;
				 }
			 }
			if(flag) {
				sb.append("YES");
				sb.append("\n");
			}
		 
		 dos.write(sb.toString().getBytes());
			
		}
	  public static void main(String[] args) throws Exception { new PrasunDetective().run(); }
	  
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
 
    private boolean isSpaceChar(int c) { return !(c >= 32 && c <= 126); }
    private int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }
 
    private double nextDouble() { return Double.parseDouble(nextString()); }
    private char nextChar() { return (char)skip(); }
   
    private String nextString() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while(!(isSpaceChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }
 	
    private char[] nextString(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while(p < n && !(isSpaceChar(b))){
            buf[p++] = (char)b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }
 
    private char[][] nextMap(int n, int m) {
        char[][] map = new char[n][];
        for(int i = 0;i < n;i++)map[i] = nextString(m);
        return map;
    }
 
    private int[] nextArray(int n) {
        int[] a = new int[n];
        for(int i = 0;i < n;i++)a[i] = nextInt();
        return a;
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

