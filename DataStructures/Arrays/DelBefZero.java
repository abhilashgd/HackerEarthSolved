package Arrays;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class DelBefZero {
	 static DataOutputStream dos;
	 private void solve() throws IOException {
		
		 dos = new DataOutputStream(System.out);
		 StringBuilder sb=new StringBuilder();
		 int N=nextInt();
		 int sum=0;
		 LinkedList ll = new LinkedList();
		 for(int i=0;i<N;i++){
			  sum=ll.add_delete(nextInt(),sum);
			 
		 }
		 sb.append(sum);
		 dos.write(sb.toString().getBytes());
		}
	  public static void main(String[] args) throws Exception { new DelBefZero().run(); }
	  
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
 	
    private char[] nextString(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while(p < n && !(isSpaceChar(b))){
            buf[p++] = (char)b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
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

class Node {
	int popularity;
	Node next;
	Node previous;
}
 
class LinkedList {
	Node root;
	Node last;
 
	public int add_delete(int popularity,int sum) {
		if (root == null) {
			Node n = new Node();
			n.popularity = popularity;
			root = n;
			last = n;
			sum+=popularity;
		} else {
			if(popularity==0){
				sum-=last.popularity;
				last=last.previous;
			}
			else{
				sum+=popularity;
				Node currNode=new Node();
				currNode.popularity=popularity;
				currNode.next=null;
				currNode.previous=last;
				last.next=currNode;
				last=currNode;
			}
		}
 
		return sum;
	}
	
	
	}