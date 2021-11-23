package Trees;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.TreeMap;

public class NQueries {

	 private void solve() {
			
		 int N=nextInt();
		 int elem=0;
		 TreeMap<Integer,Integer> table = new TreeMap<Integer,Integer>();
		 while(N-->0)
		 {
			 int action=nextInt();
			 switch(action){
			 	case 1:
			 			elem = nextInt();
			 			if(table.isEmpty())
			 				table.put(elem, 1);
			 			else if(table.containsKey(elem))
			 				table.put(elem, table.get(elem)+1);
			 			else
			 				table.put(elem, 1);
			 		break;
			 	case 2:
			 			elem = nextInt();
			 			if(table.containsKey(elem))
			 				if(table.get(elem)>1)
			 					table.put(elem,table.get(elem)-1);
			 				else
			 					table.remove(elem);
			 			else
			 				pw.println("-1"+"\n");
			 		break;
			 	case 3:
			 		if(!table.isEmpty())
			 			pw.println(table.lastKey());
			 		else
			 			pw.println("-1");
			 		break;
			 	case 4:
			 		if(!table.isEmpty())
			 			pw.println(table.firstKey());
			 		else
			 			pw.println("-1");
			 		break;
			 }
		 }
	}
	 
	 
	  public static void main(String[] args) throws Exception { new NQueries().run(); }
	  
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

