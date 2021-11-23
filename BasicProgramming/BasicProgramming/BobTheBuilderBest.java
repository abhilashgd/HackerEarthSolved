package BasicProgramming;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.InputMismatchException;
import java.util.HashMap;
 
class BobTheBuilderBest {
    public static void main(String args[] ) throws Exception {
      MyScanner ms=new MyScanner();
		int[] count=new int[10];
		int testcase=ms.nextInt();
		long num,big=0,index=0,temp;
		HashMap<Long,Long> hm=new HashMap<Long,Long>();		
		while(testcase--!=0)
		{
			num=ms.nextLong();
			if(hm.containsKey(num))
				hm.put(num, hm.get(num)+1);
			else
				hm.put(num, (long) 1);
 
		}
		for(long number:hm.keySet())
		{
			temp=hm.get(number);
			if(temp>big)
			{
				big=temp;
				index=number;
			}
			else if(temp==big)
			{
				if(index>number)
					index=number;
			}
				
		}
		System.out.println(index);
 
    }
}
 
class MyScanner {
	private byte[] buf = new byte[1024];
	private int index;
	private InputStream in;
	private int total;
 
	public MyScanner() {
		in = System.in;
	}
 
	public MyScanner(String inputFilePath) throws IOException {
		in = new FileInputStream(inputFilePath);
	}
 
	public int next() throws IOException {
		if (total < 0)
			throw new InputMismatchException();
		if (index >= total) 
		{
			index = 0;
			total = in.read(buf);
			if (total <= 0)
				return -1;
		}
		return buf[index++];
	}
 
	public int nextInt() throws IOException {
		int integer = 0;
		int n = next();
		while (isWhiteSpace(n))
			n = next();
		int neg = 1;
		if (n == '-') {
			neg = -1;
			n = next();
		}
		while (!isWhiteSpace(n)) {
			if (n >= '0' && n <= '9') {
				integer *= 10;
				integer += n - '0';
				n = next();
			} else
				throw new InputMismatchException();
		}
		return neg * integer;
	}
	
	public long nextLong() throws IOException {
		long longe = 0;
		int n = next();
		while (isWhiteSpace(n))
			n = next();
		int neg = 1;
		if (n == '-') {
			neg = -1;
			n = next();
		}
		while (!isWhiteSpace(n)) {
			if (n >= '0' && n <= '9') {
				longe *= 10;
				longe += n - '0';
				n = next();
			} else
				throw new InputMismatchException();
		}
		return neg * longe;
	}
 
	public double scanDouble() throws IOException {
		double doub = 0;
		int n = next();
		while (isWhiteSpace(n))
			n = next();
		int neg = 1;
		if (n == '-') {
			neg = -1;
			n = next();
		}
		while (!isWhiteSpace(n) && n != '.') {
			if (n >= '0' && n <= '9') {
				doub *= 10;
				doub += n - '0';
				n = next();
			} else
				throw new InputMismatchException();
		}
		if (n == '.') {
			n = next();
			double temp = 1;
			while (!isWhiteSpace(n)) {
				if (n >= '0' && n <= '9') {
					temp /= 10;
					doub += (n - '0') * temp;
					n = next();
				} else
					throw new InputMismatchException();
			}
		}
		return doub * neg;
	}
 
	public String scanString() throws IOException {
		StringBuilder sb = new StringBuilder();
		int n = next();
		while (isWhiteSpace(n))
			n = next();
		while (!isWhiteSpace(n)) {
			sb.append((char) n);
			n = next();
		}
		return sb.toString();
	}
 
	private boolean isWhiteSpace(int n) {
		if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1)
			return true;
		return false;
	}
}