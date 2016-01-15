package jp.number64.regex.quantifiers;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * greedy quantifiers <br>
 * <br>
 * X? X, once or not at all
 * X* X, zero or more times
 * X+ X, one or more times
 * X{n} X, exactly n times
 * X{n,} X, at least n times
 * X{n,m} X, at least n but not more than m times
 * <br>
 */
public class GreedyQuantifiers {
    private static final Logger LOGGER = LoggerFactory.getLogger(GreedyQuantifiers.class);

    /** X? X, once or not at all */
    public static final String EXP_GQ_ONCE_OR_NAA = "NUMBER6?4";
    /** X* X, zero or more times */
    public static final String EXP_GQ_ZERO_OR_MT = "NUMBER6*4";
    /** X+ X, one or more times */
    public static final String EXP_GQ_ONE_OR_MT = "NUMBER6+4";
    /** X{n} X, exactly n times */
    public static final String EXP_GQ_EXAC_N_TIMES = "N{2}UMBER64";
    /** X{n,} X, at least n times */
    public static final String EXP_GQ_LEAST_N_TIMES = "N{3,}UMBER64";
    /** X{n,m} X, at least n but not more than m times */
    public static final String EXP_GQ_N_TO_M_TIMES = "NU{0,2}MBER64";

    // -----------------------------------------------------------------------------------------------

    private static final Pattern PATTERN_GQ_ONCE_OR_NAA = Pattern.compile(EXP_GQ_ONCE_OR_NAA);
    private static final Pattern PATTERN_GQ_ZERO_OR_MT = Pattern.compile(EXP_GQ_ZERO_OR_MT);
    private static final Pattern PATTERN_GQ_ONE_OR_MT = Pattern.compile(EXP_GQ_ONE_OR_MT);
    private static final Pattern PATTERN_GQ_EXAC_N_TIMES = Pattern.compile(EXP_GQ_EXAC_N_TIMES);
    private static final Pattern PATTERN_GQ_LEAST_N_TIMES = Pattern.compile(EXP_GQ_LEAST_N_TIMES);
    private static final Pattern PATTERN_GQ_N_TO_M_TIMES = Pattern.compile(EXP_GQ_N_TO_M_TIMES);

    public boolean findGreedyQtOnceOrNotAtAll(String text) {
        boolean result = PATTERN_GQ_ONCE_OR_NAA.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findGreedyQtZeroOrMore(String text) {
        boolean result = PATTERN_GQ_ZERO_OR_MT.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findGreedyQtOneOrMore(String text) {
        boolean result = PATTERN_GQ_ONE_OR_MT.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findGreedyQtExactlyN(String text) {
        boolean result = PATTERN_GQ_EXAC_N_TIMES.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findGreedyQtAtLeasetN(String text) {
        boolean result = PATTERN_GQ_LEAST_N_TIMES.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findGreedyQtNtoM(String text) {
        boolean result = PATTERN_GQ_N_TO_M_TIMES.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

}
