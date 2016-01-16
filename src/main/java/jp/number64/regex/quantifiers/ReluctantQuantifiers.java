package jp.number64.regex.quantifiers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Reluctant quantifiers <br>
 * <br>
 * X?? X, once or not at all <br>
 * X*? X, zero or more times <br>
 * X+? X, one or more times <br>
 * X{n}? X, exactly n times <br>
 * X{n,}? X, at least n times <br>
 * X{n,m}? X, at least n but not more than m times <br>
 * <br>
 */
public class ReluctantQuantifiers {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReluctantQuantifiers.class);

    /** X?? X, once or not at all */
    public static final String EXP_RELUC_QUANT_ONCE_OR_NOTATALL = "[a-z]??[a-z]??[a-z]??[a-z]{3}";
    /** X*? X, zero or more times */
    public static final String EXP_RELUC_QUANT_ZERO_OR_MORE = "[A-Z]*?[0-9][0-9]";
    /** X+? X, one or more times */
    public static final String EXP_RELUC_QUANT_ONE_OR_MORE = "[A-Z]+?[A-Z][A-Z]";
    /** X{n}? X, exactly n times */
    public static final String EXP_RELUC_QUANT_EXACTLY_N = "[A-Z]{6}?64";
    /** X{n,}? X, at least n times */
    public static final String EXP_RELUC_QUANT_AT_LEAST_N = "NU[A-Z]{3,}?64";
    /** X{n,m}? X, at least n but not more than m times */
    public static final String EXP_RELUC_QUANT_FROM_1_TO_3 = "NU[A-Z]{1,3}?64";
    /** X{n,m}? X, at least n but not more than m times */
    public static final String EXP_RELUC_QUANT_FROM_0_TO_2 = "NU[A-Z]{0,2}?64";

    // -----------------------------------------------------------------------------------------------

    private static final Pattern PATTERN_RELUC_QUANT_ONCE_OR_NOTATALL = Pattern.compile(EXP_RELUC_QUANT_ONCE_OR_NOTATALL);
    private static final Pattern PATTERN_RELUC_QUANT_ZERO_OR_MORE = Pattern.compile(EXP_RELUC_QUANT_ZERO_OR_MORE);
    private static final Pattern PATTERN_RELUC_QUANT_ONE_OR_MORE = Pattern.compile(EXP_RELUC_QUANT_ONE_OR_MORE);
    private static final Pattern PATTERN_RELUC_QUANT_EXACTLY_N = Pattern.compile(EXP_RELUC_QUANT_EXACTLY_N);
    private static final Pattern PATTERN_RELUC_QUANT_AT_LEAST_N = Pattern.compile(EXP_RELUC_QUANT_AT_LEAST_N);
    private static final Pattern PATTERN_RELUC_QUANT_FROM_1_TO_3 = Pattern.compile(EXP_RELUC_QUANT_FROM_1_TO_3);
    private static final Pattern PATTERN_RELUC_QUANT_FROM_0_TO_2 = Pattern.compile(EXP_RELUC_QUANT_FROM_0_TO_2);

    private boolean findAndExtract(String extractTarget, Matcher sample) {
        boolean findResult = sample.find();
        if (findResult) {
            LOGGER.debug("true :{} from {}", extractTarget.substring(sample.start(), sample.end()), extractTarget);
        } else {
            LOGGER.debug("false:{}", extractTarget);
        }
        return findResult;
    }

    public boolean findRelucQuantOnceOrNotAtAll(String text) {
        return findAndExtract(text, PATTERN_RELUC_QUANT_ONCE_OR_NOTATALL.matcher(text));
    }

    public boolean findRelucQuantZeroOrMore(String text) {
        return findAndExtract(text, PATTERN_RELUC_QUANT_ZERO_OR_MORE.matcher(text));
    }

    public boolean findRelucQuantOneOrMore(String text) {
        return findAndExtract(text, PATTERN_RELUC_QUANT_ONE_OR_MORE.matcher(text));
    }

    public boolean findRelucQuantExactlyN(String text) {
        return findAndExtract(text, PATTERN_RELUC_QUANT_EXACTLY_N.matcher(text));
    }

    public boolean findRelucQuantAtLeastN(String text) {
        return findAndExtract(text, PATTERN_RELUC_QUANT_AT_LEAST_N.matcher(text));
    }

    public boolean findRelucQuantFrom1to3(String text) {
        return findAndExtract(text, PATTERN_RELUC_QUANT_FROM_1_TO_3.matcher(text));
    }

    public boolean findRelucQuantFrom0to2(String text) {
        return findAndExtract(text, PATTERN_RELUC_QUANT_FROM_0_TO_2.matcher(text));
    }
}
