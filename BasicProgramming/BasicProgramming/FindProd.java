package BasicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
class FindProd {
    public static void main(String args[] ) throws Exception {
      
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String arrayStr = br.readLine();
        String[] str = arrayStr.split(" ");
        long prod = 1;
        for(int i =0; i<N; i++){
            prod = (prod * Integer.parseInt(str[i])) % ((long)Math.pow(10,9) +7);
            
        }
        System.out.println(prod);    
 
      
    }
}