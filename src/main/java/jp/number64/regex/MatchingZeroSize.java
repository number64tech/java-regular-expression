package jp.number64.regex;

public interface MatchingZeroSize {

    // position

    /** partial matching (basic) */
    public static final String PATTERN_PARTIAL_MATCHING = "NUMBER64";
    /** perfect matching () */
    public static final String PATTERN_PERFECT_MATCHING = "^NUMBER64$";
    /** prefix matching (starts-with) */
    public static final String PATTERN_PREFIX_MATCHING = "^NUMBER64";
    /** suffix matching (ends-with) */
    public static final String PATTERN_SUFFIX_MATCHING = "NUMBER64$";




    // methods

    public boolean checkPartialMatching(final String text);
    public boolean checkPerfectMatching(final String text);
    public boolean checkPrefixMatching(final String text);
    public boolean checkSuffixMatching(final String text);

}