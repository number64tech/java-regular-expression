package jp.number64.regex;

public interface MatchingCharactorClass {

    // char-class

    /***/
    public static final String PATTERN_SPECIFIC_CHARS = "[nN][uU]MBER64";
    /***/
    public static final String PATTERN_RANGE_CHARS = "[a-z][A-Z]MBER[0-9][4-6]";

    // methods

    public boolean findSpecificChars(final String text);
    public boolean findRangeChars(final String text);
}
