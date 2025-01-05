//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.countFreq(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    
    static int lowerbound(int[] arr, int target){
        int lo=0;
        int hi=arr.length-1;
        int lb=arr.length;
        while(lo<=hi){
            int mid=(hi-lo)/2+lo;
            if(arr[mid]>=target){
                lb=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return lb;
    }
    
    static int upperbound(int[] arr, int target){
    int lo=0;
    int hi=arr.length-1;
    int ub=arr.length;
    while(lo<=hi){
        int mid=(hi-lo)/2+lo;
        if(arr[mid]>target){
            ub=mid;
            hi=mid-1;
        }
        else{
            lo=mid+1;
        }
    }
    return ub;
}
    int countFreq(int[] arr, int target) {
        // code here
        return upperbound(arr,target)-lowerbound(arr,target);
    }
}
