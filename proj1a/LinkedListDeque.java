
public class LinkedListDeque<T> {
    private class StuffNode {
        private StuffNode prev;
        private T item;
        private StuffNode next;

        private StuffNode(StuffNode p, T i, StuffNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private StuffNode sentinel;
    private int size;
    private StuffNode first;
    private StuffNode last;
    //private ReverseNode reFirst;

    public LinkedListDeque() {
        sentinel = new StuffNode(null, null, null);
        size = 0;
    }
    /**
     * Creating a deep copy means that you create an entirely new LinkedListDeque,
     * with the exact same items as other. However, they should be different objects,
     * i.e. if you change other, the new LinkedListDeque you created should not change as well.
     */
    public LinkedListDeque(LinkedListDeque other) {
        sentinel = new StuffNode(null, null, null);
        size = 0;
        for (int i = 0; i < other.size(); i += 1) {
            addLast((T) other.get(i));
        }
    }

    public boolean isEmpty() {
        if (sentinel.next == null) return true;
        else return false;
    }

    public void addFirst(T x) {
        if (sentinel.next == null) {
            sentinel.next = new StuffNode(sentinel, x, null);
            last = sentinel.next;
            first = sentinel.next;
            sentinel.prev = last;
        }
        else {
            sentinel.next = new StuffNode(sentinel, x, sentinel.next);
            first.prev = sentinel.next;
            first = sentinel.next;
        }
        size += 1;
    }

    public void addLast(T x) {
        if (sentinel.next == null) {
            sentinel.next = new StuffNode(sentinel, x, null);
            last = sentinel.next;
            first = sentinel.next;
        }
        else {
            last.next = new StuffNode(last, x, null);
            last = last.next;
            sentinel.prev = last;
        }
        size += 1;
    }

    public T removeFirst() {
        StuffNode Q = first;
        if (Q == null ) return null;
        else if (Q.next == null) {
            sentinel.next = null;
            sentinel.prev = null;
            first = null;
            last = null;
        }
        else {
            sentinel.next = sentinel.next.next;
            first = sentinel.next;
            first.prev = sentinel;
        }
        size -= 1;
        return Q.item;
    }

    public T removeLast() {
        StuffNode Q = last;
        if (Q == null ) return null;
        last.prev.next = null;
        last = last.prev;
        sentinel.prev = last;
        size -= 1;
        return Q.item;
    }

    public T get(int x) {
        StuffNode Q = first;
        if (Q == null) return null;
        if (x >= size || x < 0) return null;
        int i = 0;
        while (i < x) {
            Q = Q.next;
            i += 1;
        }
        return Q.item;
    }

    public LinkedListDeque<T> Replicate() {
        LinkedListDeque<T> Q = new LinkedListDeque<>();
        Q.first = this.first;
        Q.last = this.last;
        Q.sentinel = this.sentinel;
        Q.size = this.size;
        return Q;
    }

    public T getRecursive(int x) {
        if (first == null) return null;
        if (x >= size) return null;
        else if (x == 0) return this.first.item;
        LinkedListDeque<T> Q = this.Replicate();
        x -= 1;
        Q.first = Q.first.next;
        return Q.getRecursive(x);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        StuffNode Q = first;
        if (this.isEmpty()) System.out.println("This is an empty list.");;
        while (Q != null) {
            System.out.print(Q.item + " ");
            Q = Q.next;
        }
        System.out.println();
    }
/** main not needed
    public static void main(String[] args) {
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
       // L.isEmpty();
        L.addLast(25);
        //L.addLast(26);
        //L.addLast(27);
        //L.removeFirst();
        //System.out.println(L.removeLast());
       // System.out.println(L.get(0));
       // System.out.println(L.getRecursive(0));

        L.printDeque();
        System.out.println(L.size());
    //
     //

    }*/


}
