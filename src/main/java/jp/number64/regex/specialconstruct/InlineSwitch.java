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
 * <br>
 * NOTE: Between Japanese kana upper|lower case, (?ui) matching result won't be expected.
 */
public class InlineSwitch {
    private static final Logger LOGGER = LoggerFactory.getLogger(InlineSwitch.class);

    /** This pattern-text contains regex meta characters. */
    public static final String PATTERN_TEXT = "NUM*(BER)=6*4";
    /** \Q Nothing, but quotes all characters until \E. \E Nothing, but ends quoting started by \Q. <br>
     * note: This switch is useful for 'dynamic and plain' pattern, if it (may) contains regex meta characters. */
    public static final String EXP_RANGE_QUOTE = "\\Q" + PATTERN_TEXT + "\\E";
    /** \Q Nothing, but quotes all characters until \E. \E Nothing, but ends quoting started by \Q. */
    public static final String EXP_NON_RANGE_QUOTE = PATTERN_TEXT;

    /** (?i) CASE_INSENSITIVE : Enables case-insensitive matching <br>
     * By default, case-insensitive matching assumes that only characters in the US-ASCII charset are being matched.<br>
     * Unicode-aware case-insensitive matching can be enabled by specifying the UNICODE_CASE flag in conjunction with this flag. <br>
     * Specifying this flag may impose a performance penalty.  */
    public static final String EXP_MATCH_FLAG_I = "NU(?i)MBE(?-i)R64";

    /** (?d) UNIX_LINES : Unix lines mode. <br>
     * In this mode, only the <code>'\n'</code> line terminator is recognized in the behavior of ., ^, and $. */
    public static final String EXP_MATCH_FLAG_D = "(?d)NUM$|num.(?-d)|ber$";

    /** (?m) MULTILINE : Enables multiline mode. <br>
     * In multiline mode the expressions ^ and $ match just after or just before, respectively, a line terminator or
     * the end of the input sequence. <br>
     * By default these expressions only match at the beginning and the end of the entire input sequence. */
    public static final String EXP_MATCH_FLAG_M = "(?m)BER$(?-m)|ber$";

    /** (?s) DOTALL : Enables dotall mode. <br>
     * In dotall mode, the expression . matches any character, including a line terminator. <br>
     * By default this expression does not match line terminators. */
    public static final String EXP_MATCH_FLAG_S = "(?s)NUM.(?-s)|num.";

    /** (?u) UNICODE_CASE : Enables Unicode-aware case folding. <br>
     * When this flag is specified then case-insensitive matching, when enabled by the CASE_INSENSITIVE flag, <br>
     * is done in a manner consistent with the Unicode Standard. <br>
     * By default, case-insensitive matching assumes that only characters in the US-ASCII charset are being matched. <br>
     * Specifying this flag may impose a performance penalty.  */
    public static final String EXP_MATCH_FLAG_U = "(?ui)NUM|\u03a3(?-u)|\u0393";

    /** (?x) COMMENTS : Permits whitespace and comments in pattern. <br>
     * In this mode, whitespace is ignored, and embedded comments starting with # are ignored until the end of a line. */
    public static final String EXP_MATCH_FLAG_X = "NUM(?x)BER 64 # comment |num(?-x)|NUM";

    /** (?U) UNICODE_CHARACTER_CLASS : Enables the Unicode version of Predefined character classes and POSIX character classes. <br>
     * When this flag is specified then the (US-ASCII only) Predefined character classes and POSIX character classes are <br>
     * in conformance with Unicode Technical Standard #18: Unicode Regular Expression Annex C: Compatibility Properties. <br>
     * The flag implies UNICODE_CASE, that is, it enables Unicode-aware case folding. <br>
     * Specifying this flag may impose a performance penalty. <br>Since : 1.7 <br>*/
    public static final String EXP_MATCH_FLAG_UPPER_U = "(?U)";

    /** (?idmsux-idmsux:X) X, as a non-capturing group with the given flags i d m s u x on - off */
    public static final String EXP_NON_CAPTURING_MATCH_FLAGS = "(?i:num)(?i)(ber)(?-i)(64)";

    // -----------------------------------------------------------------------------------------------

    private static final Pattern PATTERN_RANGE_QUOTE = Pattern.compile(EXP_RANGE_QUOTE);
    private static final Pattern PATTERN_NON_RANGE_QUOTE = Pattern.compile(EXP_NON_RANGE_QUOTE);

    private static final Pattern PATTERN_MATCH_FLAG_I = Pattern.compile(EXP_MATCH_FLAG_I);
    private static final Pattern PATTERN_MATCH_FLAG_D = Pattern.compile(EXP_MATCH_FLAG_D);
    private static final Pattern PATTERN_MATCH_FLAG_M = Pattern.compile(EXP_MATCH_FLAG_M);
    private static final Pattern PATTERN_MATCH_FLAG_S = Pattern.compile(EXP_MATCH_FLAG_S);
    private static final Pattern PATTERN_MATCH_FLAG_U = Pattern.compile(EXP_MATCH_FLAG_U);
    private static final Pattern PATTERN_MATCH_FLAG_X = Pattern.compile(EXP_MATCH_FLAG_X);
    private static final Pattern PATTERN_MATCH_FLAG_UPPER_U = Pattern.compile(EXP_MATCH_FLAG_UPPER_U);

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

    public boolean findMatchFlagUpperU(String text) {
        boolean result = PATTERN_MATCH_FLAG_UPPER_U.matcher(text).find();
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