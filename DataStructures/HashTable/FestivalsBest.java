package HashTable;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
 
class ReaderT {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;
 
    public ReaderT(InputStream stream) {
        this.stream = stream;
    }
 
    public int read() {
        if (numChars == -1) {
            throw new InputMismatchException();
        }
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buf[curChar++];
    }
 
    public int nextInt() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }
 
    public String readString() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }
 
    public double nextDouble() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        double res = 0;
        while (!isSpaceChar(c) && c != '.') {
            if (c == 'e' || c == 'E') {
                return res * Math.pow(10, nextInt());
            }
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        }
        if (c == '.') {
            c = read();
            double m = 1;
            while (!isSpaceChar(c)) {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, nextInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                m /= 10;
                res += (c - '0') * m;
                c = read();
            }
        }
        return res * sgn;
    }
 
    public int nextint() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }
 
    public boolean isSpaceChar(int c) {
        if (filter != null) {
            return filter.isSpaceChar(c);
        }
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
 
    public char nextChar() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        return (char) c;
    }
 
    public String next() {
        return readString();
    }
 
    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }
}
 
public class FestivalsBest {
    public static void main(String args[]) {
 
        ReaderT r = new ReaderT(System.in);
        
 
        int t = r.nextInt();
 
        while (t-- > 0) {
            java.util.HashMap<String, ArrayList<Integer>> hMap = 
        new java.util.HashMap<String, ArrayList<Integer>>();
            int festivals = r.nextInt();
            while (festivals-- > 0) {
                String c = r.next();
                int spendMoney = r.nextint();
 
                if (hMap.get(c) == null) {
                    ArrayList<Integer> n = new ArrayList<Integer>();
                    n.add(spendMoney);
                    hMap.put(c, n);
                }
                
               else if(hMap.get(c).size() < 3) {
                   hMap.get(c).add(spendMoney);
               } else {
                   setTopThree(hMap.get(c), spendMoney);
               }
            }
            
        Iterator<Entry<String, ArrayList<Integer>>> it = hMap.entrySet().iterator();
        String lastKey = null;
        long lastValue = 0L;
        while (it.hasNext()) {
         Entry<String, ArrayList<Integer>> e  = it.next();
         long temp = sum(e.getValue());
         //System.out.println("calling .." +  e.getKey() + " value " + temp);
 
         if(lastKey == null) {
          lastValue = temp;
          lastKey = e.getKey();
         }
         else if(lastValue < temp) {
              lastValue = temp;
              lastKey = e.getKey();
         }
         else if(lastValue == temp && lastKey.compareTo(e.getKey()) > 0)  {
             lastKey = e.getKey();
         }
        }
        System.out.println(lastKey + " " + lastValue);
    }
 
    }
 
    static long sum(ArrayList<Integer> al) {
        long sum = 0;
        for (int i = 0; i < al.size(); i++) {
                sum += al.get(i);
               
            }
      return sum; 
    }
 
    static void setTopThree(ArrayList<Integer> al, int a) {
           // System.out.println("calling" + al);
            int index = findMinimum(al);
           //  System.out.println("findMinimum" + index);
            if (al.get(index) < a) {
                al.set(index, a);
            }
    }
 
    static int findMinimum(ArrayList<Integer> al) {
        int index = 0;
        int v = Integer.MAX_VALUE;
        for (int i = 0; i < al.size(); i++) {
            if (v > al.get(i)) {
                v = al.get(i);
                index = i;
            }
        }
      return index;
    }
 
}