package HashTable;


/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
//import for Scanner and other utility classes
import java.util.*;
*/
 
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.List;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
 
class HashTableTwoWithEqualsAndHashCodeOveeride {
    	static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
 
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
 
        public String readLine() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
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
 
        public long readLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
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
 
        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
 
        public boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
    }
	
	static class OutputWriter {
        private final PrintWriter writer;
 
        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                    outputStream)));
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
        }
 
        public void close() {
            writer.close();
        }
    }
    
    
    public static void main(String args[] ) throws Exception {
        
		
		InputReader in = new InputReader(System.in);
	    OutputWriter out = new OutputWriter(System.out);
	    
	    int N = in.readInt();
	    StringBuilder output = new StringBuilder();
	    Hashtable<Pair, Integer> countMap = new Hashtable<>();
	    List<Pair> list = new ArrayList<>();
	    int count = 0;
	    for (int i=0;i<N;i++) {
	    	
	    	int a = in.readInt();
	    	int b = in.readInt();
	    	Pair p = new Pair(a, b);
	    	
	    	if (!countMap.containsKey(p))  {
	    		countMap.put(p, 1);
	    		list.add(p);
	    	}
	    	else {
	    		int value = countMap.get(p);
	    		countMap.put(p, ++value);
	    	}
	    }
	    
	    Collections.sort(list);
	    int len = list.size();
 	    for (int i=0;i<len;i++) {
 	    	
 	    	Pair q = list.get(i);
 	    	
 	    	output.append(q.a).append(" ").append(q.b).append(" ").
    		append(countMap.get(q)).append("\n");
 	    }
	    
	    out.print(output);
	    out.close();
	
    }
    
    static class Pair implements Comparable<Pair> {
		
		int a;
		int b;
		int counter = 1;
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		
		}
		
		public void incrementCounter() {
			counter = counter+1;
		}
		
		@Override
		public boolean equals(Object obj) {
			
			if (obj ==  null) {
				return false;
			}
			
			if (!(obj instanceof Pair)) {
				return false;
			}
			
			Pair p = (Pair) obj;
			return this.a == p.a && this.b == p.b;
		}
		
		@Override
		public int hashCode() {
			int hash = new Integer(a).hashCode();
			hash = hash*31 + new Integer(b).hashCode();
			return hash;
		}
 
		@Override
		public int compareTo(Pair o) {
			
			if (o.a != this.a) {
				if (this.a > o.a) {
					return 1;
				}
				else {
					return -1;
				}
			}
			else {
				if (this.b > o.b) {
					return 1;
				}
				else if (this.b < o.b) {
					return -1;
				}
				else {
					return 0;
				}
			}
			
		}
		
		
	}
    
}