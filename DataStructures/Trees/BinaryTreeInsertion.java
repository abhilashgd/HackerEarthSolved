package Trees;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeInsertion {
	static int INT_MIN=0;
	
	static class Node{
		int key;
		Node left, right;
		
		Node(int key){
			this.key=key;
			left=right=null;
		}
	}
	static Node root;
	
	
	/*In Order Traversal of Binary Tree */
	static void inOrder(Node temp)
	{
		if(temp==null)
			return;
		
		inOrder(temp.left);
		System.out.print(temp.key+" ");
		inOrder(temp.right);
		
	}
	
	static void inOrderNonRecursive(Node temp){
		Stack<Node> stack = new Stack<Node>();
		while(true){
			while(temp!=null){
				stack.push(temp);
				temp=temp.left;
			}
			if(stack.isEmpty())
				break;
			temp=stack.pop();
			System.out.print(temp.key+" ");
			temp=temp.right;
		}
	
			
	}
	
	static void insert(Node temp,int key)
	{
		Queue<Node> q =new LinkedList<Node>();
		q.add(temp);
		
		while(!q.isEmpty()){
			temp=q.peek();
			//System.out.print(temp.key+" ");
			q.remove();
			if(temp.left==null){
				temp.left = new Node(key);
				break;
			}
			else
				q.add(temp.left);
			
			if(temp.right==null){
				temp.right = new Node(key);
				break;
			}
			else
				q.add(temp.right);
		}
		q.clear();
	}
	
	static int FindMax(Node temp){
		int root_key,left,right,max=INT_MIN;
		
		if(temp!=null){
			//root_key=temp.key;
			left=FindMax(temp.left);
			right=FindMax(temp.right);
			
			if(left>right)
				max=left;
			else
				max=right;
			if(temp.key>max)
				max=temp.key;
		}
		
		
		return max;
		
	}
	
	static int FindMin(Node temp){
		int root_key,left,right,min=INT_MIN;
		
		if(temp!=null){
			root_key=temp.key;
			left=FindMax(temp.left);
			right=FindMax(temp.right);
			
			if(left<right)
				min=left;
			else
				min=right;
			if(root_key<min)
				min=root_key;
		}
		return min;
	}

	static int binarySearch(Node temp, int findN){
		int flag;
		if(temp==null)
			return 0;
		else{
			if(temp.key==findN)
				return 1;
			else{
				flag =binarySearch(temp.left,findN);
				if(flag!=0)
					return flag;
				else
					return binarySearch(temp.right,findN);
			}
			
		}
	}
	
	static int sizeOfBinaryTree(Node temp){
		if(temp==null)
			return 0;
		else
			return sizeOfBinaryTree(temp.left)+1+sizeOfBinaryTree(temp.right);
	}
	
	private void solve(){
		
		System.out.println("enter number of tree elements N:");
		int N=nextInt();
		root=new Node(nextInt());
       while(--N>0)
       {
    	   insert(root,nextInt());
       }
        System.out.print( "Binary Tree Inorder traversal :"); 
        //inOrderNonRecursive(root); 
       inOrder(root);
       System.out.println();
       //Finding Maximum value in the tree
        System.out.println("Maximum value in the tree is: "+FindMax(root));
 

        //Finding Minimum value in the tree
        System.out.println("Maximum value in the tree is: "+FindMin(root));
        
        System.out.println("Enter an element to search ");
        int x=binarySearch(root,nextInt());
        if(x==1)
        System.out.println("Element found");
        else
        	 System.out.println("Element NOT found");
        
        System.out.println("Size of Binary Tree is: "+sizeOfBinaryTree(root));
 		
	}

	  public static void main(String[] args) throws Exception { new BinaryTreeInsertion().run(); }
	  
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
 
    private double nextDouble() { return Double.parseDouble(nextString()); }
    private char nextChar() { return (char)skip(); }
   
    private String nextString() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while(!(isSpaceChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }
 	
    private String nextLine() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while(!(isSpaceString(b))){ // when nextLine)
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }
    private char[] nextString(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while(p < n && !(isSpaceChar(b))){
            buf[p++] = (char)b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }
 
    private char[][] nextMap(int n, int m) {
        char[][] map = new char[n][];
        for(int i = 0;i < n;i++)map[i] = nextString(m);
        return map;
    }
 
    private int[] nextArray(int n) {
        int[] a = new int[n];
        for(int i = 0;i < n;i++)a[i] = nextInt();
        return a;
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







