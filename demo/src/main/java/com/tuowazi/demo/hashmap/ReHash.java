package com.tuowazi.demo.hashmap;

import java.util.Map;

/**
 * 模拟hashmap的rehash操作，参考：https://www.jianshu.com/p/13c650a25ed3
 */
public class ReHash<K, V> {

    class Entry<K, V> {
        public K key;
        public V value;

        public Entry<K, V> next;

        private int hash() {
            return key.hashCode();
        }
    }

    private Entry<K, V>[] table;

    public void put(K key, V value) {

    }

    public void resize(int newCapacity) {
        Entry<K, V>[] oldTable = table;
        int oldCapacity = oldTable.length;
        //创建一个新的Hash Table
        Entry<K, V>[] newTable = new Entry[oldCapacity * 2];
        //将Old Hash Table上的数据迁移到New Hash Table上
        transfer(newTable);
        table = newTable;
    }

    void transfer(Entry<K, V>[] newTable) {
        Entry<K, V>[] src = table;
        int newCapacity = newTable.length;
        //下面这段代码的意思是：
        //  从OldTable里摘一个元素出来，然后放到NewTable中
        for (int j = 0; j < src.length; j++) {
            Entry<K, V> e = src[j];
            if (e != null) {
                src[j] = null;
                do {
                    Entry<K, V> next = e.next;
                    int i = indexFor(e.hash(), newCapacity);
                    e.next = newTable[i];
                    newTable[i] = e;
                    e = next;
                } while (e != null);
            }
        }
    }

    int indexFor(int hash, int newCapacity) {
        return hash % newCapacity;
    }

}
