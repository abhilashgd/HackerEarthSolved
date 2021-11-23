package StringOperation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class BeerStr {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int[] fav = new int[126];
    	String favStr = br.readLine();
    	 for(int i=0;i<favStr.length();i++)
         		fav[(int)favStr.charAt(i)]++;
    	int count=0;
        int N= Integer.parseInt(br.readLine());
        while(N-->0){
            int[] T = new int[127];
        	String input = br.readLine();
        	boolean flag=true;
        	
        	for(int i=0;i<input.length();i++)
            	T[(int)input.charAt(i)]++;
            
            for(int j=97;j<123;j++)
            		if((fav[j]-T[j])<0)
            			{flag = false; break;}
            if(flag)
            	count++;
        }
        bw.write(count+"\n"); 	
        bw.flush();
    }
}
