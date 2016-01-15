package jp.number64.regex.expressions;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Character classes  <br>
 * [] : Box brackets, Square brackets.  <br>
 *  <br>
 * [abc] a, b, or c (simple class)  <br>
 * [^abc] Any character except a, b, or c (negation)  <br>
 * [a-zA-Z] a through z or A through Z, inclusive (range)  <br>
 * [a-d[m-p]] a through d, or m through p: a-dm-p  <br>
 * [a-z&&[def]] d, e, or f (intersection) (Google transrate: Set consists of all the elements that belong to also to A B)  <br>
 * [a-z&&[^bc]] a through z, except for b and c: ad-z  <br>
 * [a-z&&[^m-p]] a through z, and not m through p: a-lq-z  <br>
 *  <br>
 * memo : [abc[def]] = [[abc][def]] = [[ab][cd][ef]] <br>
 */
public class CharacterClass {
    private static final Logger LOGGER = LoggerFactory.getLogger(CharacterClass.class);

    /** [abc] a, b, or c (simple class)  */
    public static final String EXP_SIMPLE_CHARS = "[nN][uU]MBER64";
    /** [^abc] Any character except a, b, or c (negation)  */
    public static final String EXP_NEGATION_CHARS = "[^nN][^uU]MBER64";
    /** [a-zA-Z] a through z or A through Z, inclusive (range)  */
    public static final String EXP_RANGE_CHARS = "[a-z][A-Z]MBER[0-9][4-6]";
    /** [a-d[m-p]] a through d, or m through p: a-dm-p */
    public static final String EXP_RANGE_OR_RANGE = "[[n-z][A-N]]UMBER[[0-1][3-4][679]]4";
    /** [a-z&&[def]] d, e, or f (intersection) */
    public static final String RANGE_A_END   = "q";
    public static final String RANGE_B_START = "m";
    public static final String EXP_RANGE_AND_RANGE = "[a-" + RANGE_A_END + "&&[" + RANGE_B_START + "-n]]UMBER64";
    /** [a-z&&[^bc]] a through z, except for b and c: ad-z */
    public static final String EXP_RANGE_EXCEPTING_CHARS = "[a-z&&[^abcdefghijklmopqrstuvwxyz]]UMBER64";
    /** [a-z&&[^m-p]] a through z, and not m through p: a-lq-z */
    public static final String EXP_RANGE_EXCEPTING_RANGE = "[[[A-E]&&[^B-D]][F-N]]UMBER64";

    // -----------------------------------------------------------------------------------------------

    private static final Pattern PATTERN_SIMPLE_CHARS = Pattern.compile(EXP_SIMPLE_CHARS);
    private static final Pattern PATTERN_NEGATION_CHARS = Pattern.compile(EXP_NEGATION_CHARS);
    private static final Pattern PATTERN_RANGE_CHARS = Pattern.compile(EXP_RANGE_CHARS);

    private static final Pattern PATTERN_RANGE_OR_RANGE = Pattern.compile(EXP_RANGE_OR_RANGE);
    private static final Pattern PATTERN_RANGE_AND_RANGE = Pattern.compile(EXP_RANGE_AND_RANGE);
    private static final Pattern PATTERN_RANGE_EXCEPTING_CHARS = Pattern.compile(EXP_RANGE_EXCEPTING_CHARS);
    private static final Pattern PATTERN_RANGE_EXCEPTIONG_RANGE = Pattern.compile(EXP_RANGE_EXCEPTING_RANGE);

    public boolean findSimpleChars(String text) {
        boolean result = PATTERN_SIMPLE_CHARS.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findNegationChars(String text) {
        boolean result = PATTERN_NEGATION_CHARS.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findRangeChars(String text) {
        boolean result = PATTERN_RANGE_CHARS.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findRangeOrRange(String text) {
        boolean result = PATTERN_RANGE_OR_RANGE.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findRangeAndRange(String text) {
        boolean result = PATTERN_RANGE_AND_RANGE.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findRangeExceptingChars(String text) {
        boolean result = PATTERN_RANGE_EXCEPTING_CHARS.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findRangeExceptingRange(String text) {
        boolean result = PATTERN_RANGE_EXCEPTIONG_RANGE.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }
}
