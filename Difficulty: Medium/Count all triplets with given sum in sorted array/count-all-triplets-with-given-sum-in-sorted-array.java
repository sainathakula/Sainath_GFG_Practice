//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            int target = Integer.parseInt(sc.nextLine());

            Solution ob = new Solution();
            int ans = ob.countTriplets(arr, target);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int countTriplets(int[] arr, int target) {
        // Code Here
        int n=arr.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            int lt=i+1, rt=n-1;
            while(lt<rt){
                int sum=arr[i]+arr[lt]+arr[rt];
                if(sum<target){
                    lt++;
                }else if(sum>target){
                    rt--;
                }else if(sum==target){
                    int e1=arr[lt], c1=0, e2=arr[rt], c2=0;
                    while(lt<=rt && arr[lt]==e1){
                        lt++;c1++;
                    }
                    while(lt<=rt && arr[rt]==e2){
                        rt--;c2++;
                    }
                    
                    cnt+= (e1==e2) ? (c1*(c1-1))/2 : (c1*c2);
                }
            }
        }
        return cnt;
    }
}