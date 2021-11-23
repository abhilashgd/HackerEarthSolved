package BasicProgramming;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.InputMismatchException;
public class MonkAndFriend {

	private void solve() {
		int T=nextInt();
		StringBuilder sb = new StringBuilder();
		while(T-->0){
			String L =  BigInteger.valueOf(nextLong()).toString(2);
			String R =  BigInteger.valueOf(nextLong()).toString(2);
			int count=0;pw.println(L+" "+R);
			
			if(L.length()<R.length())
			{
				int tempLen=R.length()-L.length();
				for(int i=0;i<tempLen;i++)
					if(R.charAt(i)=='1')
						count++;
				for(int i=tempLen,j=0;i<R.length();i++,j++)
				{
					if(L.charAt(j)!=R.charAt(i))
						count++;
				}
			}
			else if(L.length()>R.length())
			{
				int tempLen=L.length()-R.length();
				for(int i=0;i<tempLen;i++)
					if(L.charAt(i)=='1')
						count++;
				for(int i=tempLen,j=0;i<L.length();i++,j++)
				{
					if(R.charAt(j)!=L.charAt(i))
						count++;
				}
			}else
				for(int i=0;i<R.length();i++)
					if(R.charAt(i)!=L.charAt(i))
						count++;
				
				
			sb.append(count+"\n");
		}
		pw.print(sb.toString());
	}

public static void main(String[] args) throws Exception { 
	new Thread(null, new Runnable() {
		public void run() {
			try {
				new MonkAndFriend().run();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}, "1", 1 << 10).start();
	
 }
	
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