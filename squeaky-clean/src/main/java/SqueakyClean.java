import java.util.HashMap;
import java.util.Map;

class SqueakyClean {

    private static final Map<Character, Character> LEETSPEAK = Map.of(
            '4', 'a',
            '3', 'e',
            '0', 'o',
            '1', 'l',
            '7', 't');

    static String clean(String identifier) {
        StringBuilder builder = new StringBuilder();
        boolean lastCharWasADash = false;

        for (char character : identifier.toCharArray())
        {
            var cleaned = cleanCharacter(character, lastCharWasADash);

            if (cleaned != null) {
                builder.append(cleaned);
            }

            lastCharWasADash = character == '-';

        }
        return builder.toString();
    }

    private static Character cleanCharacter(
            char character,
            boolean lastCharWasADash
    ) {
        if (Character.isWhitespace(character)) {
            return '_';
        }

        var replacement = LEETSPEAK.get(character);
        if (replacement != null) {
            return replacement;
        }

        else if (!Character.isLetterOrDigit(character)) {
            return null;
        }

        return lastCharWasADash ? Character.toUpperCase(character) : character;
    }

}