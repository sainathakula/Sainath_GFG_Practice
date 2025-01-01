//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                String temp[] = br.readLine().trim().split(" ");
                arr[i][0] = Integer.parseInt(temp[0]);
                String x = temp[1];
                arr[i][1] = Integer.parseInt(x);
            }
            Solution obj = new Solution();
            // The mergeOverlap function now returns a List<int[]>
            List<int[]> ans = obj.mergeOverlap(arr);

            // Printing the merged arr
            for (int[] interval : ans) {
                System.out.print(interval[0] + " " + interval[1] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public List<int[]> mergeOverlap(int[][] arr) {
        // Code here // Code here
        
        List<int[]> olap=new ArrayList<>();
        Arrays.sort(arr, (o1,o2)->Integer.compare(o1[0],o2[0]));
        
        olap.add(new int[]{arr[0][0],arr[0][1]});
        
        for(int i=1;i<arr.length;i++){
            
            int[] last=olap.get(olap.size()-1);
            int[] curr=arr[i];
            
            if(last[1]>=curr[0]){
                last[1]=Math.max(last[1],curr[1]);
            }
            else{
                olap.add(new int[]{curr[0],curr[1]});
            }
        }
        return olap;
        
        
        // other way (this will not use extra space); * Inplace merge
        
        // int idx=0;
        // for(int i=1;i<arr.length;i++){
        //     if(arr[idx][1]>=arr[i][0]){
        //         arr[idx][1]=Math.max(arr[idx][1], arr[i][1]);
        //     }
        //     else{
        //         idx++;
        //         arr[idx]=arr[i];
        //     }
        // }
        // return idx+1;
        
    }
}