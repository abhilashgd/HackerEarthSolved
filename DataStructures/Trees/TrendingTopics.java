package Trees;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;

public class TrendingTopics {
	
	
	 private void solve() {
		 int N=nextInt();
		 List<Points> ll = new LinkedList<Points>();
		 sBuilder str = new sBuilder();
		 long id, zScore,P,L,C,S;
		 long change=0,newScore=0;
		
		 for(int i=0;i<N;i++){
			 id =nextLong();
			 zScore=nextLong();
			 newScore=nextLong()*50+nextLong()*5+nextLong()*10+nextLong()*20;
			 change= newScore-zScore;
			 
			 ll.add(new Points(id,newScore,change));
		 }
		 
		 Collections.sort(ll,new Comparator<Points>(){

				@Override
				public int compare(Points o1, Points o2) {
					int result=0;
					result= Long.compare(o2.change, o1.change);
					if(result==0)
						return Long.compare(o2.id, o1.id);
					return result;
				}
				
			});
		 
		 for(int i=0;i<5;i++)
			str.setOutput(ll.get(i).id+" "+ll.get(i).newScore);
		 
		 str.getOutput();
	}
	 class Points{
			long id;
			long newScore;
			long change;
			
			
			public Points(long id,long newScore, long change) {
				this.id=id;
				this.newScore=newScore;
				this.change=change;
				
			}
		}

class sBuilder{
	private StringBuilder sb =new StringBuilder();
	
	void setOutput(String val){
		sb.append(val+"\n");
	}
	void getOutput(){
		pw.println(sb.toString());
	}
	
	
}

	  public static void main(String[] args) throws Exception { new TrendingTopics().run(); }
	  
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
    private boolean isSpaceString(int c){return !(c >= 32 && c <= 126); }
    private int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }
 
    private String nextLine() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while(!(isSpaceString(b))){ // when nextLine)
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

