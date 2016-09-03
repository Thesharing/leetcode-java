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