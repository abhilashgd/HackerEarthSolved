package Arrays;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class MaxOccurance {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        	int[] S = new int[126];
            int temp=0;
            int max=S[32];
        	String first = br.readLine();
            for(int i=0;i<first.length();i++)
            	S[(int)first.charAt(i)]++;
            for(int i=32;i<126;i++){
            	if(max<S[i]){
            		max=S[i];temp=i;
            	}
            }
            char ch =(char)temp;
            bw.write(ch+" "+max); 	
        
        bw.flush();
    }
}
