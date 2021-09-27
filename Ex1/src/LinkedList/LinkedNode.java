package LinkedList;

public class LinkedNode {
    public String val;
    public LinkedNode next;
    public LinkedNode(String v) {val = v; next = null;}
    public LinkedNode(LinkedNode node){
        val= node.val;
        next = node.next;
    }
}
