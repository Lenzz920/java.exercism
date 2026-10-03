import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class WordCount {
    public static Map<String, Integer> phrase(String input) {
        Map<String, Integer> wordCount = new HashMap<>();
        String [] words = input.split(" ");

        for(String word : words) {
            String toLower = word.toLowerCase();
            if(!wordCount.containsKey(toLower)) {
                wordCount.put(toLower, 1);
            } else {
                Integer count = wordCount.get(toLower);
                wordCount.replace(toLower, ++count);
            }
        }
        return wordCount;
    }

    public static void main(String[] args) {
        System.out.println(phrase("car Car car"));
    }
}
