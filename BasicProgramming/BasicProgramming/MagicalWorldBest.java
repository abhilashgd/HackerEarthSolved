package BasicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
class MagicalWorldBest {
	public static void main(String args[]) throws Exception {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int N = 0;
		String string = null, result = null;
		for (int i = 1; i <= T; i++) {
			N = Integer.parseInt(br.readLine());
			string = br.readLine();
			result = getResultantString(string, N);
			System.out.println(result);
		}
 
	}
 
	private static String getResultantString(String string, int n) {
 
		int temp = 0, next = 0, prev = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
 
			if (Character.isDigit(string.charAt(i))) {
 
				sb.append("C");
			} else {
				temp = string.codePointAt(i);
				next = temp;
				prev = temp;
				if (next >= 122) {
					next = 113;
				}
				if (prev <=65) {
					prev = 67;
				}
				while (!isPrime(next) && !isPrime(prev)) {
					next = next + 1;
					prev = prev - 1;
					if (next >= 122) {
						next = 113;
					}
					if (prev <=65) {
						prev = 67;
					}
				}
 
				if (isPrime(next) && isPrime(prev)) {
					sb.append((char) prev);
				} else if (isPrime(next)) {
					sb.append((char) next);
				} else if (isPrime(prev)) {
					sb.append((char) prev);
				}
			}
 
		}
		return sb.toString();
	}
 
	private static boolean isPrime(int num) {
 
		int flag = 0;
		int sqrt = (int) Math.sqrt(num);
		for (int i = 2; i <= sqrt; i++) {
			if (num % i == 0) {
				flag = 1;
				break;
			}
		}
		if (flag == 0)
			return true;
		else
			return false;
	}
}