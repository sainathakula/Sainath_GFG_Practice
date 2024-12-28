//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s, patt;
            s = sc.next();
            patt = sc.next();

            Solution ob = new Solution();

            ArrayList<Integer> res = ob.search(patt, s);
            if (res.size() == 0)
                System.out.print("[]");
            else {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    static void givelps(String pat,int[] lps){
        int len=0;
        lps[0]=0;
        
        int i=1;
        int m=pat.length();
        
        while(i<m){
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

    ArrayList<Integer> search(String pat, String txt) {
        // your code here
        int n=txt.length(), m=pat.length();
        int[] lps=new int[m];
        givelps(pat,lps);
        
        ArrayList<Integer> result=new ArrayList<>();
        
        int i=0,j=0;
        while(i<n){
            
            
            if(txt.charAt(i)==pat.charAt(j)){
                i++;j++;
                
                if(j==m){
                    result.add(i-j);
                    j=lps[j-1];
                }
                
            }
            else{
                if(j!=0){j=lps[j-1];}
                else{i++;}
            }
        }
        
        return result;
        
        
        
        
    }
}