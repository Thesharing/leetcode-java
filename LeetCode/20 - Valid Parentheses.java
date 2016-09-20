
/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

*/

public class Solution {
    public static boolean isValid(String s) {
    Stack<Integer> stack = new Stack<Integer>();
    List<Character> front = new ArrayList<Character>();
    front.add(new Character('('));
    front.add(new Character('['));
    front.add(new Character('{'));
    List<Character> back = new ArrayList<Character>();
    back.add(new Character(')'));
    back.add(new Character(']'));
    back.add(new Character('}'));
    Boolean res = true;
        for(int i = 0; i < s.length(); i++){
          int index = front.indexOf(s.charAt(i));
          if(index >= 0){
            stack.push(new Integer(index));
          }
          else{
            index = back.indexOf(s.charAt(i));
            if(index >= 0){
                if(stack.empty()){
                    res = false;
                    break;
                }
                else{
                  int index2 = (int)stack.pop();
                  if(index2 != index){
                    res = false;
                    break;
                  }
                }
            }
          }
        }
        if(!stack.empty())
          res = false;
        return res;
    }
}