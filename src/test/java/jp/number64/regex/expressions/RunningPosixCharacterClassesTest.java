package jp.number64.regex.expressions;

import static jp.number64.regex.expressions.PosixCharacterClasses.*;
import static org.junit.Assert.*;
import jp.number64.regex.expressions.RunningPosixCharacterClassesTest.PosixAlnumTest;
import jp.number64.regex.expressions.RunningPosixCharacterClassesTest.PosixAlphaTest;
import jp.number64.regex.expressions.RunningPosixCharacterClassesTest.PosixAsciiTest;
import jp.number64.regex.expressions.RunningPosixCharacterClassesTest.PosixBlankTest;
import jp.number64.regex.expressions.RunningPosixCharacterClassesTest.PosixCntrlTest;
import jp.number64.regex.expressions.RunningPosixCharacterClassesTest.PosixDigitTest;
import jp.number64.regex.expressions.RunningPosixCharacterClassesTest.PosixGraphTest;
import jp.number64.regex.expressions.RunningPosixCharacterClassesTest.PosixLowerAlphaTest;
import jp.number64.regex.expressions.RunningPosixCharacterClassesTest.PosixPrintTest;
import jp.number64.regex.expressions.RunningPosixCharacterClassesTest.PosixPuncationTest;
import jp.number64.regex.expressions.RunningPosixCharacterClassesTest.PosixSpaceTest;
import jp.number64.regex.expressions.RunningPosixCharacterClassesTest.PosixUpperAlphaTest;
import jp.number64.regex.expressions.RunningPosixCharacterClassesTest.PosixXdigitTest;

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
    PosixLowerAlphaTest.class,
    PosixUpperAlphaTest.class,
    PosixAsciiTest.class,
    PosixAlphaTest.class,
    PosixDigitTest.class,
    PosixAlnumTest.class,
    PosixPuncationTest.class,
    PosixGraphTest.class,
    PosixPrintTest.class,
    PosixBlankTest.class,
    PosixCntrlTest.class,
    PosixXdigitTest.class,
    PosixSpaceTest.class
})
public class RunningPosixCharacterClassesTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(RunningPosixCharacterClassesTest.class);

    /**  */
    public static final class PosixLowerAlphaTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_LOWER_ALPHA: pattern=\"{}\"", EXP_LOWER_ALPHA);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findLowerAplha("a"));
            assertTrue(target.findLowerAplha("z"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findLowerAplha("A"));
            assertFalse(target.findLowerAplha("Z"));
            assertFalse(target.findLowerAplha("\uff41"));  // doublebyte 'a', If JavaCharacterClass, this char matches.
        }
    }

    /**  */
    public static final class PosixUpperAlphaTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_UPPER_ALPHA: pattern=\"{}\"", EXP_UPPER_ALPHA);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findUpperAlpha("A"));
            assertTrue(target.findUpperAlpha("Z"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findUpperAlpha("a"));
            assertFalse(target.findUpperAlpha("z"));
            assertFalse(target.findUpperAlpha("\uff21"));  // doublebyte 'A', If JavaCharacterClass, this char matches.
        }
    }

    /**  */
    public static final class PosixAsciiTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_ASCII: pattern=\"{}\"", EXP_ASCII);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findAscii(" "));
            assertTrue(target.findAscii("a"));
            assertTrue(target.findAscii("!"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findAscii("\uff41"));
        }
    }

    /**  */
    public static final class PosixAlphaTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_ALPHA: pattern=\"{}\"", EXP_ALPHA);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findAlpha("a"));
            assertTrue(target.findAlpha("z"));
            assertTrue(target.findAlpha("A"));
            assertTrue(target.findAlpha("Z"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findAlpha("0"));
            assertFalse(target.findAlpha("_"));
            assertFalse(target.findAlpha("\uff41"));
            assertFalse(target.findAlpha("\uff21"));
        }
    }

    /**  */
    public static final class PosixDigitTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_DIGIT: pattern=\"{}\"", EXP_DIGIT);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findDigit("0"));
            assertTrue(target.findDigit("9"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findDigit("a"));
            assertFalse(target.findDigit("\uff19"));
        }
    }

    /**  */
    public static final class PosixAlnumTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_ALNUM: pattern=\"{}\"", EXP_ALNUM);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findAlnum("a"));
            assertTrue(target.findAlnum("Z"));
            assertTrue(target.findAlnum("9"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findAlnum("_"));
            assertFalse(target.findAlpha("\uff41"));
        }
    }

    /**  */
    public static final class PosixPuncationTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_PUNCATION: pattern=\"{}\"", EXP_PUNCATION);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findPuncation("!"));
            assertTrue(target.findPuncation("\""));
            assertTrue(target.findPuncation("("));
            assertTrue(target.findPuncation("<"));
            assertTrue(target.findPuncation("|"));
            assertTrue(target.findPuncation("{"));
            assertTrue(target.findPuncation("\\"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findPuncation(" "));
            assertFalse(target.findPuncation("a"));
            assertFalse(target.findPuncation("\t"));
            assertFalse(target.findPuncation("\uff01"));
        }
    }

    /**  */
    public static final class PosixGraphTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_GRAPH: pattern=\"{}\"", EXP_GRAPH);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findGraph("!"));
            assertTrue(target.findGraph("("));
            assertTrue(target.findGraph("<"));
            assertTrue(target.findGraph("{"));
            assertTrue(target.findGraph("a"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findGraph(" "));
            assertFalse(target.findGraph("\t"));
            assertFalse(target.findGraph("\uff01"));
        }
    }

    /**  */
    public static final class PosixPrintTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_PRINT: pattern=\"{}\"", EXP_PRINT);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findPrint("!"));
            assertTrue(target.findPrint("("));
            assertTrue(target.findPrint("<"));
            assertTrue(target.findPrint("{"));
            assertTrue(target.findPrint("a"));
            assertTrue(target.findPrint(" "));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findPrint("\t"));
        }
    }

    /**  */
    public static final class PosixBlankTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_BLANK: pattern=\"{}\"", EXP_BLANK);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findBlank(" "));
            assertTrue(target.findBlank("\t"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findBlank("\n"));
            assertFalse(target.findBlank("\f"));
        }
    }

    /**  */
    public static final class PosixCntrlTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_CNTRL: pattern=\"{}\"", EXP_CNTRL);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findCntrl("\t"));
            assertTrue(target.findCntrl("\r"));
            assertTrue(target.findCntrl("\n"));
            assertTrue(target.findCntrl("\f"));
            assertTrue(target.findCntrl("\u007F"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findCntrl(" "));
            assertFalse(target.findCntrl("\\"));
        }
    }

    /**  */
    public static final class PosixXdigitTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_XDIGIT: pattern=\"{}\"", EXP_XDIGIT);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findXdigit("0"));
            assertTrue(target.findXdigit("a"));
            assertTrue(target.findXdigit("F"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findXdigit("g"));
            assertFalse(target.findXdigit("x"));
            assertFalse(target.findXdigit("X"));
        }
    }

    /**  */
    public static final class PosixSpaceTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_SPACE: pattern=\"{}\"", EXP_SPACE);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findSpace(" "));
            assertTrue(target.findSpace("\t"));
            assertTrue(target.findSpace("\n"));
            assertTrue(target.findSpace("\f"));
            assertTrue(target.findSpace("\r"));
            assertTrue(target.findSpace("\u000B"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findSpace("\u3000"));
        }
    }

    //--------------------------------------------------------------------------------------------------

    /** */
    public static abstract class TestBase {
        protected PosixCharacterClasses target;
        @Before
        public void doBefore() {
            target = new PosixCharacterClasses();
        }
    }
}
