package Math;

	import java.io.ByteArrayInputStream;
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.PrintWriter;
	import java.util.InputMismatchException;

import java.util.Arrays;

	public class BeautifulPrime {
		 final static int MOD=1000000007;
		 static int[] factor;
		 private void solve() {
			
			StringBuilder sb = new StringBuilder();
			int T=nextInt();
			while(T-->0){
				int x = nextInt();
				int[] pi = nextArray(x);
				int[] ai = nextArray(x);
				int N=1;
				for(int i=0;i<x;i++)
					N*=pow(pi[i],ai[i])%MOD;
				factor =new int[N+1];
				generatePrimeFactors(N+1);
				int factN = calculateNoOFactors(N);
				pw.println(factN);
				int sum=N;
				for(int i=1;i<N;i++)
				{
					int temp =calculateNoOFactors(i);
					pw.print(temp+" ");
					if(factN==temp)
						sum+=i;
				}
				sb.append(sum+"\n");
			}
				
		pw.print(sb.toString());
	}
		 public static int pow(int base , int power)
		    {
		        int res= 1;
		        while(power>0)
		        {
		            if(power%2==1)
		                res = (res *base)%MOD;
		            base *= base;
		            base %= MOD;
		            power /= 2; 
		        }
		        return res%MOD;    
		        
		    }
		
	static void generatePrimeFactors(int n) 
	{ 	//Sieve of Eratostheneses 
	    factor[1] = 1; 

	    for (int i = 2; i < n; i++) 
	        factor[i] = i; 
	    for (int i = 4; i < n; i += 2) 
	        factor[i] = 2; 
	    for (int i = 3; i * i < n; i++) { 
	        if (factor[i] == i) { 
	            for (int j = i * i; j < n; j += i) { 
	                if (factor[j] == j) 
	                    factor[j] = i; 
	            } 
	        } 
	    } 
	} 
	static int calculateNoOFactors(int n) 
	{ 
	    if (n == 1) 
	        return 1; 

	    int ans = 1; 
	    int dup = factor[n]; 
	    int c = 1; 

	    int j = n / factor[n]; 

	    while (j != 1) { 
	        if (factor[j] == dup) 
	            c += 1; 
	        else { 
	            dup = factor[j]; 
	            ans = ans * (c + 1); 
	            c = 1; 
	        } 
	        j = j / factor[j]; 
	    } 
	    ans = ans * (c + 1); 

	    return ans; 
	} 
		 
		public static void main(String[] args) throws Exception { new BeautifulPrime().run(); }
		  
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
	   private int[] nextArray(int n) {
	        int[] a = new int[n];
	        for(int i = 0;i < n;i++)a[i] = nextInt();
	        return a;
	    }
	    private void tr(Object... o) { if(INPUT.length() > 0)System.out.println(Arrays.deepToString(o)); }
	}

