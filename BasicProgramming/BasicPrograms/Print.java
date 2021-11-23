package BasicPrograms;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Print  {
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

