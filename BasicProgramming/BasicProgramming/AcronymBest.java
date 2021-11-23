package BasicProgramming;
import java.io.BufferedReader;
import java.util.*;
 
class AcronymBest {
public static void main(String args[] ) throws Exception {
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
ArrayList<String> a = new ArrayList<String>();
for(int j=0;j<n;j++) {
a.add(sc.next());
}
int len=sc.nextInt();
sc.nextLine();
String str=sc.nextLine();
 
String arr[]=str.split(" ");
ArrayList<String>list=new ArrayList<String>();
for(int k=0;k<arr.length;k++){
list.add(arr[k]);
}
list.removeAll(a);
 
String ans="";
for(int x=0;x<list.size();x++) {
String s12= list.get(x);
char c=s12.charAt(0);
 
ans=ans+Character.toUpperCase(c)+".";
 
 
}
System.out.println((ans.substring(0,ans.length()-1)));
}
}
 