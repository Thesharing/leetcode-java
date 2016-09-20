/* 

Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".

*/

public class Solution {
    public static String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int len = Math.min(aLen, bLen);
        StringBuilder res = new StringBuilder();
        int jinWei = 0;
        for(int i = 0; i < len; i++){
            res.insert(0, (a.charAt(aLen - 1 - i) + b.charAt(bLen - 1 - i) + jinWei - 96) % 2);
            jinWei = (a.charAt(aLen - 1 - i) + b.charAt(bLen - 1 - i) + jinWei - 96) / 2;
        }
        if(a.length() >= b.length()){
            for(int i = a.length() - len - 1; i >= 0; i--){
                res.insert(0, (a.charAt(i) + jinWei - 48) % 2);
                jinWei = (a.charAt(i) + jinWei - 48) / 2;
            }
        }
        else{
            for(int i = b.length() - len - 1; i >= 0; i--){
                res.insert(0, (b.charAt(i) + jinWei - 48) % 2);
                jinWei = (b.charAt(i) + jinWei - 48) / 2;
            }
        }
        if(jinWei != 0){
            res.insert(0, jinWei);
        }
        return res.toString();
    }
}