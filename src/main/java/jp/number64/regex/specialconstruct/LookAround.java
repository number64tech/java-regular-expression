package jp.number64.regex.specialconstruct;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * lookahead/lookbehind  <br>
 * <br>
 * (?=X) X, via zero-width positive lookahead <br>
 * (?!X) X, via zero-width negative lookahead <br>
 * (?<=X) X, via zero-width positive lookbehind <br>
 * (?< !X) X, via zero-width negative lookbehind <br>
 * <br>
 * NOTE: Applied usage (ex. replacement) will be implemented in other class. <br>
 */
public class LookAround {
    private static final Logger LOGGER = LoggerFactory.getLogger(LookAround.class);

    /** (?=X) X, via zero-width positive lookahead */
    public static final String EXP_POSITIVE_LOOKAHEAD = "NUM(?=BER)";
    /** (?!X) X, via zero-width negative lookahead */
    public static final String EXP_NEGATIVE_LOOKAHEAD = "NUM(?!BER)";
    /** (?<=X) X, via zero-width positive lookbehind */
    public static final String EXP_POSITIVE_LOOKBEHIND = "(?<=NUM)BER";
    /** (?< !X) X, via zero-width negative lookbehind */
    public static final String EXP_NEGATIVE_LOOKBEHIND = "(?<!NUM)BER";
    /** combination-A: positive lookbehind + positive lookahead */
    public static final String EXP_LOOKAROUND_A = "(?<=NUM)(?=BER)";
    /** combination-B */
    public static final String EXP_LOOKAROUND_B = "(?<!NUM)-(?!BER)";

    // -----------------------------------------------------------------------------------------------

    private static final Pattern PATTERN_POSITIVE_LOOKAHEAD = Pattern.compile(EXP_POSITIVE_LOOKAHEAD);
    private static final Pattern PATTERN_NEGATIVE_LOOKAHEAD = Pattern.compile(EXP_NEGATIVE_LOOKAHEAD);
    private static final Pattern PATTERN_POSITIVE_LOOKBEHIND = Pattern.compile(EXP_POSITIVE_LOOKBEHIND);
    private static final Pattern PATTERN_NEGATIVE_LOOKBEHIND = Pattern.compile(EXP_NEGATIVE_LOOKBEHIND);
    private static final Pattern PATTERN_LOOKAROUND_A = Pattern.compile(EXP_LOOKAROUND_A);
    private static final Pattern PATTERN_LOOKAROUND_B = Pattern.compile(EXP_LOOKAROUND_B);

    public boolean find(Matcher match, String text) {
        boolean result = match.find();
        if (result) {
            LOGGER.debug("result:true  input:{} position: {}", text, match.start());
        } else {
            LOGGER.debug("result:false input:{}", text);
        }
        return result;
    }

    public boolean findPositiveLookAhead(String text) {
        return find(PATTERN_POSITIVE_LOOKAHEAD.matcher(text), text);
    }

    public boolean findNegativeLookAhead(String text) {
        return find(PATTERN_NEGATIVE_LOOKAHEAD.matcher(text), text);
    }

    public boolean findPositiveLookBehind(String text) {
        return find(PATTERN_POSITIVE_LOOKBEHIND.matcher(text), text);
    }

    public boolean findNegativeLookBehind(String text) {
        return find(PATTERN_NEGATIVE_LOOKBEHIND.matcher(text), text);
    }

    public boolean findLookAroundA(String text) {
        return find(PATTERN_LOOKAROUND_A.matcher(text), text);
    }

    public boolean findLookAroundB(String text) {
        return find(PATTERN_LOOKAROUND_B.matcher(text), text);
    }
}