//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.HashMap;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());

            ArrayList<Integer> ans = new Solution().countDistinct(arr, k);

            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            t--;
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code 
        int n=arr.length;
        ArrayList<Integer> res=new ArrayList<>();
        Map<Integer,Integer> freqmp=new HashMap<>();
        
        for(int i=0;i<n;i++){
            freqmp.put(arr[i], freqmp.getOrDefault(arr[i],0)+1);
            if(i>=k){
                freqmp.put(arr[i-k],freqmp.getOrDefault(arr[i-k],0)-1);
                if(freqmp.get(arr[i-k])==0){
                    freqmp.remove(arr[i-k]);
                }
            }
            if(i>=k-1){
                res.add(freqmp.size());
            }
            
        }
        return res;
        
    }
}
