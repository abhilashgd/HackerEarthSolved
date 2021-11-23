package BasicProgramming;

import java.io.*;
import java.util.*;



public class MinimiseCost {
	
    public static void main(String[] args) throws IOException {
       
    	 Reader in = new Reader();  
         Writer out = new Writer(); 

         int N = in.nextInt();
         int K = in.nextInt();
         long sum=0;
         while(N-->0){
        	 int temp=in.nextInt();
        	 if(temp<0)
        	 {
        		 
        	 }
         }
         out.close();
         in.close();
    }
    
}


class Reader {
	final private int BUFFER_SIZE = 1<<16;
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
	
	private byte read() throws IOException{
		if (bufferPointer == bytesRead) {
			fillBuffer();
		}
		return buffer[bufferPointer++];
	}
 
	private void fillBuffer() throws IOException{
		bytesRead = din.read(buffer, bufferPointer = 0 , BUFFER_SIZE);
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
		while (isWhiteSpace(c = read())) {}
		while (c != -1) {
			if (c == '\n') {
				break;
			}
			buf[cnt++] = c;
			c = read();
		}
		return new String(buf, 0 , cnt);
	}
	public int nextLine(int size) throws IOException {
		int cnt = 0;
		byte c;
		while (isWhiteSpace(c = read())) {}
		for (int i = 0 ; i < size ; i++) {
			if (c == '0') {
			    cnt++;
			}
			c = read();
		}
		return cnt;
	}
 
	public String next() throws IOException {
		byte[] buf = new byte[64];
		int cnt = 0;
		byte c;
		while (isWhiteSpace(c = read())) {}
		while (c != -1) {
			if (isWhiteSpace(c)) {
				break;
			}
			buf[cnt++] = c;
			c = read();
		}
		return new String(buf, 0 , cnt);
	}
	
	public String next(int size) throws IOException {
		byte[] buf = new byte[size];
		int cnt = 0;
		byte c;
		while (isWhiteSpace(c = read())) {}
		while (c != -1) {
			if (isWhiteSpace(c)) {
				break;
			}
			buf[cnt++] = c;
			c = read();
		}
		return new String(buf, 0 , cnt);
	}
	
	public boolean isWhiteSpace(byte n) {
		return (n == ' ' || n == '\n' || n == '\r' || n == '\t');
	}
	
	public char nextChar() throws IOException {
		byte c = read();
		while (isWhiteSpace(c))
			c = read();
		return (char)c;
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
		} while ((c = read()) >= '0' && c <='9');
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
		} while ((c = read()) >= '0' && c <='9');
		if (neg) 
			return -ret;
		return ret;
	}
 
	public double nextDouble() throws IOException {
		double ret = 0 , div = 1;
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
}
 
class Writer {
	private BufferedWriter bw;
	 
	public Writer(){
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
 
	public void print(Object o) throws IOException{
		bw.append(o.toString());
	}
 
	public void println(Object o) throws IOException{
		print(o + "\n");
	}
	
	public void println() throws IOException{
		print("\n");
	}
	
	public void flush() throws IOException{
	    bw.flush();
	}
	
	public void close() throws IOException {
		bw.close();
	}
}
       