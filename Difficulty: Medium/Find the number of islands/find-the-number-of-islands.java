//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        while (tc-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.countIslands(grid);
            System.out.println(ans);
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    static int[][] dirs = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    void dfs (int r, int c, char[][] grid, boolean[][] vis, int n, int m) {
        vis[r][c] = true;
        for (int i = 0; i < dirs.length; ++i) {
            int nr = r + dirs[i][0];
            int nc = c + dirs[i][1];
            if (nr >= 0 && nr <  n && nc >= 0 && nc < m && !vis[nr][nc] && grid[nr][nc] == 'L')
                dfs (nr, nc, grid, vis, n, m);
        }
    }
    public int countIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] vis = new boolean[n][m];
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 'L' && !vis[i][j]) {
                    dfs (i, j, grid, vis, n, m);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}