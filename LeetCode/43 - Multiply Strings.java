/*

Given two numbers represented as strings, return multiplication of the numbers as a string.

Note:
The numbers can be arbitrarily large and are non-negative.
Converting the input string to integer is NOT allowed.
You should NOT use internal library such as BigInteger.

*/

public class Solution {
    public String multiply(String num1, String num2) {
    String res = "0";
    int len = num2.length() - 1;
        for(int i = len; i >= 0; i--){
          res = add(res, multiplyOneChar(num1, num2.charAt(i)), len - i);
        }
        for(int i = 0; i < res.length(); i++){
          if(res.charAt(i) == '0'){
            continue;
          }
          else{
            return res.substring(i);
          }
        }
        return "0";
    }
  
  public String add(String num1, String num2, int pos){
    int i;
    int jinWei = 0;
    int temp = 0;
    int len1 = num1.length();
    int len2 = num2.length();
    String res = num1.substring(len1 - pos);
    for(i = pos + 1; i <= len1; i++){
      if(i - pos <= len2){
        temp = num1.charAt(len1 - i) - '0' + num2.charAt(len2 - i + pos) - '0' + jinWei;
        jinWei = temp / 10;
        res = String.valueOf(temp % 10) + res;
      }
      else{
        if(jinWei != 0){
          temp = num1.charAt(len1 - i) - '0' + jinWei;
          jinWei = temp / 10;
          res = String.valueOf(temp % 10) + res;
        }
        else{
          res = num1.substring(0, len1 - i + 1) + res;
          break;
        }
      }
    }
    if(i - pos <= len2){
      i = i - pos;
      while(jinWei !=0 && i <= len2){
        temp = num2.charAt(len2 - i++) - '0' + jinWei;
        jinWei = temp / 10;
        res = String.valueOf(temp % 10) + res;
      }
      res = num2.substring(0, len2 - i + 1) + res;
    }
    if(jinWei != 0){
      res = String.valueOf(jinWei) + res;
    }
    return res;
  }
  
  public String multiplyOneChar(String num1, char ch){
        String res = "";
        int chNum = ch - '0';
        int temp = 0;
        int jinWei = 0;
        for(int i = num1.length() - 1; i >= 0; i--){
            temp = (num1.charAt(i) - '0') * chNum + jinWei;
            jinWei = temp / 10;
            res = String.valueOf(temp % 10) + res;
        }
        if(jinWei > 0){
            res = String.valueOf(jinWei) + res;
        }
        for(int i = 0; i < res.length(); i++){
          if(res.charAt(i) == '0'){
            continue;
          }
          else{
            return res.substring(i);
          }
        }
        return "0";
    }
}