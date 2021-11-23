package NumberTheory;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
 
class RoysLifeCycle{
    public static void main(String args[] ) throws Exception {
        Reader r = new Reader();
        int n = r.nextInt();
        String input;
        int streak, longestDayStreak, maxLongestDayStreak = 0, continuedStreak = 0, maxStreakEver = 0;
        boolean continued = false;
        for(int i = 0; i < n; i++){
            input = r.readLine();
            streak = 0;
            longestDayStreak = 0;
            for(int j = 0; j < input.length(); j++){
                if(input.charAt(j) == 'C'){
                    streak++;
                }
                else{
                    if(continued){
                        continuedStreak += streak;
                        continued = false;
                        maxStreakEver = max(maxStreakEver, continuedStreak);
                    }
                    continuedStreak = 0;
                    longestDayStreak = max(longestDayStreak, streak);
                    streak = 0;
                }
            }
            if(streak > 0){
                if(continued){
                    continuedStreak += streak;
                }
                else{
                    continuedStreak = streak;
                    continued = true;
                }
                maxStreakEver = max(maxStreakEver, continuedStreak);
            }
            longestDayStreak = max(longestDayStreak, streak);
            maxLongestDayStreak = max(maxLongestDayStreak, longestDayStreak);
        }
        maxStreakEver = max(maxStreakEver, maxLongestDayStreak);
        System.out.println(maxLongestDayStreak + " " + maxStreakEver);
    }
    
    static int max(int x, int y){
        return x > y ? x : y;
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
            byte[] buf = new byte[1440]; // line length
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