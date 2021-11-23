package StringAlgos;
	import java.io.ByteArrayInputStream;
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.PrintWriter;
	import java.util.InputMismatchException;
import java.util.Arrays;


	public class MollyAndFlame {
		static final int CHAR_SIZE=26;
		static char[] S = {'F','L','A','M','E'};
		static String[] flameArr={"LFAME",
				
		};
		static final int flame_size=5;
		 private void solve() {
			 StringBuilder sb = new StringBuilder();
			 int T=nextInt();
			 while(T-->0){
				 char[] one =nextString().toCharArray();
				 char[] two = nextString().toCharArray();
				 int x_rem=0;
				 int[] oc = new int[CHAR_SIZE];
				 int[] sc = new int[CHAR_SIZE];
				 for(int i=0;i<one.length;i++)oc[one[i]-'a']++;
				 for(int i=0;i<two.length;i++)sc[two[i]-'a']++;
				 for(int i=0;i<CHAR_SIZE;i++)
					 if(oc[i]>0 && sc[i]>0) continue;
					 else if(oc[i]>0 && sc[i]==0) x_rem+=oc[i];
					 else if(sc[i]>0 && oc[i]==0) x_rem+=sc[i];
						 
				 if(x_rem%flame_size==2) sb.append(String.valueOf(S)+"\n");
				 else{
					 int index=x_rem%flame_size;
					 if(x_rem==0)  index=0;
					 else if(x_rem%flame_size==0) index=flame_size-1;
					 else index=x_rem%flame_size-1;
					 char[] flame =S.clone();
					 char temp=flame[index];
					 flame[index]='L';
					 flame[1]=temp;
					 sb.append(String.valueOf(flame)+"\n");
				 }
			 }
			 pw.println(sb.toString());
		 }

		
		public static void main(String[] args) throws Exception { new MollyAndFlame().run(); }
		  
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

