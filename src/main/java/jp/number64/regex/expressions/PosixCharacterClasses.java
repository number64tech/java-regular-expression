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
 * both silently and aloud, of handwritten and printed texts." <br>
 * note2: from official site, PUNCUATION doesn't contain "\", but it does.
 */
public class PosixCharacterClasses {
    private static final Logger LOGGER = LoggerFactory.getLogger(PosixCharacterClasses.class);

    /** \p{Lower} A lower-case alphabetic character: [a-z] */
    public static final String EXP_LOWER_ALPHA = "\\p{Lower}";
    /** \p{Upper} An upper-case alphabetic character:[A-Z] */
    public static final String EXP_UPPER_ALPHA = "\\p{Upper}";
    /** \p{ASCII} All ASCII:[\x00-\x7F] */
    public static final String EXP_ASCII = "\\p{ASCII}";
    /** \p{Alpha} An alphabetic character:[\p{Lower}\p{Upper}] */
    public static final String EXP_ALPHA = "\\p{Alpha}";
    /** \p{Digit} A decimal digit: [0-9] */
    public static final String EXP_DIGIT = "\\p{Digit}";
    /** \p{Alnum} An alphanumeric character:[\p{Alpha}\p{Digit}] */
    public static final String EXP_ALNUM = "\\p{Alnum}";
    /** \p{Punct} Punctuation: One of !"#$%&'()*+,-./:;<=>?@[]^_`{|}~ */
    public static final String EXP_PUNCATION = "\\p{Punct}";
    /** \p{Graph} A visible character: [\p{Alnum}\p{Punct}] */
    public static final String EXP_GRAPH = "\\p{Graph}";
    /** \p{Print} A printable character: [\p{Graph}\x20] */
    public static final String EXP_PRINT = "\\p{Print}";
    /** \p{Blank} A space or a tab: [ \t] */
    public static final String EXP_BLANK = "\\p{Blank}";
    /** \p{Cntrl} A control character: [\x00-\x1F\x7F] */
    public static final String EXP_CNTRL = "\\p{Cntrl}";
    /** \p{XDigit} A hexadecimal digit: [0-9a-fA-F] */
    public static final String EXP_XDIGIT = "\\p{XDigit}";
    /** \p{Space} A whitespace character: [ \t\n\x0B\f\r] */
    public static final String EXP_SPACE = "\\p{Space}";

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
        boolean result = PATTERN_LOWER_ALPHA.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findUpperAlpha(String text) {
        boolean result = PATTERN_UPPER_ALPHA.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findAscii(String text) {
        boolean result = PATTERN_ASCII.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findAlpha(String text) {
        boolean result = PATTERN_ALPHA.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findDigit(String text) {
        boolean result = PATTERN_DIGIT.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findAlnum(String text) {
        boolean result = PATTERN_ALNUM.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findPuncation(String text) {
        boolean result = PATTERN_PUNCATION.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findGraph(String text) {
        boolean result = PATTERN_GRAPH.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findPrint(String text) {
        boolean result = PATTERN_PRINT.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findBlank(String text) {
        boolean result = PATTERN_BLANK.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findCntrl(String text) {
        boolean result = PATTERN_CNTRL.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findXdigit(String text) {
        boolean result = PATTERN_XDIGIT.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findSpace(String text) {
        boolean result = PATTERN_SPACE.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }
}
