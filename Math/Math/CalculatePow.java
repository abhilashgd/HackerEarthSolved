package Math;
import java.util.*;
class CalculatePow {
    public static final int MOD = 1000000007;
    
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
        int base = sc.nextInt();
        long pow = sc.nextLong();
        System.out.println(pow(base,pow));
    }
}