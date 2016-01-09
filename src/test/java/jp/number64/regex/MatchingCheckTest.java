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
        public void case01PrefectMatchingTest() {
            LOGGER.debug("PERFECT_MATCHING: pattern=\"{}\"", MatchingZeroSize.PATTERN_PERFECT_MATCHING);
            assertTrue(target.findPerfectMatching("NUMBER64"));
            assertFalse(target.findPerfectMatching("NUMBER6464"));
            assertFalse(target.findPerfectMatching("NNNUMBER64"));
            assertFalse(target.findPerfectMatching("number64"));
        }

        @Test
        public void case02PartialMatchingTest() {
            LOGGER.debug("PARTIAL_MATCHING: pattern=\"{}\"", MatchingZeroSize.PATTERN_PARTIAL_MATCHING);
            assertTrue(target.findPartialMatching("NUMBER64"));
            assertTrue(target.findPartialMatching("NUMBER6464"));
            assertTrue(target.findPartialMatching("NNNUMBER64"));
            assertFalse(target.findPartialMatching("number64"));
        }

        @Test
        public void case03PrefixMatchingTest() {
            LOGGER.debug("PREFIX_MATCHING: pattern=\"{}\"", MatchingZeroSize.PATTERN_PREFIX_MATCHING);
            assertTrue(target.findPrefixMatching("NUMBER64"));
            assertTrue(target.findPrefixMatching("NUMBER6464"));
            assertFalse(target.findPrefixMatching("NNNUMBER64"));
            assertFalse(target.findPrefixMatching("number64"));
        }

        @Test
        public void case04SuffixMatchingTest() {
            LOGGER.debug("SUFFIX_MATCHING: pattern=\"{}\"", MatchingZeroSize.PATTERN_SUFFIX_MATCHING);
            assertTrue(target.findSuffixMatching("NUMBER64"));
            assertFalse(target.findSuffixMatching("NUMBER6464"));
            assertTrue(target.findSuffixMatching("NNNUMBER64"));
            assertFalse(target.findSuffixMatching("number64"));
        }

        @Test
        public void case05PrefixMatchingEscTest() {
            LOGGER.debug("PERFECT_MATCHING: pattern=\"{}\"", MatchingZeroSize.PATTERN_PERFECT_MATCHING);
            assertTrue(target.findPrefixMatchingEsc("NUMBER64"));
            assertTrue(target.findPrefixMatchingEsc("NUMBER6464"));
            assertFalse(target.findPrefixMatchingEsc("NNNUMBER64"));
            assertFalse(target.findPrefixMatchingEsc("number64"));
        }

        @Test
        public void case06PrefixMatchingEscTest() {
            LOGGER.debug("PERFECT_MATCHING: pattern=\"{}\"", MatchingZeroSize.PATTERN_PERFECT_MATCHING);
            assertTrue(target.findSuffixMatchingEsc("NUMBER64"));
            assertFalse(target.findSuffixMatchingEsc("NUMBER6464"));
            assertTrue(target.findSuffixMatchingEsc("NNNUMBER64"));
            assertFalse(target.findSuffixMatchingEsc("number64"));
        }
    }

    /**
     *
     */
    @FixMethodOrder(MethodSorters.NAME_ASCENDING)
    public static final class MatchingCharactorClassTest extends MatchingCheckTestBase {
        private static final Logger LOGGER = LoggerFactory.getLogger(MatchingCharactorClassTest.class);

        @Test
        public void case01SpecificCharsTest() {
            LOGGER.debug("SPECIFIC_CHARS: pattern=\"{}\"", MatchingCharactorClass.PATTERN_SPECIFIC_CHARS);
            assertTrue(target.findSpecificChars("nUMBER64"));
            assertTrue(target.findSpecificChars("NuMBER64"));
            assertTrue(target.findSpecificChars("nuMBER64"));
            assertTrue(target.findSpecificChars("NUMBER64"));
            assertFalse(target.findSpecificChars("nUMBER46"));
        }

        @Test
        public void case02RangeCharsTest() {
            LOGGER.debug("RANGE_CHARS: pattern=\"{}\"", MatchingCharactorClass.PATTERN_RANGE_CHARS);
            assertTrue(target.findRangeChars("nUMBER64"));
            assertFalse(target.findRangeChars("NuMBER64"));
            assertFalse(target.findRangeChars("nuMBER64"));
            assertFalse(target.findRangeChars("NUMBER64"));
            assertTrue(target.findRangeChars("nUMBER46"));
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
