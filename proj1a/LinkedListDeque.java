public class LinkedListDeque<LochNess> {
    private class StuffNode {
        public StuffNode prev;
        public LochNess item;
        public StuffNode next;

        public StuffNode(StuffNode p, LochNess i, StuffNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }
/** Cannot figure out by this way
    private class ReverseNode {
        public LochNess reitem;
        public ReverseNode front;

        public ReverseNode(ReverseNode n, LochNess i) {
           front = n;
           reitem = i;
        }
    }*/

    private StuffNode sentinel;
    private int size;
    private StuffNode first;
    private StuffNode last;
    //private ReverseNode reFirst;

    public LinkedListDeque() {
        sentinel = new StuffNode(null, null, null);
        size = 0;
    }

    public boolean isEmpty() {
        if (sentinel.next == null) return true;
        return false;
    }

    /** Do not needed in this case
    public LinkedListDeque(LochNess x) {
        first = new StuffNode(x, null);
        last = first;
        size = 1;
    }*/

    public void addFirst(LochNess x) {
        size += 1;
        if (this.isEmpty()) {
            sentinel.next = new StuffNode(sentinel, x, sentinel.next);
            last = sentinel.next;
            first = sentinel.next;
            sentinel.prev = last;
        }
        else {
            sentinel.next = new StuffNode(sentinel, x, sentinel.next);
            first.prev = sentinel.next;
            first = sentinel.next;
        }
    }

    public void addLast(LochNess x) {
        size += 1;
        if (this.isEmpty()) {
            sentinel.next = new StuffNode(sentinel, x, sentinel.next);
            last = sentinel.next;
            first = sentinel.next;
        }
        else {
            last.next = new StuffNode(last, x, null);
            last = last.next;
            sentinel.prev = last;
        }
    }


    public LochNess removeFirst() {
        size -= 1;
        StuffNode Q = first;
        if (Q.item == null ) return null;
        else if (Q.next == null) {
            sentinel.next = null;
            sentinel.prev = null;
            first = null; last = null;
        }
        else {
            sentinel.next = sentinel.next.next;
            first = sentinel.next;
            first.prev = sentinel;
        }
        return Q.item;
    }


    public LochNess removeLast() {
        size -=1;
        StuffNode Q = last;
        if (Q.item == null ) return null;
        else if (Q.next == null) {
            sentinel.next = null;
            sentinel.prev = null;
            first = null; last = null;
        }
        else {
          last.prev.next = null;
          last = last.prev;
          sentinel.prev = last;
        }
        return Q.item;
    }

    public LochNess get(int x) {
        StuffNode Q = first;
        int i = 0;
        while (i < x) {
            Q = Q.next;
            i += 1;
        }
        return Q.item;
    }

    public LinkedListDeque<LochNess> Replicate() {
        LinkedListDeque<LochNess> Q = new LinkedListDeque<>();
        Q.first = this.first;
        Q.last = this.last;
        Q.sentinel = this.sentinel;
        Q.size = this.size;
        return Q;
    }

    public LochNess getRecursive(int x) {
        if (x == 0) return this.first.item;
        LinkedListDeque<LochNess> Q = this.Replicate();
        x -= 1;
        Q.first = Q.first.next;
        return Q.getRecursive(x);
    }


    public int size() {
        return size;
    }

    public void printDeque() {
        StuffNode Q = first;
        while (Q != null) {
        System.out.println(Q.item);
        Q = Q.next;
        }
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        L.isEmpty();
        L.addLast(25);

        L.removeLast();

        System.out.println(L.get(2));
        System.out.println(L.getRecursive(2));
        System.out.println(L.size());
        L.printDeque();
    //
     //

    }


}
