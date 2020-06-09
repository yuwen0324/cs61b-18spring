public class ArrayDeque<T> {

    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] items;
   // private double Rfactor;

    public ArrayDeque() {
        size = 0;
        nextFirst = 4;
        nextLast = 5;
        items = (T[]) new Object[8];
       // Rfactor = size / items.length;
    }

    public ArrayDeque(ArrayDeque other) {
        size = 0;
        nextFirst = 4;
        nextLast = 5;
        items = (T[]) new Object[8];
        for (int i = 0; i < other.size(); i += 1) {
            addLast((T) other.get(i));
        }
    }

    public void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, nextLast);
        System.arraycopy(items, nextLast, a, nextLast+capacity-size, size-nextLast);
        if (nextLast > nextFirst) {
            nextFirst += capacity-size;
        }
        else if (nextLast < nextFirst) {
            nextFirst = capacity-size-nextLast-1;
        }
        items = a;
    }

    public void desize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        if (nextLast > nextFirst) {
            System.arraycopy(items, nextFirst+1, a, 0, size);
            nextLast = 0;
            nextFirst = a.length - 1;
        }
        else if (nextLast < nextFirst) {
            System.arraycopy(items, 0, a, 0, nextLast);
            System.arraycopy(items,nextFirst+1, a, nextLast, size-nextLast);
            nextFirst = nextLast - 1;
        }
        items = a;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public void addLast(T x) {
        if (size == items.length) {
            this.resize(size*4);
        }
        items[nextLast] = x;
        if (nextLast == items.length-1 && size < items.length) {
            nextLast = 0;
        }
        else {
            nextLast += 1;
        }
        size += 1;
    }

    public void addFirst(T x) {
        if (size == items.length) {
            this.resize(size*4);
        }
        items[nextFirst] = x;
        if (nextFirst == 0 && size < items.length) {
            nextFirst = items.length-1;
        }
        else {nextFirst -= 1;}
        size += 1;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if (size == (items.length/4)) {
            this.desize(items.length/4);
        }
        size -= 1;
        if (nextFirst == items.length-1) {
            T Q = items[0];
            nextFirst = 0;
            return Q;
        }
        else {
            T Q = items[nextFirst+1];
            nextFirst += 1;
            return Q;
        }

    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if (size == (items.length/4)) {
            this.desize(items.length/4);
        }
        size -= 1;
        if (nextLast == 0) {
            T Q = items[items.length-1];
            nextLast = items.length-1;
            return Q;
        }
        else {
            T Q = items[nextLast - 1];
            nextLast -= 1;
            return Q;
        }
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (this.isEmpty()) {
            System.out.println("This is an empty list.");
        }
        else {
            int item = nextFirst+1;
            while (item != nextLast) {
                if (item == nextLast-1) {
                    System.out.println(items[item]);
                }
                else {
                    System.out.print(items[item]+" ");
                }
                if (item == items.length-1) {
                    item = 0;
                }
                else {
                    item += 1;
                }
            }
            }
        }

    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        else if (nextFirst+index+1 >= items.length) {
            return items[nextFirst + index + 1 - items.length];
        }
        else {
            return items[nextFirst + index + 1];
        }
    }

}
