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
            assertTrue(target.findRangeQuote(""));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findRangeQuote(""));
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
            assertTrue(target.findNonRangeQuote(""));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findNonRangeQuote(""));
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
            assertTrue(target.findMatchFlagI(""));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findMatchFlagI(""));
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
            assertTrue(target.findMatchFlagD(""));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findMatchFlagD(""));
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
            assertTrue(target.findMatchFlagM(""));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findMatchFlagM(""));
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
            assertTrue(target.findMatchFlagS(""));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findMatchFlagS(""));
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
            assertTrue(target.findMatchFlagU(""));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findMatchFlagU(""));
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
            assertTrue(target.findMatchFlagX(""));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findMatchFlagX(""));
        }
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
