// A Stack based Java program to find next  
// greater element for all array elements  
// in same order as input.  
import java.util.Stack; 
  
class PrevGreatestElement  
{ 
  
    private static int arr[] = {5,4,3,1,2}; 
   
    private static void printPGE()  
    { 
        Stack<Integer> sp = new Stack<Integer>(); 
        int pge[] = new int[arr.length]; 
        
       
        
        // iterate for rest of the elements  
        for (int i = 0; i <arr.length; i++) { 
              
            
                while (!sp.empty() && sp.peek() <= arr[i]) 
                    sp.pop(); 
             
            pge[i] = sp.empty() ? -1 : i+2; 
            sp.push(arr[i]); 
  
        } 
        for(int i = 0; i <= arr.length; i++)  
        System.out.print(pge[i] + " "); 
    } 
  
/* Driver program to test above functions */
    public static void main(String[] args) 
    { 
        //PrevGreatestElement pge = new PrevGreatestElement(); 
       printPGE(); 
    } 
} 
