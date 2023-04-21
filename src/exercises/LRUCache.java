package exercises;

import java.util.*;


//using singly linked list
public class LRUCache {
    private final HashMap<Integer, Integer> hm;
    private final LinkedList<Integer> cache;
    private final int capacity;

    public LRUCache(int capacity) {
        hm = new HashMap<Integer, Integer>();
        cache = new LinkedList<Integer>();
        this.capacity = capacity;
    }

    public int get(int key) {
        int value = hm.getOrDefault(key, -1);
        if(value != -1 && key != cache.getLast()){
            cache.addLast(key);
            cache.removeFirstOccurrence(key);
        }

        System.out.println(hm.toString()+" "+ cache.toString()+" "+value);
        return value;

    }

    private void putInCache(int key, int value) {
        if(hm.containsKey(key)){
            cache.removeFirstOccurrence(key);
        }

        if(cache.size()>0){
            if(cache.size() == capacity){
                int lruElement = cache.removeFirst();
                hm.remove(lruElement);
            }
            cache.addLast(key);
            hm.put(key,value);
        }
        else{
            hm.put(key,value);
            cache.add(key);
        }
        System.out.println(hm.toString()+" "+ cache.toString());
    }

    public void put(int key, int value) {
        putInCache(key, value);
    }

    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.put(2,1);
        obj.put(1,1);
        obj.get(2);
        obj.put(4,1);
        obj.get(1);
        obj.get(2);

    }

}
