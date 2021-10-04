package HashMap;

public class HashSet {

    private int size;
    private Entry[] buckets;

    public HashSet(int initialCapacity) {

        // Find a power of 2 >= initialCapacity
        int capacity = 1;
        while (capacity < initialCapacity)
            capacity <<= 1;
        this.buckets = new Entry[capacity];
        this.size = 0;
    }

    // from openjdk
    private int hash(int hashcode) {
        hashcode ^= (hashcode >>> 20) ^ (hashcode >>> 12);
        return hashcode ^ (hashcode >>> 7) ^ (hashcode >>> 4);
    }

    // from openjdk
    private int index(int hash, int length) {
        //when length is a power of 2, there's hash % length == hash & (length - 1)
        return hash & (length - 1);
    }

    public boolean containsKey(String k) {
        return getEntry(k) != null;
    }

    private Entry getEntry(String k) {
        int hash = (k == null) ? 0 : hash(k.hashCode());
        int i = index(hash, buckets.length);
        for (Entry e = buckets[i]; e != null; e = e.next) {
            if ((e.hash == hash) && (k != null || k.equals(e.getKey()))) {
                return e;
            }
        }
        return null;
    }

    public Entry putEntry(String k) {
        if (getEntry(k) != null) {
            return null;
        }
        int hash = hash(k.hashCode());
        int i = index(hash, buckets.length);
        Entry entry = new Entry(hash, k, buckets[i]);
        buckets[i] = entry;
        this.size++;
        return buckets[i];

    }

    public int size() {
        return this.size;
    }

    static class Entry {
        final String key;
        Entry next;
        final int hash;

        Entry(int h, String k, Entry entry) {
            key = k;
            hash = h;
            next = entry;
        }

        public final String getKey() {
            return key;
        }
    }
}


