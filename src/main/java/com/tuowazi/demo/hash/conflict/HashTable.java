package com.tuowazi.demo.hash.conflict;

/**
 * 线性探测是指连续探测之间的间隔固定（通常为1）。假设特定条目的散列索引是索引。
 */
public class HashTable {

    //数组容量
    private int capacity;

    //哈希键值对数组
    private Entry[] entries = {};

    public HashTable(int capacity) {
        this.capacity = capacity;
        entries = new Entry[this.capacity];
    }

    //添加键值对
    public void put(String key, String value) {
        final Entry hashEntry = new Entry(key, value);
        int hash = getHash(key);
        entries[hash] = hashEntry;
    }

    //获取键哈希值
    private int getHash(String key) {
        int hashCode = key.hashCode();
        int hash = hashCode % capacity;
        while (entries[hash] != null) {
            hashCode += 1;
            hash = hashCode % capacity;
        }
        return hash;
    }

    //获取指定键值
    public String get(String key) {
        int hashCode = key.hashCode();
        int hash = hashCode % capacity;
        if (entries[hash] != null) {
            while (!entries[hash].key.equals(key)) {
                hashCode += 1;
                hash = hashCode % capacity;
            }
            return entries[hash].value;
        }
        return null;
    }

    private class Entry {
        String key;
        String value;

        public Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {

        HashTable table = new HashTable(5);

        table.put(String.valueOf(4), String.valueOf(4));
        table.put(String.valueOf(16), String.valueOf(16));
        table.put(String.valueOf(68), String.valueOf(68));
        table.put(String.valueOf(125), String.valueOf(125));
        table.put(String.valueOf(255), String.valueOf(255));

        System.out.println(table.get(String.valueOf(4)));
        System.out.println(table.get(String.valueOf(125)));
    }
}