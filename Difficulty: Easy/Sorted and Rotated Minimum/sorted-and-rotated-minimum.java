//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        Solution ob = new Solution(); // Instantiate the Solution object once

        while (t-- > 0) {
            String line = scanner.nextLine();
            String[] elements = line.split(" ");
            int[] arr = new int[elements.length]; // Changed to int[]

            for (int i = 0; i < elements.length; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }

            System.out.println(ob.findMin(arr));
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findMin(int[] arr) {
        // complete the function here
        int lo=0;
        int hi=arr.length-1;
        while(lo<hi){
            
            if(arr[lo]<arr[hi]){
                return arr[lo];
            }
            
            int mid=(hi-lo)/2+lo;
            // Means mid to high is sorted min ele lies in left half
            if(arr[mid]<=arr[hi]){
             hi=mid;   // Here we can expect the min in mid also.
            }
            // Means low to mid is sorted min ele lies in right half.
            else if(arr[mid]>arr[hi]){
                lo=mid+1;
            }
        }
        return arr[lo];
    }
}
