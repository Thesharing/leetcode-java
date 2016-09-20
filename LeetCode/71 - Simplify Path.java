/*

Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".

*/

public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        StringBuilder sb = new StringBuilder();
        String strs[] = path.split("/", 0);
            for(int i = 0; i < strs.length; i++){
                if(!strs[i].isEmpty() && !strs[i].equals(".")){
                    if(strs[i].equals("..")){
                        if(!stack.isEmpty()){
                            stack.pop();
                        }
                    }
                    else{
                        stack.push(strs[i]);
                    }
                }
            }
            if(stack.isEmpty()){
                sb.append("/");
            }
            else{
                Iterator<String> it = stack.iterator();
                while(it.hasNext()){
                    sb.append("/"+it.next());
                }
            }
            return sb.toString();
    }
}
