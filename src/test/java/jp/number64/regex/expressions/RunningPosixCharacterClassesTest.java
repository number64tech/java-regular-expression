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
            assertTrue(target.findLowerAplha(""));
            fail();
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findLowerAplha(""));
            fail();
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
            assertTrue(target.findUpperAlpha(""));
            fail();
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findUpperAlpha(""));
            fail();
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
            assertTrue(target.findAscii(""));
            fail();
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findAscii(""));
            fail();
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
            assertTrue(target.findAlpha(""));
            fail();
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findAlpha(""));
            fail();
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
            assertTrue(target.findDigit(""));
            fail();
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findDigit(""));
            fail();
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
            assertTrue(target.findAlnum(""));
            fail();
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findAlnum(""));
            fail();
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
            assertTrue(target.findPuncation(""));
            fail();
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findPuncation(""));
            fail();
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
            assertTrue(target.findGraph(""));
            fail();
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findGraph(""));
            fail();
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
            assertTrue(target.findPrint(""));
            fail();
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findPrint(""));
            fail();
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
            assertTrue(target.findBlank(""));
            fail();
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findBlank(""));
            fail();
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
            assertTrue(target.findCntrl(""));
            fail();
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findCntrl(""));
            fail();
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
            assertTrue(target.findXdigit(""));
            fail();
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findXdigit(""));
            fail();
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
            assertTrue(target.findSpace(""));
            fail();
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findSpace(""));
            fail();
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
