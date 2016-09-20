/*

Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".

*/

public class Solution {
    public String reverseVowels(String s) {
        String v = "aeiouAEIOU";
        char []c = s.toCharArray();
        int i = 0;
        int j = c.length - 1;
        while(i < j){
            while(i < j && !v.contains(String.valueOf(c[i]))){
                i++;
            }
            while(i < j && !v.contains(String.valueOf(c[j]))){
                j--;
            }
            swap(c, i ,j);
            i++;
            j--;
        }
        String r = String.valueOf(c);
        return r;
    }
    
    public void swap(char[] c, int i, int j){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
}