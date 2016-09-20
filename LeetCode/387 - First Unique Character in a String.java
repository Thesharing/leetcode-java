/*

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.

*/

public class Solution {
    public int firstUniqChar(String s) {
        if(s.isEmpty()){
            return -1;
        }
        int ch[] = new int[26];
        for(int i = 0; i < s.length(); i++){
            ch[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < s.length(); i++){
            if(ch[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}