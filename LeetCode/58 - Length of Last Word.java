/*

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.

*/

public class Solution {
    public int lengthOfLastWord(String s) {
        int end = 0;
        int start = -1;
        boolean checked = false;
        int i = s.length() - 1;
        while(i >= 0){
            if(s.charAt(i)!=' '){
                end = i;
                checked = true;
                break;
            }
            i--;
        }
        if(checked){
            while(i >= 0){
                if(s.charAt(i) == ' '){
                    start = i;
                    break;
                }
                i--;
            }
            return end - start;
        }
        return 0;
    }
}