/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> oldcopy = new HashMap<>();
        oldcopy.put(null, null);
        Node cur = head;
        while(cur != null) {
            oldcopy.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while(cur != null) {
            Node copy = oldcopy.get(cur);
            copy.next = oldcopy.get(cur.next);
            copy.random = oldcopy.get(cur.random);
            cur = cur.next;
        }
        return oldcopy.get(head);

        
    }
}
