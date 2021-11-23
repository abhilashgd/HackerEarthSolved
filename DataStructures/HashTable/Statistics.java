package HashTable;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Statistics {
	
	
	 private void solve() {
		 int T=nextInt();
		 sBuilder str = new sBuilder();
		 String[] arr = new String[2];
		 Table table = new Table();
		 while(T-->0)
		 {
		 arr = nextLine().split(" ");
		 table.add(arr[0], arr[1]);
		 }
		 str.setOutput(table.getFavSport());
		 str.setOutput(table.getFootballCount());
		 table.clear();
		 str.getOutput();
	}
	
class Table{
	private Hashtable<String,String> hT = new Hashtable<String,String>();
	private Hashtable<String,Integer> counter = new Hashtable<String,Integer>();
	int maxCount=1;
	String maxCountSport;
	final String FOOTBALL="football";
	public void add(String key,String val) {
		if(hT.isEmpty() ||!hT.containsKey(key))
			hT.put(key, val);
	}
		
	public int getFootballCount() {
			
		if(counter.containsKey(FOOTBALL))
				return counter.get(FOOTBALL);
		else
			return 0;
		
	}

	public String getFavSport() {
		Set<String> hTKeys = hT.keySet();
		Iterator<String> itr = hTKeys.iterator();
		String person;
		while(itr.hasNext()){
			person = itr.next();
			this.addCounter(hT.get(person));
		}
		
		List<Points> ll = new LinkedList<Points>();
		
		Set<String> counterKeys = counter.keySet();
		Iterator<String> cItr = counterKeys.iterator();
		String sport;
		while(cItr.hasNext()){
			sport = cItr.next();
			ll.add(new Points(sport,counter.get(sport)));
		}
		
		Collections.sort(ll,new Comparator<Points>(){

			@Override
			public int compare(Points o1, Points o2) {
				int result=0;
				result= Integer.compare(o2.count, o1.count);
					if(result==0)
						return o1.sport.compareTo(o2.sport);
				return result;
			}
			
		});
		this.maxCountSport=ll.get(0).sport;
	return this.maxCountSport;
		
	}
	public void addCounter(String sport){
			if(counter.isEmpty() || !counter.containsKey(sport))
				counter.put(sport, 1);
			else 
				{int val =counter.get(sport)+1;
				counter.put(sport, val);
						if(val>maxCount)
							{this.maxCount=val;this.maxCountSport=sport;}
				}
	}

class Points{
	String sport;
	int	count;
	
	public Points(String sport, int count) {
		this.sport=sport;
		this.count = count;
	}
}
	public void clear() { hT.clear();counter.clear();}
 
}

class sBuilder{
	private StringBuilder sb =new StringBuilder();
	
	void setOutput(String val){
		sb.append(val+"\n");
	}
	void setOutput(int val){
		sb.append(val+"\n");
	}
	void getOutput(){
		pw.println(sb.toString());
	}
	
	
}

	  public static void main(String[] args) throws Exception { new Statistics().run(); }
	  
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
    private boolean isSpaceString(int c){return !(c >= 32 && c <= 126); }
    private int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }
 
    private String nextLine() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while(!(isSpaceString(b))){ // when nextLine)
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
 
    private long nextLong() {
        long num = 0;
        int b;
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

