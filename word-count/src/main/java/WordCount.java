import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

class WordCount {
    public static void main(String[] args) {
        String s = "This is a first test test";
        phrase(s);
    }

    public static Map<String, Integer> phrase(String input) {
        Map<String, Integer> counts = new HashMap<>();
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if ( Character.isLetterOrDigit(c) ) {
                word.append(c);
            } else if (Character.isLetter(c)) {
                // part of a contraction — add it to `word`

            } else {
                // anything else ends the current word
                // TODO 3: if `word` has something in it, record it, then empty it
            }
        }

        // TODO 4: the loop is over. Is anything still sitting in `word`?

        return counts;
    }
}