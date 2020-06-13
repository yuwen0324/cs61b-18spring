public class OffByN implements CharacterComparator {
    private int N;

    public OffByN(int x) {
        N = x;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        if (Math.abs(diff) == N) return true;
        else return false;
    }

}
