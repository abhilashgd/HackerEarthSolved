package Arrays;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class AllVowel {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N= Integer.parseInt(br.readLine());
        while(N-->0){
        	int[] S = new int[126];
            int[] T = new int[126];
            int diff=0,count=0;
        	String first = br.readLine();
            for(int i=0;i<first.length();i++)
            	S[(int)first.charAt(i)]++;
            String second = br.readLine();
            for(int i=0;i<second.length();i++)
            	T[(int)second.charAt(i)]++;
            
            for(int i=97;i<123;i++){
            	diff=S[i]-T[i];
            		if(diff<0){
            			diff=-diff;
            		}
            	count+=diff;
            }
            bw.write(count+"\n"); 	
            
        }
        
        bw.flush();
    }
}
