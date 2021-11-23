package Sorting;
	import java.io.ByteArrayInputStream;
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.PrintWriter;
	import java.util.Arrays;
	import java.util.InputMismatchException;

	public class LinearSort {

		 private void solve() {
			 int N=nextInt();long sum=0,fNum=0;int count=0,i=N,nCount=0;
			 while(i-->0){
				 long num=nextLong();
				 if(num>=0){ sum+=num;count++;}
				 else {
					 if(nCount<1)
					 	{fNum=num;nCount++;}
					 else if(num>fNum)
						 fNum=num;
					  }
			 }
			 if(sum>=0 && count>0)
					 pw.println(sum+" "+count);
			 else
				 pw.println(fNum+" "+nCount);
					 
	}
		 
		  public static void main(String[] args) throws Exception { new LinearSort().run(); }
		  
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

