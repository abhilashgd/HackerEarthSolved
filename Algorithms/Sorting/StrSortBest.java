package Sorting;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
 
public class StrSortBest {
	 
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static PrintWriter pw = new PrintWriter(System.out);
 
    public static void main(String[] args) throws Exception {
       
        int N = Integer.parseInt(br.readLine());
        while(N-->0){
        	 LinkedList<String>[] ll = new LinkedList[54];
             for(int i=0;i<54;i++)
             	ll[i] = new LinkedList<String>();
        String[] arr = br.readLine().split(" ");
        int len = arr.length;
        for(int i=0;i<len;i++)
        	ll[arr[i].length()].add(arr[i]);
        for(int i=0;i<=53;i++)
        	if(ll[i].size()==0)
        		continue;
        	else{
        		for(int j=0;j<ll[i].size();j++)
        			pw.print(ll[i].get(j)+ " ");
        	}
        pw.println();
        }
            pw.flush();
    }
   
}