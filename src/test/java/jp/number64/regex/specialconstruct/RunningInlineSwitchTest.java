package jp.number64.regex.specialconstruct;

import static jp.number64.regex.specialconstruct.InlineSwitch.*;
import static org.junit.Assert.*;
import jp.number64.regex.specialconstruct.RunningInlineSwitchTest.MatchFlagDTest;
import jp.number64.regex.specialconstruct.RunningInlineSwitchTest.MatchFlagITest;
import jp.number64.regex.specialconstruct.RunningInlineSwitchTest.MatchFlagMTest;
import jp.number64.regex.specialconstruct.RunningInlineSwitchTest.MatchFlagSTest;
import jp.number64.regex.specialconstruct.RunningInlineSwitchTest.MatchFlagUTest;
import jp.number64.regex.specialconstruct.RunningInlineSwitchTest.MatchFlagXTest;
import jp.number64.regex.specialconstruct.RunningInlineSwitchTest.NonCapturingMatchFlagsTest;
import jp.number64.regex.specialconstruct.RunningInlineSwitchTest.NonRangeQuoteTest;
import jp.number64.regex.specialconstruct.RunningInlineSwitchTest.RangeQuoteTest;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(Suite.class)
@SuiteClasses({
    RangeQuoteTest.class,
    NonRangeQuoteTest.class,
    MatchFlagITest.class,
    MatchFlagDTest.class,
    MatchFlagMTest.class,
    MatchFlagSTest.class,
    MatchFlagUTest.class,
    MatchFlagXTest.class,
    //MatchFlagUpperUTest.class,
    NonCapturingMatchFlagsTest.class
})
public class RunningInlineSwitchTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(RunningInlineSwitchTest.class);

    /**  */
    public static final class RangeQuoteTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_RANGE_QUOTE: pattern=\"{}\"", EXP_RANGE_QUOTE);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findRangeQuote("NUM*(BER)=6*4"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findRangeQuote("NUMMMBER=66664"));
        }
    }

    /**  */
    public static final class NonRangeQuoteTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_NON_RANGE_QUOTE: pattern=\"{}\"", EXP_NON_RANGE_QUOTE);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findNonRangeQuote("NUMMMBER=66664"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findNonRangeQuote("NUM*(BER)=6*4"));
        }
    }

    /**  */
    public static final class MatchFlagITest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_MATCH_FLAG_I: pattern=\"{}\"", EXP_MATCH_FLAG_I);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findMatchFlagI("NUMBER64"));
            assertTrue(target.findMatchFlagI("NUmbeR64"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findMatchFlagI("NUmBEr64"));
        }
    }

    /**  */
    public static final class MatchFlagDTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_MATCH_FLAG_D: pattern=\"{}\"", EXP_MATCH_FLAG_D);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findMatchFlagD("NUM\n"));
            assertTrue(target.findMatchFlagD("numm"));
            assertTrue(target.findMatchFlagD("num\r")); // In (?d) block, \r is NOT line-terminator.
            assertTrue(target.findMatchFlagD("ber\r"));
            assertTrue(target.findMatchFlagD("ber\n"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findMatchFlagD("NUMM"));
            assertFalse(target.findMatchFlagD("num\n")); // In (?d) block, \n is line-terminator.
            assertFalse(target.findMatchFlagD("NUM\r"));
        }
    }

    /**  */
    public static final class MatchFlagMTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_MATCH_FLAG_M: pattern=\"{}\"", EXP_MATCH_FLAG_M);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findMatchFlagM("NUMBER\n64"));
            assertTrue(target.findMatchFlagM("NUMBER\n"));
            assertTrue(target.findMatchFlagM("NUMBER"));
            assertTrue(target.findMatchFlagM("NUMber\n"));  // caution: by defaut, ending \n matchs "$"
            assertTrue(target.findMatchFlagM("NUMber"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findMatchFlagM("NUMber\n64")); // this text is NOT ending \n, so "ber$" doesn't match.
        }
    }

    /**  */
    public static final class MatchFlagSTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_MATCH_FLAG_S: pattern=\"{}\"", EXP_MATCH_FLAG_S);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findMatchFlagS("NUMM"));
            assertTrue(target.findMatchFlagS("NUM\r"));
            assertTrue(target.findMatchFlagS("NUM\n"));
            assertTrue(target.findMatchFlagS("numm"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findMatchFlagS("num\r"));
            assertFalse(target.findMatchFlagS("num\n"));
        }
    }

    /**  */
    public static final class MatchFlagUTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_MATCH_FLAG_U: pattern=\"{}\"", EXP_MATCH_FLAG_U);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findMatchFlagU("num"));
            assertTrue(target.findMatchFlagU("NUM"));
            assertTrue(target.findMatchFlagU("\u03a3")); // SIGMA-U
            assertTrue(target.findMatchFlagU("\u03c3")); // SIGMA-L
            assertTrue(target.findMatchFlagU("\u0393")); // GAMMA-U
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findMatchFlagU("\u03b3")); // GAMMA-L
        }
    }

    /**  */
    public static final class MatchFlagXTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_MATCH_FLAG_X: pattern=\"{}\"", EXP_MATCH_FLAG_X);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findMatchFlagX("NUMBER64"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findMatchFlagX("NUMBER 64 "));
            assertFalse(target.findMatchFlagX("NUM"));
            assertFalse(target.findMatchFlagX("num"));
        }
    }

    /**  */
    public static final class MatchFlagUpperUTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_MATCH_FLAG_UPPER_U: pattern=\"{}\"", EXP_MATCH_FLAG_UPPER_U);
        }
        // ?
    }

    /**  */
    public static final class NonCapturingMatchFlagsTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_NON_CAPTURING_MATCH_FLAGS: pattern=\"{}\"", EXP_NON_CAPTURING_MATCH_FLAGS);
        }
        @Test
        public void case01() {
            assertEquals("", target.findNonCapturingMatchFlags("", 1));
        }
        @Test
        public void case02() {
            assertEquals("", target.findNonCapturingMatchFlags("", 1));
        }
    }


    //--------------------------------------------------------------------------------------------------

    /** */
    public static abstract class TestBase {
        protected InlineSwitch target;
        @Before
        public void doBefore() {
            target = new InlineSwitch();
        }
    }
}
