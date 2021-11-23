package StringOperation;
import java.util.* ;
import java.io.BufferedReader ;
import java.io.InputStreamReader ;
 
public class CyclicPermutations
{
	private static final boolean debug = false ;
    public static void main(String args[]) throws Exception
    {
        BufferedReader bro  = new BufferedReader(new InputStreamReader(System.in)) ;
        int T = Integer.parseInt(bro.readLine()) ;
        for(int t=0;t<T;t++)
        {
            String P = bro.readLine() ;
            String T1 = bro.readLine() ;
            T1+=T1 ;
			T1 = T1.substring(0,T1.length()-1) ;
            int ans = kmpSearch(P.toCharArray(),T1.toCharArray(),kmpPreprocess(P.toCharArray())) ;
            System.out.println(ans) ;
        }
    }
	static void prt(String S)
	{
		System.out.println(S) ;
	}
    static int[] kmpPreprocess(char[] P)
    {
        int i=0,j=-1;
        int[] b = new int[P.length+1] ;
        b[0] = -1 ;
        int m = P.length ;
        while(i<m)
        {
			if(debug) prt("preprocess") ;
            while(j>=0 && P[i]!=P[j]) j = b[j] ;
            i++;j++;
            b[i] = j ;
        }
        return b ;
    }
    static int kmpSearch(char[] P,char[] T,int[] b)
    {
		if(debug) prt(Arrays.toString(b)) ;
        int i=0,j=0;
        int n = T.length ;
        int m = P.length ;
        int count = 0 ;
        
        while(i<n)
        {
			if(debug) prt("search") ;
            while(j>=0 && P[j]!=T[i]){
				j = b[j] ;
				// prt("		search:Inner loop") ;
			}
            i++;j++;
            if(j==m)
            {
                count++ ;
                j = b[j] ;
            }
        }
        return count ;
    }
}