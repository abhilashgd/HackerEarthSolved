package Stacks;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class StackAndQ {
	int temp=0;
	void solve() {
		LinkedList ll = new LinkedList();
		int N=nextInt();
		int K=nextInt();
		long maxSum=0;
		int i=K;
		while(N-->0){
			temp=nextInt();
			if(i-->0)
				maxSum+=temp;
			ll.add(temp);
		}
		if(K==N)
			pw.print(maxSum);
		else{
			maxSum = ll.findMaxSum(maxSum,K);
			pw.print(maxSum);
		}
	}
	class Node {
		int val;
		Node next;
		Node previous;
	}
	 
	class LinkedList {
		Node root;
		Node last;
		
		
		public void add(int val) {
			if (root == null) {
				Node n = new Node();
				n.val = val;
				root = n;
				last = n;
			}else {
				Node n = new Node();
				n.val = val;
				last.next = n;
				n.previous = last;
				last = last.next;
			}
		}

		public long findMaxSum(long sum,int K) {
			long maxSum=sum;
			int count=K;
			Node currNode =root;
			while(K-->1)
				currNode=currNode.next;
			while(count-->1)
			{
				sum=sum+last.val-currNode.val;
				if(maxSum<sum)
					maxSum=sum;
				last=last.previous;currNode=currNode.previous;
			}
			return maxSum;
		}

		public long get(int val) {

			return 0;
		}
	}

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
 
    public static void main(String[] args) throws Exception { new StackAndQ().run(); }
 
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

