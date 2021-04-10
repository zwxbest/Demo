package com.tuowazi.demo.hash.conflict;

public class HashTable2 {
    //数组容量
    private int capacity;

    //哈希键值对数组
    private Entry[] entries = {};

    public HashTable2(int capacity) {
        this.capacity = capacity;
        entries = new Entry[this.capacity];
    }

    //添加键值对
    public void put(String key, String value) {
        //获取键哈希值
        int hash = getHash(key);

        //实例化类存放键和值
        final Entry hashEntry = new Entry(key, value);

        //如果在数组中未有冲突的键则直接存放
        if (entries[hash] == null) {
            entries[hash] = hashEntry;
        }

        //如果找到冲突的哈希值则存放到单链表中的下一引用
        else {
            Entry temp = entries[hash];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = hashEntry;
        }
    }


    //获取键哈希值
    private int getHash(String key) {
        return key.hashCode() % capacity;
    }

    //获取指定键值
    public String get(String key) {

        int hash = getHash(key);

        if (entries[hash] != null) {

            Entry temp = entries[hash];

            while (!temp.key.equals(key)
                    && temp.next != null) {
                temp = temp.next;
            }
            return temp.value;
        }

        return null;
    }

    private class Entry {
        String key;
        String value;
        Entry next;

        public Entry(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        HashTable2 table = new HashTable2(5);

        table.put(String.valueOf(4), String.valueOf(4));
        table.put(String.valueOf(16), String.valueOf(16));
        table.put(String.valueOf(68), String.valueOf(68));
        table.put(String.valueOf(125), String.valueOf(125));
        table.put(String.valueOf(255), String.valueOf(255));

        System.out.println(table.get(String.valueOf(4)));
        System.out.println(table.get(String.valueOf(125)));
    }
}
