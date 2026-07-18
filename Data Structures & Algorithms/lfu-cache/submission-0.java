class Node {
    int key, val , freq;
    Node prev,next;
    Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.freq = 1;
    }
}

//this is the cache having all nodes
class DoubleLL {
    private Node left,right;
    private int size;

    DoubleLL(){
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.left.next = this.right;
        this.right.prev = this.left;
        this.size = 0;
    }
    public int length() {
        return size;
    }

    public void pushRight(Node node) {
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
        size++;
    }
    public void pop(Node node) {
        Node prev = node.prev, next = node.next;
        prev.next = next;
        next.prev = prev;
        node.next = null;
        node.prev = null;
        size--;
    }
    public Node popLeft() {
        Node node = this.left.next;
        pop(node);
        return node;
    }
}

class LFUCache {
    private int capacity;
    private int minFreq;
    private Map<Integer, Node> nodemap;
    private Map<Integer,DoubleLL> listmap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.nodemap= new HashMap<>();
        this.listmap = new HashMap<>();
        
    }
    private void counter(Node node){
        int c = node.freq;
        listmap.get(c).pop(node);

        if(c == minFreq && listmap.get(c).length() == 0) {
            minFreq++;
        }
        node.freq++;
        listmap.putIfAbsent(node.freq, new DoubleLL());
        listmap.get(node.freq).pushRight(node);
    }
    
    public int get(int key) {
        if(!nodemap.containsKey(key)) {
            return -1;
        }
        Node node = nodemap.get(key);
        counter(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;

        if(nodemap.containsKey(key)){
            Node node = nodemap.get(key);
            node.val = value;
            counter(node);
            return;
        }
        if(nodemap.size() == capacity) {
            Node remove = listmap.get(minFreq).popLeft();
            nodemap.remove(remove.key);
        }
        Node node = new Node(key,value);
        nodemap.put(key, node);
        listmap.putIfAbsent(1, new DoubleLL());
        listmap.get(1).pushRight(node);
        minFreq = 1;

        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */