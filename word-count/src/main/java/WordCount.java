import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class WordCount {

    public static void main(String[] args) {
        System.out.println(phrase("car Car car"));
    }

    public static Map<String, Integer> phrase(String input) {
        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = removeSymbols(input).split(" ");

        for (String word : words) {
            String toLower = word.toLowerCase();
            if (!wordCount.containsKey(toLower)) {
                wordCount.put(toLower, 1);
            } else {
                Integer count = wordCount.get(toLower);
                wordCount.replace(toLower, ++count);
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
                builder.append(c);
                isWhiteSpace = true;
                continue;
            } else if (Character.isLetterOrDigit(c)) {
                builder.append(c);
                continue;
            } else if (c == '\'') {
                if (isWhiteSpace) {
                    isWhiteSpace = false;
                    continue;
                } else {
                    builder.append(c);
                    continue;
                }
            }
        }
        return builder.toString();
    }
}
