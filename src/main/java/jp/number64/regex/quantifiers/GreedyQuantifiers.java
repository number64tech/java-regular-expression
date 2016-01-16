package jp.number64.regex.quantifiers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * greedy quantifiers <br>
 * <br>
 * X? X, once or not at all <br>
 * X* X, zero or more times <br>
 * X+ X, one or more times <br>
 * X{n} X, exactly n times <br>
 * X{n,} X, at least n times <br>
 * X{n,m} X, at least n but not more than m times <br>
 * <br>
 */
public class GreedyQuantifiers {
    private static final Logger LOGGER = LoggerFactory.getLogger(GreedyQuantifiers.class);

    /** X? X, once or not at all */
    public static final String EXP_GQ_ONCE_OR_NAA = "N?U?M?B?E?R?64";
    /** X* X, zero or more times */
    public static final String EXP_GQ_ZERO_OR_MT = "NUMBER64*";
    /** X+ X, one or more times */
    public static final String EXP_GQ_ONE_OR_MT = "NUMBER64+";
    /** X+ X, one or more times */
    public static final String EXP_GQ_ONE_OR_MT_MULTI = "\u8f5f+";
    /** X{n} X, exactly n times */
    public static final String EXP_GQ_EXAC_N_TIMES = "NUMBER64{2}";
    /** X{n,} X, at least n times */
    public static final String EXP_GQ_LEAST_N_TIMES = "NUMBER64{3,}";
    /** X{n,m} X, at least n but not more than m times ... of 1 */
    public static final String EXP_GQ_1_TO_3_TIMES = "NUMBER64{1,3}";
    /** X{n,m} X, at least n but not more than m times ... of 2 */
    public static final String EXP_GQ_0_TO_2_TIMES = "NUMBER6{0,2}4";

    // -----------------------------------------------------------------------------------------------

    private static final Pattern PATTERN_GQ_ONCE_OR_NAA = Pattern.compile(EXP_GQ_ONCE_OR_NAA);
    private static final Pattern PATTERN_GQ_ZERO_OR_MT = Pattern.compile(EXP_GQ_ZERO_OR_MT);
    private static final Pattern PATTERN_GQ_ONE_OR_MT = Pattern.compile(EXP_GQ_ONE_OR_MT);
    private static final Pattern PATTERN_GQ_ONE_OR_MT_MULTI = Pattern.compile(EXP_GQ_ONE_OR_MT_MULTI);
    private static final Pattern PATTERN_GQ_EXAC_N_TIMES = Pattern.compile(EXP_GQ_EXAC_N_TIMES);
    private static final Pattern PATTERN_GQ_LEAST_N_TIMES = Pattern.compile(EXP_GQ_LEAST_N_TIMES);
    private static final Pattern PATTERN_GQ_1_TO_3_TIMES = Pattern.compile(EXP_GQ_1_TO_3_TIMES);
    private static final Pattern PATTERN_GQ_0_TO_2_TIMES = Pattern.compile(EXP_GQ_0_TO_2_TIMES);

    private boolean findAndExtract(String extractTarget, Matcher sample) {
        boolean findResult = sample.find();
        if (findResult) {
            LOGGER.debug("true :{} from {}", extractTarget.substring(sample.start(), sample.end()), extractTarget);
        } else {
            LOGGER.debug("false:{}", extractTarget);
        }
        return findResult;
    }

    public boolean findGreedyQtOnceOrNotAtAll(String text) {
        return findAndExtract(text, PATTERN_GQ_ONCE_OR_NAA.matcher(text));
    }

    public boolean findGreedyQtZeroOrMore(String text) {
        return findAndExtract(text, PATTERN_GQ_ZERO_OR_MT.matcher(text));
    }

    public boolean findGreedyQtOneOrMore(String text) {
        return findAndExtract(text, PATTERN_GQ_ONE_OR_MT.matcher(text));
    }

    public boolean findGreedyQtOneOrMoreMulti(String text) {
        return findAndExtract(text, PATTERN_GQ_ONE_OR_MT_MULTI.matcher(text));
    }

    public boolean findGreedyQtExactlyN(String text) {
        return findAndExtract(text, PATTERN_GQ_EXAC_N_TIMES.matcher(text));
    }

    public boolean findGreedyQtAtLeasetN(String text) {
        return findAndExtract(text, PATTERN_GQ_LEAST_N_TIMES.matcher(text));
    }

    public boolean findGreedyQt1to3(String text) {
        return findAndExtract(text, PATTERN_GQ_1_TO_3_TIMES.matcher(text));
    }

    public boolean findGreedyQt0to2(String text) {
        return findAndExtract(text, PATTERN_GQ_0_TO_2_TIMES.matcher(text));
    }
}
