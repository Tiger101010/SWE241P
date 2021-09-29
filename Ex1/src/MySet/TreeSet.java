package MySet;

import Tree.RedBlkTree;

public class TreeSet implements Set {
    RedBlkTree BST;

    public TreeSet(){
        BST = new RedBlkTree();
    }

    @Override
    public boolean contains(String word) {
        return (BST.getNode(word) != null);
    }

    @Override
    public boolean add(String word) {
        return (BST.putNode(word) != null);
    }

    @Override
    public int size() {
        return BST.size();
    }
}
