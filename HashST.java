import java.util.*;

public class HashST<K, V> {
    private Map<K, V> map;

    public HashST() {
        map = new HashMap<>();
    }


    public void put(K key, V value) {
        map.put(key, value);
    }


    public V get(K key) {
        return map.get(key);
    }

    public boolean contains(K key) {
        return map.containsKey(key);
    }


    public Set<K> keySet() {
        return map.keySet();
    }

    public Collection<V> values() {
        return map.values();
    }


    public int size() {
        return map.size();
    }


    public V remove(K key) {
        return map.remove(key);
    }


    public void clear() {
        map.clear();
    }
}
