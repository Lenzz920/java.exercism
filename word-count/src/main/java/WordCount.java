import java.util.HashMap;
import java.util.Map;

class WordCount {

    public static void main(String[] args) {
        System.out.println(phrase("can't"));
    }

    public static Map<String, Integer> phrase(String input) {
        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = removeSymbols(input).split(" ");

        for (String word : words) {
            String toLower = word.toLowerCase();
            if (word.isEmpty()) {
            } else if (toLower.startsWith("'")) {
               toLower = toLower.substring(1);
            } else if (toLower.endsWith("'")) {toLower = toLower.substring(toLower.length());
            }
            if (!wordCount.containsKey(toLower)) {
                wordCount.put(toLower, 1);
            } else if (wordCount.containsKey(toLower)){
                wordCount.replace(toLower, wordCount.get(toLower) + 1);
            }
        }
        return wordCount;
    }

    public static String removeSymbols(String input) {
        char[] charArray = input.toCharArray();
        StringBuilder builder = new StringBuilder();
        boolean isWhiteSpace = false;

        for (char c : charArray) {
            if (Character.isWhitespace(c)) {
                isWhiteSpace = true;
                builder.append(' ');
            } else if (Character.isLetterOrDigit(c)) {
                builder.append(c);
            } else if (c == '\'') {
                if (isWhiteSpace) {
                    isWhiteSpace = false;
                    builder.append(c);
                } else {
                    isWhiteSpace = false;
                }
            } else {
                builder.append(" ");
            }
        }
        return builder.toString();
    }
}
