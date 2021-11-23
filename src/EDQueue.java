
import java.lang.System;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.*;

public class EDQueue {
	
	public static void main(String[] args) throws IOException {
		
		GDReader sc = new GDReader();
		Print pw = new Print();
		int N = sc.nextInt();
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(N,new Compare2DArray());
		
		String row="";
		String D = "D";
		int temp[]=new int[2];
		
		for(int i=0;i<N;i++)
		{
			row = sc.next();
			if(row.equals(D))
			{
				temp=pq.poll();
				pw.println(temp[0]+" "+temp[1]);
			}
			else
			{ 
				int[] elements = new int[2];
				elements[0]=sc.nextInt();
				elements[1]=sc.nextInt();
				pq.offer(elements);
			}
			}
		
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

class Compare2DArray implements Comparator<int[]> {
	public int compare(int a[], int b[]) {
	    for (int i = 0; i < a.length && i < b.length; i++)
	        if (a[i] != b[i])
	            return a[i] - b[i];
	    return a.length - b.length;
	}
}
