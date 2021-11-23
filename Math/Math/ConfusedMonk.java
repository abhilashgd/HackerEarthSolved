package Math;
import java.util.*;
class ConfusedMonk {
    public static final int MOD = 1000000007;
    
    public static long egcd(long a, long b)
    {
        if(a==0)
            return b;
        else
            return egcd(b%a,a);
    }
    
    public static long pow(long base , long power)
    {
        long res= 1;
        while(power>0)
        {
            if(power%2==1)
                res = (res *base)%MOD;
            base *= base;
            base %= MOD;
            power /= 2; 
        }
        return res;    
        
    }
    public static void main(String args[] ) throws Exception 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long []arr = new long[t];
        long mul = 1l,gcd = 1l;
        for(int i =0 ; i < t ; i++)
        {
            arr[i]=sc.nextLong();
            mul = (mul * arr[i])%MOD;
            if(i==0)
                gcd = arr[i];
            else
                gcd = egcd(gcd,arr[i]);
        } 
        //System.out.println(gcd+"\n"+mul);
        System.out.println(pow(mul,gcd));
    }
}