package StringAlgos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
class SubStringDeletionBest{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        while ( line != null ) {
            System.out.println(removeDuplicateLetters(line));
            line = br.readLine();
        }
    }
 
    static String removeDuplicateLetters(String s){
        if(s.length() == 0) return s;
 
        //We use 128 is to avoid substraction
        //if we use 26, we have to substract 'a' from a char
        int[] count = new int[128];
        char[] result = new char[26];
        boolean[] assigned = new boolean[128];
        char c;
        int end = -1;
 
        for(int i=0; i<s.length(); i++){
            count[s.charAt(i)]++;
        }
 
        for(int i=0; i<s.length(); i++){
            c = s.charAt(i);
            count[c]--;
            if(assigned[c])
                continue;
 
            while(end >= 0 && result[end] > c && count[result[end]]>0){
                assigned[result[end]] = false;
                end--;
            }
 
            end++;
            result[end] = c;
            assigned[c] = true;
        }
 
        StringBuilder bd = new StringBuilder();
        for(int i=0; i<=end; i++){
            bd.append(result[i]);
        }
        return bd.toString();
    }
}