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

    private ArrayDeque(ArrayDeque other) {
        size = 0;
        nextFirst = 4;
        nextLast = 5;
        items = (T[]) new Object[8];
        for (int i = 0; i < other.size(); i += 1) {
            addLast((T) other.get(i));
        }
    }

    private void resize(int capacity) {
        T[] sizedArray = (T[]) new Object[capacity];
        System.arraycopy(items, 0, sizedArray, 0, nextLast);
        System.arraycopy(items, nextLast, sizedArray, nextLast + capacity - size, size - nextLast);
        if (nextLast > nextFirst) {
            nextFirst += capacity - size;
        } else if (nextLast < nextFirst) {
            nextFirst = capacity - size - nextLast - 1;
        }
        items = sizedArray;
    }

    private void desize(int capacity) {
        T[] sizedArray = (T[]) new Object[capacity];
        if (nextLast > nextFirst) {
            System.arraycopy(items, nextFirst + 1, sizedArray, 0, size);
            nextLast = 0;
            nextFirst = sizedArray.length - 1;
        } else if (nextLast < nextFirst) {
            System.arraycopy(items, 0, sizedArray, 0, nextLast);
            System.arraycopy(items, nextFirst + 1, sizedArray, nextLast, size - nextLast);
            if (nextLast == 0) {
                nextFirst = sizedArray.length - 1;
            } else {
                nextFirst = nextLast - 1;
            }
        }
        items = sizedArray;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(T x) {
        if (size == items.length) {
            this.resize(size * 4);
        }
        if (nextLast == items.length - 1) {
            items[nextLast] = x;
            nextLast = 0;
        } else if (nextLast < items.length - 1) {
            items[nextLast] = x;
            nextLast += 1;
        } else {
            items[0] = x;
            nextLast = 1;
        }
        size += 1;
    }

    public void addFirst(T x) {
        if (size == items.length) {
            this.resize(size * 4);
        }
        items[nextFirst] = x;
        if (nextFirst == 0) {
            nextFirst = items.length - 1;
        } else if (nextFirst > 0) {
            nextFirst -= 1;
        }
        size += 1;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if (size == (items.length / 4)) {
            this.desize(items.length / 4);
        }
        size -= 1;
        if (nextFirst == items.length - 1) {
            T Q = items[0];
            nextFirst = 0;
            return Q;
        } else {
            T Q = items[nextFirst + 1];
            nextFirst += 1;
            return Q;
        }

    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if (size == (items.length / 4)) {
            this.desize(items.length / 4);
        }
        size -= 1;
        if (nextLast == 0) {
            T Q = items[items.length - 1];
            nextLast = items.length - 1;
            return Q;
        } else {
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
        } else {
            for (int i = 0; i < size; i += 1) {
                System.out.print(this.get(i) + " ");
            }
            System.out.println();
        }
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        if (nextFirst + index + 1 >= items.length) {
            return items[nextFirst + index + 1 - items.length];
        } else {
            return items[nextFirst + index + 1];
        }
    }


    public static void main(String[] args) {
        ArrayDeque<Integer> A = new ArrayDeque<>();
        A.addLast(10);
        A.addLast(20);
        A.addLast(30);
        A.addLast(40);
        A.addLast(50);
        A.addLast(10);
    }

}
