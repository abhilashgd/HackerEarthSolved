package Sorting;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;

public class MsBs {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static PrintWriter pw = new PrintWriter(System.out);
    public static void main(String[] args) throws Exception {
    	PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int N = Integer.parseInt(br.readLine());
        int T=N*2; int sum=0;
        String[] arr = br.readLine().split(" ");int i=0;
        while(T-->0) pq.add(Integer.parseInt(arr[i++]));
        while(N-->0){int x=pq.poll();int y=pq.poll();
        if(x<=y)sum+=x; else sum+=y;}pw.println(sum);pw.flush();}
}