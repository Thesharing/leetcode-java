/*

Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

*/

public class Solution {
    public static int strStr(String haystack, String needle) {
        if(needle.length() == 0)
            return 0;
        int next[] = new int[needle.length()];
        getNext(needle, next);
        int i = -1;
        int j = -1;
        while(i < haystack.length() && j < needle.length()){
            if(j == -1 || haystack.charAt(i) == needle.charAt(j)){
                ++i;
                ++j;
            }
            else{
                j = next[j];
            }
        }
        if(j >= needle.length())
            return i - needle.length();
        else
            return -1;
    }
    
    public static void getNext(String needle, int next[]){
        int i = 0;
        int j = -1;
        next[0] = -1;
        while(i < needle.length() - 1){
            if(j == -1 || needle.charAt(i) == needle.charAt(j)){
                ++i;
                ++j;
                next[i] = j;
            }
            else{
                j = next[j];
            }
        }
    }
}