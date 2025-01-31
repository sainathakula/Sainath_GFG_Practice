//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = 9;
            int matrix[][] = new int[n][n];
            // String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ob.solveSudoku(matrix);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) System.out.print(matrix[i][j] + " ");
                System.out.println();
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find a solved Sudoku.
    static void solveSudoku(int[][] mat) {
        // code here
        solve(mat, 0, 0);
    }

    static boolean solve(int[][] mat, int i, int j) {
        // If we reach the end of the board, the puzzle is solved
        if (i == 9) {
            return true;
        }

        int nextI = (j == 8) ? i + 1 : i;
        int nextJ = (j == 8) ? 0 : j + 1;

        // If the cell is already filled, move to the next cell
        if (mat[i][j] != 0) {
            return solve(mat, nextI, nextJ);
        }

        // Try placing numbers from 1 to 9
        for (int val = 1; val <= 9; val++) {
            if (isValid(mat, i, j, val)) {
                mat[i][j] = val;
                if (solve(mat, nextI, nextJ)) {
                    return true;
                }
                // Backtrack if placing 'val' doesn't lead to a solution
                mat[i][j] = 0;
            }
        }
        return false; // If no value fits, backtrack
    }

    // Function to check if placing 'val' at (r, c) is valid
    static boolean isValid(int[][] mat, int r, int c, int val) {
        for (int i = 0; i < 9; i++) {
            // Check row, column, and subgrid
            if (mat[i][c] == val || mat[r][i] == val || 
                mat[(r / 3) * 3 + i / 3][(c / 3) * 3 + i % 3] == val) {
                return false;
            }
        }
        return true;
    }
}