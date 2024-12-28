//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {

        // taking input using BufferedReader class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking total count of testcases
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // Reading the two Strings
            String s1 = br.readLine();
            String s2 = br.readLine();

            // Creating an object of class Rotate
            Solution obj = new Solution();

            // calling areRotations method
            // of class Rotate and printing
            //"1" if it returns true
            // else "0"
            if (obj.areRotations(s1, s2)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }
}
// } Driver Code Ends



class Solution {
    static void givelps(String pat, int[] lps){
        
        int n=pat.length();
    
        int len=0;
        
        int i=1; lps[0]=0;
        while(i<n){
            if(pat.charAt(i)==pat.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }
            else{
                if(len!=0){
                    len=lps[len-1];
                }
                else{
                    lps[i]=0;i++;
                }
            }
        }
    }
    ///////////////////
    
    // Function to check if two strings are rotations of each other or not.
    public static boolean areRotations(String s1, String s2) {
        // Your code here
        String s=s1+s1;
        int n=s.length();
        int m=s2.length();
        
        int[] lps=new int[m];
        givelps(s2,lps);
        
        
        int i=0;
        int j=0;
        
        while(i<n){
            if(s.charAt(i)==s2.charAt(j)){
                i++;j++;
                if(j==m){
                    return true;
                    // j=lps[j-1];
                }
                
            }
            else{
                if(j!=0){
                    j=lps[j-1];
                }
                else{
                    i++;
                }
            }
        }
        return false;
        //////////////////////////
        // String txt = s1 + s1;
        // String pat = s2;
        
        
        // int n = txt.length();
        // int m = pat.length();

        
        // int[] lps = computeLPSArray(pat);
      
        // int i = 0; 
        // int j = 0;
        // while (i < n) {
        //     if (pat.charAt(j) == txt.charAt(i)) {
        //         j++;
        //         i++;
        //     }

        //     if (j == m) {
        //         return true;
        //     }
        //     else if (i < n && pat.charAt(j) != txt.charAt(i)) {

                
        //         if (j != 0)
        //             j = lps[j - 1];
        //         else
        //             i = i + 1;
        //     }
        // }
        // return false;
        
    }
}