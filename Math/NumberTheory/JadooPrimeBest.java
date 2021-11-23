package NumberTheory;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;
public class JadooPrimeBest {
		static int n = (int)1e8;
		static boolean[] prime;
		public static void main(String[] args) throws IOException {
		PrintWriter out = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		prime  = new boolean[n + 1];
		sieve();
		int t = parseInt(br.readLine());
		while(t-- > 0) {
			int k = parseInt(br.readLine());
			long count = 0;
			int c = 0;
			int i = 0;
			while(c != k && i < n) {
				
				if(prime[i]) {
					++c;
					count += i;
				}
				++i;
			}
			
			//ans[k] = count;
			out.println(count);
		}
	
		
		
		out.close();
	
	
	}
		static void sieve() {
			Arrays.fill(prime	, true);
			prime[0] = prime[1] = false;
			for(int i = 2 ; i * i <= n ; ++i) {
				if(prime[i]) {
					for(int k = i * i; k< n ; k+=i) {
						prime[k] = false;
					}
				}
			}
			
		}
 
}