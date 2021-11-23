package Searching;

import java.util.*;
import java.io.*;
 
class MySort implements Comparator<int[]>{
    @Override
    public int compare(int a[],int b[]){
        return Integer.compare(a[0],b[0]);
    }
}
 
public class HighestAvgBest {
    public static int search(double avg[],int x){
        int mid,low=0,high=avg.length;
        while(low<high){
            mid=(low+high)>>1;
            if(avg[mid]<x) low=mid+1;
            else high=mid;
        }
        return low;
    }
    
    public static void main(String[] args) throws IOException{
        Reader sc=new Reader();
        OutputWriter out=new OutputWriter(System.out);
        int n=sc.nextInt(),i;
        double sum=0.0;
        int a[]=new int[n];
        double avg[]=new double[n];
        for(i=0;i<n;i++) a[i]=sc.nextInt();
        Arrays.sort(a);
        for(i=0;i<n;i++){
            sum=sum+a[i];
            avg[i]=sum/(i+1);
        }
        int q=sc.nextInt();
        for(i=0;i<q;i++){
            int x=sc.nextInt();
            out.println(search(avg,x));
        }
        out.close();
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
            byte[] buf = new byte[64]; // line length can be increased as use
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
    
    static class OutputWriter {
        private final PrintWriter writer;
         
        public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(outputStream);
        }
         
        public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
        }
         
        public void print(Object... objects) {
        for (int i = 0; i < objects.length; i++) {
        if (i != 0)
        writer.print(' ');
        writer.print(objects[i]);
        }
        }
         
        public void println(Object... objects) {
        print(objects);
        writer.println();
        }
         
        public void close() {
        writer.close();
        }
    }
}