package BasicProgramming;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class BookCricket {
	static final String player ="Player";
	static final String match = "Case";
	 private void solve() {
		 StringBuilder sb = new StringBuilder();
		 int T=nextInt();
		 for(int no=1;no<=T;no++){
			 int N=nextInt();//number of overs
			 int P=nextInt();//no of players
			 int noOfBalls=N*6;//no of balls
			 int[] p = new int[P];//player array
			 String input =nextString();
			 int nextPlayer=2;
			 int striker=0;
			 int nonStriker=1;
			 int temp=0;
			 for(int i=1;i<=noOfBalls;i++){
				 char ch =input.charAt(i-1);
				 if(ch=='W'){ striker=nextPlayer; nextPlayer++;}
				 else if(ch=='1'){p[striker]+=Character.getNumericValue(ch);
					 temp=striker;striker=nonStriker;nonStriker=temp;}
				 else{p[striker]+=Character.getNumericValue(ch);}
				 if(i%6==0){temp=striker;striker=nonStriker;nonStriker=temp;}
			 }
			 sb.append(match+" "+no+":\n");
			 for(int i=0;i<P;i++){
				 if(p[i]==0 && i>striker && i>nonStriker)
					 sb.append(player+" "+(i+1)+": DNB\n");
				 else{
					 if(i==striker||i==nonStriker){
						 sb.append(player+" "+(i+1)+": "+p[i]+"*"+"\n");
					 }
					 else
						 sb.append(player+" "+(i+1)+": "+p[i]+"\n");
				 }
			 }
		 }
		
		 pw.print(sb.toString());
	     pw.flush();
	     pw.close();
		}
	
	public static void main(String[] args) throws Exception { new BookCricket().run(); }
	  
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
    private int[] nextArray(int n) {
        int[] a = new int[n];
        for(int i = 0;i < n;i++)a[i] = nextInt();
        return a;
    }
    private void tr(Object... o) { if(INPUT.length() > 0)System.out.println(Arrays.deepToString(o)); }
}

