package HashTable;

import java.io.*;
import java.util.*;
class AlienLanguage{
    public static void main(String args[] ) throws Exception {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.valueOf(br.readLine());
        while(T-->0){
        	boolean flag=false;
            String text = br.readLine();
            char[] first =text.toCharArray();
            HashSet<Character> ht = new HashSet<Character>();
            for(int i=0;i<first.length;i++)
            	ht.add(first[i]);
            String pattern = br.readLine();
            char[] second =pattern.toCharArray();
            for(int i=0;i<second.length;i++)
            	if(ht.contains(second[i]))
            	{flag=true;break;}
            
            if(flag)		
                bw.write("YES"+"\n");
            else
                bw.write("NO"+"\n");
            ht.clear();
        }
        bw.flush();

    }
}
