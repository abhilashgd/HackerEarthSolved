package BasicProgramming;

/* IMPORTANT: Multiple classes and nested static classes are supported */
 
/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
//import for Scanner and other utility classes
import java.util.*;
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
 
class CityTravel {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input
 
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
 
        //Scanner
       // Scanner s = new Scanner(System.in);
       // String name = s.nextLine();                 // Reading input from STDIN
       // System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
 
        */
 
        // Write your code here
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] cin = br.readLine().split(" ");
 
		int dist = Integer.parseInt(cin[0]);
		int max = Integer.parseInt(cin[1]);
		int excCount = Integer.parseInt(cin[2]);
 
		int[][] exceptions = new int[excCount][2];
		String[] in;
		for (int i = 0; i < excCount; i++) {
			in = br.readLine().split(" ");
			exceptions[i][0] = Integer.parseInt(in[0]);
			exceptions[i][1] = Integer.parseInt(in[1]);
		}
 
		Arrays.sort(exceptions, new Comparator<int[]>() {
			@Override
			public int compare(final int[] entry1, final int[] entry2) {
				return entry1[0] - entry2[0];
			}
		});
 
		int daysTravelled = 0;
		int distCovered = 0;
		int d;
		int maxSupNormDays;
		int remDist;
		for (int i = 0; i < excCount; i++) {
			d = (exceptions[i][0] - daysTravelled - 1);
			
				remDist = dist - distCovered;
				maxSupNormDays = (remDist / max) + (remDist % max > 0 ? 1 : 0);
				if (maxSupNormDays <= d) {
					daysTravelled += maxSupNormDays;
					distCovered += maxSupNormDays * max;
				} else {
					distCovered += d * max;
					daysTravelled += d;
					if (distCovered >= dist)
						break;
					distCovered += exceptions[i][1];
					daysTravelled++;
				}
			
 
			if (distCovered >= dist)
				break;
		}
 
		if (distCovered < dist) {
		    remDist = dist - distCovered;
			daysTravelled += (remDist / max) + (remDist % max > 0 ? 1 : 0);
		}
		System.out.println(daysTravelled);
 
    }
}