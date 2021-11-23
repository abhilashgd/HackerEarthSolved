package Search;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
/**
 *
 * @author dipankar12
 */
import java.io.*;
import java.util.*;
class mosalgo implements Comparable<mosalgo>
{
    int left,right,index;
    
    @Override
    public int compareTo(mosalgo other)
    {
        if(this.left/MagicQueryBest.bsize!=other.left/MagicQueryBest.bsize)
            return this.left/MagicQueryBest.bsize-other.left/MagicQueryBest.bsize;
        return this.right-other.right;
    }
}
public class MagicQueryBest {
    static int bsize=0;
    public static void main(String args[])
    {
        fastio in=new fastio(System.in);
        PrintWriter pw=new PrintWriter(System.out);
 
       int n=in.nextInt();
       int ar[]=new int[n];
       for(int i=0;i<n;i++)
           ar[i]=in.nextInt();
       
       int q=in.nextInt();
       mosalgo query[]=new mosalgo[q];
       for(int i=0;i<q;i++)
       {
           mosalgo ob=new mosalgo();
           ob.left=in.nextInt()-1;
           ob.right=in.nextInt()-1;
           ob.index=i;
           query[i]=ob;
       }
       
       //System.out.println("Hello");
       bsize=400;
       Arrays.sort(query);
       int start=query[0].left,end=start;
       int freq[]=new int[1000001];
       int answers[]=new int[query.length];
       freq[ar[start]]++;
       int count=1;
       //System.out.println("Hello1");
       for(mosalgo queries: query)
       {
           while(start<queries.left)
           {
               freq[ar[start]]--;
               if(freq[ar[start]]==0)
                   count--;
               start++;
           }
           while(start>queries.left)
           {
               start--;
               freq[ar[start]]++;
               if(freq[ar[start]]==1)
                   count++;
           }
           while(end<queries.right)
           {
               end++;
               freq[ar[end]]++;
               if(freq[ar[end]]==1)
                   count++;
           }
           while(end>queries.right)
           {
               freq[ar[end]]--;
               if(freq[ar[end]]==0)
                   count--;
               end--;
           }
           answers[queries.index]=count;
       }
       
       for(int i=0;i<answers.length;i++)
           pw.println(answers[i]);
       pw.close();
    }
 
    static class fastio {
     
            private final InputStream stream;
            private final byte[] buf = new byte[8192];
            private int cchar, snchar;
            private SpaceCharFilter filter;
     
            public fastio(InputStream stream) {
                this.stream = stream;
            }
     
            public int nxt() {
                if (snchar == -1)
                    throw new InputMismatchException();
                if (cchar >= snchar) {
                    cchar = 0;
                    try {
                        snchar = stream.read(buf);
                    } catch (IOException e) {
                        throw new InputMismatchException();
                    }
                    if (snchar <= 0)
                        return -1;
                }
                return buf[cchar++];
            }
     
            public int nextInt() {
                int c = nxt();
                while (isSpaceChar(c)) {
                    c = nxt();
                }
                int sgn = 1;
                if (c == '-') {
                    sgn = -1;
                    c = nxt();
                }
                int res = 0;
                do {
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    res *= 10;
                    res += c - '0';
                    c = nxt();
                } while (!isSpaceChar(c));
                return res * sgn;
            }
     
            public long nextLong() {
                int c = nxt();
                while (isSpaceChar(c)) {
                    c = nxt();
                }
                int sgn = 1;
                if (c == '-') {
                    sgn = -1;
                    c = nxt();
                }
                long res = 0;
                do {
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    res *= 10;
                    res += c - '0';
                    c = nxt();
                } while (!isSpaceChar(c));
                return res * sgn;
            }
     
            public int[] nextIntArray(int n) {
                int a[] = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = nextInt();
                }
                return a;
            }
     
            public String readString() {
                int c = nxt();
                while (isSpaceChar(c)) {
                    c = nxt();
                }
                StringBuilder res = new StringBuilder();
                do {
                    res.appendCodePoint(c);
                    c = nxt();
                } while (!isSpaceChar(c));
                return res.toString();
            }
     
            public String nextLine() {
                int c = nxt();
                while (isSpaceChar(c))
                    c = nxt();
                StringBuilder res = new StringBuilder();
                do {
                    res.appendCodePoint(c);
                    c = nxt();
                } while (!isEndOfLine(c));
                return res.toString();
            }
     
            public boolean isSpaceChar(int c) {
                if (filter != null)
                    return filter.isSpaceChar(c);
                return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
            }
     
            private boolean isEndOfLine(int c) {
                return c == '\n' || c == '\r' || c == -1;
            }
     
            public interface SpaceCharFilter {
                public boolean isSpaceChar(int ch);
            }
        }
    
 
}