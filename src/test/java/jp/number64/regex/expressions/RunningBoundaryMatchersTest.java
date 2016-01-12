package jp.number64.regex.expressions;

//import MatchingZeroSize.*;
//static import MatchingZeroSize, MatchingCharactorClass;

import static jp.number64.regex.expressions.BoundaryMatchers.*;
import static org.junit.Assert.*;
import jp.number64.regex.expressions.RunningBoundaryMatchersTest.BoudaryBeginningInputTest;
import jp.number64.regex.expressions.RunningBoundaryMatchersTest.BoudaryEndInputTest;
import jp.number64.regex.expressions.RunningBoundaryMatchersTest.BoudaryTerminatorInputTest;
import jp.number64.regex.expressions.RunningBoundaryMatchersTest.BoundaryBeginningLineTest;
import jp.number64.regex.expressions.RunningBoundaryMatchersTest.BoundaryEndLineTest;
import jp.number64.regex.expressions.RunningBoundaryMatchersTest.BoundaryMultiByteWordTest;
import jp.number64.regex.expressions.RunningBoundaryMatchersTest.BoundaryNonWordTest;
import jp.number64.regex.expressions.RunningBoundaryMatchersTest.BoundaryWordTest;
import jp.number64.regex.expressions.RunningBoundaryMatchersTest.EndOfPreviousMatchTest;
import jp.number64.regex.expressions.RunningBoundaryMatchersTest.MatchingPartialTest;
import jp.number64.regex.expressions.RunningBoundaryMatchersTest.MatchingPerfectTest;

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
    BoundaryBeginningLineTest.class,
    BoundaryEndLineTest.class,
    MatchingPartialTest.class,
    MatchingPerfectTest.class,
    BoudaryBeginningInputTest.class,
    BoudaryTerminatorInputTest.class,
    BoudaryEndInputTest.class,
    EndOfPreviousMatchTest.class,
    BoundaryWordTest.class,
    BoundaryMultiByteWordTest.class,
    BoundaryNonWordTest.class
})
public class RunningBoundaryMatchersTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(RunningBoundaryMatchersTest.class);

    /**  */
    public static final class BoundaryBeginningLineTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_BOUNDARY_BEGINNING_LINE: pattern=\"{}\"", EXP_BOUNDARY_BEGINNING_LINE);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findBoundaryBeginningLine("NUMBER64"));
            assertTrue(target.findBoundaryBeginningLine("NUMBER6464"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findBoundaryBeginningLine("NNNUMBER64"));
            assertFalse(target.findBoundaryBeginningLine("number64"));
        }
    }

    /**  */
    public static final class BoundaryEndLineTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_BOUNDARY_END_LINE: pattern=\"{}\"", EXP_BOUNDARY_END_LINE);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findBoundaryEndLine("NUMBER64"));
            assertTrue(target.findBoundaryEndLine("NNNUMBER64"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findBoundaryEndLine("NUMBER6464"));
            assertFalse(target.findBoundaryEndLine("number64"));
        }
    }

    /**  */
    public static final class MatchingPartialTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_MATCHING_PARTIAL: pattern=\"{}\"", EXP_MATCHING_PARTIAL);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findMatchingPartial("NUMBER64"));
            assertTrue(target.findMatchingPartial("NUMBER6464"));
            assertTrue(target.findMatchingPartial("NNNUMBER64"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findMatchingPartial("number64"));
        }
    }

    /**  */
    public static final class MatchingPerfectTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_MATCHING_PERFECT: pattern=\"{}\"", EXP_MATCHING_PERFECT);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findMatchingPerfecr("NUMBER64"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findMatchingPerfecr("NUMBER6464"));
            assertFalse(target.findMatchingPerfecr("NNNUMBER64"));
            assertFalse(target.findMatchingPerfecr("number64"));
        }
    }

    /**  */
    public static final class BoudaryBeginningInputTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_BOUNDARY_BEGINNING_INPUT: pattern=\"{}\"", EXP_BOUNDARY_BEGINNING_INPUT);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findBoundaryBeginnigInput("NUMBER64"));
            assertTrue(target.findBoundaryBeginnigInput("NUMBER6464"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findBoundaryBeginnigInput("NNNUMBER64"));
            assertFalse(target.findBoundaryBeginnigInput("number64"));
        }
    }

    /**  */
    public static final class BoudaryTerminatorInputTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_BOUNDARY_TERMINATOR: pattern=\"{}\"", EXP_BOUNDARY_TERMINATOR);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findBoundaryTerminator("NNUMBER64"));
            assertTrue(target.findBoundaryTerminator("NNUMBER64\n"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findBoundaryTerminator("NUMBER6464"));
        }
    }

    /**  */
    public static final class BoudaryEndInputTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_BOUNDARY_END_INPUT: pattern=\"{}\"", EXP_BOUNDARY_END_INPUT);
        }
        @Test
        public void caseTest() {
            assertTrue(target.findBoundaryEndInput("NNUMBER64"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findBoundaryEndInput("NNUMBER64\n"));
            assertFalse(target.findBoundaryEndInput("NUMBER6464"));
        }
    }

    /**  */
    public static final class EndOfPreviousMatchTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_END_OF_PREV_MATCH_ESC: pattern=\"{}\"", EXP_END_OF_PREV_MATCH_ESC);
        }
        @Test
        public void caseTest() {
        }
        @Test
        public void caseFalse() {
        }
    }

    /**  */
    public static final class BoundaryWordTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_BOUNDARY_WORD: pattern=\"{}\"", EXP_BOUNDARY_WORD);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findBoundaryWord("NUMBER64"));
            assertTrue(target.findBoundaryWord("##NUMBER64##"));
            assertTrue(target.findBoundaryWord("He is NUMBER64"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findBoundaryWord("\u8f5f" + "NUMBER64" + "\u8f5f"));
            assertFalse(target.findBoundaryWord("NNUMBER644"));
        }
    }

    /**  */
    public static final class BoundaryMultiByteWordTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_BOUNDARY_MULTI_BYTE_WORD: pattern=\"{}\"", EXP_BOUNDARY_MULTI_BYTE_WORD);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findBoundaryMultiByteWord("\u8f5f\u5927\u8f14"));
            assertTrue(target.findBoundaryMultiByteWord(" \u8f5f\u5927\u8f14 "));
            assertTrue(target.findBoundaryMultiByteWord("#\u8f5f\u5927\u8f14#"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findBoundaryMultiByteWord("\u8f5f"));
            assertFalse(target.findBoundaryMultiByteWord("number64\u8f5f\u5927\u8f14number64"));
        }
    }

    /**  */
    public static final class BoundaryNonWordTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_BOUNDARY_NON_WORD: pattern=\"{}\"", EXP_BOUNDARY_NON_WORD);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findBoundaryNonWord("\u8f5f" + "NUMBER64" + "\u8f5f"));
            assertTrue(target.findBoundaryNonWord("NNUMBER644"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findBoundaryNonWord("NUMBER64"));
            assertFalse(target.findBoundaryNonWord("##NUMBER64##"));
            assertFalse(target.findBoundaryNonWord("He is NUMBER64"));
        }
    }

    //--------------------------------------------------------------------------------------------------

    /** */
    public static abstract class TestBase {
        protected BoundaryMatchers target;
        @Before
        public void doBefore() {
            target = new BoundaryMatchers();
        }
    }
}
