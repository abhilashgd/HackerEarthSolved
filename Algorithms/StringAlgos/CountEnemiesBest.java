package StringAlgos;
import java.io.*;
import java.util.*;
 
public class CountEnemiesBest {
    static FastScanner in;
    static int t;
 
    public static void main(String[] args) throws IOException {
        //        in = new FastScanner("input.txt");
        in = new FastScanner(System.in);
        t = in.nextInt();
        while (t-- > 0) {
            char s[] = in.next().toCharArray();
            if (s.length == 1) {
                if (s[0] == 'O')
                    System.out.println(1);
                else
                    System.out.println(0);
            } else {
                int ans = 0;
                int cur = 0;
                boolean flag = false;
                for (char c : s) {
                    if (c == 'O')
                        cur++;
                    else if (c == 'X')
                        flag = true;
                    else {
                        if (!flag)
                            ans += cur;
                        flag = false;
                        cur = 0;
                    }
                }
                if (!flag)
                    ans += cur;
                System.out.println(ans);
            }
        }
    }
}
 
class FastScanner {
 
    BufferedReader br;
    StringTokenizer tokenizer;
 
    FastScanner(String fileName) throws FileNotFoundException {
        this(new FileInputStream(new File(fileName)));
    }
 
    FastScanner(InputStream is) {
        br = new BufferedReader(new InputStreamReader(is));
    }
 
    String nextLine() throws IOException {
        tokenizer = null;
        return br.readLine();
    }
 
    String next() throws IOException {
        if (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) {
                return null;
            }
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }
 
    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
 
    long nextLong() throws IOException {
        return Long.parseLong(next());
    }
 
    char nextChar() throws IOException {
        return next().charAt(0);
    }
}