import java.lang.System;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
 
public class BinaryQueries {
	
	public static void main(String[] args) throws IOException {
		
		GDReader r = new GDReader();
		PrintWriter pw = new PrintWriter(System.out);
		int testCases = r.nextInt();
		for(int i=0;i<testCases;i++)
		{
			int n = r.nextInt();
			int rate=r.nextInt();
			int count =1;
			int max=0;
			double temp=0;
			temp = r.nextInt();
			
			for(int j=1;j<n;j++) {
				int x=r.nextInt();
				if(temp <x && max<x){
					max=x;
					count++;
				}
			}
			n=rate*count;
			pw.println(n);
		}
	pw.flush();
	}
	
	static class GDReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public GDReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }

        
    }

}