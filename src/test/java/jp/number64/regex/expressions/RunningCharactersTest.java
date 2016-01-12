package jp.number64.regex.expressions;

import static jp.number64.regex.expressions.Characters.*;
import static org.junit.Assert.*;
import jp.number64.regex.expressions.RunningCharactersTest.CharEscCarriageReturnTest;
import jp.number64.regex.expressions.RunningCharactersTest.CharEscLineBreakTest;
import jp.number64.regex.expressions.RunningCharactersTest.CharEscLineFeedTest;
import jp.number64.regex.expressions.RunningCharactersTest.CharEscTabTest;
import jp.number64.regex.expressions.RunningCharactersTest.CharHexValue2DigitsTest;
import jp.number64.regex.expressions.RunningCharactersTest.CharHexValue4DigitsTest;
import jp.number64.regex.expressions.RunningCharactersTest.CharHexValueFlexDigitsTest;
import jp.number64.regex.expressions.RunningCharactersTest.CharOctalValue1DigitTest;
import jp.number64.regex.expressions.RunningCharactersTest.CharOctalValue2DigitsTest;
import jp.number64.regex.expressions.RunningCharactersTest.CharOctalValue3DigitsTest;

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
    CharOctalValue1DigitTest.class,
    CharOctalValue2DigitsTest.class,
    CharOctalValue3DigitsTest.class,
    CharHexValue2DigitsTest.class,
    CharHexValue4DigitsTest.class,
    CharHexValueFlexDigitsTest.class,
    CharEscTabTest.class,
    CharEscLineFeedTest.class,
    CharEscCarriageReturnTest.class,
    CharEscLineBreakTest.class,
})
public class RunningCharactersTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(RunningCharactersTest.class);

    /**  */
    public static final class CharOctalValue1DigitTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_OCTAL_VALUE_1_DIGIT: \"\" pattern=\"{}\"", EXP_OCTAL_VALUE_1_DIGIT);
        }
        @Test
        public void caseTrue() {
            assertTrue(true);
            fail(); // this method had not been implemented.
        }
        @Test
        public void caseFalse() {
            assertFalse(false);
            fail(); // this method had not been implemented.
        }
    }

    /**  */
    public static final class CharOctalValue2DigitsTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_OCTAL_VALUE_2_DIGITS: pattern=\"{}\"", EXP_OCTAL_VALUE_2_DIGITS);
        }
        @Test
        public void caseTrue() {
            assertTrue(true);
            fail(); // this method had not been implemented.
        }
        @Test
        public void caseFalse() {
            assertFalse(false);
            fail(); // this method had not been implemented.
        }
    }

    /**  */
    public static final class CharOctalValue3DigitsTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_OCTAL_VALUE_3_DIGITS: pattern=\"{}\"", EXP_OCTAL_VALUE_3_DIGITS);
        }
        @Test
        public void caseTrue() {
            assertTrue(true);
            fail(); // this method had not been implemented.
        }
        @Test
        public void caseFalse() {
            assertFalse(false);
            fail(); // this method had not been implemented.
        }
    }

    /**  */
    public static final class CharHexValue2DigitsTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_HEX_VALUE_2_DIGITS: pattern=\"{}\"", EXP_HEX_VALUE_2_DIGITS);
        }
        @Test
        public void caseTrue() {
            assertTrue(true);
            fail(); // this method had not been implemented.
        }
        @Test
        public void caseFalse() {
            assertFalse(false);
            fail(); // this method had not been implemented.
        }
    }

    /**  */
    public static final class CharHexValue4DigitsTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_HEX_VALUE_4_DIGITS: pattern=\"{}\"", EXP_HEX_VALUE_4_DIGITS);
        }
        @Test
        public void caseTrue() {
            assertTrue(true);
            fail(); // this method had not been implemented.
        }
        @Test
        public void caseFalse() {
            assertFalse(false);
            fail(); // this method had not been implemented.
        }
    }

    /**  */
    public static final class CharHexValueFlexDigitsTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_HEX_VALUE_FLEX_DIGITS: pattern=\"{}\"", EXP_HEX_VALUE_FLEX_DIGITS);
        }
        @Test
        public void caseTrue() {
            assertTrue(true);
            fail(); // this method had not been implemented.
        }
        @Test
        public void caseFalse() {
            assertFalse(false);
            fail(); // this method had not been implemented.
        }
    }

    /**  */
    public static final class CharEscTabTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_ESC_TAB: pattern=\"{}\"", EXP_ESC_TAB);
        }
        @Test
        public void caseTrue() {
            assertTrue(true);
            fail(); // this method had not been implemented.
        }
        @Test
        public void caseFalse() {
            assertFalse(false);
            fail(); // this method had not been implemented.
        }
    }

    /**  */
    public static final class CharEscLineFeedTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_ESC_LINE_FEED: pattern=\"{}\"", EXP_ESC_LINE_FEED);
        }
        @Test
        public void caseTrue() {
            assertTrue(true);
            fail(); // this method had not been implemented.
        }
        @Test
        public void caseFalse() {
            assertFalse(false);
            fail(); // this method had not been implemented.
        }
    }

    /**  */
    public static final class CharEscCarriageReturnTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_ESC_CARRIAGE_RETURN: pattern=\"{}\"", EXP_ESC_CARRIAGE_RETURN);
        }
        @Test
        public void caseTrue() {
            assertTrue(true);
            fail(); // this method had not been implemented.
        }
        @Test
        public void caseFalse() {
            assertFalse(false);
            fail(); // this method had not been implemented.
        }
    }

    /**  */
    public static final class CharEscLineBreakTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_ESC_LINE_BREAK: pattern=\"{}\"", EXP_ESC_LINE_BREAK);
        }
        @Test
        public void caseTrue() {
            assertTrue(true);
            fail(); // this method had not been implemented.
        }
        @Test
        public void caseFalse() {
            assertFalse(false);
            fail(); // this method had not been implemented.
        }
    }

    //--------------------------------------------------------------------------------------------------

    /** */
    public static abstract class TestBase {
        protected Characters target;
        @Before
        public void doBefore() {
            target = new Characters();
        }
    }
}
