package Searching;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
 
public class VowelCount {
	public static void main(String[] args) throws IOException {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		final long start = System.currentTimeMillis();		
		int T=in.nextInt();
		while(T-->0){
			int[] arr = new int[126];
			String input = in.nextLine();
			int x=input.length();
			while(x-->=1)arr[(int)input.charAt(x)]++;
			x = arr[97]+arr[101]+arr[105]+arr[111]+arr[117]+
				arr[65]+arr[69]+arr[73]+arr[79]+arr[85];
			out.println(x);
		}
		@SuppressWarnings("unused")
		final long duration = System.currentTimeMillis()-start;
		out.close();
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
