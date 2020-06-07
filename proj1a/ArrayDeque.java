import java.nio.file.LinkOption;
import java.security.PublicKey;

public class ArrayDeque<LochNess> {

    private int size;
    private int nextFirst;
    private int nextLast;
    private LochNess[] items;
   // private double Rfactor;

    public ArrayDeque() {
        size = 0;
        nextFirst = 4;
        nextLast = 5;
        items = (LochNess[]) new Object[8];
       // Rfactor = size / items.length;
    }

    public ArrayDeque(ArrayDeque L) {
        ArrayDeque<String> Q = new ArrayDeque();
        Q.size = this.size;
        System.arraycopy(this, 0, Q, 0, size);

    }

    public void resize(int capacity){
        LochNess[] a = (LochNess[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, nextLast);
        System.arraycopy(items, nextLast, a, nextLast + capacity - size, size - nextLast);
        if ( nextLast > nextFirst ) {nextFirst += capacity - size;}
        else if (nextLast < nextFirst) nextFirst = capacity - size -  nextLast - 1;
        items = a;
    }

    public void desize(int capacity){
        LochNess[] a = (LochNess[]) new Object[capacity];
        if (nextLast > nextFirst) {
            System.arraycopy(items, nextFirst+1, a, 0, size);
            nextLast = 0;
            nextFirst = a.length - 1;
        }
        else if (nextLast < nextFirst) {
            System.arraycopy(items, 0, a, 0, nextLast );
            System.arraycopy(items,nextFirst+1, a, nextLast, size-nextLast);
            nextFirst = nextLast - 1;
        }
        items = a;
    }

    public boolean isEmpty() {
        if (size == 0 ) return true;
        else return false;
    }

    public void addLast(LochNess x) {
        if (size == items.length) {
            this.resize(size * 4);
        }
        items[nextLast] = x;
        if (nextLast == items.length - 1 && size < items.length) {
            nextLast = 0;
        }
        else{nextLast += 1;}
        size += 1;
    }

    public void addFirst(LochNess x) {
        if (size == items.length) {
            this.resize(size * 4);
        }
        items[nextFirst] = x;
        if (nextFirst == 0 && size < items.length) {
            nextFirst = items.length - 1;
        }
        else {nextFirst -= 1;}
        size += 1;
    }

    public LochNess removeFirst() {
        if (size == (items.length/4)) {
            this.desize(items.length / 4);
        }
        size -= 1;
        if (nextFirst == items.length - 1) {
            LochNess Q = items[0];
            nextFirst = 0;
            return Q;
        }
        else {
            LochNess Q = items[nextFirst + 1];
            nextFirst += 1;
            return Q;
        }
    }

    public LochNess removeLast() {
        if (size == (items.length/4)) {
            this.desize(items.length / 4);
        }
        size -= 1;
        if (nextLast == 0) {
            LochNess Q = items[items.length - 1];
            nextLast = items.length - 1;
            return Q;
        }
        else {
            LochNess Q = items[nextLast - 1];
            nextLast -= 1;
            return Q;
        }
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int item = nextFirst + 1;
        while ( item != nextLast ) {
            System.out.println(items[item]);
            if (item == items.length - 1) { item = 0;}
            else {item += 1;}
        }
    }

    public LochNess get(int index) {
        if (index >= size) return null;
        else if (nextFirst + index + 1 >= items.length)
            return items[nextFirst + index + 1 - items.length];
        else return items[ nextFirst + index + 1];
    }

    public static void main(String[] args) {
    ArrayDeque<Integer> L = new ArrayDeque<>();
    L.isEmpty();
        L.addFirst(25);
        L.addFirst(20);
        L.addFirst(15);
        L.addFirst(10);
        L.addFirst(5);
        L.addFirst(0);
        L.addLast(30);
        L.addLast(35);
        L.addLast(40);

        L.addLast(45);
        L.addLast(50);
        L.addLast(55);
        L.addLast(60);
        L.addLast(65);


        L.addFirst(-5);


        L.addLast(70);
        L.addLast(75);
        L.addLast(80);
        L.addLast(85);
        L.addLast(90);
        L.addLast(95);
     L.addFirst(-10);
     L.addFirst(-15);
     L.addFirst(-20);
     L.addFirst(-25);
        L.addFirst(-30);
        L.addFirst(-35);
        L.addFirst(-40);
        L.addFirst(-45);


        L.removeLast();
        L.removeLast();
        L.removeLast();
        L.removeLast();
        L.removeLast();
        L.removeLast();
        L.removeLast();
        L.removeLast();
        L.removeFirst();
        L.removeFirst();
        L.removeFirst();
        L.removeFirst();
        L.removeFirst();
        L.removeFirst();
        L.removeFirst();
        L.removeFirst();
        L.removeLast();
        L.removeLast();
        L.removeLast();
        L.removeLast();
        L.removeLast();
        L.removeLast();
        L.removeLast();

        L.addFirst(-146);
        L.addFirst(-147);
        L.addFirst(-148);
        L.addFirst(-149);
        L.addLast(-114);
        L.addLast(-113);
        L.addLast(-112);
        L.addLast(-111);
        L.addLast(-110);

        L.printDeque();
        System.out.println(L.size());
        System.out.println(L.get(1));
        System.out.println(L.get(5));

}


}
