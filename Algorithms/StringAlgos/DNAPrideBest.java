package StringAlgos;
import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class DNAPrideBest {
	private static InputStream stream;
	private static byte[] buf = new byte[1024];
	private static int curChar;
	private static int numChars;
	private static SpaceCharFilter filter;
	private static PrintWriter pw;
	private static long mod=1000000009;

    public static void main(String[] args) {
    	InputReader(System.in);
		pw = new PrintWriter(System.out); 
        new Thread(null ,new Runnable(){
           public void run(){
               try{
                   solve();//This is solution method
           pw.close();
       } catch(Exception e){
           e.printStackTrace();
       }
   }
},"1",1<<26).start();
    				   }
    				    static long sort(int a[])
        		    	{  int n=a.length;
        		    		int b[]=new int[n];	
        		    		return mergeSort(a,b,0,n-1);}
        		    	static long mergeSort(int a[],int b[],long left,long right)
        		    	{ long c=0;if(left<right)
        		    	 {   long mid=left+(right-left)/2;
        		    		 c= mergeSort(a,b,left,mid);
        		    		 c+=mergeSort(a,b,mid+1,right);
        		    		 c+=merge(a,b,left,mid+1,right); }	
        		    		return c;	 }
        		    	static long merge(int a[],int  b[],long left,long mid,long right)
        		    	{long c=0;int i=(int)left;int j=(int)mid; int k=(int)left;
        		    	while(i<=(int)mid-1&&j<=(int)right)
        		    	{ if(a[i]>a[j]) {b[k++]=a[i++]; }
        		    	else	{ b[k++]=a[j++];c+=mid-i;}}
        		    	while (i <= (int)mid - 1)   b[k++] = a[i++]; 
        		    	while (j <= (int)right) b[k++] = a[j++];
        		    	for (i=(int)left; i <= (int)right; i++) 
        		    		a[i] = b[i];  return c;  }
        		    		    
    				    
    				    
        		    	public static void solve() {

        		     		char temp[]=new char[200];
        		     		 
        		     		Arrays.fill(temp,'#');
        		     		temp['A']='T';
        		     		temp['T']='A';
        		     		temp['C']='G';
        		     		temp['G']='C';
        		     
        		     		int n=nextInt();
        		     
        		     		while(n-- > 0)
        		     		{
        		     			int t=nextInt();
        		     			char c[]=nextLine().toCharArray();
        		     
        		     			int flag=0;
        		     			char ans[]=new char[t];
        		     			int elem=0;
        		     			for(char ch:c)
        		     			{
        		     				if(temp[ch]=='#')
        		     					flag=1;
        		     
        		     				ans[elem++]=temp[ch];
        		     			}
        		     
        		     			if(flag==1)
        		     				pw.println("Error RNA nucleobases found!");
        		     			else
        		     				pw.println(new String(ans));
        		     		}
        		    	}
        		    		
        		    		
        		    				
        		        
        		    		

public static long trailingZeroes(long n) {
    long count = 0;

    while (n > 0) {
        n /= 5;
        count += n;
    }

    return count;
}

public static int largestPrimeFactor(long number) {
    int i;

    for (i = 2; i <= number; i++) {
        if (number % i == 0) {
            number /= i;
            i--;
        }
    }

    return i;
}

public static long pow(long n, long p) {
	if(p==0)
		return 1;
	if(p==1)
		return n;
	if(p%2==0){
		long temp=pow(n, p/2);
	return (temp*temp);
	}else{
		 	long temp=pow(n,p/2);
		 	temp=(temp*temp);
		 	return(temp*n);
		 	
	}
}
public static String reverseString(String s) {
	StringBuilder sb = new StringBuilder(s);
	sb.reverse();
	return (sb.toString());
}
private static BigInteger ncr(int n,int k){
	if (k < 0 || k > n) return BigInteger.ZERO;
    if (n-k < k) k = n-k;

    BigInteger x = BigInteger.ONE;
    for (int i = 1; i <= k; i++) {
        x = x.multiply(new BigInteger(""+(n-i+1)));
x = x.divide(new BigInteger(""+i));
    }

return x;
}
static long fact[];
private static void factmod(int n,int mod){
fact=new long[n+1];
fact[0]=1;
for(int i=1;i<=n;i++){
	fact[i]=i*fact[i-1];
	//fact[i]%=mod;

}

}
private static long phi(long n){
long ans=n;
if(n%2==0)
	ans-=(ans/2);
while(n%2==0)
{
	n/=2;
	
}
for(int i=3;i*i<=n;i+=2){
	if(n%i==0){
	while(n%i==0){
		n/=i;
	}
	ans-=(ans/i);
	}
}
if(n>2)
	ans-=(ans/n);

return ans;
}
static long d,x,y;
static long modInverse(long A, long M)
{
extendedEuclid(A,M);
return (x%M+M)%M;    //x may be negative
}
static void extendedEuclid(long A, long B) {
if(B == 0) {
d = A;
x = 1;
y = 0;
}
else {
extendedEuclid(B, A%B);
long temp = x;
x = y;
y = temp - (A/B)*y;
}
}
static boolean prime[];
static int spf[];
public static void sieve(int n){
prime=new boolean[n+1];
spf=new int[n+1];

Arrays.fill(spf, 1);
Arrays.fill(prime, true);
prime[1]=false;
spf[2]=2;
for(int i=4;i<=n;i+=2)
{
	spf[i]=2;
	prime[i]=false;
}

for(int i=3;i<=n;i+=2){
if(prime[i]){
	spf[i]=i;
	for(int j=2*i;j<=n;j+=i){
		
		prime[j]=false;
	if(spf[j]==1){
		spf[j]=i;
	}
	}
}
}

}
public static boolean isPrime(long n) {

if (n <= 1)
	return false;
if (n <= 3)
	return true;

if (n % 2 == 0 || n % 3 == 0)
	return false;

for (long i = 5; i * i <= n; i = i + 6)
	if (n % i == 0 || n % (i + 2) == 0)
		return false;

return true;
}

public static long pow(long n, long p,long mod) {
	if(p==0)
		return 1;
	if(p==1)
		return n%mod;
	if(p%2==0){
		long temp=pow(n, p/2,mod);
	return (temp*temp)%mod;
	}else{
		 	long temp=pow(n,p/2,mod);
		 	temp=(temp*temp)%mod;
		 	return(temp*n)%mod;
		 	
	}
}
public static long gcd(long x, long y) {
	if (x == 0)
		return y;
	else
		return gcd( y % x,x);
}


public static void InputReader(InputStream stream1) {
	stream = stream1;
}

private static boolean isWhitespace(int c) {
	return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
}

private static boolean isEndOfLine(int c) {
	return c == '\n' || c == '\r' || c == -1;
}

private static int read() {
	if (numChars == -1)
		throw new InputMismatchException();
	if (curChar >= numChars) {
		curChar = 0;
		try {
			numChars = stream.read(buf);
		} catch (IOException e) {
			throw new InputMismatchException();
		}
		if (numChars <= 0)
			return -1;
	}
	return buf[curChar++];
}

private static int nextInt() {
	int c = read();
	while (isSpaceChar(c))
		c = read();
	int sgn = 1;
	if (c == '-') {
sgn = -1;
c = read();
}
int res = 0;
do {
if (c < '0' || c > '9')
throw new InputMismatchException();
res *= 10;
res += c - '0';
		c = read();
	} while (!isSpaceChar(c));
	return res * sgn;
}

private static long nextLong() {
	int c = read();
	while (isSpaceChar(c))
		c = read();
	int sgn = 1;
	if (c == '-') {
sgn = -1;
c = read();
}
long res = 0;
do {
if (c < '0' || c > '9')
throw new InputMismatchException();
res *= 10;
res += c - '0';
		c = read();
	} while (!isSpaceChar(c));
	return res * sgn;
}

private static String nextToken() {
	int c = read();
	while (isSpaceChar(c))
		c = read();
	StringBuilder res = new StringBuilder();
	do {
		res.appendCodePoint(c);
		c = read();
	} while (!isSpaceChar(c));
	return res.toString();
}

private static String nextLine() {
	int c = read();
	while (isSpaceChar(c))
		c = read();
	StringBuilder res = new StringBuilder();
	do {
		res.appendCodePoint(c);
		c = read();
	} while (!isEndOfLine(c));
	return res.toString();
}

private static int[] nextIntArray(int n) {
	int[] arr = new int[n];
	for (int i = 0; i < n; i++) {
		arr[i] = nextInt();
	}
	return arr;
}

private static int[][] next2dArray(int n, int m) {
	int[][] arr = new int[n][m];
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			arr[i][j] = nextInt();
		}
	}
	return arr;
}
private static char[][] nextCharArray(int n,int m){
	char [][]c=new char[n][m];
	for(int i=0;i<n;i++){
		String s=nextLine();
		for(int j=0;j<s.length();j++){
			c[i][j]=s.charAt(j);
		}
	}
	return c;
}

