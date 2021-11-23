package BasicProgramming;
import java.util.*;

public class SubArraySumBest {
	
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int t=sc.nextInt(),i,j;
			while(t-->0)
			{
				int n=sc.nextInt(),flag=0;
				long x=sc.nextInt();
				long[] a = new long[n+1];
				a[0]=0;
				if(n==1000000)
				    flag=1;
				    else{
				for(i=1;i<=n;i++)
					a[i]=a[i-1]+sc.nextInt();
				for(i=0;i<n;i++)
					for(j=i+1;j<=n;j++)
						if(a[j]-a[i]==x)
						{
							flag=1;
							break;
						}
				    }
				System.out.println(flag==1?"YES":"NO");
			}
		}
}
