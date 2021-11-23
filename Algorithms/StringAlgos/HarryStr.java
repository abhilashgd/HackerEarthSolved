package StringAlgos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

class HarryStr {
    public static void main(String args[] ) throws Exception {
    	final String good="Good\n";
    	final String worst="Worst\n";
    	final String bad="Bad\n";
    	StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int T = Integer.parseInt(line);
         while(T-->0) {
	   		String input = br.readLine();
	   		int len = input.length();
	   		int[] arr = new int[126];
	   		for(int i=0;i<len;i++)
	   			arr[(int)input.charAt(i)]=i;
	
	   		TreeMap<Integer,Integer> tree = new TreeMap<Integer,Integer>();	
	   		
	   		if(arr[97]>0)
	   			tree.put(arr[97],97);
	   		if(arr[101]>0)
	   			tree.put(arr[101],101);
	   		if(arr[105]>0)
	   			tree.put(arr[105],105);
	   		if(arr[111]>0)
	   			tree.put(arr[111],111);
	   		if(arr[117]>0)
	   			tree.put(arr[117],117);
	   		if(tree.size()==0){
	   			sb.append(good);
	   		}
	   		else{
	   		Set<Integer> keySet = tree.keySet();
	   		Iterator<Integer> itr = keySet.iterator();
	   		int first = tree.firstKey();
	   		boolean flag=true;
	   		boolean badFlag=false;
	   		while(itr.hasNext()){
	   			int second = itr.next();
	   			if(tree.get(first)==tree.get(second))
	   				continue;
	   			else if(tree.get(first)<tree.get(second))
	   			{first=second;if(flag==false){badFlag=true;break;}}
	   			else{flag = false;first=second;}
	   		}
	   		if(flag)
	   			sb.append(good);
	   		else if(!flag && !badFlag)
	   				sb.append(worst);
	   		else
	   				sb.append(bad);
	   			}
         }
        System.out.println(sb.toString());
    }
}