package jp.number64.regex.expressions;

import static jp.number64.regex.expressions.CharactorClass.*;
import static org.junit.Assert.*;
import jp.number64.regex.expressions.CharactorClassTest.NegationCharsTest;
import jp.number64.regex.expressions.CharactorClassTest.RangeCharsTest;
import jp.number64.regex.expressions.CharactorClassTest.SimpleCharsTest;

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
    SimpleCharsTest.class,
    NegationCharsTest.class,
    RangeCharsTest.class
})
public class CharactorClassTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(CharactorClassTest.class);

    /**  */
    public static final class SimpleCharsTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_SIMPLE_CHARS: pattern=\"{}\"", EXP_SIMPLE_CHARS);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findSimpleChars("nUMBER64"));
            assertTrue(target.findSimpleChars("NuMBER64"));
            assertTrue(target.findSimpleChars("nuMBER64"));
            assertTrue(target.findSimpleChars("NUMBER64"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findSimpleChars("nUMBER46"));
        }
    }

    /**  */
    public static final class NegationCharsTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_NEGATION_CHARS: pattern=\"{}\"", EXP_NEGATION_CHARS);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findNegationChars("BOMBER64"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findNegationChars("nUMBER64"));
            assertFalse(target.findNegationChars("NuMBER64"));
            assertFalse(target.findNegationChars("nuMBER64"));
            assertFalse(target.findNegationChars("NUMBER64"));
        }
    }

    /**  */
    public static final class RangeCharsTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_RANGE_CHARS: pattern=\"{}\"", EXP_RANGE_CHARS);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findRangeChars("nUMBER64"));
            assertTrue(target.findRangeChars("nUMBER46"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findRangeChars("NuMBER64"));
            assertFalse(target.findRangeChars("nuMBER64"));
            assertFalse(target.findRangeChars("nUMBER63"));
        }
    }

    //--------------------------------------------------------------------------------------------------

    /** */
    public static abstract class TestBase {
        protected CharactorClass target;
        @Before
        public void doBefore() {
            target = new CharactorClass();
        }
    }
}
