import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.InputMismatchException;

public class AverageProd {
		static final int MOD = ((int)Math.pow(10,9) +7);
	 private void solve() {
			int N= nextInt();
			int K=nextInt();
			int prodOne=1; int prodTwo=1;
			ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
			ArrayDeque<Integer> ads = new ArrayDeque<Integer>();
			for(int i=0;i<N;i++)
				ad.add(nextInt());
			ads=ad.clone();
			while(ad.size()>=K){
			
				int temp=0;int avg=0;
				for(int i=0;i<K;i++){
					temp=(temp+ad.pop())%MOD;
				}
				avg=temp/K;
				ad.push(avg);
				prodOne= (prodOne*avg)% MOD;
			}
			while(ads.size()>=K){
				int temp=0;int avg=0;
				for(int i=0;i<K;i++){
					temp=(temp+ads.pollLast())%MOD;
				}
				avg=temp/K;
				ads.addLast(avg);
				prodTwo= (int) ((prodTwo*temp/K)% MOD);
			}
			int prod=prodOne>prodTwo?prodOne:prodTwo;
			
			pw.println(prod%MOD);
		}
	  public static void main(String[] args) throws Exception { new AverageProd().run(); }
	  
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

