
import java.lang.System;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.*;

public class EeriePlanet {
	static final String no="NO\n";
	static final String yes="YES\n";
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		GDReader sc = new GDReader();//Reader
		Print pw = new Print();//Writer
		
		int H=sc.nextInt();
		int C=sc.nextInt();
		int Q=sc.nextInt();
		TreeMap<Integer,Integer> tree = new TreeMap<Integer,Integer>();
		//PriorityQueue<Integer> pq = new PriorityQueue<Integer>(H);
		
		while(C-->0)
		{
			int height =sc.nextInt();
			int start = sc.nextInt()-1;
			int end =sc.nextInt()-1;
			for(int i=start;i<=end;i++)
				if(!tree.containsKey(i))
					tree.put(i, height);
				else if(tree.get(i)<height)
							tree.put(i,height);
		}
		int hi=0,ti=0;
		while(Q-->0)
			{
			 hi=sc.nextInt();
			 ti=sc.nextInt()-1;
			 if(!tree.containsKey(ti)) sb.append(yes);
			 else if  (tree.get(ti)<hi) sb.append(yes);
			 else sb.append(no);	 
			}
		pw.print(sb.toString());
		pw.close();
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
	 
	        long nextLong()
	        {
	            return Long.parseLong(next());
	        }
	 
	        double nextDouble()
	        {
	            return Double.parseDouble(next());
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

	 static class Print
		{
		    private final BufferedWriter bw;
		    public Print()
		    {
		        this.bw=new BufferedWriter(new OutputStreamWriter(System.out));
		    }
		    public void print(Object object)throws IOException
		    {
		        bw.append(""+object);
		    }
		    public void println(Object object)throws IOException
		    {
		        print(object);
		        bw.append("\n");
		    }
		    public void close()throws IOException
		    {
		        bw.close();
		    }
		}

}


