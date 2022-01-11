package MySet;

import LinkedList.*;

public class LinkedListSet implements Set {
    private LinkedList setList;
    private int setSize;

    public LinkedListSet() {
        setList = new LinkedList();
        setSize = 0;
    }

    @Override
    public boolean add(String word) {
        if (setList.find(word) == null) {
            setList.pushFront(new LinkedNode(word));
            setSize += 1;
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(String word) {
        return  (setList.find(word) != null);
    }

    @Override
    public int size() {
        return setSize;
    }
}
