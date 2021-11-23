package StringAlgos;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.InputMismatchException;
public class GaryAndSubString {
	static final int CHAR_SIZE=26;
	void solve() {
		String yes="Yes\n";
		String no="No\n";
		Hashtable<Integer,Point> ht = new Hashtable<Integer,Point>();
		StringBuilder sb = new StringBuilder();
		int N=nextInt();
		int Q=nextInt();
		for(int i=1;i<=N;i++) ht.put(i, new Point(nextString()));
		while(Q-->0){
			int x=nextInt();
			int y =nextInt();
			boolean flag=true;
			if(ht.get(x).getLen()>ht.get(y).getLen())
					flag=isSubSequence(ht.get(y).getArr(),ht.get(x).getArr());
			else	flag=isSubSequence(ht.get(x).getArr(),ht.get(y).getArr());
				
			if(flag) sb.append(yes);
			else sb.append(no);
		}
				pw.println(sb.toString());
	}
	
boolean isSubSequence(ArrayList<Integer>[] a,ArrayList<Integer>[] b){
	boolean flag=true;
	
	for(int i=0;i<CHAR_SIZE;i++){
		if(a[i].size()!=0 && b[i].size()>=a[i].size())
		{
				for(int j=0,k=0;j<a[i].size();j++)
				{
					if(a[i].get(j)<=b[i].get(k))
				        	k++;
					else
						{
						    k++;
						while(true){
						    if(k<b[i].size() && a[i].get(j)>b[i].get(k)) ++k;
						    else
						  	{flag=false;break;}
						   
						}
						if(!flag)
						break;
						
					
						}
					
				}
				if(!flag)break;
		}
		else if(b[i].size()<a[i].size())
			{flag=false;break;}
		
	}
	return flag;	
}
 
class Point{
	private int len;
	private ArrayList<Integer>[] a = new ArrayList[CHAR_SIZE];
	int getLen(){return this.len;}
	ArrayList<Integer>[] getArr(){return this.a;}

	public Point(String s) {
		this.len=s.length();
		for(int i=0;i<CHAR_SIZE;i++)this.a[i]= new ArrayList<Integer>();
		for(int i=0;i<len;i++) this.a[s.charAt(i)-'a'].add(i);
	}	
}

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
 
    public static void main(String[] args) throws Exception { new GaryAndSubString().run(); }
 
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