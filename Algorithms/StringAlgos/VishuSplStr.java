package StringAlgos;

import java.io.IOException;
import java.util.Scanner;

public class VishuSplStr {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		double msum = 0;
		int l=-1;
		for(int i=0; i<s.length(); i++) {
			double sum = 0;
			int p = 0;
			for(int j=i; j<s.length(); j++) {
					sum += ( (s.charAt(j) - 96) * Math.pow(2, p) );
					p--;
				}
			for(int j=0; j<i; j++) {
					sum += ( (s.charAt(j) - 96) * Math.pow(2, p) );
					p--;
				}
			if(msum<sum) {
				msum = sum;
				l = i;
			}
		}
		System.out.println(s.substring(l) + s.substring(0, l));
		}
}
