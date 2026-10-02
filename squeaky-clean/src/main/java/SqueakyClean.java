import java.util.HashMap;
import java.util.Map;

class SqueakyClean {

    static Map<Character, Character> leetspeakMap = Map.of(
            '4', 'a',
            '3', 'e',
            '0', 'o',
            '1', 'l',
            '7', 't');

    static String clean(String identifier) {
        StringBuilder builder = new StringBuilder();
        char[] identifierChars = identifier.toCharArray();
        boolean lastCharWasADash = false;

        for (char c : identifierChars) {
            if (leetSpeakCheck(c)) {
                builder.append(leetSpeakConverter(c));
                continue;
            } else if (c == '-') {
                lastCharWasADash = true;
                continue;
            } else if (lastCharWasADash) {
                lastCharWasADash = false;
                builder.append(Character.toUpperCase(c));
                continue;
            } else if (Character.isWhitespace(c)) {
                builder.append('_');
                continue;
            } else if (((int) c > 32 && (int) c < 48) ||
                        ((int) c > 57 && (int) c < 65) ||
                        ((int) c > 90 && (int) c < 97) ||
                        ((int) c > 122 && (int) c < 256)){
                continue;
            }
            builder.append(c);
        }
        return builder.toString();
    }

    public static boolean leetSpeakCheck(char c) {
        return leetspeakMap.containsKey(c);
    }

    public static char leetSpeakConverter(char c) {
        return leetspeakMap.get(c);
    }
}