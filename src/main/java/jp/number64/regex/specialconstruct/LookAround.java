package jp.number64.regex.specialconstruct;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * lookahead/lookbehind  <br>
 * <br>
 * (?=X) X, via zero-width positive lookahead
 * (?!X) X, via zero-width negative lookahead
 * (?<=X) X, via zero-width positive lookbehind
 * (?<!X) X, via zero-width negative lookbehind
 * <br>
 */
public class LookAround {
    private static final Logger LOGGER = LoggerFactory.getLogger(LookAround.class);

    /** (?=X) X, via zero-width positive lookahead */
    public static final String EXP_POSITIVE_LOOKAHEAD = "(?=)";
    /** (?!X) X, via zero-width negative lookahead */
    public static final String EXP_NEGATIVE_LOOKAHEAD = "(?!)";
    /** (?<=X) X, via zero-width positive lookbehind */
    public static final String EXP_POSITIVE_LOOKBEHIND = "(?<=)";
    /** (?<!X) X, via zero-width negative lookbehind */
    public static final String EXP_NEGATIVE_LOOKBEHIND = "(?<!)";
    /** combination-A */
    public static final String EXP_LOOKAROUND_A = "";
    /** combination-B */
    public static final String EXP_LOOKAROUND_B = "";


    // -----------------------------------------------------------------------------------------------

    private static final Pattern PATTERN_POSITIVE_LOOKAHEAD = Pattern.compile(EXP_POSITIVE_LOOKAHEAD);
    private static final Pattern PATTERN_NEGATIVE_LOOKAHEAD = Pattern.compile(EXP_NEGATIVE_LOOKAHEAD);
    private static final Pattern PATTERN_POSITIVE_LOOKBEHIND = Pattern.compile(EXP_POSITIVE_LOOKBEHIND);
    private static final Pattern PATTERN_NEGATIVE_LOOKBEHIND = Pattern.compile(EXP_NEGATIVE_LOOKBEHIND);
    private static final Pattern PATTERN_LOOKAROUND_A = Pattern.compile(EXP_LOOKAROUND_A);
    private static final Pattern PATTERN_LOOKAROUND_B = Pattern.compile(EXP_LOOKAROUND_B);


    public boolean findPositiveLookAhead(String text) {
        boolean result = PATTERN_POSITIVE_LOOKAHEAD.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findNegativeLookAhead(String text) {
        boolean result = PATTERN_NEGATIVE_LOOKAHEAD.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findPositiveLookBehind(String text) {
        boolean result = PATTERN_POSITIVE_LOOKBEHIND.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findNegativeLookBehind(String text) {
        boolean result = PATTERN_NEGATIVE_LOOKBEHIND.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findLookAroundA(String text) {
        boolean result = PATTERN_LOOKAROUND_A.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findLookAroundB(String text) {
        boolean result = PATTERN_LOOKAROUND_B.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }
}