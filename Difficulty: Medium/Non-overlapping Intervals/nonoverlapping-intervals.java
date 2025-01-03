//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[][] = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.minRemoval(a);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int minRemoval(int intervals[][]) {
        // code here
        int n=intervals.length;
        int ans=0;
        Arrays.sort(intervals, (o1,o2)->(Integer.compare(o1[0],o2[0])));
        int end=intervals[0][1];
        int idx=1;
        while(idx<n){
            // int[] curr=intervals[i];
            if(intervals[idx][0] < end){
                ans++;
                end= Math.min(end, intervals[idx][1]);
                idx++;
            }
            else{
               end= intervals[idx][1];
                idx++;
            }
        }
        return ans;
    }
}
