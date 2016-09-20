/*

The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

*/

public class Solution {
    public String countAndSay(int n) {
        String res = "1";
        for(int i = 1; i < n; i++)
            res = Count(res);
        return res;
    }
    
    public String Count(String input){
        char nowChar = '1';
        int count = 0;
        int len = input.length();
        String res = "";
        if(len <= 0){
            return "";
        }
        nowChar = input.charAt(0);
        count++;
        for(int i = 1; i < len; i++){
            if(input.charAt(i) != input.charAt(i - 1)){
                res += String.valueOf(count);
                res += String.valueOf(nowChar);
                nowChar = input.charAt(i);
                count = 1;
            }
            else{
                count++;
            }
        }
        res += String.valueOf(count);
        res += String.valueOf(nowChar);
        return res;
    }
}