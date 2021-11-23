package Arrays;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Ruby {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N= Integer.parseInt(br.readLine());
       
        while(N-->0){
        	 int[] arr = new int[126];
        	String input = br.readLine();
            for(int i=0;i<input.length();i++)
            	arr[(int)input.charAt(i)]++;
            int[] ruby={arr[114],arr[117],arr[98],arr[121]};
            int min=ruby[0];
            for(int i=0;i<4;i++){if(min>ruby[i])min=ruby[i];}
            bw.write(min+"\n"); 	
        }
        bw.flush();
    }
}
