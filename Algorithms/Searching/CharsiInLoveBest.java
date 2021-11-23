package Searching;


import java.io.*;
import java.util.*;
class CharsiInLoveBest
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean a = isDesperate(n);
		if(a)
			System.out.println("YES");
		else
			System.out.println("NO");
			
	}
 
	static boolean isDesperate(int n)
	{
		int i = 0,j = (int)Math.sqrt(2*n);
		while(i <= j)
		{
			int num1, num2;
			num1 = desp(i);
			num2 = desp(j);
			if(num1 + num2 == n)
				return true;
			if(num1 + num2 < n)
				i++;
			else
				j--;
		}
		return false;
	}
 
	static int desp(int n)
	{
		int desp = (n*(n+1))/2;
		return desp;
	}
}