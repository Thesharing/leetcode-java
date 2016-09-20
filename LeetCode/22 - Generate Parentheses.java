/*

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

*/

public class Solution {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        recursiveFunction(res, "", n, n);
        return res;
    }
    
    public static void recursiveFunction(List<String> res, String str, int left, int right){
            if(left == 0 && right == 0){
                res.add(str);
                return;
            }
            if(left > 0){
                recursiveFunction(res, str+"(", left - 1, right);
            }
            if(right > 0 && left < right){
                recursiveFunction(res, str+")", left, right - 1);
            }
    }
}