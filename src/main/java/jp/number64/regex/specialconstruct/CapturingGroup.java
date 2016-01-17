package jp.number64.regex.specialconstruct;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * capturing group  <br>
 * <br>
 * (?X) X, as a named-capturing group <br>
 * (?:X) X, as a non-capturing group <br>
 * (?>X) X, as an independent, non-capturing group <br>
 * <br>
 * Back references <br>
 * <br>
 * \n Whatever the nth capturing group matched <br>
 * \k Whatever the named-capturing group "name" matched <br>
 */
public class CapturingGroup {
    private static final Logger LOGGER = LoggerFactory.getLogger(CapturingGroup.class);

    /** (?X) X, as a named-capturing group  */
    public static final String EXP_CAPTURING_NAMED = "(?<grp1>[A-Z]{3})(?<grp2>[A-Z]{3})(?<grp3>[0-9]+)";
    /** (?:X) X, as a non-capturing group  */
    public static final String EXP_CAPTURING_NOT_CAPTURE = "(NUM)(?:BER)(64)";
    /** (?>X) X, as an independent, non-capturing group  */
    public static final String EXP_CAPTURING_IDP_NOT_CAPTURE = "(NUMBER)(?>R+)(64)";

    /** \n Whatever the nth capturing group matched  */
    public static final String EXP_BACK_REF_BY_NUMBER = "([A-Z]+(64)) (\\1)(\\2)";
    /** \k Whatever the named-capturing group "name" matched */
    public static final String EXP_BACK_REF_BY_NAME =
        "(?<grp1>[A-Z]{3})(?<grp2>[A-Z]{3})(?<grp3>[0-9]+) (\\k<grp3>)(\\k<grp2>)(\\k<grp1>)";

    // -----------------------------------------------------------------------------------------------

    private static final Pattern PATTERN_CAPTURING_NAMED = Pattern.compile(EXP_CAPTURING_NAMED);
    private static final Pattern PATTERN_CAPTURING_NOT_CAPTURE = Pattern.compile(EXP_CAPTURING_NOT_CAPTURE);
    private static final Pattern PATTERN_CAPTURING_IDP_NOT_CAPTURE = Pattern.compile(EXP_CAPTURING_IDP_NOT_CAPTURE);

    private static final Pattern PATTERN_BACK_REF_BY_NUMBER = Pattern.compile(EXP_BACK_REF_BY_NUMBER);
    private static final Pattern PATTERN_BACK_REF_BY_NAME = Pattern.compile(EXP_BACK_REF_BY_NAME);

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

    public String findBackRefByName(String text, String groupName) {
        Matcher match = PATTERN_BACK_REF_BY_NAME.matcher(text);
        match.find();
        LOGGER.debug("result:{} group:{} text:{}", match.group(groupName), groupName, text);
        return match.group(groupName);
    }
}