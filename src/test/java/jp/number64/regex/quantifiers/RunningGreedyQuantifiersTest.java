package jp.number64.regex.quantifiers;

import static jp.number64.regex.quantifiers.GreedyQuantifiers.*;
import static org.junit.Assert.*;
import jp.number64.regex.quantifiers.RunningGreedyQuantifiersTest.GreedyQtAtLeastNTimesTest;
import jp.number64.regex.quantifiers.RunningGreedyQuantifiersTest.GreedyQtExacNTimesTest;
import jp.number64.regex.quantifiers.RunningGreedyQuantifiersTest.GreedyQtNtoMTimesTest;
import jp.number64.regex.quantifiers.RunningGreedyQuantifiersTest.GreedyQtOnceOrNotAtAllTest;
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
            assertTrue(target.findGreedyQtOnceOrNotAtAll("NUMBER64"));
            assertTrue(target.findGreedyQtOnceOrNotAtAll("NUMBER4"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findGreedyQtOnceOrNotAtAll("NUMBER664"));
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
            assertTrue(target.findGreedyQtZeroOrMore("NUMBER64"));
            assertTrue(target.findGreedyQtZeroOrMore("NUMBER4"));
            assertTrue(target.findGreedyQtZeroOrMore("NUMBER6666666664"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findGreedyQtZeroOrMore("NUMBER54"));
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
            assertTrue(target.findGreedyQtOneOrMore("NUMBER6666666664"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findGreedyQtOneOrMore("NUMBER4"));
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
            assertTrue(target.findGreedyQtExactlyN("NNUMBER64"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findGreedyQtExactlyN("NUMBER64"));
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
            assertTrue(target.findGreedyQtAtLeasetN("NNNUMBER64"));
            assertTrue(target.findGreedyQtAtLeasetN("NNNNNNNNNNNNNNNNNNNNUMBER64"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findGreedyQtAtLeasetN("NNUMBER64"));
        }
    }

    /**  */
    public static final class GreedyQtNtoMTimesTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_GQ_N_TO_M_TIMES: pattern=\"{}\"", EXP_GQ_N_TO_M_TIMES);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findGreedyQtNtoM("NUMBER64"));
            assertTrue(target.findGreedyQtNtoM("NUUMBER64"));
            assertTrue(target.findGreedyQtNtoM("NMBER64"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findGreedyQtNtoM("NUUUMBER64"));
            assertFalse(target.findGreedyQtNtoM("NOMBER64"));
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
