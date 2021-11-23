package BasicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
class CarNamesBest {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input, distinct;
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            input = br.readLine();
            distinct = getDistinct(input);
            if(distinct.length() != 3){
                System.out.println("Not OK");
                continue;
            }
            else{
                for(int j = 0; j < distinct.length(); j++){
                    if(getFrequency(input, distinct.charAt(j)) != input.length()/3){
                        System.out.println("Not OK");
                        break;
                    }
                }
                System.out.println("OK");
            }
        }
    }
    
    static String getDistinct(String input){
        String output = "";
        char prev = input.charAt(0), next;
        output += prev;
        for(int i = 1; i < input.length(); i++){
            next = input.charAt(i);
            if(prev != next){
                if(output.indexOf(next) != -1){
                    output = "invalid";
                    return output;
                }
                else{
                    output += next;
                }
            }
            prev = next;
        }
        return output;
    }
    
    static int getFrequency(String input, char c){
        int count = 0;
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == c){
                count++;
            }
        }
        return count;
    }
}