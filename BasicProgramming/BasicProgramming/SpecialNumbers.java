package BasicProgramming;

import java.io.*;
import java.util.*;
 
class SpecialNumbers {
 
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader() {
            din = new DataInputStream(System.in);
            bytesRead = bufferPointer = 0;
            buffer = new byte[BUFFER_SIZE];
        }
 
        public Reader(String filename) throws IOException {
            din = new DataInputStream(new FileInputStream(filename));
            bytesRead = bufferPointer = 0;
            buffer = new byte[BUFFER_SIZE];
        }
 
        private byte read() throws IOException {
            if (bufferPointer == bytesRead) {
                fillBuffer();
            }
            return buffer[bufferPointer++];
        }
 
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) {
                buffer[0] = -1;
            }
        }
 
        public void close() throws IOException {
            if (din != null) {
                din.close();
            }
        }
 
        public String nextLine() throws IOException {
            byte[] buf = new byte[64];
            int cnt = 0;
            byte c;
            while (isWhiteSpace(c = read())) {
            }
            while (c != -1) {
                if (c == '\n') {
                    break;
                }
                buf[cnt++] = c;
                c = read();
            }
            return new String(buf, 0, cnt);
        }
 
        public String nextLine(int size) throws IOException {
            byte[] buf = new byte[size];
            int cnt = 0;
            byte c;
            while (isWhiteSpace(c = read())) {
            }
            while (c != -1) {
                if (c == '\n') {
                    break;
                }
                buf[cnt++] = c;
                c = read();
            }
            return new String(buf, 0, cnt);
        }
 
        public String next() throws IOException {
            byte[] buf = new byte[64];
            int cnt = 0;
            byte c;
            while (isWhiteSpace(c = read())) {
            }
            while (c != -1) {
                if (isWhiteSpace(c)) {
                    break;
                }
                buf[cnt++] = c;
                c = read();
            }
            return new String(buf, 0, cnt);
        }
 
        public String next(int size) throws IOException {
            byte[] buf = new byte[size];
            int cnt = 0;
            byte c;
            while (isWhiteSpace(c = read())) {
            }
            while (c != -1) {
                if (isWhiteSpace(c)) {
                    break;
                }
                buf[cnt++] = c;
                c = read();
            }
            return new String(buf, 0, cnt);
        }
 
        public boolean isWhiteSpace(byte n) {
            return (n == ' ' || n == '\n' || n == '\r' || n == '\t');
        }
 
        public char nextChar() throws IOException {
            byte c = read();
            while (isWhiteSpace(c))
                c = read();
            return (char) c;
        }
 
        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (isWhiteSpace(c))
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            if (!(c >= '0' && c <= '9'))
                throw new InputMismatchException();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
 
        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (isWhiteSpace(c))
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            if (!(c >= '0' && c <= '9'))
                throw new InputMismatchException();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
 
        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (isWhiteSpace(c))
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
 
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
            if (neg)
                return -ret;
            return ret;
        }
 
        public byte readLastByte() throws IOException {
            byte buf = 0;
            int c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf = (byte) c;
            }
            return buf;
        }
    }
 
    static class Writer {
        private BufferedWriter bw;
 
        public Writer() {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }
 
        public void print(Object o) throws IOException {
            bw.append(o.toString());
        }
 
        public void println(Object o) throws IOException {
            print(o + "\n");
        }
 
        public void println() throws IOException {
            print("\n");
        }
 
        public void flush() throws IOException {
            bw.flush();
        }
 
        public void close() throws IOException {
            bw.close();
        }
    }
    final static int MAX=101;
    static boolean[] isSpecial;
    public static void main(String args[]) throws IOException {
    	
        Reader reader = new Reader();
        Writer writer = new Writer();
        StringBuilder sb = new StringBuilder();
        int t,l,r;
        sieve();
        t = reader.nextInt();
        
        
        for(int i=0;i<t;i++) {
        	 int count=0;
            l =reader.nextInt();
            r =reader.nextInt();
           for(int j=l;j<=r;j++) 
        	   if(isSpecial[j])
        	     {count++;writer.print(j+" ");}
            
            sb.append(count+"\n");
        }
        writer.println(sb);
        writer.close();
        reader.close();
    }
	private static void sieve() {
		isSpecial=new boolean[MAX+1];
		for(int i=0;i<MAX;i++)
			isSpecial[i]=false;
		
		for(int i=1;i<=MAX;i++){
			if(Integer.bitCount(i)==Integer.toBinaryString(i).length())
				{isSpecial[i]=true;continue;}
			else if(altPattern(i)){
				isSpecial[i]=true;continue;}
			else if(setBitSequence(i)){
				isSpecial[i]=true;
			}
		}
	}

	 private static boolean setBitSequence(int n) {

		 String s = Integer.toBinaryString(n);
		System.out.println(s);
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i=0;i<s.length();i++)
			{
				int count=0;
				while(i<s.length() && s.charAt(i)=='1' ){
					count++;i++;
				}
				if(count!=0)al.add(count);
			}
		for(int i=0;i<al.size()-1;i++){
			if(al.get(i)==al.get(i+1))
				continue;
			else return false;
		}
		return true;
	}
	 
	static boolean altPattern(int n) 
	    { 
	        int prev = n % 2; 
	        n = n/2; 
	        while (n > 0) 
	        { 
	            int curr = n % 2; 
	            if (curr == prev) 
	               return false; 
	            prev = curr; 
	            n = n / 2; 
	        } 
	        return true; 
	    } 
	
	
}


