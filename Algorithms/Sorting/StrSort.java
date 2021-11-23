package Sorting;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
  
public class StrSort {
	
	public void solve(){
		LinkedList<String> pq = new LinkedList<String>();
				
				
		int N=nextInt();
		
		String str;
		while(N-->0){
			int count=0;
			str=nextString();
				pq.add(str);
			Collections.sort(pq);
					/*new Comparator<String>(){

				@Override
				public int compare(String o1, String o2) {
							return strCompareTo(o1,o2);
				}
				
			});*/
			
			if(pq.size()==1)
				count=0;
			else{
				int flag=0;
				Iterator<String> itr=pq.iterator();
				while(itr.hasNext()){
					if(itr.next()!=str)
							count++;
					else
						break;
					flag++;
				}
				//pw.print(itr.next()+" ");	
			}
			pw.println(count);
		}
	}
	int strCompareTo(String o1,String o2)
	{
		int result=0;
		int len1 = o1.length();
        int len2 = o2.length();
        char v1[] = o1.toCharArray();
        char v2[] = o2.toCharArray();
        if(len2>len1)
    		return -1;
    	else if(len2<len1)
    		return 1;
    	else
        	for(int i=0;i<Math.min(len2, len1);i++)
        		if(v1[i]<v2[i])
        			return -1;
        		else
        			{result =1;break;}
        	
        
        return result;
	}
	public static void main(String[] args) throws Exception { new StrSort().run();}
	InputStream is;
    PrintWriter pw;
    String INPUT = "";
    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        pw = new PrintWriter(System.out);
        long s = System.currentTimeMillis();
        solve();
        pw.flush();
        if(!INPUT.isEmpty())tr(System.currentTimeMillis()-s+"ms");
    }
   
	private byte[] inbuf = new byte[1024];
    public int lenbuf = 0, ptrbuf = 0;
 
    private int readByte() {
        if(lenbuf == -1)throw new InputMismatchException();
        if(ptrbuf >= lenbuf){
            ptrbuf = 0;
            try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
            if(lenbuf <= 0)return -1;
        }
        return inbuf[ptrbuf++];
    }
    private boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
    private int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }
  
    private String nextString() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while(!(isSpaceChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }
     private int nextInt() {
        int num = 0, b;
        boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if(b == '-'){
            minus = true;
            b = readByte();
        }
 
        while(true){
            if(b >= '0' && b <= '9'){
                num = num * 10 + (b - '0');
            }else{
                return minus ? -num : num;
            }
            b = readByte();
        }
    }
     private void tr(Object... o) { if(INPUT.length() > 0)System.out.println(Arrays.deepToString(o)); }
}
