package com.tuowazi.demo.redis;

import java.util.*;

public class Pool {
    private Map<String, String> map = new HashMap<>();
    private List<String> keys = new ArrayList<>();

    public void add(String key, String value) {
        map.put(key, value);
        keys.add(key);
    }

    public void add(int index,String key,String value){
        map.put(key, value);
        keys.add(index,key);
    }


    public List<String> getKeys() {
        return keys;
    }

    public void delete(String key) {
        map.remove(key);
    }
}
