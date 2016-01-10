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
 * [a-z&&[def]] d, e, or f (intersection)  <br>
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

    // -----------------------------------------------------------------------------------------------

    private static final Pattern PATTERN_SIMPLE_CHARS = Pattern.compile(EXP_SIMPLE_CHARS);
    private static final Pattern PATTERN_NEGATION_CHARS = Pattern.compile(EXP_NEGATION_CHARS);
    private static final Pattern PATTERN_RANGE_CHARS = Pattern.compile(EXP_RANGE_CHARS);

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
}
