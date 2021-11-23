package Sorting;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;


public class TwistedMatrix {
	 private void solve() {
			
		 int T=nextInt();
		 int[] arr = new int[T*T];
		 for(int i=0;i<T*T;i++)
				 arr[i]=nextInt();
			 Arrays.sort(arr);
		spiralFill(T,arr);
	}

	void spiralFill(int N,int[] arr) 
	{ 
	   int [][] matrix = new int[N][N];
	    int val = 0; 
	    int m=N,n=N;
	    int k = 0, l = 0; 
	    while (k < m && l < n) 
	    { 
	        for (int i = l; i < n; ++i) 
	            matrix[k][i] = arr[val++]; 
	        k++; 
	        for (int i = k; i < m; ++i) 
	            matrix[i][n-1] = arr[val++]; 
	        n--; 
	        if (k < m) 
	        { 
	            for (int i = n-1; i >= l; --i) 
	                matrix[m-1][i] = arr[val++]; 
	            m--; 
	        } 
	        if (l < n) 
	        { 
	            for (int i = m-1; i >= k; --i) 
	                 matrix[i][l] = arr[val++]; 
	            l++; 
	        } 
	    }
	    for (int i=0; i<N; i++) 
	    { 
	       for (int j=0; j<N; j++) 
	          pw.print(matrix[i][j]+ " "); 
	      pw.println();
	    } 
	    
	} 
	public static void main(String[] args) throws Exception { new TwistedMatrix().run(); }
	  
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
