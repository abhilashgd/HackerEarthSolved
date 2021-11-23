package Trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
 
public class BstMaxHeightBest {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		final long start = System.currentTimeMillis();		
		new BT().solve(in, out);
		@SuppressWarnings("unused")
		final long duration = System.currentTimeMillis()-start;
		out.close();
	}
	
	static class BT{
	    static class Node{
	        int value;
	        Node left, right;
	        public Node(int value){
	            this.value = value;
	            this.left = this.right = null;
	        }
	    }
		public void solve(InputReader in, PrintWriter out){
			int T=in.nextInt();
			while(T-->0){
			int n = in.nextInt();
			Node root = null;
			for(int i=0; i<n; i++){
			    root = insert(root, in.nextInt());
			}
			out.println(dfs(root));
			}
		}
		public int dfs(Node root){
		    if(root==null) return 0;
		    return 1+Math.max(dfs(root.right), dfs(root.left));
		}
		public Node insert(Node root, int n){
		    if(root == null) return new Node(n);
		    if(root.value<n){
		        root.right = insert(root.right, n);
		    } else if(root.value>=n){
		        root.left = insert(root.left, n);
		    }
		    return root;
		}
	}
	
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;
		public InputReader() {
			reader = new BufferedReader(new InputStreamReader(System.in));
			tokenizer = null;
		}
		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
		public long nextLong(){
			return Long.parseLong(next());
		}
		public double nextDouble(){
			return Double.parseDouble(next());
		}
		public String nextLine() throws IOException{
            return reader.readLine();
        }
	}
}