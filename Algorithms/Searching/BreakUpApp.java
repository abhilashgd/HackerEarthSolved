package Searching;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
 
public class BreakUpApp {
	public static void main(String[] args) throws IOException {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		final long start = System.currentTimeMillis();		
		int T=in.nextInt();
		int weightage=0;
		int[][] days = new int[31][2];
		
		while(T-->0){
			String input = in.nextLine();
			if(input.charAt(0)=='G')
				weightage=2;
			else
				weightage=1;
			
			String[] arr = input.split("\\s+");
			int len=arr.length;
			for(int i=0;i<len;i++)
				if(isNumber(arr[i]))
					{
						days[Integer.parseInt(arr[i])][0]++;
						days[Integer.parseInt(arr[i])][1]+=weightage;
					}
		}
		int max=0,maxCount=days[0][0],maxWeight=days[0][1];
		boolean flag=false;
		for(int j=1;j<31;j++)
			if(maxCount<days[j][0]){
				maxCount=days[j][0];
				maxWeight=days[j][1];
				max=j;
				flag=true;
			}
			else if(maxCount==days[j][0])
					if(maxWeight==days[j][1])
							flag=false;
					else if(maxWeight<days[j][1])
					{
							maxWeight=days[j][1];
							max=j;
							flag=true;
					}
		if(flag &(max==19||max==20))
			out.println("Date");
		else	
		out.println("No Date");
		@SuppressWarnings("unused")
		final long duration = System.currentTimeMillis()-start;
		out.close();
	}
	

	private static boolean isNumber(String string) {
		for(int i=0;i<string.length();i++)
			if(Character.isDigit(string.charAt(i))==false)
			return false;

		return true;
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
