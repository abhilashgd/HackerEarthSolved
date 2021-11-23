package StringAlgos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
class WordSwap {
    public static void main(String args[] ) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int T = Integer.parseInt(line);
        Set<String> set = new HashSet<String>();
        while(T-->0) {
	   		String[] input = br.readLine().split("=");
	   		set.add(input[0]);
	     }
        System.out.println(set.size());
    }
}