package BasicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class MonkDigitalWorld {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
			int[] a =new int[123];
			String s = br.readLine();
			for(int i=0;i<N;i++) a[s.charAt(i)]++;
			
			int[] b =new int[124];
			s = br.readLine();
			for(int i=0;i<N;i++) b[s.charAt(i)]++;
			
			boolean flag=false;
			for(int i=97;i<122;i++)
				if(a[i]==b[i]) flag=true;
				else {flag=false;break;}
			if(flag) System.out.println("YES");
			else System.out.println("NO");
	}
}