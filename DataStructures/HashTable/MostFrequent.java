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


public class MostFrequent {

	 private void solve() {
			
		 int N=nextInt();
		 Hashtable<Integer,Integer> table = new Hashtable<Integer,Integer>(N);
		 int temp=nextInt();
		 table.put(temp, 1);
		 while(N-->1)
		 {
			 temp=nextInt();
			 if(table.containsKey(temp))
				 table.put(temp, table.get(temp)+1);
			 else
				 table.put(temp, 1);
		 }
		 Set<Integer> keys = table.keySet();
		 Iterator<Integer> itr = keys.iterator();
		 List<Point> points = new ArrayList<Point>();
		 
		 while(itr.hasNext()){
			 temp=itr.next();
			 points.add(new Point(temp,table.get(temp)));
		 }	
		 
		 
		 Collections.sort(points,new Comparator<Point>() {

			 public int compare(Point o1, Point o2) {
				 int result = Integer.compare((int) o1.getY(), (int) o2.getY());
		            if (result == 0 ) {
		                result = Integer.compare((int) o2.getX(), (int) o1.getX());
		            }
		            return result;
			 }
			 });
		
		 int ln=points.size();
		 Point node;
		 node=points.get(ln-1);
		
			 pw.println(node.getX());
		 
		}
	 
	 
	  static class Point{
		    private int x;
		    private int y;

		    int getX() {
		        return x;
		    }

		    void setX(int x) {
		        this.x = x;
		    }

		    int getY() {
		        return y;
		    }

		    void setY(int y) {
		        this.y = y;
		    }

		    Point(int x, int y) {
		        this.x = x;
		        this.y = y;
		    }

		    Point() {
		    }
		}
	  public static void main(String[] args) throws Exception { new MostFrequent().run(); }
	  
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

