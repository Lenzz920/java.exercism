import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

class WordCount {

  public Map<String, Integer> phrase(String input) {
    Map<String, Integer> wordCounts = new HashMap<>();
    String[] words = removeSymbols(input).split("\\s+");

    for (String word : words) {
      String normalizedWord = word.toLowerCase(Locale.ROOT);
      while (normalizedWord.startsWith("'")) {
        normalizedWord = normalizedWord.substring(1);
      }
      while (normalizedWord.endsWith("'")) {
        normalizedWord = normalizedWord.substring(
                0,
                normalizedWord.length() - 1
        );
      }
      if (normalizedWord.isEmpty()) {
        continue;
      }
      wordCounts.merge(normalizedWord, 1, Integer::sum);
    }
    return wordCounts;
  }

  private static String removeSymbols(String input) {
    StringBuilder builder = new StringBuilder();

    for (char character : input.toCharArray()) {
      if (Character.isLetterOrDigit(character) || character == '\'') {
        builder.append(character);
      } else {
        builder.append(' ');
      }
    }
    return builder.toString();
  }
}
