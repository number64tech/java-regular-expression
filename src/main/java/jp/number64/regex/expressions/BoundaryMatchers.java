package jp.number64.regex.expressions;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * boundary expression patterns <br>
 * <br>
 * ^ The beginning of a line <br>
 * $ The end of a line <br>
 * \b A word boundary <br>
 * \B A non-word boundary <br>
 * \A The beginning of the input <br>
 * \G The end of the previous match <br>
 * \Z The end of the input but for the final terminator, if any <br>
 * \z The end of the input <br>
 * <br>
 * at java.util.regex, PCRE, "word" means [a-zA-Z0-9_] <br>
 */
public class BoundaryMatchers {
    private static final Logger LOGGER = LoggerFactory.getLogger(BoundaryMatchers.class);

    /** ^ The beginning of a line (starts-with) */
    public static final String EXP_BOUNDARY_BEGINNING_LINE = "^NUMBER64";
    /** $ The end of a line (ends-with) */
    public static final String EXP_BOUNDARY_END_LINE = "NUMBER64$";
    /** partial matching (standard) */
    public static final String EXP_MATCHING_PARTIAL = "NUMBER64";
    /** perfect matching (starts-with & ends-with) */
    public static final String EXP_MATCHING_PERFECT = "^NUMBER64$";
    /** \A The beginning of the input */
    public static final String EXP_BOUNDARY_BEGINNING_INPUT = "\\ANUMBER64";
    /** \Z The end of the input but for the final terminator, if any */
    public static final String EXP_BOUNDARY_TERMINATOR = "NUMBER64\\Z";
    /** \z The end of the input */
    public static final String EXP_BOUNDARY_END_INPUT = "NUMBER64\\z";

    /** the end of the previous match (This expression is not important at Java... ?) */
    public static final String EXP_END_OF_PREV_MATCH_ESC = "\\G";

    /** \b A word boundary */
    public static final String EXP_BOUNDARY_WORD = "\\bNUMBER64\\b";
    /** \B A non-word boundary */
    public static final String EXP_BOUNDARY_NON_WORD = "\\BNUMBER64\\B";

    // -----------------------------------------------------------------------------------------------

    private static final Pattern PATTERN_BOUNDARY_BEGINNING_LINE = Pattern.compile(EXP_BOUNDARY_BEGINNING_LINE);
    private static final Pattern PATTERN_BOUNDARY_END_LINE = Pattern.compile(EXP_BOUNDARY_END_LINE);
    private static final Pattern PATTERN_MATCHING_PARTIAL = Pattern.compile(EXP_MATCHING_PARTIAL);
    private static final Pattern PATTERN_MATCHING_PERFECT = Pattern.compile(EXP_MATCHING_PERFECT);
    private static final Pattern PATTERN_BOUNDARY_BEGINNING_INPUT = Pattern.compile(EXP_BOUNDARY_BEGINNING_INPUT);
    private static final Pattern PATTERN_BOUNDARY_TERMINATOR = Pattern.compile(EXP_BOUNDARY_TERMINATOR);
    private static final Pattern PATTERN_BOUNDARY_END_INPUT = Pattern.compile(EXP_BOUNDARY_END_INPUT);

    private static final Pattern PATTERN_END_OF_PREV_MATCH_ESC = Pattern.compile(EXP_END_OF_PREV_MATCH_ESC);

    private static final Pattern PATTERN_BOUNDARY_WORD = Pattern.compile(EXP_BOUNDARY_WORD);
    private static final Pattern PATTERN_BOUNDARY_NON_WORD = Pattern.compile(EXP_BOUNDARY_NON_WORD);

    public boolean findBoundaryBeginningLine(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_BOUNDARY_BEGINNING_LINE.matcher(text).find();
    }

    public boolean findBoundaryEndLine(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_BOUNDARY_END_LINE.matcher(text).find();
    }

    public boolean findMatchingPartial(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_MATCHING_PARTIAL.matcher(text).find();
    }

    public boolean findMatchingPerfecr(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_MATCHING_PERFECT.matcher(text).find();
    }

    public boolean findBoundaryBeginnigInput(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_BOUNDARY_BEGINNING_INPUT.matcher(text).find();
    }

    public boolean findBoundaryTerminator(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_BOUNDARY_TERMINATOR.matcher(text).find();
    }

    public boolean findBoundaryEndInput(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_BOUNDARY_END_INPUT.matcher(text).find();
    }

    public boolean findEndOfPreviousMatch(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_END_OF_PREV_MATCH_ESC.matcher(text).find();
    }

    public boolean findBoundaryWord(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_BOUNDARY_WORD.matcher(text).find();
    }

    public boolean findBoundaryNonWord(String text) {
        LOGGER.debug("text:{}", text);
        return PATTERN_BOUNDARY_NON_WORD.matcher(text).find();
    }


}