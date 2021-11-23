package Arrays;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class DivideArray {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N= Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int divider=1;
    	String[] strArr = br.readLine().split(" ");
    	 for(int i=0;i<N;i++)
         		arr[i]=Integer.parseInt(strArr[i]);
    	 int Q= Integer.parseInt(br.readLine());
        while(Q-->0){
        	int div= Integer.parseInt(br.readLine());
        	divider*=div;
        	
        }
        if(divider==0)
        	for(int i=0;i<N;i++)
        		sb.append(0+" ");
        else
        for(int i=0;i<N;i++)
        		sb.append(arr[i]/divider+" ");
        bw.write(sb.toString()+"\n"); 	
        bw.flush();
    }
}
