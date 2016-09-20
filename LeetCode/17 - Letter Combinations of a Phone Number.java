/*

Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.

*/

public class Solution {
    public String[] numbers = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if(digits.length() <= 0)
            return res;
        StringBuilder temp = new StringBuilder();
        recurseFunction(digits, 0, temp, res);
        return res;
    }
    
    public void recurseFunction(String digits, int loc, StringBuilder temp, List<String> res){
        if(loc == digits.length()){
            res.add(temp.toString());
        }
        else{
            int digit = digits.charAt(loc) - '0';
            for(int i = 0; i < numbers[digit].length(); i++){
                StringBuilder temp2 = new StringBuilder(temp);
                temp2.append(numbers[digit].charAt(i));
                recurseFunction(digits, loc + 1, temp2, res);
            }
        }
    }
}