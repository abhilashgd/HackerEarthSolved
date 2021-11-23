import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.PriorityQueue;
 
public class ChocolateDistribution {
 
    
    boolean isTestCase = !true;
    
    public ChocolateDistribution() throws IOException 
    {
        //input
    	InputReader in = new InputReader(System.in);
        
        //output
        PrintWriter out = new PrintWriter(System.out);
        int T;
        if(isTestCase==true)
        	T = in.nextInt();
        else
        	T=1;
        
        for(int caseNo = 1; caseNo <= T; caseNo++)
            solve(caseNo, in, out);
 
        out.close();
    }
 
    private void solve(int caseNo, InputReader in, PrintWriter out) throws IOException 
    {
    	int N=in.nextInt();
    	int X=0,Q=0,K=0,sum,studentCount=0;
    	PriorityQueue<Integer> first = new PriorityQueue<Integer>();
    	while(N-->0)
    	{
    		Q= in.nextInt();
    		K=in.nextInt();
    		sum=0;
        	first.clear();
        	
    		for(int i=0;i<Q;i++)
    		{
    			int ns=in.nextInt();studentCount+=ns;
    				for(int j=0;j<ns;j++)
    				{
    					 X=in.nextInt();
    					 if(!first.contains(X))
    					 first.add(X); //out.print(X+" ");
    				}
    		}
    		
    		if(K>=studentCount)
    			out.println(studentCount);
    		else
    		{
    			
    				for(int z=0;z<K;z++)
    					sum=sum+first.poll();
    				out.println(sum);	
    					//out.print(first.poll()+" ");
    		}
    	
    	}
    }
    static class InputReader {
 
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
 
        public InputReader(InputStream stream) {
            this.stream = stream;
        }
 
        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
 
        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                        numChars = stream.read(buf);
                } catch (IOException e) {
                        throw new InputMismatchException();
                }
                if (numChars <= 0) {
                        return -1;
                }
            }
            return buf[curChar++];
        }
 
 
 
        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }
 
        public interface SpaceCharFilter {
 
            public boolean isSpaceChar(int ch);
        }
 
        public String next() {
            return nextString();
        }
        
        public char nextChar(){
        	int c=read();
        	while (isSpaceChar(c)) {
                c = read();
            }
        	return (char)c;
        }
 
        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }
 
        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
 
        public Long nextLong() {
            return Long.parseLong(nextString());
        }
 
        public Double nextDouble() {
            return Double.parseDouble(nextString());
        }
    }
 
    public static void main(String args[]) throws IOException {
        new ChocolateDistribution();
    }
}