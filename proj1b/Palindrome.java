public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        //Answer Source: https://stackoverflow.com/questions/5235401/split-string-into-array-of-character-strings
        char[] parts = word.toCharArray();
        Deque<Character> L = new ArrayDeque<>();
        for (int i = 0; i < parts.length; i += 1) {
            L.addLast(parts[i]);
        }
        return L;
    }

    /** use the get() method
     * Don’t use the get method of Deque. That will just make things unnecessarily complicated.
     **/
    public boolean isPalindrome(String word) {
        Deque<Character> L = wordToDeque(word);
        while (L.get(0) == L.get(L.size()-1) && L.get(0) != null) {
            L.removeFirst();
            L.removeLast();
        }
        if (L.size() == 0 || L.size() == 1) return true;
        else return false;
    }
    /** Try Recursive method
     * Cannot figure out this without using get method
     public boolean isPalindrome(String word) {
     Deque<Character> L = wordToDeque(word);
     return L.isPalinDeque();
     }*/

    /**The method will return true if the word is a palindrome
     * according to the character comparison test provided by the CharacterComparator passed in as argument cc.
     */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> L = wordToDeque(word);
        while (L.get(0) != null && L.get(L.size()-1) != null && cc.equalChars(L.get(0), L.get(L.size() - 1))) {
            L.removeFirst();
            L.removeLast();
        }
        if (L.size() == 0 || L.size() == 1) return true;
        else return false;
    }





}
