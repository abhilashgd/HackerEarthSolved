package BasicProgramming;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
 
public class TripletSum {
 
	public static void main(String[] args) {
		try (Reader reader = new Reader()) {
			int n = reader.nextInt();
			int m = reader.nextInt();
			if(n<3){
			    System.out.println("-1");
			    return;
			}
			PriorityQueue<Integer> a = new PriorityQueue<>(Collections.reverseOrder());
			Integer[] arr = new Integer[n];
			for(int i=0; i<n; i++) {
				a.offer(reader.nextInt());
			}
			int sum = 0;
			boolean found = false;
			int i = 0;
			int l = i;
			int j = i+1;
			int k = j+1;
			arr[i] = a.poll();
			arr[j] = a.poll();
			arr[k] = a.poll();
			while(k < n) {
				sum = arr[i] + arr[j] + arr[k];
				if(sum % m == 0) {
					found = true;
					break;
				}
				if(j < k-1) {
					++j;
				} else if(i < j -1) {
					++i;
				} else {
					i = l++;
					j = i+1;
					if(a.isEmpty()) {
					    break;
					}
					arr[++k]=a.poll();
					
				}
			}
			System.out.println(found ? sum : -1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static class Reader implements AutoCloseable
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
			byte[] buf = new byte[2048]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1)
			{
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
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