//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    int countPairs(int arr[], int target) {
        // Complete the function
        int n=arr.length;
        int i=0, j=n-1;
        int cnt=0;
        while(i<j){
            int sum=arr[i]+arr[j];
            
            if(sum > target){ j--;}
            else if(sum < target) {i++;}
            else {
                int e1=arr[i], c1=0, e2=arr[j], c2=0;
                while(i<=j && arr[i]==e1){
                    i++;c1++;
                }
                while(i<=j && arr[j]==e2){
                    j--;c2++;
                }
                if(e1==e2){
                    cnt += (c1*(c1-1))/2;
                }
                else{
                    cnt += c1*c2;
                }
            }
            
        }
        return cnt;
    }
}


//{ Driver Code Starts.
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int target = Integer.parseInt(inputLine[0]);

            Solution obj = new Solution();
            int res = obj.countPairs(arr, target);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends