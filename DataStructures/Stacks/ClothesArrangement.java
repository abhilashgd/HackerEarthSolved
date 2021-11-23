package Stacks;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
public class ClothesArrangement {
	
	void solve() {
		int[] arr = new int[600001];
		int[] ht = new int[100001];
		StringBuilder sb = new StringBuilder();
		int N=nextInt();
		for(int i=0;i<N;i++){
			arr[i]=nextInt();
			ht[arr[i]]++;
		}
		int Q=nextInt();
		int count=0;
		while(Q-->0){
			int ch=nextInt();
			switch(ch){
			case 1:
					arr[N]=nextInt();
					ht[arr[N]]++;++N;
					break;
			case 2: 
					int C=nextInt();
					int K=nextInt();
					if(ht[C]>0){
						int noOfClothes=ht[C];
						int m=noOfClothes-K;
						int negCount=0;
						if(noOfClothes>=K){
							for(int i=0;i<N;i++){
								if(arr[i]<0)
									{++negCount;}
								else if(arr[i]==C){
									if(m==0){
										sb.append((N-i-1-(count-negCount))+"\n");
										arr[i]=-1;
										ht[C]--;count++;
										break;
									}else m--;
								}
							}
						} else sb.append(-1+"\n");
					}else sb.append(-1+"\n");
					break;
			}
		}
		pw.println(sb.toString());
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
 
    public static void main(String[] args) throws Exception { new ClothesArrangement().run(); }
 
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

