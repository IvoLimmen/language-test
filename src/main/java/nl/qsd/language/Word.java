package nl.qsd.language;


public class Word implements Comparable<Word> {

    private final String word;

    private final char[] letters;
    
    private final boolean strict;
    
    public Word(String word) {
        this(word, false);
    }
    
    public Word(String word, boolean strict) {
        if (word == null) {
            word = "";
        }

        this.word = word;
        this.strict = strict;
        this.letters = this.word.toCharArray();
    }

    public int length() {
        return this.word.length();
    }
    
    public boolean isAbrivate() {

        for (char letter : letters) {
            if (!Character.isUpperCase(letter)) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean isAscendingOrder() {
        
        char previous = letters[0];

        for (int i = 1; i < letters.length; i++) {
            char current = letters[i];
            if (previous > current) {
                return false;
            }
            if (strict && previous == current) {
                return false;
            }

            previous = current;
        }

        return true;
    }

    public boolean isDescendingOrder() {
        
        char previous = letters[0];

        for (int i = 1; i < letters.length; i++) {
            char current = letters[i];
            if (previous < current) {
                return false;
            }
            if (strict && previous == current) {
                return false;
            }

            previous = current;
        }

        return true;
    }
    
    @Override
    public String toString() {
        return this.word;
    }

    @Override
    public int compareTo(Word o) {
        return this.word.compareTo(o.word);
    }
}
