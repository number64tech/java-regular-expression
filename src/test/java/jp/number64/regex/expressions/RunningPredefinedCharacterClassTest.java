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
            assertTrue(target.findAnyCharacter("0UMBER64"));
            assertTrue(target.findAnyCharacter("aUMBER64"));
            assertTrue(target.findAnyCharacter("\u8f5fUMBER64"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findAnyCharacter("NNUMBER64"));
            assertFalse(target.findAnyCharacter("UMBER64"));
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
            assertTrue(target.findNonDigit("NUMBER64"));
            assertTrue(target.findNonDigit("\uff1064"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findNonDigit("064"));
            assertFalse(target.findNonDigit("64"));  // 'NON-DIGIT' is not 'EMPTY'
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
            assertTrue(target.findHorizontalWhiteSpace(" "));
            assertTrue(target.findHorizontalWhiteSpace("\t"));
            assertTrue(target.findHorizontalWhiteSpace("\u00A0"));
            assertTrue(target.findHorizontalWhiteSpace("\u1680"));
            assertTrue(target.findHorizontalWhiteSpace("\u180E"));
            assertTrue(target.findHorizontalWhiteSpace("\u2000"));
            assertTrue(target.findHorizontalWhiteSpace("\u2005"));
            assertTrue(target.findHorizontalWhiteSpace("\u200A"));
            assertTrue(target.findHorizontalWhiteSpace("\u202F"));
            assertTrue(target.findHorizontalWhiteSpace("\u205F"));
            assertTrue(target.findHorizontalWhiteSpace("\u3000"));
        }
        @Test
        public void caseFalse() { // verticals
            assertFalse(target.findHorizontalWhiteSpace("\n"));
            assertFalse(target.findHorizontalWhiteSpace("\u000B"));
            assertFalse(target.findHorizontalWhiteSpace("\f"));
            assertFalse(target.findHorizontalWhiteSpace("\r"));
            assertFalse(target.findHorizontalWhiteSpace("\u0085"));
            assertFalse(target.findHorizontalWhiteSpace("\u2028"));
            assertFalse(target.findHorizontalWhiteSpace("\u2029"));
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
            assertTrue(target.findNonHorizontalWhiteSpace("\n"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findNonHorizontalWhiteSpace("\t"));
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
            assertTrue(target.findWhiteSpace("\t"));
            assertTrue(target.findWhiteSpace("\n"));
            assertTrue(target.findWhiteSpace("\u000B"));
            assertTrue(target.findWhiteSpace("\f"));
            assertTrue(target.findWhiteSpace("\r"));
        }
        @Test
        public void caseFalse() {
            // \\u3000 = double-byte space character
            assertFalse(target.findWhiteSpace("\u3000"));
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
            assertTrue(target.findNonWhiteSpace("\u3000"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findNonWhiteSpace("\t"));
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
            // \f = new page (it may work in a printer...)
            assertTrue(target.findVerticalWhiteSpace("\n"));
            assertTrue(target.findVerticalWhiteSpace("\u000B"));
            assertTrue(target.findVerticalWhiteSpace("\f"));
            assertTrue(target.findVerticalWhiteSpace("\r"));
            assertTrue(target.findVerticalWhiteSpace("\u0085"));
            assertTrue(target.findVerticalWhiteSpace("\u2028"));
            assertTrue(target.findVerticalWhiteSpace("\u2029"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findVerticalWhiteSpace("\t"));
            assertFalse(target.findVerticalWhiteSpace("\u00A0"));
            assertFalse(target.findVerticalWhiteSpace("\u1680"));
            assertFalse(target.findVerticalWhiteSpace("\u180E"));
            assertFalse(target.findVerticalWhiteSpace("\u2000"));
            assertFalse(target.findVerticalWhiteSpace("\u2005"));
            assertFalse(target.findVerticalWhiteSpace("\u200A"));
            assertFalse(target.findVerticalWhiteSpace("\u202F"));
            assertFalse(target.findVerticalWhiteSpace("\u205F"));
            assertFalse(target.findVerticalWhiteSpace("\u3000"));
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
            assertTrue(target.findNonVerticalWhiteSpace("\t"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findNonVerticalWhiteSpace("\f"));
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
            assertTrue(target.findWordCharacter("a"));
            assertTrue(target.findWordCharacter("z"));
            assertTrue(target.findWordCharacter("A"));
            assertTrue(target.findWordCharacter("Z"));
            assertTrue(target.findWordCharacter("0"));
            assertTrue(target.findWordCharacter("9"));
            assertTrue(target.findWordCharacter("_"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findWordCharacter("!"));
            assertFalse(target.findWordCharacter(" "));
            assertFalse(target.findWordCharacter("#"));
            assertFalse(target.findWordCharacter("\u8f5f"));
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
            assertTrue(target.findNonWordCharacter("!"));
            assertTrue(target.findNonWordCharacter("\u8f5f"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findNonWordCharacter("a"));
            assertFalse(target.findNonWordCharacter("9"));
            assertFalse(target.findNonWordCharacter("_"));
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
