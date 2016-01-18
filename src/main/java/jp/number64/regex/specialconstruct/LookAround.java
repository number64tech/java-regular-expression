package jp.number64.regex.specialconstruct;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * lookahead/lookbehind  <br>
 * <br>
 * (?=X) X, via zero-width positive lookahead
 * (?!X) X, via zero-width negative lookahead
 * (?<=X) X, via zero-width positive lookbehind
 * (?<!X) X, via zero-width negative lookbehind
 * <br>
 */
public class LookAround {
    private static final Logger LOGGER = LoggerFactory.getLogger(LookAround.class);

    /** (?=X) X, via zero-width positive lookahead */
    public static final String EXP_POSITIVE_LOOKAHEAD = "";
    /** (?!X) X, via zero-width negative lookahead */
    public static final String EXP_NEGATIVE_LOOKAHEAD = "";
    /** (?<=X) X, via zero-width positive lookbehind */
    public static final String EXP_POSITIVE_LOOKBEHIND = "";
    /** (?<!X) X, via zero-width negative lookbehind */
    public static final String EXP_NEGATIVE_LOOKBEHIND = "";
    /** combination-A */
    public static final String EXP_LOOKAROUND_A = "";
    /** combination-B */
    public static final String EXP_LOOKAROUND_B = "";


    // -----------------------------------------------------------------------------------------------

    private static final Pattern PATTERN_CAPTURING_NAMED = Pattern.compile(EXP_CAPTURING_NAMED);


    public String findCapturingNamed(String text, String groupName) {
        Matcher match = PATTERN_CAPTURING_NAMED.matcher(text);
        match.find();
        LOGGER.debug("result:{} group:{} text:{}", match.group(groupName), groupName, text);
        return match.group(groupName);
    }

    public String findCapturingNotCapture(String text, int groupNumber) {
        Matcher match = PATTERN_CAPTURING_NOT_CAPTURE.matcher(text);
        match.find();
        LOGGER.debug("result:{} group:{} text:{}", match.group(groupNumber), groupNumber, text);
        return match.group(groupNumber);
    }

    public String findCapturingIdpNotCapture(String text, int groupNumber) {
        Matcher match = PATTERN_CAPTURING_IDP_NOT_CAPTURE.matcher(text);
        match.find();
        LOGGER.debug("result:{} group:{} text:{}", match.group(groupNumber), groupNumber, text);
        return match.group(groupNumber);
    }

    public String findBackRefByNumber(String text, int groupNumber) {
        Matcher match = PATTERN_BACK_REF_BY_NUMBER.matcher(text);
        match.find();
        LOGGER.debug("result:{} group:{} text:{}", match.group(groupNumber), groupNumber, text);
        return match.group(groupNumber);
    }
}