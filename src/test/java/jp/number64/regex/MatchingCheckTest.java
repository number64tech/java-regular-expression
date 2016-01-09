package jp.number64.regex;

//import MatchingZeroSize.*;
//static import MatchingZeroSize, MatchingCharactorClass;

import static org.junit.Assert.*;
import jp.number64.regex.MatchingCheckTest.MatchingCharactorClassTest;
import jp.number64.regex.MatchingCheckTest.MatchingZeroSizeTest;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(Suite.class)
@SuiteClasses({
    MatchingZeroSizeTest.class,
    MatchingCharactorClassTest.class
})
public class MatchingCheckTest {

    /**
     *
     */
    @FixMethodOrder(MethodSorters.NAME_ASCENDING)
    public static final class MatchingZeroSizeTest extends MatchingCheckTestBase {
        private static final Logger LOGGER = LoggerFactory.getLogger(MatchingZeroSizeTest.class);

        @Test
        public void case01PrefixMatchingTest() {
            LOGGER.debug("PERFECT_MATCHING: pattern=\"{}\"", MatchingZeroSize.PATTERN_PERFECT_MATCHING);
            assertTrue(target.checkPerfectMatching("NUMBER64"));
            assertFalse(target.checkPerfectMatching(" NUMBER64 "));
            assertFalse(target.checkPerfectMatching("NNUMBER64"));
        }
    }

    /**
     *
     */
    @FixMethodOrder(MethodSorters.NAME_ASCENDING)
    public static final class MatchingCharactorClassTest extends MatchingCheckTestBase {
        private static final Logger LOGGER = LoggerFactory.getLogger(MatchingCharactorClassTest.class);

        @Test
        public void case01RangeCharsTest() {
            LOGGER.debug("RANGE_CHARS: pattern=\"{}\"", MatchingCharactorClass.PATTERN_RANGE_CHARS);
            assertTrue(target.checkRangeChars("nUMBER64"));
            assertTrue(target.checkRangeChars("jAMBER96"));
            assertFalse(target.checkRangeChars("NUMBER64"));
        }
    }

    /** */
    public static abstract class MatchingCheckTestBase {
        protected MatchingCheckImpl target;
        @Before
        public void doBefore() {
            target = new MatchingCheckImpl();
        }
    }
}
