package BasicProgramming;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class CarNames {

	 private void solve() {
		 StringBuilder sb = new StringBuilder();
		 String yes ="OK\n";
		 String no = "Not OK\n";
		 int N=nextInt();
		// int count=1;
		 while(N-->0){
			 
			 String input = nextString();
			 int[] arr = new int[126];
			 char fc=input.charAt(0);
			 
			 arr[input.charAt(0)]++;
			 for(int i=1;i<input.length();i++)
			 { arr[input.charAt(i)]++;
			 }
			 Arrays.sort(arr);
			 int temp=arr[125];
			 boolean flag=false;
			 for(int i=124;i>=0 && arr[i]>1;i--){
				if(temp==arr[i])
					flag=true;
				else{
					flag=false;
					break;
				}
			 }
			 int indCount=0;
			 for(int i=124;i>=0;i--){
					if(arr[i]==1)
						indCount++;
						}
			// if(count==60)
				// sb.append(input);
			// sb.append(count+"\n");count++;
			 if(input.length()<=1)
				 sb.append(no);
			 else if(fc!=input.charAt(1) && input.length()!=3)
				 sb.append(no);
			 else if(indCount>3)
					sb.append(no);
			 else if(flag ||(temp==1 && indCount==3))
				sb.append(yes);
			 else
				 sb.append(no);
		 }
		 pw.print(sb.toString());
	     pw.flush();
	     pw.close();
		}
	
	public static void main(String[] args) throws Exception { new CarNames().run(); }
	  
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

