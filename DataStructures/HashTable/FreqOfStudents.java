package HashTable;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class FreqOfStudents {

	 private void solve() {
			
		 int N=nextInt();
		 Hashtable<String,Integer> table = new Hashtable<String,Integer>(N);
		 String temp=nextLine();
		 table.put(temp, 1);
		 while(N-->1)
		 {
			 temp=nextLine();
			 if(table.containsKey(temp))
				 table.put(temp, table.get(temp)+1);
			 else
				 table.put(temp, 1);
		 }
		 Set<String> keys = table.keySet();
		 Iterator<String> itr = keys.iterator();
		 List<Point> points = new ArrayList<Point>();
		 
		 while(itr.hasNext()){
			 temp=itr.next();
			 points.add(new Point(temp,table.get(temp)));
		 }	
		 
		 
		 Collections.sort(points,new Comparator<Point>() {

			 public int compare(Point o1, Point o2) {
				 int result =(o1.getX().compareTo(o2.getX()));
		           if (result == 0 ) {
		                result =  Integer.compare((int) o2.getY(), (int) o1.getY());;
		            }
		            return result;
			 }
			 });
		
		 Iterator<Point> pItr = points.iterator();
		 Point node;
		 while(pItr.hasNext()){
			 node=pItr.next();
			 pw.println(node.getX()+" "+node.getY());
		 }
		 
		 
		}
	 
	 
	  static class Point{
		    private String x;
		    private int y;

		    String getX() {
		        return x;
		    }

		    void setX(String x) {
		        this.x = x;
		    }

		    int getY() {
		        return y;
		    }

		    void setY(int y) {
		        this.y = y;
		    }

		    Point(String x, int y) {
		        this.x = x;
		        this.y = y;
		    }

		    Point() {
		    }
		}
	 
	 
	 
	 
	  public static void main(String[] args) throws Exception { new FreqOfStudents().run(); }
	  
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
 
    private void tr(Object... o) { if(INPUT.length() > 0)System.out.println(Arrays.deepToString(o)); }
}

