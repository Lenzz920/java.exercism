import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

class WordCount {
    public static void main(String[] args) {
        String s = "This is a first test test";
    }

    public Map<String, Integer> phrase(String input) {
        Map<String, Integer> wordMap = new HashMap<>();
        String currentWord = "";

        while (input)
        if(!wordMap.containsKey(currentWord)) {
            wordMap.put(currentWord.toLowerCase(Locale.ROOT), 1);
        } else {
            wordMap.put(currentWord.toLowerCase(), wordMap.getValue() + 1);
        }

        return wordMap;
    }
}