package com.datastructures;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by chandrashekar.v on 5/15/2017.
 */
public class LRUCache {

    LRUList lruList = new LRUList(3);
    HashMap<String, String> cacheMap = new HashMap<>();

    public static void main(String[] args) {

        LRUCache cache = new LRUCache();
        cache.add("1", "value-1");
        cache.add("2", "value-2");
        cache.add("3", "value-3");
        cache.add("4", "value-4");
        cache.get("3");
        cache.add("5", "value-5");
    }

    private void add(final String key, String value) {

        if (!cacheMap.containsKey(key)) {
            lruList.access(key);
            cacheMap.put(key, value);
        }
    }

    private void get(final String key) {
        if (cacheMap.containsKey(key)) {
            lruList.access(key);
            cacheMap.get(key);
        }
    }

    private boolean remove(String key) {
        if (cacheMap.containsKey(key)) {
            lruList.remove(key);
            cacheMap.remove(key);
            return true;
        }
        return false;
    }

    public static class Node<T> {
        private T value;
        private String key;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }


    public static class LRUList {

        LinkedList<String> linkedList = new LinkedList();

        public LinkedList<String> getLinkedList() {
            return linkedList;
        }

        public void setLinkedList(LinkedList<String> linkedList) {
            this.linkedList = linkedList;
        }

        private static final int DEFAULT_SIZE = 10;
        int size = 0;

        public LRUList(int size) {
            if (size != 0)
                this.size = size;
            else
                this.size = DEFAULT_SIZE;
        }

        public LRUList() {
            this.size = DEFAULT_SIZE;
        }

        public void access(String e) {
            if (linkedList.contains(e)) {
                linkedList.remove(e);
                linkedList.addFirst(e);
            } else {
                // List is full
                if (linkedList.size() == size) {
                    String s = linkedList.removeLast();
                    System.out.println("Removed:" + s);
                    linkedList.addFirst(e);
                } else {
                    linkedList.addFirst(e);
                }
            }
            linkedList.forEach(System.out::printf);
            System.out.println();
        }

        public void remove(String key) {
            if (linkedList.contains(key))
                linkedList.remove(key);
        }
    }

}
