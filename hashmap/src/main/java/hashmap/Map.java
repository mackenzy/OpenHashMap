package hashmap;

/**
 * Created by MatveyI on 22.02.2015.
 *
 * Simple Map interface
 */
public interface Map<K,V> {
    V put(K key, V value);
    V get(K key);
    V remove(Object key);
    int size();
}