private static long[] nextLongArray(int n) {
	long[] arr = new long[n];
	for (int i = 0; i < n; i++) {
		arr[i] = nextLong();
	}
	return arr;
}

private static void pArray(int[] arr) {
	for (int i = 0; i < arr.length; i++) {
		pw.print(arr[i] + " ");
	}
	pw.println();
	return;
}

private static void pArray(long[] arr) {
	for (int i = 0; i < arr.length; i++) {
		pw.print(arr[i] + " ");
	}
	pw.println();
	return;
}

private static void pArray(boolean[] arr) {
	for (int i = 0; i < arr.length; i++) {
		pw.print(arr[i] + " ");
	}
	pw.println();
	return;
}

private static boolean isSpaceChar(int c) {
	if (filter != null)
		return filter.isSpaceChar(c);
	return isWhitespace(c);
}

private interface SpaceCharFilter {
	public boolean isSpaceChar(int ch);
}


}	

/*class Pair implements Comparable<Pair>{


int  from,to,a,b;
Pair(int from,int to,int a,int b){

	this.from=from;
	this.to=to;
	this.a=a;
	this.b=b;
}
@Override
public int compareTo(Pair o) {

	return 0;
	//return (int)(o.size-size);
}
public int hashCode() {
		//int hu = (int) (x ^ (x >>> 32));
		//int hv = (int) (y ^ (y >>> 32));
		//int hw = (int) (mass ^ (mass >>> 32));
		//return 31 * hu + hv ;
	return 0;
	}
	public boolean equals(Object o) {
		Pair other = (Pair) o;
	//	return x == other.x && y == other.y;
	return false;
	}
}*/
