package StringAlgos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class LexLarge {
    public static void main(String args[] ) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        int len = line.length();
        char maxChar=line.charAt(0);
        int maxIndex=0;
        for(int i=1;i<len;i++){
        	if(line.charAt(i)>maxChar)
        	{maxChar=line.charAt(i); maxIndex=i;}}
        
        System.out.println(line.substring(maxIndex,len)+line.substring(0,maxIndex));
    }
}