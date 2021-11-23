package BasicProgramming;
import java.util.*;
public class TrilogyB {
	
	    public static void main(String args[] ) throws Exception {
	      
	        Scanner s = new Scanner(System.in);
	        long n = s.nextInt();                 // Reading input from STDIN
	       // long sum = 11631*(2*7+(11631-1)*33)/2;
	        System.out.println(n*(2*7+(n-1)*33)/2);    // Writing output to STDOUT

	    }
	}

