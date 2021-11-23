package BasicProgramming;

import java.util.*;
import java.lang.*;
class Test1
{
  public static void main(String[] args)
    {
	  AlooParanthe();	  
	}
  public static int AlooParanthe()
    {
	  int t,n,m,i,q,h,flag=0,count=0,j;
	  Scanner var = new Scanner(System.in);
	  n=var.nextInt();
	  Integer A[]=new Integer[n];
	    for(i=0;i<n;i++)
	      {
	    	A[i]=var.nextInt();
	      }
	    m=var.nextInt();
	    Integer B[]=new Integer[m];
	      for(i=0;i<m;i++)
	        {
	    	  B[i]=var.nextInt();
	        }
	      Arrays.sort(A, Collections.reverseOrder());
	      Arrays.sort(B, Collections.reverseOrder());
	      /*for(i=0;i<n;i++)
	        {
	    	  System.out.printf("%d ",A[i]);
	        }
	      System.out.println();
	      for(i=0;i<m;i++)
	        {
	    	  System.out.printf("%d ",B[i]);
	        }
	      System.out.println();*/
	      if(n<=m)
	        {
	    	  flag=1;
	        }
	      if(flag==1)
	        {
	    	  for(i=0;i<n;i++)
	    	    {
	    		  for(j=0;j<m;j++)
	    		    {
	    			  if(Math.abs(A[i]-B[j])<=1)
	    			    {
	    				  count++;
	    				  B[j]=1000;
	    				  break;
	    			    }
	    		    }
	    	    }
	        }
	      else
	        {
	    	  for(i=0;i<m;i++)
	    	    {
	    		  for(j=0;j<n;j++)
	    		    {
	    			  if(Math.abs(B[i]-A[j])<=1)
	    			    {
	    				  count++;
	    				  A[j]=1000;
	    				  break;
	    			    }
	    		    }
	    	    }
	        }
	      System.out.printf("%d",count);
	  return 0;
	}
}