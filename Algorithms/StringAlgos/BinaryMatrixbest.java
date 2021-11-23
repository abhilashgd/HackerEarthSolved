package StringAlgos;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
 
class BinaryMatrixbest{
    public static void main(String args[] ) throws Exception
    {
		CustomReader input=new CustomReader(System.in);
		int n=input.nextInt();
		int m=input.nextInt();
		char[][] binaryNumber=new char[n][m];
		int maxNumberIndex=0;
		for(int i=0;i<n;i++)
		{
			int j=0;
			boolean thereIsAChance=true;
			while(j<m)
			{
				binaryNumber[i][j]=input.nextChar();
				if(binaryNumber[i][j]==binaryNumber[maxNumberIndex][j])
				{
					j++;
				}
				else if(thereIsAChance&&binaryNumber[i][j]=='1')
				{
					maxNumberIndex=i;
 
					j++;
				}
				else
				{
					j++;
					thereIsAChance=false;
				}
			}
		}
		
		System.out.println(maxNumberIndex+1);
	}
    static class CustomReader
	{
		public static final char NEW_LINE='\n';
		public static final char TAB='\t';
		public static final char RETURN='\r';
		public static final char SPACE=' ';
		
		private byte[] buf = new byte[1024]; // Buffer of Bytes
		private int index;
		private InputStream in;
		private int total;
 
		public CustomReader(InputStream in)
		{
			this.in = in;
			total=0;
		}
		public char nextChar() throws IOException
		{
			int n= scan();
			while (isWhiteSpace(n))// Removing starting whitespaces
			{
				n=scan();
			}
			return (char) n;
		}
		public int nextShort() throws IOException
		{
			short shortNumber = 0;
			int n = scan();
			while (isWhiteSpace(n)) // Removing starting whitespaces
				n = scan();
			int neg = 1;
			if (n == '-') // If Negative Sign encounters
			{
				neg = -1;
				n = scan();
			}
			while (!isWhiteSpace(n))
			{
				if (n >= '0' && n <= '9')
				{
					shortNumber *= 10;
					shortNumber += n - '0';
					n = scan();
				}
				else
				{
					throw new InputMismatchException("Un-recognized character while reading integer");
				}
			}
			return neg * shortNumber;
		}
		public int nextInt() throws IOException
		{
			int integer = 0;
			int n = scan();
			while (isWhiteSpace(n)) // Removing starting whitespaces
				n = scan();
			int neg = 1;
			if (n == '-') // If Negative Sign encounters
			{
				neg = -1;
				n = scan();
			}
			while (!isWhiteSpace(n))
			{
				if (n >= '0' && n <= '9')
				{
					integer *= 10;
					integer += n - '0';
					n = scan();
				}
				else
				{
					throw new InputMismatchException("Un-recognized character while reading integer");
				}
			}
			return neg * integer;
		}
		public long nextLong() throws IOException
		{
			long longVal = 0L;
			int n = scan();
			while (isWhiteSpace(n)) // Removing starting whitespaces
			{
				n = scan();
			}
			int neg = 1;
			if (n == '-') // If Negative Sign encounters
			{
				neg = -1;
				n = scan();
			}
			while (!isWhiteSpace(n))
			{
				if (n >= '0' && n <= '9')
				{
					longVal *= 10;
					longVal += n - '0';
					n = scan();
				}
				else
				{
					throw new InputMismatchException("Un-recognized character while reading long");
				}
			}
			return neg * longVal;
		}
		public String nextLine() throws IOException
		{
			return readString('\n');
		}
		public String readString(char endChar) throws IOException
		{
			StringBuilder stringVal=new StringBuilder();
			int n = scan();
			while (n!=endChar)
			{
				stringVal.append((char)n);
				n=scan();
			}
			return stringVal.toString();
		}
		public int scan() throws IOException // Scan method used to scan buf
		{
			if (total < 0)
			{
				throw new InputMismatchException();
			}
			if (index >= total)
			{
				index = 0;
				total = in.read(buf);
				if (total <= 0)
				{
					return -1;
				}
			}
			return buf[index++];
		}
 
		private boolean isWhiteSpace(int n)
		{
			return n == SPACE || n == NEW_LINE || n == RETURN || n == TAB || n == -1;
		}
	}
}
