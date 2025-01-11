//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubstr(s));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

// User function Template for Java
// import java.util.Arrays;
class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        int n=s.length();
        // sliding window and 2 pointer approach.
        int[] hash=new int[256]; // maintaining the characters.
        // Arrays.fill(hash,-1);
        for(int i=0;i<256;i++){
            hash[i]=-1;
        }
        int maxlen=0;
        int lt=0,rt=0;
        while(rt<n){
            char ch=s.charAt(rt);
            if(hash[ch]!=-1){
                if(hash[ch] >= lt ){ // checking if the ch index is with in the window.
                    lt=hash[ch]+1; 
                }
            }
            int len=rt-lt+1;
            maxlen=Math.max(len,maxlen);
            hash[ch]=rt;
            rt++;
        }
        return maxlen;
    }
}