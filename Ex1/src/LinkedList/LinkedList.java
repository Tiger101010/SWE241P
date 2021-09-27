package LinkedList;

public class LinkedList {

    private LinkedNode head;

    public LinkedList() {
        head = null;
    }

    public LinkedList(LinkedList list) {
        head = list.getHead();
    }

    ;

    public LinkedNode getHead() {
        return head;
    }

    public void setHead(LinkedNode node) {
        head = node;
    }

    public LinkedNode pushFront(LinkedNode node) {
        LinkedNode newNode = new LinkedNode(node);
        newNode.next = head;
        head = newNode;
        return head;
    }

    public LinkedNode find(String word) {
        LinkedNode walk = getHead();
        while (null != walk) {
            if (walk.val.equals(word)) {
                return walk;
            }
            walk = walk.next;
        }
        return null;
    }


    public static void main(String args[]) {
        LinkedList l = new LinkedList();
        LinkedNode a = new LinkedNode("hello");
        l.setHead(a);

        LinkedNode b = new LinkedNode("world");
        l.pushFront(b);


        LinkedNode walk = l.getHead();
        while (null != walk) {
            System.out.println(walk.val);
            walk = walk.next;
        }
        return;
    }
}


