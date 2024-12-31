//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int countndmerge(int[] arr,int lt,int mid,int rt){
        int n1=mid-lt+1;
        int n2=rt-mid;
        int[] rtt=new int[n2];
        int[] ltt=new int[n1];
        for(int i=0;i<n1;i++){ltt[i]=arr[i+lt];}
        for(int j=0;j<n2;j++){rtt[j]=arr[mid+1+j];}
        
        int i=0,j=0,k=lt;
        int count=0;
        while(i<n1 && j<n2){
            
            if(ltt[i]<=rtt[j]){
                arr[k++]=ltt[i++];
                
            }else{
                arr[k++]=rtt[j++];
                count+=(n1-i);
            }
        }
        while(i<n1){
            arr[k++]=ltt[i++];
        }
        while(j<n2){
            arr[k++]=rtt[j++];
        }
        return count;
    }

    // Function to count inversions in the array.
    static int countinv(int[] arr,int lt,int rt){
        int count=0;
        
        
        if(lt<rt){
            int mid=(lt+rt)/2;
            count+=countinv(arr,lt,mid);
            count+=countinv(arr,mid+1,rt);
            count+=countndmerge(arr,lt,mid,rt);
            
        }
        
        return count;
        
    }
    static int inversionCount(int[] arr) {
        // Your Code Here
        return countinv(arr,0,arr.length-1);
    }
}