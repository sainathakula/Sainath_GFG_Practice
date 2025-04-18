//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maxXor(arr));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maxXor(int[] arr) {
        // code here
        
        // store the array length
        int n =arr.length;
        
        
        // make a variable to return
        int count=0;
        
        // travel from 0 and 1 index to last
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                
                // xor operation between O and 1 place continue till last
            count = Math.max(count, arr[i] ^ arr[j]);
        }
        }
        return count;
    }
}