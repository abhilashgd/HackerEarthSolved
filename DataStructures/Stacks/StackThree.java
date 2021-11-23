package Stacks;

import java.util.*;
import java.io.*;
 
class StackThree {
 
    public static void main(String args[]) throws Exception {
 
        Reader in = new Reader(System.in);
        StringBuilder sb = new StringBuilder();
        int n = in.nextInt();
        List<Long> list[] = new List[n];
        Stack<Long> st = new Stack<>();
        for (int i = 0; i < n; i++) {
 
            list[i] = new ArrayList<>();
            int rs = in.nextInt();
            for (int j = 0; j < rs; j++) {
 
                long h = in.nextLong();
                list[i].add(h);
                if (i == 0) {
                    if (j == 0) {
                        st.push(list[i].get(j));
                    } else if (list[i].get(j) < st.peek()) {
                        st.push(list[i].get(j));
                    } else {
                        st.push(st.peek());
                    }
                }
            }
        }
        int q = in.nextInt();
        while (q-- > 0) {
            int v = in.nextInt();
            switch (v) {
                case 1: {
                    int k = in.nextInt() - 1;
                    long h = in.nextLong();
                    list[k].add(h);
                    if (k == 0) {
                        if (h < st.peek()) {
                            st.push(h);
                        } else {
                            st.push(st.peek());
                        }
                    }
                    break;
                }
                case 0: {
                    int k = in.nextInt() - 1;
                    if (k == 0) {
                        st.pop();
                    }
                    list[k].remove(list[k].size()-1);
                    break;
                }
                default:
                    long x = st.peek();
                    String res = "YES";
                    for (int r = 1; r < n; r++) {
 
                        int s = 0;
                        int end = list[r].size();
                        while (s < end) {
                            int mid = (s + end) / 2;
                            if (list[r].get(mid) > x) {
                                end = mid;
                            } else {
                                s = mid + 1;
                            }
                        }
                        if (s < list[r].size() && list[r].get(s) > x) {
 
                            x = list[r].get(s);
                            
                        } else {
                            res = "NO";
                            break;
                        }
                    }
                    sb.append(res).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
 
    static class Reader {
 
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader(InputStream in) {
            din = new DataInputStream(in);
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
                if (c == '\n') {
                    break;
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
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
 
        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
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
 
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
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
        