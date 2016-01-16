package jp.number64.regex.quantifiers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Possessive quantifiers <br>
 * <br>
 * X?+ X, once or not at all <br>
 * X*+ X, zero or more times <br>
 * X++ X, one or more times <br>
 * X{n}+ X, exactly n times <br>
 * X{n,}+ X, at least n times <br>
 * X{n,m}+ X, at least n but not more than m times <br>
 * <br>
 * note: "Possessive quantifiers" doesn't backtrack. see testresults. <br>
 */
public class PossessiveQuantifiers {
    private static final Logger LOGGER = LoggerFactory.getLogger(PossessiveQuantifiers.class);

    /** X?+ X, once or not at all */
    public static final String EXP_POS_QUANT_ONCE_OR_NOTATALL_ALLALP = "[a-z]?+[a-z]?+[a-z]?+[a-z]{3}";
    /** X?+ X, once or not at all */
    public static final String EXP_POS_QUANT_ONCE_OR_NOTATALL_ALNUM = "[a-z]?+[a-z]?+[a-z]?+[0-9]{3}";
    /** X*+ X, zero or more times */
    public static final String EXP_POS_QUANT_ZERO_OR_MORE_FIRST = "[A-Z]*+BER";
    /** X*+ X, zero or more times */
    public static final String EXP_POS_QUANT_ZERO_OR_MORE_LAST = "NUMBER[0-9]*+";
    /** X++ X, one or more times */
    public static final String EXP_POS_QUANT_ONE_OR_MORE = "NUMBER[0-9]++";
    /** X{n}+ X, exactly n times */
    public static final String EXP_POS_QUANT_EXACTLY_N = "[A-Z]{3}+BER";
    /** X{n,}+ X, at least n times */
    public static final String EXP_POS_QUANT_AT_LEAST_N = "NU[A-Z]{3,}+64";
    /** X{n,m}+ X, at least n but not more than m times */
    public static final String EXP_POS_QUANT_FROM_1_TO_3 = "NU[A-Z]{1,3}+[A-Z0-9]";
    /** X{n,m}+ X, at least n but not more than m times */
    public static final String EXP_POS_QUANT_FROM_0_TO_2 = "NU[A-Z]{0,2}+[A-Z0-9]";

    // -----------------------------------------------------------------------------------------------

    private static final Pattern PATTERN_POS_QUANT_ONCE_OR_NOTATALL_ALLALP = Pattern.compile(EXP_POS_QUANT_ONCE_OR_NOTATALL_ALLALP);
    private static final Pattern PATTERN_POS_QUANT_ONCE_OR_NOTATALL_ALNUM = Pattern.compile(EXP_POS_QUANT_ONCE_OR_NOTATALL_ALNUM);
    private static final Pattern PATTERN_POS_QUANT_ZERO_OR_MORE_FIRST = Pattern.compile(EXP_POS_QUANT_ZERO_OR_MORE_FIRST);
    private static final Pattern PATTERN_POS_QUANT_ZERO_OR_MORE_LAST = Pattern.compile(EXP_POS_QUANT_ZERO_OR_MORE_LAST);
    private static final Pattern PATTERN_POS_QUANT_ONE_OR_MORE = Pattern.compile(EXP_POS_QUANT_ONE_OR_MORE);
    private static final Pattern PATTERN_POS_QUANT_EXACTLY_N = Pattern.compile(EXP_POS_QUANT_EXACTLY_N);
    private static final Pattern PATTERN_POS_QUANT_AT_LEAST_N = Pattern.compile(EXP_POS_QUANT_AT_LEAST_N);
    private static final Pattern PATTERN_POS_QUANT_FROM_1_TO_3 = Pattern.compile(EXP_POS_QUANT_FROM_1_TO_3);
    private static final Pattern PATTERN_POS_QUANT_FROM_0_TO_2 = Pattern.compile(EXP_POS_QUANT_FROM_0_TO_2);

    private boolean findAndExtract(String extractTarget, Matcher sample) {
        boolean findResult = sample.find();
        if (findResult) {
            LOGGER.debug("true :{} from {}", extractTarget.substring(sample.start(), sample.end()), extractTarget);
        } else {
            LOGGER.debug("false:{}", extractTarget);
        }
        return findResult;
    }

    public boolean findPosQuantOnceOrNotAtAllAlp(String text) {
        return findAndExtract(text, PATTERN_POS_QUANT_ONCE_OR_NOTATALL_ALLALP.matcher(text));
    }

    public boolean findPosQuantOnceOrNotAtAllAlnum(String text) {
        return findAndExtract(text, PATTERN_POS_QUANT_ONCE_OR_NOTATALL_ALNUM.matcher(text));
    }

    public boolean findPosQuantZeroOrMoreFirst(String text) {
        return findAndExtract(text, PATTERN_POS_QUANT_ZERO_OR_MORE_FIRST.matcher(text));
    }

    public boolean findPosQuantZeroOrMoreLast(String text) {
        return findAndExtract(text, PATTERN_POS_QUANT_ZERO_OR_MORE_LAST.matcher(text));
    }

    public boolean findPosQuantOneOrMore(String text) {
        return findAndExtract(text, PATTERN_POS_QUANT_ONE_OR_MORE.matcher(text));
    }

    public boolean findPosQuantExactlyN(String text) {
        return findAndExtract(text, PATTERN_POS_QUANT_EXACTLY_N.matcher(text));
    }

    public boolean findPosQuantAtLeastN(String text) {
        return findAndExtract(text, PATTERN_POS_QUANT_AT_LEAST_N.matcher(text));
    }

    public boolean findPosQuantFrom1to3(String text) {
        return findAndExtract(text, PATTERN_POS_QUANT_FROM_1_TO_3.matcher(text));
    }

    public boolean findPosQuantFrom0to2(String text) {
        return findAndExtract(text, PATTERN_POS_QUANT_FROM_0_TO_2.matcher(text));
    }
}
