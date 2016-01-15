package jp.number64.regex.expressions;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Predefined character classes  <br>
 * <br>
 * . Any character (may or may not match line terminators)  <br>
 * \d A digit: [0-9]  <br>
 * \D A non-digit: [^0-9]  <br>
 * \h A horizontal whitespace character: [ \t\xA0\u1680\u180e\u2000-\u200a\u202f\u205f\u3000]  <br>
 * \H A non-horizontal whitespace character: [^\h]  <br>
 * \s A whitespace character: [ \t\n\x0B\f\r]  <br>
 * \S A non-whitespace character: [^\s]  <br>
 * \v A vertical whitespace character: [\n\x0B\f\r\x85\u2028\u2029]  <br>
 * \V A non-vertical whitespace character: [^\v]  <br>
 * \w A word character: [a-zA-Z_0-9]  <br>
 * \W A non-word character: [^\w]  <br>
 */
public class PredefinedCharacterClasses {
    private static final Logger LOGGER = LoggerFactory.getLogger(PredefinedCharacterClasses.class);

    /** . Any character (may or may not match line terminators) */
    public static final String EXP_ANY_CHARACTER = "^.UMBER64";
    /** \d A digit: [0-9] */
    public static final String EXP_A_DIGIT = "\\d";
    /** \D A non-digit: [^0-9] */
    public static final String EXP_A_NON_DIGIT = "\\D";
    /** \h A horizontal whitespace character: [ \t\xA0\u1680\u180e\u2000-\u200a\u202f\u205f\u3000] */
    public static final String EXP_HORIZONTAL_WHITE_SPACE = "\\h";
    /** \H A non-horizontal whitespace character: [^\h] */
    public static final String EXP_NON_HORIZONTAL_WHITE_SPACE = "\\H";
    /** \s A whitespace character: [ \t\n\x0B\f\r] */
    public static final String EXP_WHITE_SPACE = "\\s";
    /** \S A non-whitespace character: [^\s] */
    public static final String EXP_NON_WHITE_SPACE = "\\S";
    /** \v A vertical whitespace character: [\n\x0B\f\r\x85\u2028\u2029] */
    public static final String EXP_VERTICAL_WHITE_SPACE = "\\v";
    /** \V A non-vertical whitespace character: [^\v] */
    public static final String EXP_NON_VERTICAL_WHITE_SPACE = "\\V";
    /** \w A word character: [a-zA-Z_0-9] */
    public static final String EXP_A_WORD_CHARACTER = "\\w";
    /** \W A non-word character: [^\w] */
    public static final String EXP_A_NON_WORD_CHARACTER = "\\W";

    // -----------------------------------------------------------------------------------------------

    private static final Pattern PATTERN_ANY_CHARACTER = Pattern.compile(EXP_ANY_CHARACTER);
    private static final Pattern PATTERN_A_DIGIT = Pattern.compile(EXP_A_DIGIT);
    private static final Pattern PATTERN_A_NON_DIGIT = Pattern.compile(EXP_A_NON_DIGIT);
    private static final Pattern PATTERN_HORIZONTAL_WHITE_SPACE = Pattern.compile(EXP_HORIZONTAL_WHITE_SPACE);
    private static final Pattern PATTERN_NON_HORIZONTAL_WHITE_SPACE = Pattern.compile(EXP_NON_HORIZONTAL_WHITE_SPACE);
    private static final Pattern PATTERN_WHITE_SPACE = Pattern.compile(EXP_WHITE_SPACE);
    private static final Pattern PATTERN_NON_WHITE_SPACE = Pattern.compile(EXP_NON_WHITE_SPACE);
    private static final Pattern PATTERN_VERTICAL_WHITE_SPACE = Pattern.compile(EXP_VERTICAL_WHITE_SPACE);
    private static final Pattern PATTERN_NON_VERTICAL_WHITE_SPACE = Pattern.compile(EXP_NON_VERTICAL_WHITE_SPACE);
    private static final Pattern PATTERN_A_WORD_CHARACTER = Pattern.compile(EXP_A_WORD_CHARACTER);
    private static final Pattern PATTERN_A_NON_WORD_CHARACTER = Pattern.compile(EXP_A_NON_WORD_CHARACTER);

    public boolean findAnyCharacter(String text) {
        boolean result = PATTERN_ANY_CHARACTER.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findDigit(String text) {
        boolean result = PATTERN_A_DIGIT.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findNonDigit(String text) {
        boolean result = PATTERN_A_NON_DIGIT.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findHorizontalWhiteSpace(String text) {
        boolean result = PATTERN_HORIZONTAL_WHITE_SPACE.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findNonHorizontalWhiteSpace(String text) {
        boolean result = PATTERN_NON_HORIZONTAL_WHITE_SPACE.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findWhiteSpace(String text) {
        boolean result = PATTERN_WHITE_SPACE.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findNonWhiteSpace(String text) {
        boolean result = PATTERN_NON_WHITE_SPACE.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findVerticalWhiteSpace(String text) {
        boolean result = PATTERN_VERTICAL_WHITE_SPACE.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findNonVerticalWhiteSpace(String text) {
        boolean result = PATTERN_NON_VERTICAL_WHITE_SPACE.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findWordCharacter(String text) {
        boolean result = PATTERN_A_WORD_CHARACTER.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findNonWordCharacter(String text) {
        boolean result = PATTERN_A_NON_WORD_CHARACTER.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }
}
