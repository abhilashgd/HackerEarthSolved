package HashTable;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;
import java.util.Set;


public class Festivals {
	static LinkedHashMap<String,Point> table = new LinkedHashMap<String,Point>();
	static StringBuilder sb = new StringBuilder();
	 private void solve() {
		 	
		 int T=nextInt();
		for(int i=1;i<=T;i++)
		 {
			 int N=nextInt();
			 while(N-->0){
				 String[] arr=nextString().split(" ");
				 String str =arr[0];
				 int val = Integer.parseInt(arr[1]);
				 if(table.isEmpty()) table.put(str, new Point(str,val));
				 else if(table.containsKey(str))  table.get(str).add(val);
				 else table.put(str, new Point(str,val));
			}
			findMaxSpending();
		}
		 pw.print(sb.toString());
	 } 
	 
	  private void findMaxSpending() {
		   String maxString="";
		   long max=0;
		   Set<String> keys = table.keySet();
		   Iterator<String> itr = keys.iterator();
		   int flag=0;
		   while(itr.hasNext()){
				if(flag==0){
					maxString=itr.next();
					max=table.get(maxString).getSum();flag++;
				}else{
					String temp = itr.next(); 
					long tVal=table.get(temp).getSum();
					if(tVal>max) {max=tVal;maxString=temp;}
					else if(tVal==max)
						if(maxString.compareTo(temp)>0) {maxString=temp;}
				}
			}
		sb.append(maxString+" "+max+"\n");
		 table.clear();
	}

	static class Point{
		    private PriorityQueue<Integer> values = new PriorityQueue<Integer>();
		   
		    private int counter=0;
		    private long sum;
		    
		    long getSum() { return this.sum;}
		    Point(String str, int sum) {
		        this.sum = sum;
		        values.add(sum);
		        this.counter=1;
		    }
		    void add(int val){
		    	if(counter==1){values.add(val);sum+=val; counter=2;}
		    	else if (counter==2){values.add(val);sum+=val;counter=3;}
		    	else if(counter==3){findAndReplace(val);}
				
		    }
		    private void findAndReplace(int val) {
		    	int min =0;
		    	Iterator<Integer> itr = values.iterator();
				while(itr.hasNext()){int temp=itr.next();if(temp<val){min=temp;break;}}
				if(min!=0){values.remove(min); values.add(val);sum=sum-min+val;}
			}
			Point() {}
		}
	 
	  public static void main(String[] args) throws Exception { new Festivals().run(); }
	  
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
 
    private boolean isSpaceChar(int c) { return !(c >= 32 && c <= 126); }
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

