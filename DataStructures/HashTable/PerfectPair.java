package HashTable;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;


public class PerfectPair {
	
	 private void solve() {
		 
		 int T=nextInt();
		 sBuilder str = new sBuilder();
		 int N,count=0;
		 LinkedList ll = new LinkedList();
		
		 while(T-->0)
		 {
			 ll.clear();
			 N=nextInt();
			 int size=N;
			 while(N-->0)	 	
				 ll.add(nextInt());
			
			 count = ll.getPairCount(size);
			 str.setOutput(count);
		 }
		 str.getOutput();
	}
	
class Node{
	int val;
	Node next;
	Node prev;
}

class LinkedList{
	Node root;
	Node last;
	
	public void add(int val){
		if(root==null){
			Node n=new Node();
			n.val=val;
			root =n;
			last=n;
		}else{
			Node currNode = new Node();
			currNode.val=val;
			last.next=currNode;
			currNode.prev=last;
			last=last.next;
			}
		
	}

	public void clear() {
		this.root=null;
		this.last=null;
		
	}

	public int getPairCount(int N) {
		Node currNode = root;
		Node nextNode;
		int i =N,j,count = 0;
		while(i-->0){
			j=i;nextNode = currNode.next;
			while(j-->0)
			{
				if(isPerfectPair(currNode.val+nextNode.val))
						count++;
				nextNode=nextNode.next;
			}
			currNode=currNode.next;
				
		}
		return count;
	}

	private boolean isPerfectPair(int num) {
		long sqrt = (long)Math.sqrt(num);
		long cube = (long) Math.round(Math.pow(num, 1.0/3.0));
		if(sqrt*sqrt==num || cube*cube*cube==num)
				return true;
		return false;
	}
}

class sBuilder{
	private StringBuilder sb =new StringBuilder();
	
	void setOutput(String val){
		sb.append(val+"\n");
	}
	void setOutput(int val){
		sb.append(val+"\n");
	}
	void getOutput(){
		pw.println(sb.toString());
	}
	
	
}

	  public static void main(String[] args) throws Exception { new PerfectPair().run(); }
	  
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

