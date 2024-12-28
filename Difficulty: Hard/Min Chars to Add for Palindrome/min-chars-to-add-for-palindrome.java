//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    static void givelps(String pat, int[] lps){
        int m=pat.length();
        lps[0]=0;
        int len=0;
        int i=1;
        while(i<m){
            if(pat.charAt(i)==pat.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }
            else{
                if(len!=0){len=lps[len-1];}
                else{lps[i]=0;i++;}
            }
        }
    }
    public static int minChar(String s) {
        // Write your code here
        StringBuilder revsb=new StringBuilder(s);
        revsb.reverse();
        String rev=revsb.toString();
        String pat= s+"#"+rev;
        int n=s.length();
        int[] lps=new int[n*2+1];
        givelps(pat,lps);
        
        int last=lps[n*2+1-1];
        return n-last;
        
    }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        var sc = new FastReader();
        int test = sc.nextInt();
        while (test-- > 0) {
            String s = sc.nextString();
            System.out.println(Solution.minChar(s));

            System.out.println("~");
        }
    }

    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        private void read() throws IOException {
            st = new StringTokenizer(br.readLine());
        }

        public String nextString() throws IOException {
            while (!st.hasMoreTokens()) read();
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(nextString());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(nextString());
        }
    }
}
// } Driver Code Ends