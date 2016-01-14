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
            LOGGER.debug("EXP_OCTAL_VALUE_1_DIGIT: \"??\" pattern=\"{}\"", EXP_OCTAL_VALUE_1_DIGIT);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findOctalValue1Digit("\u0007"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findOctalValue1Digit("\u0008"));
        }
    }

    /**  */
    public static final class CharOctalValue2DigitsTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_OCTAL_VALUE_2_DIGITS: \"0\" pattern=\"{}\"", EXP_OCTAL_VALUE_2_DIGITS);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findOctalValue2Digits("0"));
            assertTrue(target.findOctalValue2Digits("\u0030"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findOctalValue2Digits("1"));
            assertFalse(target.findOctalValue2Digits("\u0031"));
        }
    }

    /**  */
    public static final class CharOctalValue3DigitsTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_OCTAL_VALUE_3_DIGITS: \"a\" pattern=\"{}\"", EXP_OCTAL_VALUE_3_DIGITS);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findOctalValue3Digits("a"));
            assertTrue(target.findOctalValue3Digits("\u0061"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findOctalValue3Digits("A"));
            assertFalse(target.findOctalValue3Digits("\u0062"));
        }
    }

    /**  */
    public static final class CharHexValue2DigitsTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_HEX_VALUE_2_DIGITS: \"A\" pattern=\"{}\"", EXP_HEX_VALUE_2_DIGITS);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findHexValue2Digits("A"));
            assertTrue(target.findHexValue2Digits("\u0041"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findHexValue2Digits("a"));
            assertFalse(target.findHexValue2Digits("\u0042"));
        }
    }

    /**  */
    public static final class CharHexValue4DigitsTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_HEX_VALUE_4_DIGITS: \"あ\" pattern=\"{}\"", EXP_HEX_VALUE_4_DIGITS);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findHexValue4Digits("\u3042"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findHexValue4Digits("\\u3042"));
        }
    }

    /**  */
    public static final class CharHexValueFlexDigitsTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_HEX_VALUE_FLEX_DIGITS: \"𠮟\" pattern=\"{}\"", EXP_HEX_VALUE_FLEX_DIGITS);
            int \u0061\u0062\u0063 = 1;
            LOGGER.debug("int \u0061\u0062\u0063 = {}", abc);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findHexValueFlexDigits("𠮟"));
        }
        @Test
        public void caseFalse() {
            // For pattern '\\uXXXX', XXXX must be 4-length. So, this sample means '\\u20B9' + 'F'.
            assertFalse(target.findHexValueFlexDigits("\u20B9F"));
        }
    }

    /**  */
    public static final class CharEscTabTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_ESC_TAB: '    ' pattern=\"{}\"", EXP_ESC_TAB);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findEscTab("\t"));
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
            assertTrue(target.findEscLineFeed("\n"));
            assertTrue(target.findEscLineFeed(String.valueOf(Character.toChars(0x000A)[0])));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findEscLineFeed("\r"));
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
            assertTrue(target.findEscCarriageReturn("\r"));
            assertTrue(target.findEscCarriageReturn(String.valueOf(Character.toChars(0x000D)[0])));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findEscCarriageReturn("\n"));
        }
    }

    /**  */
    public static final class CharEscLineBreakTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            // \ u0085 NEW-LINE
            // \ u2028 LINE SEPARATOR
            // \ u2029 PARAGRAPH SEPARATOR
            LOGGER.debug("EXP_ESC_LINE_BREAK: pattern=\"{}\"", EXP_ESC_LINE_BREAK);
        }
        @Test
        public void caseTrue() {
            String char000b = String.valueOf(Character.toChars(0x000B)[0]);
            String char000c = String.valueOf(Character.toChars(0x000C)[0]);
            String char0085 = String.valueOf(Character.toChars(0x0085)[0]);
            String char2028 = String.valueOf(Character.toChars(0x2028)[0]);
            String char2029 = String.valueOf(Character.toChars(0x2029)[0]);
            assertTrue(target.findEscLineBreak("\r\n"));
            assertTrue(target.findEscLineBreak("\r"));
            assertTrue(target.findEscLineBreak(char000b));
            assertTrue(target.findEscLineBreak(char000c));
            assertTrue(target.findEscLineBreak("\n"));
            assertTrue(target.findEscLineBreak(char0085));
            assertTrue(target.findEscLineBreak(char2028));
            assertTrue(target.findEscLineBreak(char2029));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findEscLineBreak("\t"));
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
