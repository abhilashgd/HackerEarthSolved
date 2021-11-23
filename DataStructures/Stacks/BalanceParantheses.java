package Stacks;
import java.io.*;
 
import java.util.*;
 
class TestClass {
    public static void main(String args[] ) throws Exception {
        Reader in = new Reader();
        int N = in.nextInt();
        Stack<Integer> stack = new Stack<>();
        int count = 0, max = 0;
        for(int i = 0; i < N; i++) {
            int n = in.nextInt();
            if(!stack.isEmpty() && n <= 0 && stack.peek() == -n) {
                stack.pop();
                count += 2;
            } else if(!stack.isEmpty() && (n <= 0 || stack.peek() != -n)) {
                stack.push(n);
                if(max < count) {
                    max = count;
                    count = 0;
                }
            } else {
                stack.push(n);
            }
        }
        if(max < count)
            max = count;
        System.out.println(max);
    }
    
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
 
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }
}