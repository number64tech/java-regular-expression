package jp.number64.regex.expressions;

import static jp.number64.regex.expressions.PredefinedCharacterClasses.*;
import static org.junit.Assert.*;
import jp.number64.regex.expressions.RunningPredefinedCharacterClassTest.PredefAnyCharacterTest;
import jp.number64.regex.expressions.RunningPredefinedCharacterClassTest.PredefDigitTest;
import jp.number64.regex.expressions.RunningPredefinedCharacterClassTest.PredefHorizontalWhiteSpaceTest;
import jp.number64.regex.expressions.RunningPredefinedCharacterClassTest.PredefNonDigitTest;
import jp.number64.regex.expressions.RunningPredefinedCharacterClassTest.PredefNonHorizontalWhiteSpaceTest;
import jp.number64.regex.expressions.RunningPredefinedCharacterClassTest.PredefNonVerticalWhiteSpaceTest;
import jp.number64.regex.expressions.RunningPredefinedCharacterClassTest.PredefNonWhiteSpaceTest;
import jp.number64.regex.expressions.RunningPredefinedCharacterClassTest.PredefNonWordCharacterTest;
import jp.number64.regex.expressions.RunningPredefinedCharacterClassTest.PredefVerticalWhiteSpaceTest;
import jp.number64.regex.expressions.RunningPredefinedCharacterClassTest.PredefWhiteSpaceTest;
import jp.number64.regex.expressions.RunningPredefinedCharacterClassTest.PredefWordCharacterTest;

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
    PredefAnyCharacterTest.class,
    PredefDigitTest.class,
    PredefNonDigitTest.class,
    PredefHorizontalWhiteSpaceTest.class,
    PredefNonHorizontalWhiteSpaceTest.class,
    PredefWhiteSpaceTest.class,
    PredefNonWhiteSpaceTest.class,
    PredefVerticalWhiteSpaceTest.class,
    PredefNonVerticalWhiteSpaceTest.class,
    PredefWordCharacterTest.class,
    PredefNonWordCharacterTest.class
})
public class RunningPredefinedCharacterClassTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(RunningPredefinedCharacterClassTest.class);

    /**  */
    public static final class PredefAnyCharacterTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_ANY_CHARACTER: pattern=\"{}\"", EXP_ANY_CHARACTER);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findAnyCharacter("0"));
            assertTrue(target.findAnyCharacter("a"));
            assertTrue(target.findAnyCharacter("\u8f5f"));
        }
    }

    /**  */
    public static final class PredefDigitTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_A_DIGIT: pattern=\"{}\"", EXP_A_DIGIT);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findDigit("0"));
            assertTrue(target.findDigit("9"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findDigit("a"));
            assertFalse(target.findDigit("\uff10"));
        }
    }

    /**  */
    public static final class PredefNonDigitTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_A_NON_DIGIT: pattern=\"{}\"", EXP_A_NON_DIGIT);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findNonDigit(""));
            fail();
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findNonDigit(""));
            fail();
        }
    }

    /**  */
    public static final class PredefHorizontalWhiteSpaceTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_HORIZONTAL_WHITE_SPACE: pattern=\"{}\"", EXP_HORIZONTAL_WHITE_SPACE);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findHorizontalWhiteSpace(""));
            fail();
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findHorizontalWhiteSpace(""));
            fail();
        }
    }

    /**  */
    public static final class PredefNonHorizontalWhiteSpaceTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_NON_HORIZONTAL_WHITE_SPACE: pattern=\"{}\"", EXP_NON_HORIZONTAL_WHITE_SPACE);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findNonHorizontalWhiteSpace(""));
            fail();
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findNonHorizontalWhiteSpace(""));
            fail();
        }
    }

    /**  */
    public static final class PredefWhiteSpaceTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_WHITE_SPACE: pattern=\"{}\"", EXP_WHITE_SPACE);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findWhiteSpace(""));
            fail();
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findWhiteSpace(""));
            fail();
        }
    }

    /**  */
    public static final class PredefNonWhiteSpaceTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_NON_WHITE_SPACE: pattern=\"{}\"", EXP_NON_WHITE_SPACE);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findNonWhiteSpace(""));
            fail();
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findNonWhiteSpace(""));
            fail();
        }
    }

    /**  */
    public static final class PredefVerticalWhiteSpaceTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_VERTICAL_WHITE_SPACE: pattern=\"{}\"", EXP_VERTICAL_WHITE_SPACE);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findVerticalWhiteSpace(""));
            fail();
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findVerticalWhiteSpace(""));
            fail();
        }
    }

    /**  */
    public static final class PredefNonVerticalWhiteSpaceTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_NON_VERTICAL_WHITE_SPACE: pattern=\"{}\"", EXP_NON_VERTICAL_WHITE_SPACE);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findNonVerticalWhiteSpace(""));
            fail();
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findNonVerticalWhiteSpace(""));
            fail();
        }
    }

    /**  */
    public static final class PredefWordCharacterTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_A_WORD_CHARACTER: pattern=\"{}\"", EXP_A_WORD_CHARACTER);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findWordCharacter(""));
            fail();
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findWordCharacter(""));
            fail();
        }
    }

    /**  */
    public static final class PredefNonWordCharacterTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_A_NON_WORD_CHARACTER: pattern=\"{}\"", EXP_A_NON_WORD_CHARACTER);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findAnyCharacter(""));
            fail();
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findAnyCharacter(""));
            fail();
        }
    }

    //--------------------------------------------------------------------------------------------------

    /** */
    public static abstract class TestBase {
        protected PredefinedCharacterClasses target;
        @Before
        public void doBefore() {
            target = new PredefinedCharacterClasses();
        }
    }
}
