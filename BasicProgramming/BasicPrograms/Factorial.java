package BasicPrograms;

import java.io.IOException;
import java.io.PrintWriter;

public class Factorial {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Reader in = new Reader();
	    PrintWriter pw=new PrintWriter(System.out);
		
		int N = in.nextInt();//Enter a number
		pw.print("Factorial of: "+N+" is ");
		pw.print(Fact(N));
		pw.flush();
	}

	private static int Fact(int n) {
		
		if(n==0)
			return 1;
		else if (n==1)
			return 1;
		else
			return n*Fact(n-1);
		
	}

}
