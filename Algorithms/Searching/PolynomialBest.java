package Searching;
import java.io.*;
import java.util.InputMismatchException;
 
class PolynomialBest {
 
    public static void main(String args[]) throws Exception {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        StringBuilder sb = new StringBuilder();
        int T = in.readInt(),n,index;
        long a, b, c, k;
        for (int test = 0; test < T; test++) {
            a = in.readLong();
            b = in.readLong();
            c = in.readLong();
            k = in.readLong();
            c-=k;
            if(b*b-4*a*c<=0||c>=0)
                sb.append(0).append("\n");
            else{
                int ans = (int) Math.ceil((Math.sqrt(b*b-4*a*c*1.0)-b)/(2*a));
                sb.append(ans).append("\n");
            }
        }
        out.print(sb.toString());
        out.flush();
        out.close();
    }
 
}
 
class InputReader {
 
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;
 
    public InputReader(InputStream stream) {
        this.stream = stream;
    }
 
    public int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }
 
    public int readInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }
 
 
    public long readLong() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        long sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }
 
    public String readLine() {
        int c = read();
        StringBuilder res = new StringBuilder();
        while (!isNewLineChar(c)) {
            res.appendCodePoint(c);
            c = read();
        }
        return res.toString();
    }
 
    private boolean isNewLineChar(int c) {
        return c == '\n';
    }
 
    public String readString() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }
 
    public boolean isSpaceChar(int c) {
        if (filter != null)
            return filter.isSpaceChar(c);
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
 
    public String next() {
        return readString();
    }
 
    public interface SpaceCharFilter {
        boolean isSpaceChar(int ch);
    }
}
 
class OutputWriter {
    private final PrintWriter writer;
 
    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
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
 
    public void printLine(Object... objects) {
        print(objects);
        writer.println();
        this.flush();
    }
 
    public void close() {
        writer.close();
    }
 
    public void flush() {
        writer.flush();
    }
 
    public void println(Object... objects) {
        print(objects);
        writer.println();
        this.flush();
    }
}
 
class IOUtils {
 
    public static int[] readIntArray(InputReader in, int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++)
            array[i] = in.readInt();
        return array;
    }
 
    public static int[] readIntArray(InputReader in, int size, long[] counts) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = in.readInt();
            if (array[i] % 2 == 0)
                counts[0]++;
            else
                counts[1]++;
        }
        return array;
    }
 
}