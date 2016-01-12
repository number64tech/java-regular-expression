package jp.number64.regex.expressions;

import static jp.number64.regex.expressions.CharacterClass.*;
import static org.junit.Assert.*;
import jp.number64.regex.expressions.RunningCharacterClassTest.NegationCharsTest;
import jp.number64.regex.expressions.RunningCharacterClassTest.RangeAndRangeTest;
import jp.number64.regex.expressions.RunningCharacterClassTest.RangeCharsTest;
import jp.number64.regex.expressions.RunningCharacterClassTest.RangeExceptingCharsTest;
import jp.number64.regex.expressions.RunningCharacterClassTest.RangeExceptingRangeTest;
import jp.number64.regex.expressions.RunningCharacterClassTest.RangeOrRangeTest;
import jp.number64.regex.expressions.RunningCharacterClassTest.SimpleCharsTest;

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
    RangeCharsTest.class,
    RangeOrRangeTest.class,
    RangeAndRangeTest.class,
    RangeExceptingCharsTest.class,
    RangeExceptingRangeTest.class
})
public class RunningCharacterClassTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(RunningCharacterClassTest.class);

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

    /**  */
    public static final class RangeOrRangeTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_RANGE_OR_RANGE: pattern=\"{}\"", EXP_RANGE_OR_RANGE);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findRangeOrRange("nUMBER04"));
            assertTrue(target.findRangeOrRange("NUMBER34"));
            assertTrue(target.findRangeOrRange("NUMBER64"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findRangeOrRange("mUMBER04"));
            assertFalse(target.findRangeOrRange("OUMBER04"));
            assertFalse(target.findRangeOrRange("NUMBER24"));
            assertFalse(target.findRangeOrRange("NUMBER54"));
            assertFalse(target.findRangeOrRange("NUMBER84"));
        }
    }

    /**  */
    public static final class RangeAndRangeTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_RANGE_AND_RANGE: pattern=\"{}\"", EXP_RANGE_AND_RANGE);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findRangeAndRange("mUMBER64"));
            assertTrue(target.findRangeAndRange("nUMBER64"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findRangeAndRange("aUMBER64"));
            assertFalse(target.findRangeAndRange("oUMBER64"));
        }
    }

    /**  */
    public static final class RangeExceptingCharsTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_RANGE_EXCEPTING_CHARS: pattern=\"{}\"", EXP_RANGE_EXCEPTING_CHARS);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findRangeExceptingChars("nUMBER64"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findRangeExceptingChars("mUMBER64"));
            assertFalse(target.findRangeExceptingChars("oUMBER64"));
        }
    }

    /**  */
    public static final class RangeExceptingRangeTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_RANGE_EXCEPTING_RANGE: pattern=\"{}\"", EXP_RANGE_EXCEPTING_RANGE);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findRangeExceptingRange("AUMBER64"));
            assertTrue(target.findRangeExceptingRange("EUMBER64"));
            assertTrue(target.findRangeExceptingRange("NUMBER64"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findRangeExceptingRange("BUMBER64"));
            assertFalse(target.findRangeExceptingRange("OUMBER64"));
        }
    }

    //--------------------------------------------------------------------------------------------------

    /** */
    public static abstract class TestBase {
        protected CharacterClass target;
        @Before
        public void doBefore() {
            target = new CharacterClass();
        }
    }
}
