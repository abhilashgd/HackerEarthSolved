/*
 * Divide and Conquer algorithm
 * 
 * Can be implemented as a stable sort 
 * depending on how the pivot is handled
 * 
 * In Place Algorithm. 
 * 
 * Space Complexity O(1)
 * 
 * worst case Time Complexity is O(n2)
 * Best Case Time Complexity is O(nlogn)
 * Average Case Complexity O(nlogn)
 * worst case Space Complexity O(1)
 * 
 */

package Sort;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class QuickSort {
	
	 private void solve() {
			
		pw.println("Enter Number of Array Elements");	
		 int N = nextInt();
		pw.println("Enter array Elements: ");
		int[] A = new int[N];
		for(int i=0;i<N;i++){
			A[i]=nextInt();
		}
		quickSort(A,0,N-1);
		pw.println("Sorted Array IS:");
		for(int i=0;i<N;i++){
			pw.print(A[i]+" ");;
		}
			
		}
	 
	 /* This function takes last element as pivot, 
     places the pivot element at its correct 
     position in sorted array, and places all 
     smaller (smaller than pivot) to left of 
     pivot and all greater elements to right 
     of pivot */
  int partition(int arr[], int low, int high) 
  { 
      int pivot = arr[high];  
      int i = (low-1); // index of smaller element 
      for (int j=low; j<high; j++) 
      { 
          // If current element is smaller than or 
          // equal to pivot 
          if (arr[j] <= pivot) 
          { 
              i++; 

              // swap arr[i] and arr[j] 
              int temp = arr[i]; 
              arr[i] = arr[j]; 
              arr[j] = temp; 
          } 
      } 

      // swap arr[i+1] and arr[high] (or pivot) 
      int temp = arr[i+1]; 
      arr[i+1] = arr[high]; 
      arr[high] = temp; 

      return i+1; 
  } 


  /* The main function that implements QuickSort() 
    arr[] --> Array to be sorted, 
    low  --> Starting index, 
    high  --> Ending index */
  void quickSort(int arr[], int low, int high) 
  { 
      if (low < high) 
      { 
          /* pi is partitioning index, arr[pi] is  
            now at right place */
          int pi = partition(arr, low, high); 

          // Recursively sort elements before 
          // partition and after partition 
          quickSort(arr, low, pi-1); 
          quickSort(arr, pi+1, high); 
      } 
  } 
	  public static void main(String[] args) throws Exception { new QuickSort().run(); }
	  
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


