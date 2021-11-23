package Stacks;
import java.io.*;
import java.util.*;
 
class StackOne {
    public static void main(String args[]) throws Exception {
 
        Reader in = new Reader();
        int N = in.nextInt(); 
        int i;
        long[] stack = new long[N];
        int[] x = new int[N];
        int[] y = new int[N];
 
        for (i = 0; i < N; i++) {
            stack[i] = in.nextLong();
            if (i == 0) {
                x[i] = -1;
            } else if (stack[i - 1] > stack[i]) {
                x[i] = i;
            } else {
                int index = x[i - 1] - 1;
                while (index >= 0 && stack[index] <= stack[i]) {
                    index = x[index] - 1;
                }
                x[i] = index < 0 ? -1 : index + 1;
            }
        }
        y[N - 1] = -1;
        int[] sum = new int[N];
        sum[N - 1] = x[N - 1] + y[N - 1];
        for (i = N - 2; i >= 0; i--) {
            if (stack[i + 1] > stack[i]) {
                y[i] = i + 2;
            } else {
                int index = y[i + 1] - 1;
                while (index >= 0 && stack[index] <= stack[i]) {
                    index = y[index] - 1;
                }
                y[i] = index < 0 ? -1 : index + 1;
            }
            sum[i] = x[i] + y[i];
        }
        StringBuilder sb = new StringBuilder();
        for (i = 0; i < N; i++) {
            sb.append(sum[i]).append(" ");
        }
        System.out.println(sb);
        //in.close;
 
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
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
 
            if (neg) {
                return -ret;
            }
            return ret;
        }
 
        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) {
                return -ret;
            }
            return ret;
        }
 
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) {
                buffer[0] = -1;
            }
        }
 
        private byte read() throws IOException {
            if (bufferPointer == bytesRead) {
                fillBuffer();
            }
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException {
            if (din == null) {
                return;
            }
            din.close();
        }
    }
}