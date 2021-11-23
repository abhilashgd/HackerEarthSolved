package Sorting;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;

public class DescendingWeight {
	
	  static class Node{
		    private int elem;
		    private int weight;

		    int getElem() {return elem;}
		    int getWeight(){return weight;}

		    Node(int elem, int weight) {
		        this.elem = elem;
		        this.weight = weight;
		    }
		    Node() {}
		}
	public static void main(String[] args) throws Exception { new DescendingWeight().run(); }
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
    private void solve() {
		 int N=nextInt();
		 int K=nextInt(); 
		 List<Node> al = new ArrayList<Node>();
		 while(N-->0)
		 {
			 int elem=nextInt();  
			 al.add(new Node(elem,elem%K));
		 }
		 
		 Collections.sort(al,new Comparator<Node>() {
			 	public int compare(Node o1, Node o2) {
				 int result = Integer.compare(o2.getWeight(),o1.getWeight());
		         if (result == 0 ) {result = Integer.compare(o1.getElem(),o2.getElem());}
		            return result;}});
		 Iterator<Node> pItr = al.iterator();
		 while(pItr.hasNext()){
			 pw.print(pItr.next().getElem()+" ");	 
		 }
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

