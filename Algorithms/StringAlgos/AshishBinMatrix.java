package StringAlgos;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;

public class AshishBinMatrix {
	
	 private void solve() {
		
		 StringBuilder sb = new StringBuilder();
		 HashSet<String> hs = new HashSet<String>();
		 int T=nextInt();
		 while(T-->0){
			 int N=nextInt();
			 int M=nextInt();
			
			 String[] arr=  new String[N];
			for(int i=0;i<N;i++)
				 arr[i]=nextString();
			boolean flag=true;
			int col=0;
				for(int i=0;i<N;i++){
					String temp = arr[i].substring(col+1, M);
					if(hs.isEmpty())
						hs.add(temp);
					else if(hs.contains(temp))
					{flag=false;break;}
					else{flag=true;hs.add(temp);}
				
				}
				hs.clear();
			if(flag)
				sb.append("Yes\n");
			else{
			for( col=1;col<=M-1;col++){
				for(int i=0;i<N;i++){
					String temp = arr[i].substring(0, col)+arr[i].substring(col+1, M);
					if(hs.isEmpty())
						hs.add(temp);
					else if(hs.contains(temp))
					{flag=false;break;}
					else{flag=true;hs.add(temp);}
				}
				if(flag)
					{sb.append("Yes\n");hs.clear();break;}hs.clear();
			}
			if(!flag){hs.clear();
				for(int i=0;i<N;i++){
					String temp = arr[i].substring(0, M-1);
					if(hs.isEmpty())
						hs.add(temp);
					else if(hs.contains(temp))
					{flag=false;break;}
					else{flag=true;hs.add(temp);}
					
				}
				if(flag)
					sb.append("Yes\n");
				else
					sb.append("No\n");
			}	
			}
		 }
		 pw.print(sb.toString());	 
	     pw.flush();
	     pw.close();
		}
	public static void main(String[] args) throws Exception { new AshishBinMatrix().run(); }
	  
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

