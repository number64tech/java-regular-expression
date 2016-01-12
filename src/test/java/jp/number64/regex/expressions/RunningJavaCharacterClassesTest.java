package jp.number64.regex.expressions;

import static jp.number64.regex.expressions.JavaCharacterClasses.*;
import static org.junit.Assert.*;
import jp.number64.regex.expressions.RunningJavaCharacterClassesTest.JavaLowerCaseTest;
import jp.number64.regex.expressions.RunningJavaCharacterClassesTest.JavaMirroredTest;
import jp.number64.regex.expressions.RunningJavaCharacterClassesTest.JavaUpperCaseTest;
import jp.number64.regex.expressions.RunningJavaCharacterClassesTest.JavaWhiteSpaceTest;

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
    JavaLowerCaseTest.class,
    JavaUpperCaseTest.class,
    JavaWhiteSpaceTest.class,
    JavaMirroredTest.class
})
public class RunningJavaCharacterClassesTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(RunningJavaCharacterClassesTest.class);

    /**  */
    public static final class JavaLowerCaseTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_JAVA_LOWER_CASE: pattern=\"{}\"", EXP_JAVA_LOWER_CASE);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findJavaLowerCase(""));
            fail();
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findJavaLowerCase(""));
            fail();
        }
    }

    /**  */
    public static final class JavaUpperCaseTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_JAVA_UPPER_CASE: pattern=\"{}\"", EXP_JAVA_UPPER_CASE);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findJavaUpperCase(""));
            fail();
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findJavaUpperCase(""));
            fail();
        }
    }

    /**  */
    public static final class JavaWhiteSpaceTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_JAVA_WHITE_SPACE: pattern=\"{}\"", EXP_JAVA_WHITE_SPACE);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findJavaWhiteSpace(""));
            fail();
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findJavaWhiteSpace(""));
            fail();
        }
    }

    /**  */
    public static final class JavaMirroredTest extends TestBase {
        @BeforeClass
        public static void doBeforeClass() {
            LOGGER.debug("EXP_JAVA_MIRRORED: pattern=\"{}\"", EXP_JAVA_MIRRORED);
        }
        @Test
        public void caseTrue() {
            assertTrue(target.findJavaMirrored(""));
            fail();
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findJavaMirrored(""));
            fail();
        }
    }


    //--------------------------------------------------------------------------------------------------

    /** */
    public static abstract class TestBase {
        protected JavaCharacterClasses target;
        @Before
        public void doBefore() {
            target = new JavaCharacterClasses();
        }
    }
}
