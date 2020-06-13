public interface Deque<T> {

    public void addFirst(T x);
    public void addLast(T x);
    public T removeFirst();
    public T removeLast();
    public T get(int x);
    public int size();
    public void printDeque();

}
