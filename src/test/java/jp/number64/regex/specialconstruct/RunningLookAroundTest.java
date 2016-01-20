package jp.number64.regex.specialconstruct;

import static jp.number64.regex.specialconstruct.LookAround.*;
import static org.junit.Assert.*;
import jp.number64.regex.specialconstruct.RunningLookAroundTest.FindWithExcludingConditionTest;
import jp.number64.regex.specialconstruct.RunningLookAroundTest.LookAroundATest;
import jp.number64.regex.specialconstruct.RunningLookAroundTest.LookAroundBTest;
import jp.number64.regex.specialconstruct.RunningLookAroundTest.NegativeLookAheadTest;
import jp.number64.regex.specialconstruct.RunningLookAroundTest.NegativeLookBehindTest;
import jp.number64.regex.specialconstruct.RunningLookAroundTest.PositiveLookAheadTest;
import jp.number64.regex.specialconstruct.RunningLookAroundTest.PositiveLookBehindTest;

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
    PositiveLookAheadTest.class,
    NegativeLookAheadTest.class,
    PositiveLookBehindTest.class,
    NegativeLookBehindTest.class,
    LookAroundATest.class,
    LookAroundBTest.class,
    FindWithExcludingConditionTest.class
})
public class RunningLookAroundTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(RunningLookAroundTest.class);

    /**  */
    public static final class PositiveLookAheadTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_POSITIVE_LOOKAHEAD: pattern=\"{}\"", EXP_POSITIVE_LOOKAHEAD);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findPositiveLookAhead("NNNUMBER64"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findPositiveLookAhead("NNNUMber64"));
        }
    }

    /**  */
    public static final class NegativeLookAheadTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_NEGATIVE_LOOKAHEAD: pattern=\"{}\"", EXP_NEGATIVE_LOOKAHEAD);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findNegativeLookAhead("NNNUMNUM64"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findNegativeLookAhead("NNNUMBER64"));
        }
    }

    /**  */
    public static final class PositiveLookBehindTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_POSITIVE_LOOKBEHIND: pattern=\"{}\"", EXP_POSITIVE_LOOKBEHIND);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findPositiveLookBehind("NUMBER64"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findPositiveLookBehind("NUMber64"));
        }
    }

    /**  */
    public static final class NegativeLookBehindTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_NEGATIVE_LOOKBEHIND: pattern=\"{}\"", EXP_NEGATIVE_LOOKBEHIND);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findNegativeLookBehind("numBER64"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findNegativeLookBehind("NUMBER64"));
        }
    }

    /**  */
    public static final class LookAroundATest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_LOOKAROUND_A: pattern=\"{}\"", EXP_LOOKAROUND_A);
        }
        @Test
        public void case01() {
            assertTrue(target.findLookAroundA("NUMNUM numBER NUMBER"));
        }
    }

    /**  */
    public static final class LookAroundBTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_LOOKAROUND_B: pattern=\"{}\"", EXP_LOOKAROUND_B);
        }
        @Test
        public void case01() {
            assertTrue(target.findLookAroundB("NUM-NUM num-BER NUM-BER num-ber"));
        }
    }

    /**  */
    public static final class FindWithExcludingConditionTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_EXCLUDING_CONDITION: pattern=\"{}\"", EXP_EXCLUDING_CONDITION);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findWithExcludingCondition("NUM"));
            assertTrue(target.findWithExcludingCondition("numNUMberBER"));
            assertTrue(target.findWithExcludingCondition("numNUM"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findWithExcludingCondition("num"));
            assertFalse(target.findWithExcludingCondition("NUM64"));
            assertFalse(target.findWithExcludingCondition("NUMber64ber"));
            assertFalse(target.findWithExcludingCondition("64numNUMberBER"));
            assertFalse(target.findWithExcludingCondition("num64NUMberBER"));
            assertFalse(target.findWithExcludingCondition("numNUM64berBER"));
            assertFalse(target.findWithExcludingCondition("numNUMberBER64"));
            assertFalse(target.findWithExcludingCondition("64NUM"));
            assertFalse(target.findWithExcludingCondition("num64numNUM"));
        }
    }

    //--------------------------------------------------------------------------------------------------

    /** */
    public static abstract class TestBase {
        protected LookAround target;
        @Before
        public void doBefore() {
            target = new LookAround();
        }
    }
}
