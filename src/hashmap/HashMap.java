import arrays.DynamicArray;
import arrays.DynamicArrayException;
import arrays.StaticArrayException;

class Entry<K, V> {
    protected K key;
    protected V value;
    protected Entry<K, V> next;

    protected Entry(K key, V value, Entry<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    protected Entry(K key, V value) {
        this(key, value, null);
    }
}

public class HashMap<K, V> {
    private DynamicArray<Entry<K, V>> buckets;
    private int capacity;
    private int size;
    private int hashCode;

    public HashMap() {

        
    }

}