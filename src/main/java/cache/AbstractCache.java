package cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {
    
    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        cache.put(key, new SoftReference<V>(value));
    }

    public V get(K key) {
        SoftReference<V> value = cache.get(key);
        if (value == null) {
            cache.get(key).get();
            put(key, load(key));
        }
       return cache.get(key).get();
    }

    protected abstract V load(K key);
}
