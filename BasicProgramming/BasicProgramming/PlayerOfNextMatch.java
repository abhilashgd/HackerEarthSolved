package BasicProgramming;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.InputMismatchException;
public class PlayerOfNextMatch {
	final static int MAX=1000000;
	private void solve() {
		int T=nextInt();
		StringBuilder sb = new StringBuilder();
		if(T<50){
			while(T-->0){
				int N=nextInt();
				int sum=0;
				while(N-->0){
					String elem =  BigInteger.valueOf(nextInt()).toString(2);
					int index=0;
					if(elem.length()==1 && elem.charAt(0)=='0')
						continue;
					else
					for(int i=elem.length()-1;i>=0;--i){
						if(elem.charAt(i)=='1')
							break;
						index++;
					}
					sum+=Math.pow(2, index);	
				}
				sb.append(sum+"\n");
			}
		}
		else{
		int[] arr = new int[MAX+1];
		arr[0]=0;
		for(int i=1;i<=MAX;i++){
			String elem =  BigInteger.valueOf(i).toString(2);
			int sum=0;
			int index=0;
			for(int j =elem.length()-1;j>=0;--j){
					if(elem.charAt(j)=='1')
							break;
				index++;
			}
			arr[i]=(int) Math.pow(2, index);
		}
		while(T-->0){
			int N=nextInt();
			int sum=0;
			while(N-->0)
				{
				int temp = nextInt();
				//pw.print(arr[temp]+" ");
					sum+=arr[temp];
				}
			
			sb.append(sum+"\n");
			}
		}
		pw.print(sb.toString());
	}

public static void main(String[] args) throws Exception { 
	new Thread(null, new Runnable() {
		public void run() {
			try {
				new PlayerOfNextMatch().run();
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