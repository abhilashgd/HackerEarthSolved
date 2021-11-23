/*
 * used for linkedlist
 * Divide and Conquer
 * 
 * worst case Time Complexity is O(nlogn)
 * Best Case Time Complexity is O(nlogn)
 * 
 */

package Sort;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class MergeSort {
	
	 private void solve() {
			
		pw.println("Enter Number of Array Elements");	
		 int N = nextInt();
		pw.println("Enter array Elements: ");
		int[] A = new int[N];
		for(int i=0;i<N;i++){
			A[i]=nextInt();
		}
		mergeSort(A,0,N-1);
		pw.println("Sorted Array IS:");
		for(int i=0;i<N;i++){
			pw.print(A[i]+" ");;
		}
			
		}
	 
	 // Main function that sorts arr[l..r] using 
	    // merge() 
	    static void mergeSort(int arr[], int l, int r) 
	    { 
	        if (l < r) 
	        { 
	            // Find the middle point 
	            int m = (l+r)/2; 
	  
	            // Sort first and second halves 
	            mergeSort(arr, l, m); 
	            mergeSort(arr , m+1, r); 
	  
	            // Merge the sorted halves 
	            mergeSortAux(arr, l, m, r); 
	        } 
	    }
	 
	  // Merges two subarrays of arr[]. 
	    // First subarray is arr[l..m] 
	    // Second subarray is arr[m+1..r] 
	    static void mergeSortAux(int arr[], int l, int m, int r) 
	    { 
	        // Find sizes of two sub arrays to be merged 
	        int n1 = m - l + 1; 
	        int n2 = r - m; 
	  
	        /* Create temp arrays */
	        int L[] = new int [n1]; 
	        int R[] = new int [n2]; 
	  
	        /*Copy data to temp arrays*/
	        for (int i=0; i<n1; ++i) 
	            L[i] = arr[l + i]; 
	        for (int j=0; j<n2; ++j) 
	            R[j] = arr[m + 1+ j]; 
	  
	  
	        /* Merge the temp arrays */
	  
	        // Initial indexes of first and second subarrays 
	        int i = 0, j = 0; 
	  
	        // Initial index of merged subarry array 
	        int k = l; 
	        while (i < n1 && j < n2) 
	        { 
	            if (L[i] <= R[j]) 
	            { 
	                arr[k] = L[i]; 
	                i++; 
	            } 
	            else
	            { 
	                arr[k] = R[j]; 
	                j++; 
	            } 
	            k++; 
	        } 
	  
	        /* Copy remaining elements of L[] if any */
	        while (i < n1) 
	        { 
	            arr[k] = L[i]; 
	            i++; 
	            k++; 
	        } 
	  
	        /* Copy remaining elements of R[] if any */
	        while (j < n2) 
	        { 
	            arr[k] = R[j]; 
	            j++; 
	            k++; 
	        } 
	    } 
	    
	  public static void main(String[] args) throws Exception { new MergeSort().run(); }
	  
	InputStream is;
    PrintWriter pw;
    String INPUT = "";
    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        pw = new PrintWriter(System.out);
        long s = System.currentTimeMillis();
        solve();
        pw.flush();
        if(!INPUT.isEmpty())tr(System.currentTimeMillis()-s+"ms");
    }
   
	private byte[] inbuf = new byte[1024];
    public int lenbuf = 0, ptrbuf = 0;
 
    private int readByte() {
        if(lenbuf == -1)throw new InputMismatchException();
        if(ptrbuf >= lenbuf){
            ptrbuf = 0;
            try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
            if(lenbuf <= 0)return -1;
        }
        return inbuf[ptrbuf++];
    }
 
    private boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
    private int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }
 
   
    private String nextString() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while(!(isSpaceChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }
 	
      private int nextInt() {
        int num = 0, b;
        boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if(b == '-'){
            minus = true;
            b = readByte();
        }
 
        while(true){
            if(b >= '0' && b <= '9'){
                num = num * 10 + (b - '0');
            }else{
                return minus ? -num : num;
            }
            b = readByte();
        }
    }
 
   
  
    private void tr(Object... o) { if(INPUT.length() > 0)System.out.println(Arrays.deepToString(o)); }
}


