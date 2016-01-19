package jp.number64.regex.matchersample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Samples of "Matcher" methods <br>
 * <br>
 * @see Matcher
 */
public class Replacement {
    private static final Logger LOGGER = LoggerFactory.getLogger(Extraction.class);

    /** TAB separated, check input */
    public static final String EXP_TEXT_CHECKER = "[^\\p{Alnum}]";
    /** find insertion point from the first char */
    public static final String EXP_CONV_TSV_FROM_FIRST = "(?<=^(\\p{Alnum}{3})+)(?=\\p{Alnum})";
    /** find insertion point from the end char */
    public static final String EXP_CONV_TSV_FROM_END = "(?<=\\p{Alnum})(?=(\\p{Alnum}{3})+$)";

    private static final Pattern PATTERN_TEXT_CHECKER = Pattern.compile(EXP_TEXT_CHECKER);
    private static final Pattern PATTERN_CONV_TSV_FROM_FIRST = Pattern.compile(EXP_CONV_TSV_FROM_FIRST);
    private static final Pattern PATTERN_CONV_TSV_FROM_END = Pattern.compile(EXP_CONV_TSV_FROM_END);

    // -----------------------------------------------------------------------------------------------

    public boolean checkText(String inputText) {
        Matcher match = PATTERN_TEXT_CHECKER.matcher(inputText);
        boolean result = !match.find();
        LOGGER.debug("check result: {}", (result ? "valid" : "invalid"));
        return !match.find();
    }

    public String separateFromFirst(String inputText) {
        Matcher match = PATTERN_CONV_TSV_FROM_FIRST.matcher(inputText);
        String result = match.replaceAll("\t");
        LOGGER.debug("replaced: {}", result);
        return result;
    }

    public String separateFromEnd(String inputText) {
        Matcher match = PATTERN_CONV_TSV_FROM_END.matcher(inputText);
        String result = match.replaceAll("\t");
        LOGGER.debug("replaced: {}", result);
        return result;
    }
}
