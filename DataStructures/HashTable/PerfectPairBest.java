package HashTable;

import java.util.*;
import java.io.*;
public class PerfectPairBest {
    static int a[] = new int[10003];
    static void init(){
        for(int i=1;i<=2000;i++){
            if(i*i>2000) continue;
            a[i*i]=1;
            if(i*i*i>2000) continue;
            a[i*i*i]=1;
        }
    }
    static boolean isp(int aa){
        return a[aa]==1;
    }
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.valueOf(br.readLine());
        init();
        while(t-->0){
            int n  = Integer.valueOf(br.readLine());
            int arr[] = new int[1003];
            String str[] = br.readLine().split(" ");
            for(int i=0;i<n;i++) arr[Integer.valueOf(str[i])]++;
            int ans = 0;
            for(int i=1;i<=1000;i++){
                for(int j=i; j<=1000;j++){
                    if(arr[i]>0 && arr[j]>0 && isp(i+j)){
                        if(i==j)ans+=((arr[i]*(arr[i]-1))>>1); else
                        ans+=(arr[i]*arr[j]);
                    }
                }
            }
            bw.write(ans+"\n");
        }
        bw.flush();
    }
}