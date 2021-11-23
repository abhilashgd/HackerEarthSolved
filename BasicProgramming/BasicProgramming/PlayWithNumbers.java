package BasicProgramming;

import java.io.*;
import java.util.*;

 class PlayWithNumbers
 {
	 
   public static void main(String[] args)throws IOException 
   {
  
       Scan in = new Scan();
	   Print out = new Print();
        
       int N=in.scanInt();
       int Q=in.scanInt();
       long[] sArr = new long[N];
       int [] arr =new int[N];
       long sum=0;
      for(int i=0;i<N;i++){
    	  arr[i]=in.scanInt();
    	  sum+=arr[i];
    	  sArr[i]=sum;
    	   }
      while(Q-->0){
    	  int L=in.scanInt()-1;
    	  int R=in.scanInt()-1;
    	  long subArraySum = sArr[R]-sArr[L]+arr[L];
    	  out.println(subArraySum/(R-L+1));
      }
     
       out.close();
    }
      
 }
 
 class Scan
 {
     private byte[] buf=new byte[1024];    
     private int index;
     private InputStream in;
     private int total;
     public Scan()
     {
         in=System.in;
     }
     public int scan()throws IOException   
     {
         if(total<0)
         throw new InputMismatchException();
         if(index>=total)
         {
             index=0;
             total=in.read(buf);
             if(total<=0)
             return -1;
         }
         return buf[index++];
     }
     public int scanInt()throws IOException
     {
         int integer=0;
         int n=scan();
         while(isWhiteSpace(n))    
         n=scan();
         int neg=1;
         if(n=='-')               
         {
             neg=-1;
             n=scan();
         }
         while(!isWhiteSpace(n))
         {
             if(n>='0'&&n<='9')
             {
                 integer*=10;
                 integer+=n-'0';
                 n=scan();
             }
             else throw new InputMismatchException();
         }
         return neg*integer;
     }
     private boolean isWhiteSpace(int n)
     {
         if(n==' '||n=='\n'||n=='\r'||n=='\t'||n==-1)
         return true;
         return false;
     }
 }
 
 class Print
 {
     private final BufferedWriter bw;
     public Print()
     {
         this.bw=new BufferedWriter(new OutputStreamWriter(System.out));
     }
     public void print(Object object)throws IOException
     {
         bw.append(""+object);
     }
     public void println(Object object)throws IOException
     {
         print(object);
         bw.append("\n");
     }
     public void close()throws IOException
     {
         bw.close();
     }
 }
     