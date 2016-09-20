/*

Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.

*/

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        for(int i = 0; i < strs.length; i++){
            int code = getAlphabetic(strs[i]);
            if(map.containsKey(code)){
                map.get(code).add(strs[i]);
            } 
            else{
                List<String> strList = new ArrayList<String>();
                strList.add(strs[i]);
                map.put(code, strList);
            }
        }
        for(List<String> list : map.values()){
            res.add(list);
        }
        return res;
    }
    
    public int getAlphabetic(String s){
        char a[] = s.toCharArray();
        Arrays.sort(a);
        return String.valueOf(a).hashCode();
    }
}