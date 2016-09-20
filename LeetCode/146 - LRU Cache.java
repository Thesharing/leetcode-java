/*

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

*/

public class LRUCache {
    Map<Integer, Integer> map;
    
    public LRUCache(int capacity) {
        map = new LinkedHashMap<Integer, Integer>((int) Math.ceil(capacity / 0.75f) + 1, 0.75f, true){
            @Override
        	protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
                return size() > capacity;
            }
        };
    }
    
    public int get(int key) {
        if(map.containsKey(key))
    		return map.get(key);
    	else
    		return -1;
    }
    
    public void set(int key, int value) {
        map.put(key, value);
    }
}