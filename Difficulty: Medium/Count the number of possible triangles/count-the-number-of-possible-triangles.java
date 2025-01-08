//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().countTriangles(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to count the number of possible triangles.
    static int countTriangles(int arr[]) {
        // code here
        // we take three elements a, b, c and have to check three conditions 
        // 1. a+b > c
        // 2. b+c > a
        // 3. a+c > b
        // If the array is sorted that means a<=b<=c which means it 2,3 conditions will be always true.
        // So we will check for only 1 condition;
        Arrays.sort(arr);
        int n=arr.length;
        int cnt=0;
        for(int i=2;i<n;i++){
            int lo=0,hi=i-1;
            while(lo<hi){
                
                if(arr[lo]+arr[hi] > arr[i]){
                    cnt += hi-lo; // we take the count of all the pairs with in between elements.
                    hi--;
                }else{lo++;}
            }
        }
        return cnt;
    }
}