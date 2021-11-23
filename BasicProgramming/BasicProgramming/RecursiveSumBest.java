package BasicProgramming;
import java.util.*;
import java.io.*;
 

public class RecursiveSumBest{
 
 
  static long fun(long sum){
     if(sum%9==0 && sum!=0){return 9;}
       else if(sum>9){return sum%9;}
       else if(sum<9){return sum;}
       return 0;
  }
        public static void main(String args[] ) throws Exception {
      InputReader in=new InputReader(System.in);
    OutputWriter out=new OutputWriter(System.out);
 
       int t=in.readInt();
       while(t-- >0){
        long sum=0;
        int bb=in.readInt();
        while(bb-- >0){
          long a=in.readLong();
          long b=in.readLong();
          sum+=fun(a*b);
        }
        long k=fun(sum);
        out.println(k);
      
       
       }
  out.close();  }
        
       static class InputReader {
            private InputStream stream;
            private byte[] buf = new byte[1024];
            private int curChar;
            private int numChars;
            private SpaceCharFilter filter;
         
            public InputReader(InputStream stream) {
                this.stream = stream;
            }
         
            public int read() {
                if (numChars == -1)
                    throw new InputMismatchException();
                if (curChar >= numChars) {
                    curChar = 0;
                    try {
                        numChars = stream.read(buf);
                    } catch (IOException e) {
                        throw new InputMismatchException();
                    }
                    if (numChars <= 0)
                        return -1;
                }
                return buf[curChar++];
            }
         
            public int readInt() {
                int c = read();
            while (isSpaceChar(c))
                    c = read();
            int sgn = 1;
            if (c == '-') {
                    sgn = -1;
                    c = read();
            }
                int res = 0;
            do {
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    res *= 10;
                    res += c - '0';
                    c = read();
                } while (!isSpaceChar(c));
                return res * sgn;
            }
         
            public long readLong() {
                int c = read();
                while (isSpaceChar(c))
                    c = read();
                int sgn = 1;
                if (c == '-') {
                    sgn = -1;
                    c = read();
                }
            long res = 0;
                do {
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                        c = read();
                } while (!isSpaceChar(c));
                return res * sgn;
            }
         
            public String readString() {
                int c = read();
                while (isSpaceChar(c))
                    c = read();
                StringBuilder res = new StringBuilder();
            do {
                    res.appendCodePoint(c);
                    c = read();
                } while (!isSpaceChar(c));
            return res.toString();
            }
         
            public boolean isSpaceChar(int c) {
                if (filter != null)
                    return filter.isSpaceChar(c);
                return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
            }
         
            public String next() {
                return readString();
            }
         
            public interface SpaceCharFilter {
                public boolean isSpaceChar(int ch);
            }
        }
         
        static class OutputWriter {
            private final PrintWriter writer;
         
            public OutputWriter(OutputStream outputStream) {
                writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
            }
         
            public OutputWriter(java.io.Writer writer) {
                this.writer = new PrintWriter(writer);
            }
         
            public void print(Object...objects) {
                for (int i = 0; i < objects.length; i++) {
                    if (i != 0)
                        writer.print(' ');
                writer.print(objects[i]);
                }
            }
         
            public void println(Object...objects) {
                print(objects);
            writer.println();
            }
         
            public void close() {
                writer.close();
            }
            public void flush(){
                writer.flush();
            }
        }
}