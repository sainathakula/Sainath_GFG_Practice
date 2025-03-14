//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            int capacity = Integer.parseInt(br.readLine());
            String[] valInput = br.readLine().split(" ");
            String[] wtInput = br.readLine().split(" ");

            int[] val = new int[valInput.length];
            int[] wt = new int[wtInput.length];

            for (int i = 0; i < valInput.length; i++) {
                val[i] = Integer.parseInt(valInput[i]);
            }

            for (int i = 0; i < wtInput.length; i++) {
                wt[i] = Integer.parseInt(wtInput[i]);
            }

            System.out.println(Solution.knapsack(capacity, val, wt));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int solve(int W,int[] val,int[] wt,int i,int[][] dp){
        if(i==wt.length) return 0;
        if(dp[i][W] != -1)return dp[i][W];
        int include = 0;
        if(wt[i]<=W) include = val[i]+solve(W-wt[i],val,wt,i+1,dp);
        int exclude = solve(W,val,wt,i+1,dp);
        return dp[i][W] = Math.max(include,exclude);
    }
    
    static int knapsack(int W, int val[], int wt[]) {
        int[][] dp = new int[val.length][W+1];
        for(int i=0;i<val.length;i++)
            for(int j=0;j<W+1;j++)
                dp[i][j]=-1;
        return solve(W,val,wt,0,dp);
        
    }
}
