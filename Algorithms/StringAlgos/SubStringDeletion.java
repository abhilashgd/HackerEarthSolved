package StringAlgos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class SubStringDeletion {
	@SuppressWarnings({ "unchecked"})
	public static void main(String args[] ) throws Exception {
		 try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String s;
				while((s = br.readLine())!=null) {
				ArrayList<Integer>[] a = new ArrayList[26];
				for(int i=0;i<26;i++)a[i]= new ArrayList<Integer>();
				for(int i=0;i<s.length();i++) a[s.charAt(i)-'a'].add(i);
				for(int i=25;i>=0;i--){Collections.reverse(a[i]);}
				String f="";
				for(int i=0;i<26;i++){
					int x=Integer.MAX_VALUE;
					for(int j=0;j<26;j++){
						if(a[j].isEmpty())continue;
						boolean flag=true;
						for(int k=0;k<26;k++){if(a[k].size()>0){if(a[k].get(0)<a[j].get(a[j].size()-1)){flag=false;break;}}}
						if(flag){x=j;break;}
						}
					if(x==Integer.MAX_VALUE)break;
					int index=a[x].get(a[x].size()-1);
					f=f+(char)(x+'a');
					a[x].clear();
					for(int k=0;k<26;k++){while(a[k].size()>0 && a[k].get(a[k].size()-1)<index)a[k].remove(a[k].size()-1);}
				}
				System.out.println(f);}
				
			}
		 catch (IOException io) {io.printStackTrace();}
	}
}
