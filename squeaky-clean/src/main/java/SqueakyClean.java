class SqueakyClean {

    static String clean(String identifier) {
        StringBuilder builder = new StringBuilder();
        char[] identifierChars = identifier.toCharArray();
        for(char c: identifierChars) {
            if(Character.isWhitespace(c)) {
                c = '_';
            } else if (c == '-') {
                if(Character.isLetter(c)) {
                    //if c is a -, then it should remove the -. If the next char is a letter, then capitalize that letter
                }
            }
            builder.append(c);
        }
        return builder.toString();
    }
}