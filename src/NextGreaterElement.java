// A Stack based Java program to find next  
// greater element for all array elements  
// in same order as input.  
import java.util.Stack; 
  
class NextGreaterElement  
{ 
  
    private int arr[] = {3,7,1,7,8,4,5,2}; 
  
    /* prints element and NGE pair for all  
    elements of arr[] of size n */
    private void printNGE()  
    { 
        Stack<Integer> s = new Stack<>(); 
        int nge[] = new int[arr.length]; 
      
        // iterate for rest of the elements  
        for (int i = arr.length - 1; i >= 0; i--) { 
              
            if (!s.empty()) { 
                while (!s.empty() && s.peek() <= arr[i]) { 
                    s.pop(); 
                } 
            }
           
            nge[i] = s.empty() ? -1 : s.peek();
            s.push(arr[i]);
        } 
        for(int i = 0; i < arr.length; i++)  
        System.out.print(nge[i] + " "); 
    } 
  
/* Driver program to test above functions */
    public static void main(String[] args) 
    { 
        NextGreaterElement nge = new NextGreaterElement(); 
        nge.printNGE(); 
    } 
} 