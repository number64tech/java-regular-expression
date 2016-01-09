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
    /** prefix matching (starts-with) */
    public static final String PATTERN_PREFIX_MATCHING_ESC = "\\ANUMBER64";
    /** suffix matching (ends-with) */
    public static final String PATTERN_SUFFIX_MATCHING_ESC = "NUMBER64\\Z";

    // methods

    public boolean findPartialMatching(final String text);
    public boolean findPerfectMatching(final String text);
    public boolean findPrefixMatching(final String text);
    public boolean findSuffixMatching(final String text);
    public boolean findPrefixMatchingEsc(final String text);
    public boolean findSuffixMatchingEsc(final String text);
}