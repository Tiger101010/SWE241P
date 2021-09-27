package MySet;

public interface Set {

    /*
        Returns true if the word was added
        and returns false if the word is already present in the set.
    */
    default boolean add(String word) {
        return false;
    }

    /*
        Takes a word as input and returns whether the
        word is present in the set (true) or not (false).
    */
    default boolean contains(String word) {
        return false;
    }

    /* Returns the size of the set. */
    default int size() {
        return 0;
    }
}
