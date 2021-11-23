package StringAlgos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class AshishBinMatrixBest {
    public static void main(String args[] ) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int T = Integer.parseInt(line);
        for (int i = 0; i < T; i++) {
	   		String[] inputSize = br.readLine().split(" ");
	   		int rows = Integer.parseInt(inputSize[0]);
	   		int columns = Integer.parseInt(inputSize[1]); 
	   		Set<String> matrix = new HashSet<String>();
	   		for(int j = 0 ; j < rows ; j++){
	   			matrix.add(br.readLine());
	   		}
	   		if(matrix.size() == rows) 
	   			System.out.println("Yes");
	   		else
	   			System.out.println("No");
	   		
	     }
 
    }
}