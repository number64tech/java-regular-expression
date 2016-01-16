package jp.number64.regex.quantifiers;

import static jp.number64.regex.quantifiers.GreedyQuantifiers.*;
import static org.junit.Assert.*;
import jp.number64.regex.quantifiers.RunningGreedyQuantifiersTest.GreedyQtAtLeastNTimesTest;
import jp.number64.regex.quantifiers.RunningGreedyQuantifiersTest.GreedyQtExacNTimesTest;
import jp.number64.regex.quantifiers.RunningGreedyQuantifiersTest.GreedyQtNtoMTimesTest;
import jp.number64.regex.quantifiers.RunningGreedyQuantifiersTest.GreedyQtOnceOrNotAtAllTest;
import jp.number64.regex.quantifiers.RunningGreedyQuantifiersTest.GreedyQtOneOrMoreMultiTest;
import jp.number64.regex.quantifiers.RunningGreedyQuantifiersTest.GreedyQtOneOrMoreTest;
import jp.number64.regex.quantifiers.RunningGreedyQuantifiersTest.GreedyQtZeroOrMoreTest;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * greedy quantifiers test
 */
@RunWith(Suite.class)
@SuiteClasses({
    GreedyQtOnceOrNotAtAllTest.class,
    GreedyQtZeroOrMoreTest.class,
    GreedyQtOneOrMoreTest.class,
    GreedyQtOneOrMoreMultiTest.class,
    GreedyQtExacNTimesTest.class,
    GreedyQtAtLeastNTimesTest.class,
    GreedyQtNtoMTimesTest.class
})
public class RunningGreedyQuantifiersTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(RunningGreedyQuantifiersTest.class);

    /**  */
    public static final class GreedyQtOnceOrNotAtAllTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_GQ_ONCE_OR_NAA: pattern=\"{}\"", EXP_GQ_ONCE_OR_NAA);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findGreedyQtOnceOrNotAtAll("64"));
            assertTrue(target.findGreedyQtOnceOrNotAtAll("ME64"));
            assertTrue(target.findGreedyQtOnceOrNotAtAll("NUMBER64"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findGreedyQtOnceOrNotAtAll("63"));
        }
    }

    /**  */
    public static final class GreedyQtZeroOrMoreTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_GQ_ZERO_OR_MT: pattern=\"{}\"", EXP_GQ_ZERO_OR_MT);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findGreedyQtZeroOrMore("NUMBER6"));
            assertTrue(target.findGreedyQtZeroOrMore("NUMBER64"));
            assertTrue(target.findGreedyQtZeroOrMore("NUMBER64444444444444"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findGreedyQtZeroOrMore("NUMBER"));
        }
    }

    /**  */
    public static final class GreedyQtOneOrMoreTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_GQ_ONE_OR_MT: pattern=\"{}\"", EXP_GQ_ONE_OR_MT);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findGreedyQtOneOrMore("NUMBER64"));
            assertTrue(target.findGreedyQtOneOrMore("NUMBER64444444444444"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findGreedyQtOneOrMore("NUMBER"));
            assertFalse(target.findGreedyQtOneOrMore("NUMBER6"));
        }
    }

    /**  */
    public static final class GreedyQtOneOrMoreMultiTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_GQ_ONE_OR_MT_MULTI: pattern=\"{}\"", EXP_GQ_ONE_OR_MT_MULTI);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findGreedyQtOneOrMoreMulti("\u8f5f"));
            assertTrue(target.findGreedyQtOneOrMoreMulti("\u8f5f\u8f5f\u8f5f\u8f5f"));
        }
    }

    /**  */
    public static final class GreedyQtExacNTimesTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_GQ_EXAC_N_TIMES: pattern=\"{}\"", EXP_GQ_EXAC_N_TIMES);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findGreedyQtExactlyN("NUMBER644"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findGreedyQtExactlyN("NUMBER6"));
            assertFalse(target.findGreedyQtExactlyN("NUMBER64"));
            assertFalse(target.findGreedyQtExactlyN("NUMBER642"));
        }
    }

    /**  */
    public static final class GreedyQtAtLeastNTimesTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_GQ_LEAST_N_TIMES: pattern=\"{}\"", EXP_GQ_LEAST_N_TIMES);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findGreedyQtAtLeasetN("NUMBER6444"));
            assertTrue(target.findGreedyQtAtLeasetN("NUMBER644444444444"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findGreedyQtAtLeasetN("NUMBER644"));
            assertFalse(target.findGreedyQtAtLeasetN("NUMBER643"));
        }
    }

    /**  */
    public static final class GreedyQtNtoMTimesTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_GQ_1_TO_3_TIMES: pattern=\"{}\"", EXP_GQ_1_TO_3_TIMES);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findGreedyQt1to3("NUMBER64"));
            assertTrue(target.findGreedyQt1to3("NUMBER64444444444444"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findGreedyQt1to3("NUMBER6"));
        }
    }

    /**  */
    public static final class GreedyQt0to2TimesTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_GQ_0_TO_2_TIMES: pattern=\"{}\"", EXP_GQ_0_TO_2_TIMES);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findGreedyQt0to2("NUMBER4"));
            assertTrue(target.findGreedyQt0to2("NUMBER64"));
            assertTrue(target.findGreedyQt0to2("NUMBER664"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findGreedyQt0to2("NUMBER6664"));
            assertFalse(target.findGreedyQt0to2("NUMBER6"));
        }
    }

    //--------------------------------------------------------------------------------------------------

    /** */
    public static abstract class TestBase {
        protected GreedyQuantifiers target;
        @Before
        public void doBefore() {
            target = new GreedyQuantifiers();
        }
    }
}
