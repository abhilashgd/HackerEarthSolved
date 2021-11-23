package Searching;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
 
 
class BinSubBest {
 
    public static void main(String[] args) throws IOException {
        Reader sc = new Reader();
        BufferedOutputStream out = new BufferedOutputStream(System.out);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int query = sc.nextInt();
        int setBit[] = new int[n];
        for (int i = 0; i < n; i++) {
            setBit[i] = countSetBits(sc.nextInt());
        }
        for (int i = 0; i < query; i++) {
            int q = sc.nextInt();
            int min_len = smallestSubWithSum(setBit, setBit.length, q);
            if(min_len == setBit.length+1){
                sb.append(-1+"\n");
            }else{
                sb.append(min_len+"\n");
            }
        }
 
        out.write(sb.toString().getBytes());
        out.flush();
    }
 
    static int smallestSubWithSum(int arr[], int n, int x) {
 
        int curr_sum = 0, min_len = n + 1;
 
        int start = 0, end = 0;
        while (end < n) {
 
            while (curr_sum <= x && end < n)
                curr_sum += arr[end++];
 
            while (curr_sum >= x && start < n) {
                if (end - start < min_len)
                    min_len = end - start;
 
                curr_sum -= arr[start++];
            }
        }
        return min_len;
    }
 
 
    static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
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
 
        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
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
            } while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
 
        public long nextLong() throws IOException {
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
 
        public double nextDouble() throws IOException {
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
 
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
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
