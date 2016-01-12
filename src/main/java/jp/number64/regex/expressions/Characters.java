package jp.number64.regex.expressions;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Characters <br>
 * <br>
 * x The character x  <br>
 * \ The backslash character  <br>
 * \0n The character with octal value 0n (0 <= n <= 7)  <br>
 * \0nn The character with octal value 0nn (0 <= n <= 7)  <br>
 * \0mnn The character with octal value 0mnn (0 <= m <= 3, 0 <= n <= 7)  <br>
 * \xhh The character with hexadecimal value 0xhh  <br>
 * \\uhhhh The character with hexadecimal value 0xhhhh  <br>
 *  note: on sourcecode, \ + u expression causes an error (even though in comment block) <br>
 * \x{h...h} The character with hexadecimal value 0xh...h (Character.MIN_CODE_POINT <= 0xh...h <= Character.MAX_CODE_POINT)  <br>
 * \t The tab character ('\u0009')  <br>
 * \n The newline (line feed) character ('\u000A')  <br>
 * \r The carriage-return character ('\u000D')  <br>
 * \f The form-feed character ('\u000C')  <br>
 * \a The alert (bell) character ('\u0007')  <br>
 * \e The escape character ('\u001B')  <br>
 * \cx The control character corresponding to x  <br>
 * <br>
 * Linebreak matcher
 * <br>
 * \R Any Unicode linebreak sequence, is equivalent to \u000D\u000A|[\u000A\u000B\u000C\u000D\u0085\u2028\u2029]
 * <br>
 * @see Character#isLetter(char)
 * @see Character#isLetter(int)
 */
public class Characters {
    private static final Logger LOGGER = LoggerFactory.getLogger(Characters.class);

    /** \0n The character with octal value 0n (0 <= n <= 7) */
    public static final String EXP_OCTAL_VALUE_1_DIGIT = "";
    /** \0nn The character with octal value 0nn (0 <= n <= 7)  */
    public static final String EXP_OCTAL_VALUE_2_DIGITS = "";
    /** \0mnn The character with octal value 0mnn (0 <= m <= 3, 0 <= n <= 7)  */
    public static final String EXP_OCTAL_VALUE_3_DIGITS = "";
    /** \xhh The character with hexadecimal value 0xhh  */
    public static final String EXP_HEX_VALUE_2_DIGITS = "";
    /** \\uhhhh The character with hexadecimal value 0xhhhh  */
    public static final String EXP_HEX_VALUE_4_DIGITS = "";
    /** \x{h...h} The character with hexadecimal value 0xh...h (Character.MIN_CODE_POINT <= 0xh...h <= Character.MAX_CODE_POINT)  */
    public static final String EXP_HEX_VALUE_FLEX_DIGITS = "";
    /** \t The tab character ('\u0009')  */
    public static final String EXP_ESC_TAB = "";
    /** \n The newline (line feed) character ('\u000A')  */
    public static final String EXP_ESC_LINE_FEED = "";
    /** \r The carriage-return character ('\u000D')  */
    public static final String EXP_ESC_CARRIAGE_RETURN = "";
    /** \R Any Unicode linebreak sequence, is equivalent to \u000D\u000A|[\u000A\u000B\u000C\u000D\u0085\u2028\u2029] */
    public static final String EXP_ESC_LINE_BREAK = "";

    // -----------------------------------------------------------------------------------------------

    private static final Pattern PATTERN_OCTAL_VALUE_1_DIGIT = Pattern.compile(EXP_OCTAL_VALUE_1_DIGIT);
    private static final Pattern PATTERN_OCTAL_VALUE_2_DIGITS = Pattern.compile(EXP_OCTAL_VALUE_2_DIGITS);
    private static final Pattern PATTERN_OCTAL_VALUE_3_DIGITS = Pattern.compile(EXP_OCTAL_VALUE_3_DIGITS);

    private static final Pattern PATTERN_HEX_VALUE_2_DIGITS = Pattern.compile(EXP_HEX_VALUE_2_DIGITS);
    private static final Pattern PATTERN_HEX_VALUE_4_DIGITS = Pattern.compile(EXP_HEX_VALUE_4_DIGITS);
    private static final Pattern PATTERN_HEX_VALUE_FLEX_DIGITS = Pattern.compile(EXP_HEX_VALUE_FLEX_DIGITS);

    private static final Pattern PATTERN_ESC_TAB = Pattern.compile(EXP_ESC_TAB);
    private static final Pattern PATTERN_ESC_LINE_FEED = Pattern.compile(EXP_ESC_LINE_FEED);
    private static final Pattern PATTERN_CARRIAGE_RETURN = Pattern.compile(EXP_ESC_CARRIAGE_RETURN);
    private static final Pattern PATTERN_LINE_BREAK = Pattern.compile(EXP_ESC_LINE_BREAK);

    public boolean findOctalValue1Digit(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_OCTAL_VALUE_1_DIGIT.matcher(text).find();
    }

    public boolean findOctalValue2Digits(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_OCTAL_VALUE_2_DIGITS.matcher(text).find();
    }

    public boolean findOctalValue3Digits(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_OCTAL_VALUE_3_DIGITS.matcher(text).find();
    }

    public boolean findHexValue2Digits(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_HEX_VALUE_2_DIGITS.matcher(text).find();
    }

    public boolean findHexValue4Digits(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_HEX_VALUE_4_DIGITS.matcher(text).find();
    }

    public boolean findHexValueFlexDigits(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_HEX_VALUE_FLEX_DIGITS.matcher(text).find();
    }

    public boolean findEscTab(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_ESC_TAB.matcher(text).find();
    }

    public boolean findEscLineFeed(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_ESC_LINE_FEED.matcher(text).find();
    }

    public boolean findEscCarriageReturn(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_CARRIAGE_RETURN.matcher(text).find();
    }

    public boolean findEscLineBreak(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_LINE_BREAK.matcher(text).find();
    }
}
