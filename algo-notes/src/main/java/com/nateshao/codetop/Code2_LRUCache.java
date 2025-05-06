package com.nateshao.codetop;

import java.util.LinkedHashMap;

public class Code2_LRUCache {
    /**
     * 146. LRU 缓存
     * https://leetcode.cn/problems/lru-cache/description/
     *
     * @param capacity
     */
//    int cap;
//    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
//    public Code2_LRUCache(int capacity) {
//        this.cap = capacity;
//    }
//
//    public int get(int key) {
//        if (!cache.containsKey(key)) {
//            return -1;
//        }
//        // 将 key 变为最近使用
//        makeRecently(key);
//        return cache.get(key);
//    }
//
//    public void put(int key, int val) {
//        if (cache.containsKey(key)) {
//            // 修改 key 的值
//            cache.put(key, val);
//            // 将 key 变为最近使用
//            makeRecently(key);
//            return;
//        }
//
//        if (cache.size() >= this.cap) {
//            // 链表头部就是最久未使用的 key
//            int oldestKey = cache.keySet().iterator().next();
//            cache.remove(oldestKey);
//        }
//        // 将新的 key 添加链表尾部
//        cache.put(key, val);
//    }
//
//    private void makeRecently(int key) {
//        int val = cache.get(key);
//        // 删除 key，重新插入到队尾
//        cache.remove(key);
//        cache.put(key, val);
//    }

//    LinkedHashMap<Integer,Integer> cache = new LinkedHashMap<>();
//    int cap;
//    public Code2_LRUCache(int capacity) {
//        this.cap = capacity;
//    }
//    public int get(int key) {
//        if (!cache.containsKey(key)) {
//            return -1;
//        }
//        // 置为最近最少使用
//        makeRecently(key);
//        return cache.get(key);
//    }
//    public void put(int key, int value) {
//        if (cache.containsKey(key)) {
//            cache.put(key,value);
//            makeRecently(key);
//            return;
//        }
//        if (cache.size() >= this.cap) {
//            cache.remove(cache.keySet().iterator().next());
//        }
//        cache.put(key,value);
//    }
//
//    /**
//     * 最近最少使用
//     * @param key
//     */
//    private void makeRecently(int key) {
//        int val = get(key);
//        cache.remove(key);
//        cache.put(key,val);
//    }


//    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
//    int capacity;
//
//    public Code2_LRUCache(int cap) {
//        this.capacity = cap;
//    }
//
//    public int get(int key) {
//        if (!cache.containsKey(key)) {
//            return -1;
//        }
//        // 最近最少使用
//        makeRecently(key);
//        return cache.get(key);
//    }
//
//    public void put(int key, int value) {
//        if (cache.containsKey(key)) {
//            cache.put(key, value);
//            makeRecently(key);
//            return;
//        }
//        if (cache.size() >= this.capacity) {
//            cache.remove(cache.keySet().iterator().next());
//        }
//        cache.put(key, value);
//    }
//
//    private void makeRecently(int key) {
//        int val = cache.get(key);
//        cache.remove(key);
//        cache.put(key, val);
//    }

//    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<Integer, Integer>();
//    int cap;
//
//    public Code2_LRUCache(int capacity) {
//        this.cap = capacity;
//    }
//
//    public int get(int key) {
//        if (!cache.containsKey(key)) {
//            return -1;
//        }
//        // 最近最少使用
//        makeRecently(key);
//        return cache.get(key);
//    }
//
//
//    public void put(int key, int value) {
//        if (cache.containsKey(key)) {
//            cache.put(key, value);
//            makeRecently(key);
//            return;
//        }
//        if (cache.size() >= this.cap) {
//            cache.remove(cache.keySet().iterator().next());
//        }
//        cache.put(key, value);
//    }
//
//    /**
//     * 最近最少使用
//     *
//     * @param key
//     */
//    private void makeRecently(int key) {
//        int val = cache.get(key);
//        cache.remove(key);
//        cache.put(key, val);
//    }

//    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
//    int cap;
//
//    public Code2_LRUCache(int capacity) {
//        this.cap = capacity;
//    }
//
//    public int get(int key) {
//        if (!cache.containsKey(key)) {
//            return -1;
//        }
//        // 最近最少使用
//        makeRecently(key);
//        return cache.get(key);
//    }
//
//    private void makeRecently(int key) {
//        int val = cache.get(key);
//        cache.remove(val);
//        cache.put(key, val);
//    }
//
//    public void put(int key, int value) {
//        if (cache.containsKey(key)) {
//            cache.put(key, value);
//            makeRecently(key);
//            return;
//        }
//        if (cache.size() >= cap) {
//            cache.remove(cache.keySet().iterator().next());
//        }
//        cache.put(key, value);
//    }
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<Integer, Integer>();
    int capacity;

    public Code2_LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        // 最近最少使用
        makeRecently(key);
        return cache.get(key);
    }

    private void makeRecently(int key) {
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            makeRecently(key);
            return;
        }
        if (cache.size() >= capacity) {
            cache.remove(cache.keySet().iterator().next());
        }
        cache.put(key, value);
    }

}
