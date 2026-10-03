import java.util.HashMap;
import java.util.Map;

class SqueakyClean {

    private static final Map<Character, Character> leetspeakMap = Map.of(
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
            Character replacement = leetspeakMap.get(character);
            if (replacement != null) {
                builder.append(replacement);
            } else if (character == '-') {
                lastCharWasADash = true;
            } else if (Character.isWhitespace(character)) {
                builder.append('_');
            } else if (lastCharWasADash) {
                lastCharWasADash = false;
                builder.append(Character.toUpperCase(character));
            }  else if (Character.isLetterOrDigit(character)){
                builder.append(character);
            }
        }
        return builder.toString();
    }

    private static Character cleanCharacter(
            char character,
            boolean lastCharWasADash
    ) {
        Character replacement = leetspeakMap.get(character);
        if (replacement != null) {
            return replacement;
        } else if (character == '-') {
            lastCharWasADash = true;
        } else if (Character.isWhitespace(character)) {
            return '_';
        } else if (lastCharWasADash) {
            lastCharWasADash = false;
            return Character.toUpperCase(character);
        }
        return '1';
    }

}