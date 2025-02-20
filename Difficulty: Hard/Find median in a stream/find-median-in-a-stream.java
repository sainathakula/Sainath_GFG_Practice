//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            ArrayList<Double> ans = ob.getMedian(nums);
            for (double i : ans) {
                System.out.printf("%.1f ", i);
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        // code here
        ArrayList<Double> list = new ArrayList<>();
        list.add((double)arr[0]);
       for(int i = 1;i<arr.length;i++) {
           int cur = arr[i];
           int prev = i-1;
           while(prev >= 0 && cur < arr[prev]) {
               arr[prev+1] = arr[prev];
               prev--;
           }
           arr[prev+1] = cur;
           
          
           int mid = (i+1)/2;
           if((i&1) == 0) {
               list.add((double)arr[mid]);
           }else {
               list.add((double)((arr[mid]+arr[mid-1])/2.0));
           }
           
       } 
       return list;
    }
}