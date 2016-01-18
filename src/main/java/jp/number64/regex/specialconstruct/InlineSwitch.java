package jp.number64.regex.specialconstruct;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * inline switch  <br>
 * <br>
 * \Q Nothing, but quotes all characters until \E
 * \E Nothing, but ends quoting started by \Q
 * <br>
 * (?idmsuxU-idmsuxU) Nothing, but turns match flags i d m s u x U on - off
 * (?idmsux-idmsux:X) X, as a non-capturing group with the given flags i d m s u x on - off
 */
public class InlineSwitch {
    private static final Logger LOGGER = LoggerFactory.getLogger(InlineSwitch.class);

    /** This pattern-text contains special chars (it must be escaped). */
    public static final String PATTERN_TEXT = "NUM*(BER)=6*4";
    /** \Q Nothing, but quotes all characters until \E. \E Nothing, but ends quoting started by \Q. */
    public static final String EXP_RANGE_QUOTE = "\\Q" + PATTERN_TEXT + "\\E";
    /** \Q Nothing, but quotes all characters until \E. \E Nothing, but ends quoting started by \Q. */
    public static final String EXP_NON_RANGE_QUOTE = PATTERN_TEXT;

    /** (?i) CASE_INSENSITIVE */
    public static final String EXP_MATCH_FLAG_I = "";
    /** (?d) UNIX_LINES */
    public static final String EXP_MATCH_FLAG_D = "";
    /** (?m) MULTILINE */
    public static final String EXP_MATCH_FLAG_M = "";
    /** (?s) DOTALL */
    public static final String EXP_MATCH_FLAG_S = "";
    /** (?u) UNICODE_CASE */
    public static final String EXP_MATCH_FLAG_U = "";
    /** (?x) COMMENTS */
    public static final String EXP_MATCH_FLAG_X = "";

    /** (?idmsux-idmsux:X) X, as a non-capturing group with the given flags i d m s u x on - off */
    public static final String EXP_NON_CAPTURING_MATCH_FLAGS = "";

    // -----------------------------------------------------------------------------------------------

    private static final Pattern PATTERN_RANGE_QUOTE = Pattern.compile(EXP_RANGE_QUOTE);
    private static final Pattern PATTERN_NON_RANGE_QUOTE = Pattern.compile(EXP_NON_RANGE_QUOTE);

    private static final Pattern PATTERN_MATCH_FLAG_I = Pattern.compile(EXP_MATCH_FLAG_I);
    private static final Pattern PATTERN_MATCH_FLAG_D = Pattern.compile(EXP_MATCH_FLAG_D);
    private static final Pattern PATTERN_MATCH_FLAG_M = Pattern.compile(EXP_MATCH_FLAG_M);
    private static final Pattern PATTERN_MATCH_FLAG_S = Pattern.compile(EXP_MATCH_FLAG_S);
    private static final Pattern PATTERN_MATCH_FLAG_U = Pattern.compile(EXP_MATCH_FLAG_U);
    private static final Pattern PATTERN_MATCH_FLAG_X = Pattern.compile(EXP_MATCH_FLAG_X);

    private static final Pattern PATTERN_NON_CAPTURING_MATCH_FLAGS = Pattern.compile(EXP_NON_CAPTURING_MATCH_FLAGS);

    public boolean findRangeQuote(String text) {
        boolean result = PATTERN_RANGE_QUOTE.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findNonRangeQuote(String text) {
        boolean result = PATTERN_NON_RANGE_QUOTE.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findMatchFlagI(String text) {
        boolean result = PATTERN_MATCH_FLAG_I.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findMatchFlagD(String text) {
        boolean result = PATTERN_MATCH_FLAG_D.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findMatchFlagM(String text) {
        boolean result = PATTERN_MATCH_FLAG_M.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findMatchFlagS(String text) {
        boolean result = PATTERN_MATCH_FLAG_S.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findMatchFlagU(String text) {
        boolean result = PATTERN_MATCH_FLAG_U.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findMatchFlagX(String text) {
        boolean result = PATTERN_MATCH_FLAG_X.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public String findNonCapturingMatchFlags(String text, int groupNumber) {
        Matcher match = PATTERN_NON_CAPTURING_MATCH_FLAGS.matcher(text);
        match.find();
        LOGGER.debug("text:{} group:{} value:{}", text, groupNumber, match.group(groupNumber));
        return match.group(groupNumber);
    }
}