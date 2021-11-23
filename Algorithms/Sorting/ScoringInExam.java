package Sorting;
	import java.io.ByteArrayInputStream;
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.PrintWriter;
	import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

	public class ScoringInExam {

		 private void solve() {
			StringBuilder sb = new StringBuilder();
			int N=nextInt();
			int Q=nextInt();
				int[] A = nextArray(N);
				List<Point> list = new ArrayList<Point>();
				int sum=0,i;
				for(i=0;i<N;i++)
					list.add(new Point(A[i],nextInt()));
					
				Collections.sort(list, new Comparator<Point>(){
										public int compare(Point o1, Point o2) {
										int result = Integer.compare(o2.getScore(),o1.getScore());
										if(result==0)
												return Integer.compare(o1.getTime(),o2.getTime());
										return result ;}});
				for(i=0;i<N;i++){
					sum+=list.get(i).getTime();
					list.get(i).setSum(sum);
				}
				while(Q-->0)
					sb.append(list.get(nextInt()-1).getSum()+"\n");
			pw.print(sb.toString());
	}
private class Point{
	private int time;
	private int score;
	private int sum;
	 Point(int time, int score){
		 this.time=time;
		 this.score=score;
	 }
	 public void setSum(int sum){
		 this.sum=sum;
	 }
	 public int getScore(){return this.score;}
	 public int getTime(){return this.time;}
	 public int getSum(){return this.sum;}
}
		public static void main(String[] args) throws Exception { new ScoringInExam().run(); }
		  
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

