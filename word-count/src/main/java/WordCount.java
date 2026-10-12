import java.util.HashMap;
import java.util.Map;

class WordCount {

    public Map<String, Integer> phrase(String input) {
        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = removeSymbols(input).split(" ");

        for (String word : words) {
            String toLower = word.toLowerCase();
            while (toLower.startsWith("'")) {
               toLower = toLower.substring(1);
            }
            while (toLower.endsWith("'")) {
                toLower = toLower.substring(0, toLower.length() - 1);
            }
            if(toLower.isEmpty()) {
                continue;
            }
        if (!wordCount.containsKey(toLower)) {
            wordCount.put(toLower, 1);
        } else {
            wordCount.replace(toLower, wordCount.get(toLower) + 1);
        }
    }
        return wordCount;
    }

    public String removeSymbols(String input) {
        char[] charArray = input.toCharArray();
        StringBuilder builder = new StringBuilder();

        for (char c : charArray) {
            if (Character.isLetterOrDigit(c) || c == '\'') {
                builder.append(c);
            } else {
                builder.append(" ");
            }
        }
        return builder.toString();
    }
}
