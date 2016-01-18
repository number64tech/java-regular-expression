package jp.number64.regex.specialconstruct;

import static jp.number64.regex.specialconstruct.LookAround.*;
import static org.junit.Assert.*;
import jp.number64.regex.specialconstruct.RunningLookAroundTest.PositiveLookAheadTest;

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
    PositiveLookAheadTest.class
})
public class RunningLookAroundTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(PositiveLookAheadTest.class);

    /**  */
    public static final class PositiveLookAheadTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_CAPTURING_NAMED: pattern=\"{}\"", EXP_POSITIVE_LOOKAHEAD);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findPositiveLookAhead("NUMBER64"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findPositiveLookAhead("NUMBER64"));
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
