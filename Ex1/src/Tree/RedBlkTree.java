package Tree;

public class RedBlkTree {

    private Node root;
    private int size;

    public RedBlkTree(){
        root = null;
        size = 0;
    }

    public Node getNode(String key){
        Node p = root;
        while(p != null){
            int cmp = key.compareTo(p.getKey());
            if(cmp > 0){
                p = p.right;
            } else if(cmp < 0) {
                p = p.left;
            } else {
                return p;
            }
        }
        return null;
    }

    public int size(){
        return this.size;
    }

    public Node putNode(String key){
        Node p = root;
        if(key == null){
            return null;
        }
        if(p == null) {
            root = new Node(key, null);
            size = 1;
            return root;
        }

        Node parent = null;
        int cmp = 0;
        while(p != null){
            parent = p;
            cmp = key.compareTo(p.getKey());
            if(cmp > 0){
                p = p.right;
            } else if(cmp < 0) {
                p = p.left;
            } else {
                return null;
            }
        }

        Node n = new Node(key, parent);
        if(cmp > 0) {
            parent.right = n;
        } else {
            parent.left = n;
        }
        reBalance(n);
        size++;

        return n;
    }

    private static boolean colorOf(Node n) {
        return (n == null ? BLK : n.color);
    }

    private static Node parentOf(Node n) {
        return (n == null) ? null : n.parent;
    }

    private static Node leftOf(Node n) {
        return (n == null) ? null : n.left;
    }

    private static Node rightOf(Node n) {
        return (n == null) ? null : n.right;
    }

    private static void setColor(Node n, boolean c){
        if(n != null) {
            n.color = c;
        }
    }

    private void rotateLeft(Node p) {
        if (p != null) {
            Node r = p.right;
            p.right = r.left;
            if (r.left != null)
                r.left.parent = p;
            r.parent = p.parent;
            if (p.parent == null)
                root = r;
            else if (p.parent.left == p)
                p.parent.left = r;
            else
                p.parent.right = r;
            r.left = p;
            p.parent = r;
        }
    }

    /** From CLR */
    private void rotateRight(Node p) {
        if (p != null) {
            Node l = p.left;
            p.left = l.right;
            if (l.right != null) l.right.parent = p;
            l.parent = p.parent;
            if (p.parent == null)
                root = l;
            else if (p.parent.right == p)
                p.parent.right = l;
            else p.parent.left = l;
            l.right = p;
            p.parent = l;
        }
    }

    /** From CLR */
    private void reBalance(Node x) {
        x.color = RED;

        while (x != null && x != root && x.parent.color == RED) {
            if (parentOf(x) == leftOf(parentOf(parentOf(x)))) {
                Node y = rightOf(parentOf(parentOf(x)));
                if (colorOf(y) == RED) {
                    setColor(parentOf(x), BLK);
                    setColor(y, BLK);
                    setColor(parentOf(parentOf(x)), RED);
                    x = parentOf(parentOf(x));
                } else {
                    if (x == rightOf(parentOf(x))) {
                        x = parentOf(x);
                        rotateLeft(x);
                    }
                    setColor(parentOf(x), BLK);
                    setColor(parentOf(parentOf(x)), RED);
                    rotateRight(parentOf(parentOf(x)));
                }
            } else {
                Node y = leftOf(parentOf(parentOf(x)));
                if (colorOf(y) == RED) {
                    setColor(parentOf(x), BLK);
                    setColor(y, BLK);
                    setColor(parentOf(parentOf(x)), RED);
                    x = parentOf(parentOf(x));
                } else {
                    if (x == leftOf(parentOf(x))) {
                        x = parentOf(x);
                        rotateRight(x);
                    }
                    setColor(parentOf(x), BLK);
                    setColor(parentOf(parentOf(x)), RED);
                    rotateLeft(parentOf(parentOf(x)));
                }
            }
        }
        root.color = BLK;
    }



    private static boolean BLK = true;
    private static boolean RED = false;

    public static class Node {
        private String key;
        Node left = null;
        Node right = null;
        Node parent;
        boolean color = BLK;

        public Node(String key, Node parent){
            this.key = key;
            this.parent = parent;
        }

        public String getKey(){
            return key;
        }
    }
}
