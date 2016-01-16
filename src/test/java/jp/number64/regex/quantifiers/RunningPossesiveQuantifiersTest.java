package jp.number64.regex.quantifiers;

import static jp.number64.regex.quantifiers.PossessiveQuantifiers.*;
import static org.junit.Assert.*;
import jp.number64.regex.quantifiers.RunningPossesiveQuantifiersTest.PosQuant0to2TimesTest;
import jp.number64.regex.quantifiers.RunningPossesiveQuantifiersTest.PosQuant1to3TimesTest;
import jp.number64.regex.quantifiers.RunningPossesiveQuantifiersTest.PosQuantAtLeastNTimesTest;
import jp.number64.regex.quantifiers.RunningPossesiveQuantifiersTest.PosQuantExactlyNTimesTest;
import jp.number64.regex.quantifiers.RunningPossesiveQuantifiersTest.PosQuantOnceOrNotAtAllAlnumTest;
import jp.number64.regex.quantifiers.RunningPossesiveQuantifiersTest.PosQuantOnceOrNotAtAllAlpTest;
import jp.number64.regex.quantifiers.RunningPossesiveQuantifiersTest.PosQuantOneOrMoreTest;
import jp.number64.regex.quantifiers.RunningPossesiveQuantifiersTest.PosQuantZeroOrMoreFirstTest;
import jp.number64.regex.quantifiers.RunningPossesiveQuantifiersTest.PosQuantZeroOrMoreLastTest;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Possessive quantifiers test
 */
@RunWith(Suite.class)
@SuiteClasses({
    PosQuantOnceOrNotAtAllAlpTest.class,
    PosQuantOnceOrNotAtAllAlnumTest.class,
    PosQuantZeroOrMoreFirstTest.class,
    PosQuantZeroOrMoreLastTest.class,
    PosQuantOneOrMoreTest.class,
    PosQuantExactlyNTimesTest.class,
    PosQuantAtLeastNTimesTest.class,
    PosQuant1to3TimesTest.class,
    PosQuant0to2TimesTest.class
})
public class RunningPossesiveQuantifiersTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(RunningPossesiveQuantifiersTest.class);

    /**  */
    public static final class PosQuantOnceOrNotAtAllAlpTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_POS_QUANT_ONCE_OR_NOTATALL_ALLALP: pattern=\"{}\"", EXP_POS_QUANT_ONCE_OR_NOTATALL_ALLALP);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findPosQuantOnceOrNotAtAllAlp("abcdefgh"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findPosQuantOnceOrNotAtAllAlp("ab"));
            assertFalse(target.findPosQuantOnceOrNotAtAllAlp("abc"));
            assertFalse(target.findPosQuantOnceOrNotAtAllAlp("abcde"));
        }
    }

    /**  */
    public static final class PosQuantOnceOrNotAtAllAlnumTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_POS_QUANT_ONCE_OR_NOTATALL_ALNUM: pattern=\"{}\"", EXP_POS_QUANT_ONCE_OR_NOTATALL_ALNUM);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findPosQuantOnceOrNotAtAllAlnum("abc123"));
            assertTrue(target.findPosQuantOnceOrNotAtAllAlnum("ab123"));
            assertTrue(target.findPosQuantOnceOrNotAtAllAlnum("123"));
            assertTrue(target.findPosQuantOnceOrNotAtAllAlnum("abcdef123"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findPosQuantOnceOrNotAtAllAlnum("abc"));
        }
    }

    /** Pattern "X*+" is greedly & possessive. Correctly, first-MORE next-ZERO. <br>
     * In this sample, first, pattern "[A-Z]*+" eats away all text 'BER', so next, pattern "BER" doesn't match.
     */
    public static final class PosQuantZeroOrMoreFirstTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_POS_QUANT_ZERO_OR_MORE_FIRST: pattern=\"{}\"", EXP_POS_QUANT_ZERO_OR_MORE_FIRST);
        }
        public void caseTrue() {
            // this pattern doesn't match any text.
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findPosQuantZeroOrMoreFirst("BER"));
            assertFalse(target.findPosQuantZeroOrMoreFirst("MBER"));
            assertFalse(target.findPosQuantZeroOrMoreFirst("NUMBER"));
        }
    }

    /**  */
    public static final class PosQuantZeroOrMoreLastTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_POS_QUANT_ZERO_OR_MORE_LAST: pattern=\"{}\"", EXP_POS_QUANT_ZERO_OR_MORE_LAST);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findPosQuantZeroOrMoreLast("NUMBER6"));
            assertTrue(target.findPosQuantZeroOrMoreLast("NUMBER66666666666666666664"));
            assertTrue(target.findPosQuantZeroOrMoreLast("NUMBER"));
            assertTrue(target.findPosQuantZeroOrMoreLast("NUMBERRR"));
        }
        public void caseFalse() {
            assertFalse(target.findPosQuantZeroOrMoreLast("64"));
        }
    }

    /**  */
    public static final class PosQuantOneOrMoreTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_POS_QUANT_ONE_OR_MORE: pattern=\"{}\"", EXP_POS_QUANT_ONE_OR_MORE);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findPosQuantOneOrMore("NUMBER6"));
            assertTrue(target.findPosQuantOneOrMore("NUMBER66666666666666666666664"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findPosQuantOneOrMore("NUMBER"));
            assertFalse(target.findPosQuantOneOrMore("NUMBERRR"));
        }
    }

    /**  */
    public static final class PosQuantExactlyNTimesTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_POS_QUANT_EXACTLY_N: pattern=\"{}\"", EXP_POS_QUANT_EXACTLY_N);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findPosQuantExactlyN("NUMBER64"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findPosQuantExactlyN("NUmBER64"));
        }
    }

    /**  */
    public static final class PosQuantAtLeastNTimesTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_POS_QUANT_AT_LEAST_N: pattern=\"{}\"", EXP_POS_QUANT_AT_LEAST_N);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findPosQuantAtLeastN("NUMBE64"));
            assertTrue(target.findPosQuantAtLeastN("NUMBERRRRRRRRRRRRR64"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findPosQuantAtLeastN("NUMB64"));
        }
    }

    /**  */
    public static final class PosQuant1to3TimesTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_POS_QUANT_FROM_1_TO_3: pattern=\"{}\"", EXP_POS_QUANT_FROM_1_TO_3);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findPosQuantFrom1to3("NUMBER"));
            assertTrue(target.findPosQuantFrom1to3("NUMBE9"));
            assertTrue(target.findPosQuantFrom1to3("NUMB9"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findPosQuantFrom1to3("NU9"));
            assertFalse(target.findPosQuantFrom1to3("NUMBE"));
        }
    }

    /**  */
    public static final class PosQuant0to2TimesTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_POS_QUANT_FROM_0_TO_2: pattern=\"{}\"", EXP_POS_QUANT_FROM_0_TO_2);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findPosQuantFrom0to2("NUMBE"));
            assertTrue(target.findPosQuantFrom0to2("NUMB9"));
            assertTrue(target.findPosQuantFrom0to2("NU9"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findPosQuantFrom0to2("NUM"));
            assertFalse(target.findPosQuantFrom0to2("NUMB"));
            assertFalse(target.findPosQuantFrom0to2("NUMBr"));
        }
    }

    //--------------------------------------------------------------------------------------------------

    /** */
    public static abstract class TestBase {
        protected PossessiveQuantifiers target;
        @Before
        public void doBefore() {
            target = new PossessiveQuantifiers();
        }
    }

}
