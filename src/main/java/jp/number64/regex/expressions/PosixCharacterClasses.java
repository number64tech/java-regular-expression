package jp.number64.regex.expressions;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * POSIX character classes (US-ASCII only)  <br>
 *  <br>
 * \p{Lower} A lower-case alphabetic character: [a-z]  <br>
 * \p{Upper} An upper-case alphabetic character:[A-Z]  <br>
 * \p{ASCII} All ASCII:[\x00-\x7F]  <br>
 * \p{Alpha} An alphabetic character:[\p{Lower}\p{Upper}]  <br>
 * \p{Digit} A decimal digit: [0-9]  <br>
 * \p{Alnum} An alphanumeric character:[\p{Alpha}\p{Digit}]  <br>
 * \p{Punct} Punctuation: One of !"#$%&'()*+,-./:;<=>?@[]^_`{|}~  <br>
 * \p{Graph} A visible character: [\p{Alnum}\p{Punct}]  <br>
 * \p{Print} A printable character: [\p{Graph}\x20]  <br>
 * \p{Blank} A space or a tab: [ \t]  <br>
 * \p{Cntrl} A control character: [\x00-\x1F\x7F]  <br>
 * \p{XDigit} A hexadecimal digit: [0-9a-fA-F]  <br>
 * \p{Space} A whitespace character: [ \t\n\x0B\f\r]  <br>
 *  <br>
 * note: from wikipedia, PUNCUATION means <br>
 * "the use of spacing, conventional signs, and certain typographical devices as aids to the understanding and correct reading,
 * both silently and aloud, of handwritten and printed texts."
 */
public class PosixCharacterClasses {
    private static final Logger LOGGER = LoggerFactory.getLogger(PosixCharacterClasses.class);

    /** \p{Lower} A lower-case alphabetic character: [a-z] */
    public static final String EXP_LOWER_ALPHA = "";
    /** \p{Upper} An upper-case alphabetic character:[A-Z] */
    public static final String EXP_UPPER_ALPHA = "";
    /** \p{ASCII} All ASCII:[\x00-\x7F] */
    public static final String EXP_ASCII = "";
    /** \p{Alpha} An alphabetic character:[\p{Lower}\p{Upper}] */
    public static final String EXP_ALPHA = "";
    /** \p{Digit} A decimal digit: [0-9] */
    public static final String EXP_DIGIT = "";
    /** \p{Alnum} An alphanumeric character:[\p{Alpha}\p{Digit}] */
    public static final String EXP_ALNUM = "";
    /** \p{Punct} Punctuation: One of !"#$%&'()*+,-./:;<=>?@[]^_`{|}~ */
    public static final String EXP_PUNCATION = "";
    /** \p{Graph} A visible character: [\p{Alnum}\p{Punct}] */
    public static final String EXP_GRAPH = "";
    /** \p{Print} A printable character: [\p{Graph}\x20] */
    public static final String EXP_PRINT = "";
    /** \p{Blank} A space or a tab: [ \t] */
    public static final String EXP_BLANK = "";
    /** \p{Cntrl} A control character: [\x00-\x1F\x7F] */
    public static final String EXP_CNTRL = "";
    /** \p{XDigit} A hexadecimal digit: [0-9a-fA-F] */
    public static final String EXP_XDIGIT = "";
    /** \p{Space} A whitespace character: [ \t\n\x0B\f\r] */
    public static final String EXP_SPACE = "";

    // -----------------------------------------------------------------------------------------------

    private static final Pattern PATTERN_LOWER_ALPHA = Pattern.compile(EXP_LOWER_ALPHA);
    private static final Pattern PATTERN_UPPER_ALPHA = Pattern.compile(EXP_UPPER_ALPHA);
    private static final Pattern PATTERN_ASCII = Pattern.compile(EXP_ASCII);
    private static final Pattern PATTERN_ALPHA = Pattern.compile(EXP_ALPHA);
    private static final Pattern PATTERN_DIGIT = Pattern.compile(EXP_DIGIT);
    private static final Pattern PATTERN_ALNUM = Pattern.compile(EXP_ALNUM);
    private static final Pattern PATTERN_PUNCATION = Pattern.compile(EXP_PUNCATION);
    private static final Pattern PATTERN_GRAPH = Pattern.compile(EXP_GRAPH);
    private static final Pattern PATTERN_PRINT = Pattern.compile(EXP_PRINT);
    private static final Pattern PATTERN_BLANK = Pattern.compile(EXP_BLANK);
    private static final Pattern PATTERN_CNTRL = Pattern.compile(EXP_CNTRL);
    private static final Pattern PATTERN_XDIGIT = Pattern.compile(EXP_XDIGIT);
    private static final Pattern PATTERN_SPACE = Pattern.compile(EXP_SPACE);

    public boolean findLowerAplha(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_LOWER_ALPHA.matcher(text).find();
    }

    public boolean findUpperAlpha(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_UPPER_ALPHA.matcher(text).find();
    }

    public boolean findAscii(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_ASCII.matcher(text).find();
    }

    public boolean findAlpha(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_ALPHA.matcher(text).find();
    }

    public boolean findDigit(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_DIGIT.matcher(text).find();
    }

    public boolean findAlnum(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_ALNUM.matcher(text).find();
    }

    public boolean findPuncation(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_PUNCATION.matcher(text).find();
    }

    public boolean findGraph(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_GRAPH.matcher(text).find();
    }

    public boolean findPrint(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_PRINT.matcher(text).find();
    }

    public boolean findBlank(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_BLANK.matcher(text).find();
    }

    public boolean findCntrl(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_CNTRL.matcher(text).find();
    }

    public boolean findXdigit(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_XDIGIT.matcher(text).find();
    }

    public boolean findSpace(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_SPACE.matcher(text).find();
    }
}
