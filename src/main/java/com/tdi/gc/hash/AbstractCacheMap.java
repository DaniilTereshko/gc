package com.tdi.gc.hash;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractCacheMap<K, V> {

    private final Map<K, SoftReference<V>> cache = new ConcurrentHashMap<>();

    protected abstract V load(K key);

    public V getValue(K key) {
        SoftReference<V> softReference = cache.get(key);

        V val = softReference == null ? null : softReference.get();

        if (val == null) {
            System.out.println("Load value by key: " + key);
            val = load(key);
            put(key, val);
            return val;
        }

        System.out.println("Cache hit! Key: " + key);
        return val;
    }

    public void put(K key, V value) {
        cache.put(key, new SoftReference<>(value));
    }

    public boolean remove(K key) {
        cache.remove(key);

        return cache.get(key) == null;
    }

    public void clear() {
        cache.clear();
    }
}
