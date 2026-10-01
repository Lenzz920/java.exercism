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
            int ascii = Character.getNumericValue(c);
            if (leetSpeakCheck(c)) {
                builder.append(leetSpeakConverter(c));
                continue;
            }
            if (c == '-') {
                lastCharWasADash = true;
                continue;
            } else if (lastCharWasADash) {
                lastCharWasADash = false;
                builder.append(Character.toUpperCase(c));
                continue;
            } else if (Character.isWhitespace(c)) {
                c = '_';
            } else if ((ascii > 31 && ascii < 48) ||
                        (ascii > 57 && ascii < 65) ||
                        (ascii > 90 && ascii < 97) ||
                        (ascii > 122 && ascii < 256)){
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