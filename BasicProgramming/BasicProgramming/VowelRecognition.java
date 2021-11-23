package BasicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class VowelRecognition {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			String s = br.readLine();
			long total = 0;
			long length = s.length();
			for (int i = 0; i < length; i++) {
				char c = s.charAt(i);
				if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
					c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
					total += (i+1)*(length-i);
				}
			}
			System.out.println(total);
		}
	}
}