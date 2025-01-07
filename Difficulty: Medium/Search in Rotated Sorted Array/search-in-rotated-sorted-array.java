//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().search(arr, key));

            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int search(int[] arr, int key) {
        // Complete this function
        int lo=0;
        int n=arr.length;
        int hi=n-1;
        
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(arr[mid]==key){
                return mid;
            }
            if(arr[lo] <= arr[mid]){ // left is sorted
                
                if(key >= arr[lo] && key<arr[mid]) { hi=mid-1; }
                else{
                    lo=mid+1;
                }
                    
            }
            else if(arr[lo] > arr[mid]){ // right is sorted.
            
                if(key > arr[mid] && key <=arr[hi]){
                    lo=mid+1;
                }
                else{
                    hi=mid-1;
                }
            }
               
        }
        return -1;
    }
}