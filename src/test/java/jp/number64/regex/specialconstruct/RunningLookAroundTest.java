package jp.number64.regex.specialconstruct;

import static jp.number64.regex.specialconstruct.CapturingGroup.*;
import static org.junit.Assert.*;
import jp.number64.regex.specialconstruct.RunningLookAroundTest.BackRefByNameTest;
import jp.number64.regex.specialconstruct.RunningLookAroundTest.BackRefByNumberTest;
import jp.number64.regex.specialconstruct.RunningLookAroundTest.CapturingIdpNotCaptureTest;
import jp.number64.regex.specialconstruct.RunningLookAroundTest.CapturingNamedTest;
import jp.number64.regex.specialconstruct.RunningLookAroundTest.CapturingNotCaptureTest;

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
    CapturingNamedTest.class,
    CapturingNotCaptureTest.class,
    CapturingIdpNotCaptureTest.class,
    BackRefByNumberTest.class,
    BackRefByNameTest.class
})
public class RunningLookAroundTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(RunningLookAroundTest.class);

    /**  */
    public static final class CapturingNamedTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_CAPTURING_NAMED: pattern=\"{}\"", EXP_CAPTURING_NAMED);
        }
        @Test
        public void case01() {
            assertEquals("NUM", target.findCapturingNamed("NUMBER64", "grp1"));
        }
        @Test
        public void case02() {
            assertEquals("BER", target.findCapturingNamed("NUMBER64", "grp2"));
        }
        @Test
        public void case03() {
            assertEquals("64", target.findCapturingNamed("NUMBER64", "grp3"));
        }
    }

    /**  */
    public static final class CapturingNotCaptureTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_CAPTURING_NOT_CAPTURE: pattern=\"{}\"", EXP_CAPTURING_NOT_CAPTURE);
        }
        @Test
        public void case01() {
            assertEquals("NUM", target.findCapturingNotCapture("NUMBER64", 1));
        }
        @Test
        public void case02() {
            assertEquals("64", target.findCapturingNotCapture("NUMBER64", 2));
        }
    }

    /**  */
    public static final class CapturingIdpNotCaptureTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_CAPTURING_IDP_NOT_CAPTURE: pattern=\"{}\"", EXP_CAPTURING_IDP_NOT_CAPTURE);
        }
        @Test
        public void case01() {
            assertEquals("NUMBER", target.findCapturingIdpNotCapture(
                "NUMBERRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR64", 1));
        }
        @Test
        public void case02() {
            assertEquals("64", target.findCapturingIdpNotCapture(
                "NUMBERRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR64", 2));
        }
    }

    /**  */
    public static final class BackRefByNumberTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_BACK_REF_BY_NUMBER: pattern=\"{}\"", EXP_BACK_REF_BY_NUMBER);
        }
        @Test
        public void case01() {
            assertEquals("NUMBER64", target.findBackRefByNumber("NUMBER64 NUMBER6464", 1));
        }
        @Test
        public void case02() {
            assertEquals("64", target.findBackRefByNumber("NUMBER64 NUMBER6464", 2));
        }
    }

    /**  */
    public static final class BackRefByNameTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_BACK_REF_BY_NAME: pattern=\"{}\"", EXP_BACK_REF_BY_NAME);
        }
        @Test
        public void case01() {
            assertEquals("NUM", target.findBackRefByName("NUMBER64 64BERNUM", "grp1"));
        }
        @Test
        public void case02() {
            assertEquals("BER", target.findBackRefByName("NUMBER64 64BERNUM", "grp2"));
        }
        @Test
        public void case03() {
            assertEquals("64", target.findBackRefByName("NUMBER64 64BERNUM", "grp3"));
        }
    }

    //--------------------------------------------------------------------------------------------------

    /** */
    public static abstract class TestBase {
        protected CapturingGroup target;
        @Before
        public void doBefore() {
            target = new CapturingGroup();
        }
    }
}
