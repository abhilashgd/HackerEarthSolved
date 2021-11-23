package BasicPrograms;

import java.io.PrintWriter;

public class BackTracking {
	static PrintWriter pw=new PrintWriter(System.out);
	static int[] A = {1,2,3,4,5};
	
	public static void main(String[] args)
	{
		
		Binary(A.length);
		
		
	}
	
	private static void Binary(int n)
	{
		if(n<1)
			pw.print(A[n]);
		else{
			if(A[n-1]==0)
			Binary(n-1);
			if(A[n-1]==1)
			Binary(n-1);
		}
	}

}
