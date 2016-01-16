package jp.number64.regex.quantifiers;

import static jp.number64.regex.quantifiers.ReluctantQuantifiers.*;
import static org.junit.Assert.*;
import jp.number64.regex.quantifiers.RunningReluctantQuantifiersTest.RelucQuant0to2TimesTest;
import jp.number64.regex.quantifiers.RunningReluctantQuantifiersTest.RelucQuant1to3TimesTest;
import jp.number64.regex.quantifiers.RunningReluctantQuantifiersTest.RelucQuantAtLeastNTimesTest;
import jp.number64.regex.quantifiers.RunningReluctantQuantifiersTest.RelucQuantExactlyNTimesTest;
import jp.number64.regex.quantifiers.RunningReluctantQuantifiersTest.RelucQuantOnceOrNotAtAllTest;
import jp.number64.regex.quantifiers.RunningReluctantQuantifiersTest.RelucQuantOneOrMoreTest;
import jp.number64.regex.quantifiers.RunningReluctantQuantifiersTest.RelucQuantZeroOrMoreTest;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Reluctant quantifiers test
 */
@RunWith(Suite.class)
@SuiteClasses({
    RelucQuantOnceOrNotAtAllTest.class,
    RelucQuantZeroOrMoreTest.class,
    RelucQuantOneOrMoreTest.class,
    RelucQuantExactlyNTimesTest.class,
    RelucQuantAtLeastNTimesTest.class,
    RelucQuant1to3TimesTest.class,
    RelucQuant0to2TimesTest.class
})
public class RunningReluctantQuantifiersTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(RunningGreedyQuantifiersTest.class);

    /**  */
    public static final class RelucQuantOnceOrNotAtAllTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_RELUC_QUANT_ONCE_OR_NOTATALL: pattern=\"{}\"", EXP_RELUC_QUANT_ONCE_OR_NOTATALL);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findRelucQuantOnceOrNotAtAll("abc"));
            assertTrue(target.findRelucQuantOnceOrNotAtAll("abcde"));
            assertTrue(target.findRelucQuantOnceOrNotAtAll("abcdefgh")); // see result carefully.
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findRelucQuantOnceOrNotAtAll("ab"));
        }
    }

    /** NUMBER64 into [A-Z]*?[0-9][0-9] != (null)64, N->U->M->B->E->R->64 match! */
    public static final class RelucQuantZeroOrMoreTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_RELUC_QUANT_ZERO_OR_MORE: pattern=\"{}\"", EXP_RELUC_QUANT_ZERO_OR_MORE);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findRelucQuantZeroOrMore("NUMBER64"));
            assertTrue(target.findRelucQuantZeroOrMore("64"));
            assertTrue(target.findRelucQuantZeroOrMore("123"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findRelucQuantZeroOrMore("1"));
        }
    }

    /**  */
    public static final class RelucQuantOneOrMoreTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_RELUC_QUANT_ONE_OR_MORE: pattern=\"{}\"", EXP_RELUC_QUANT_ONE_OR_MORE);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findRelucQuantOneOrMore("NUMBER"));
            assertTrue(target.findRelucQuantOneOrMore("NO64TODOROKI"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findRelucQuantOneOrMore("N"));
        }
    }

    /**  */
    public static final class RelucQuantExactlyNTimesTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_RELUC_QUANT_EXACTLY_N: pattern=\"{}\"", EXP_RELUC_QUANT_EXACTLY_N);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findRelucQuantExactlyN("NUMBER64"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findRelucQuantExactlyN("NUmBER64"));
        }
    }

    /**  */
    public static final class RelucQuantAtLeastNTimesTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_RELUC_QUANT_AT_LEAST_N: pattern=\"{}\"", EXP_RELUC_QUANT_AT_LEAST_N);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findRelucQuantAtLeastN("NUMBE64"));
            assertTrue(target.findRelucQuantAtLeastN("NUMBERRRRRRRRRRRRR64"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findRelucQuantAtLeastN("NUMB64"));
        }
    }

    /**  */
    public static final class RelucQuant1to3TimesTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_RELUC_QUANT_FROM_1_TO_3: pattern=\"{}\"", EXP_RELUC_QUANT_FROM_1_TO_3);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findRelucQuantFrom1to3("NUM64"));
            assertTrue(target.findRelucQuantFrom1to3("NUMBE64"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findRelucQuantFrom1to3("NUMBER64"));
        }
    }

    /**  */
    public static final class RelucQuant0to2TimesTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_RELUC_QUANT_FROM_0_TO_2: pattern=\"{}\"", EXP_RELUC_QUANT_FROM_0_TO_2);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findRelucQuantFrom0to2("NU64"));
            assertTrue(target.findRelucQuantFrom0to2("NUMB64"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findRelucQuantFrom0to2("NUMBE64"));
        }
    }

    //--------------------------------------------------------------------------------------------------

    /** */
    public static abstract class TestBase {
        protected ReluctantQuantifiers target;
        @Before
        public void doBefore() {
            target = new ReluctantQuantifiers();
        }
    }
}
