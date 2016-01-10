package jp.number64.regex.expressions;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Character classes  <br>
 *  <br>
 * [abc] a, b, or c (simple class)  <br>
 * [^abc] Any character except a, b, or c (negation)  <br>
 * [a-zA-Z] a through z or A through Z, inclusive (range)  <br>
 * [a-d[m-p]] a through d, or m through p: a-dm-p  <br>
 * [a-z&&[def]] d, e, or f (intersection) (Google transrate: Set consists of all the elements that belong to also to A B)  <br>
 * [a-z&&[^bc]] a through z, except for b and c: ad-z  <br>
 * [a-z&&[^m-p]] a through z, and not m through p: a-lq-z  <br>
 */
public class CharactorClass {
    private static final Logger LOGGER = LoggerFactory.getLogger(CharactorClass.class);

    /** [abc] a, b, or c (simple class)  <br> */
    public static final String EXP_SIMPLE_CHARS = "[nN][uU]MBER64";
    /** [^abc] Any character except a, b, or c (negation)  <br> */
    public static final String EXP_NEGATION_CHARS = "[^nN][^uU]MBER64";
    /** [a-zA-Z] a through z or A through Z, inclusive (range)  <br> */
    public static final String EXP_RANGE_CHARS = "[a-z][A-Z]MBER[0-9][4-6]";
    /** [a-d[m-p]] a through d, or m through p: a-dm-p */
    public static final String EXP_RANGE_OR_RANGE = "NUMBER64";
    /** [a-z&&[def]] d, e, or f (intersection) */
    public static final String EXP_RANGE_AND_RANGE = "NUMBER64";
    /** [a-z&&[^bc]] a through z, except for b and c: ad-z */
    public static final String EXP_RANGE_EXCEPTING_CHARS = "NUMBER64";
    /** [a-z&&[^m-p]] a through z, and not m through p: a-lq-z */
    public static final String EXP_RANGE_EXCEPTING_RANGE = "NUMBER64";

    // -----------------------------------------------------------------------------------------------

    private static final Pattern PATTERN_SIMPLE_CHARS = Pattern.compile(EXP_SIMPLE_CHARS);
    private static final Pattern PATTERN_NEGATION_CHARS = Pattern.compile(EXP_NEGATION_CHARS);
    private static final Pattern PATTERN_RANGE_CHARS = Pattern.compile(EXP_RANGE_CHARS);

    private static final Pattern PATTERN_RANGE_OR_RANGE = Pattern.compile(EXP_RANGE_OR_RANGE);
    private static final Pattern PATTERN_RANGE_AND_RANGE = Pattern.compile(EXP_RANGE_AND_RANGE);
    private static final Pattern PATTERN_RANGE_EXCEPTING_CHARS = Pattern.compile(EXP_RANGE_EXCEPTING_CHARS);
    private static final Pattern PATTERN_RANGE_EXCEPTIONG_RANGE = Pattern.compile(EXP_RANGE_EXCEPTING_RANGE);

    public boolean findSimpleChars(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_SIMPLE_CHARS.matcher(text).find();
    }

    public boolean findNegationChars(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_NEGATION_CHARS.matcher(text).find();
    }

    public boolean findRangeChars(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_RANGE_CHARS.matcher(text).find();
    }

    public boolean findRangeOrRange(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_RANGE_OR_RANGE.matcher(text).find();
    }

    public boolean findRangeAndRange(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_RANGE_AND_RANGE.matcher(text).find();
    }

    public boolean findRangeExceptingChars(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_RANGE_EXCEPTING_CHARS.matcher(text).find();
    }

    public boolean findRangeExceptingRange(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_RANGE_EXCEPTIONG_RANGE.matcher(text).find();
    }
}
