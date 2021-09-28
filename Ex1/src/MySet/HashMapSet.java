package MySet;

import HashMap.HashSet;

public class HashMapSet implements Set {
    private HashSet hashSet;

    public HashMapSet(int cap){
        hashSet = new HashSet(cap);
    }

    @Override
    public boolean add(String word) {
        return (hashSet.putEntry(word) != null);
    }

    @Override
    public boolean contains(String word) {
        return hashSet.containsKey(word);
    }

    @Override
    public int size() {
        return hashSet.size();
    }
}
