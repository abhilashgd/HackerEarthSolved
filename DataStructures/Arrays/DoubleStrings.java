package Arrays;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class DoubleStrings {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N= Integer.parseInt(br.readLine());
        while(N-->0){
        	int[] S = new int[126];
            int diff=0,count=0;
            boolean flag=false;
        	String input = br.readLine();
            for(int i=0;i<input.length();i++)
            	S[(int)input.charAt(i)]++;
            
            
            for(int i=97;i<123;i++){
            	if(S[i]>1){
            		flag=true;break;
            	}
            		
            }
            if(flag)
            bw.write("YES"+"\n"); 
            else
            	bw.write("NO"+"\n");
        }
        bw.flush();
    }
}
