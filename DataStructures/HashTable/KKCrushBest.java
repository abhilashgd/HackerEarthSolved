package HashTable;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
 
class KKCrushBest {
    public static void main(String args[] ) throws Exception {
     
        Reader s = new Reader();
        BufferedOutputStream out=new BufferedOutputStream(System.out);
        StringBuilder sb = new StringBuilder();
        int numTests = s.nextInt();
        for (int i = 0; i < numTests; i++) {
            boolean[] possibleValues = new boolean[200001];
            int numElements = s.nextInt();
            for (int j = 0; j < numElements; j++) {
                possibleValues[s.nextInt() + 100000] = true;
            }
            int numCases = s.nextInt();
            for (int k = 0; k < numCases; k++) {
                if (possibleValues[s.nextInt() + 100000]) {
                    sb.append("Yes\n");
                } else {
                    sb.append("No\n");
                }
             }
        }
        out.write(sb.toString().getBytes());
		out.flush();
    }
    
    static class Reader
	    {
	        final private int BUFFER_SIZE = 1 << 16;
	        private DataInputStream din;
	        private byte[] buffer;
	        private int bufferPointer, bytesRead;
	 
	        public Reader()
	        {
	            din = new DataInputStream(System.in);
	            buffer = new byte[BUFFER_SIZE];
	            bufferPointer = bytesRead = 0;
	        }
	 
	        public Reader(String file_name) throws IOException
	        {
	            din = new DataInputStream(new FileInputStream(file_name));
	            buffer = new byte[BUFFER_SIZE];
	            bufferPointer = bytesRead = 0;
	        }
	 
	        public String readLine() throws IOException
	        {
	            byte[] buf = new byte[64]; // line length
	            int cnt = 0, c;
	            while ((c = read()) != -1)
	            {
	                if (c == '\n')
	                    break;
	                buf[cnt++] = (byte) c;
	            }
	            return new String(buf, 0, cnt);
	        }
	 
	        public void removeSpace() throws IOException
	        {
	        	  byte c = read();
	        	  while(c!='\n')
	        	  {
	        		  c=read();
	        	  }
	        }
	        public int nextInt() throws IOException
	        {
	            int ret = 0;
	            byte c = read();
	            while (c <= ' ')
	                c = read();
	            boolean neg = (c == '-');
	            if (neg)
	                c = read();
	            do
	            {
	                ret = ret * 10 + c - '0';
	            }  while ((c = read()) >= '0' && c <= '9');
	 
	            if (neg)
	                return -ret;
	            return ret;
	        }
	        public int getInt() throws IOException
	        {
	            int ret = 0;
	            byte c = read();
	            while(((c) < '0' || c > '9'))
	            {
	            	if(c=='\n')
	            	{
	            		return -1;	
	            	}
	            	c=read();
	            }
	            while (c <= ' ')
	            {
	            	c = read();
	            }
	            
	            boolean neg = (c == '-');
	            if (neg)
	                c = read();
	            do
	            {
	                ret = ret * 10 + c - '0';
	            }  while ((c = read()) >= '0' && c <= '9');
	 
	            if (neg)
	                return -ret;
	            return ret;
	        }
	        public long nextLong() throws IOException
	        {
	            long ret = 0;
	            byte c = read();
	            while (c <= ' ')
	                c = read();
	            boolean neg = (c == '-');
	            if (neg)
	                c = read();
	            do {
	                ret = ret * 10 + c - '0';
	            }
	            while ((c = read()) >= '0' && c <= '9');
	            if (neg)
	                return -ret;
	            return ret;
	        }
	 
	        public double nextDouble() throws IOException
	        {
	            double ret = 0, div = 1;
	            byte c = read();
	            while (c <= ' ')
	                c = read();
	            boolean neg = (c == '-');
	            if (neg)
	                c = read();
	 
	            do {
	                ret = ret * 10 + c - '0';
	            }
	            while ((c = read()) >= '0' && c <= '9');
	 
	            if (c == '.')
	            {
	                while ((c = read()) >= '0' && c <= '9')
	                {
	                    ret += (c - '0') / (div *= 10);
	                }
	            }
	 
	            if (neg)
	                return -ret;
	            return ret;
	        }
	 
	        private void fillBuffer() throws IOException
	        {
	            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
	            if (bytesRead == -1)
	                buffer[0] = -1;
	        }
	 
	        private byte read() throws IOException
	        {
	            if (bufferPointer == bytesRead)
	                fillBuffer();
	            return buffer[bufferPointer++];
	        }
	 
	        public void close() throws IOException
	        {
	            if (din == null)
	                return;
	            din.close();
	        }
	    }
}