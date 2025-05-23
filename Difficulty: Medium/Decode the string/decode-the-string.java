//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s = in.readLine();

            Solution ob = new Solution();
            out.println(ob.decodeString(s));

            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends



class Solution {
    static String decodeString(String s) {
        // code here
        Stack<String> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                int start = i;
                i += 1;
                while (Character.isDigit(s.charAt(i))) i++;
                stack.push(s.substring(start, i));
                i--;
                continue;
            }
            
            if (c == ']') {
                StringBuilder expandedString = new StringBuilder();
                String temp;
                
                while (!(temp = stack.pop()).equals("[")) {
                    expandedString.insert(0, temp);
                }
                
                int count = Integer.parseInt(stack.pop());
                StringBuilder finalString = new StringBuilder();
                
                while (count-- > 0) {
                    finalString.append(expandedString);
                }
                
                stack.push(finalString.toString());
            } else {
                stack.push(String.valueOf(c));
            }
        }
        
        StringBuilder solution = new StringBuilder();
        
        while (!stack.isEmpty()) {
            solution.insert(0, stack.pop());
        }
        
        return solution.toString();
    }
}