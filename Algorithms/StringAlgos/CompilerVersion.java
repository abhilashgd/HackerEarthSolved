package StringAlgos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
class CompilerVersion {
public static void main(String args[] ) throws Exception {
try {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

ArrayList a = new ArrayList();
String s;
	for(int i=0;(s = br.readLine())!=null;i++) {
		a.add(s);
		}
		Iterator i = a.iterator();
		while (i.hasNext()) {
			String f = (String) i.next();
			if (f.contains("->")) {
				if (f.contains("//")) {

					int z=f.indexOf("//");
					String sub1=f.substring(0, z);
					String sub2=f.substring(z);


					System.out.println(sub1.replaceAll("->", ".")+sub2);
//System.out.println("true");


				}
				else
				{
					System.out.println(f.replaceAll("->", "."));

				}
			}
			else
			{

				System.out.println(f);
			}
		}
	} catch (IOException io)
	{
		io.printStackTrace();
	}
	}
}
