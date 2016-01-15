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
            assertTrue(target.findJavaLowerCase("a"));
            assertTrue(target.findJavaLowerCase("z"));
            assertTrue(target.findJavaLowerCase("\uff41"));  // doublebyte 'a'
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findJavaLowerCase("A"));
            assertFalse(target.findJavaLowerCase("\u3041"));
            assertFalse(target.findJavaLowerCase("\u3042"));
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
            assertTrue(target.findJavaUpperCase("A"));
            assertTrue(target.findJavaUpperCase("Z"));
            assertTrue(target.findJavaUpperCase("\uff21"));  // doublebyte 'A'
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findJavaUpperCase("a"));
            assertFalse(target.findJavaUpperCase("z"));
            assertFalse(target.findJavaUpperCase("\uff41"));
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
            assertTrue(target.findJavaWhiteSpace(" "));
            assertTrue(target.findJavaWhiteSpace("\t"));
            assertTrue(target.findJavaWhiteSpace("\n"));
            assertTrue(target.findJavaWhiteSpace("\u000B"));
            assertTrue(target.findJavaWhiteSpace("\f"));
            assertTrue(target.findJavaWhiteSpace("\r"));
            assertTrue(target.findJavaWhiteSpace("\u001C"));
            assertTrue(target.findJavaWhiteSpace("\u001D"));
            assertTrue(target.findJavaWhiteSpace("\u001E"));
            assertTrue(target.findJavaWhiteSpace("\u001F"));
            assertTrue(target.findJavaWhiteSpace("\u3000"));
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findJavaWhiteSpace("\u00A0"));
            assertFalse(target.findJavaWhiteSpace("\u2007"));
            assertFalse(target.findJavaWhiteSpace("\u202F"));
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
            assertTrue(target.findJavaMirrored("\u0028")); // LEFT PARENTHESIS
            assertTrue(target.findJavaMirrored("\uff08")); // doublebyte LEFT PARENTHESIS
        }
        @Test
        public void caseFalse() {
            assertFalse(target.findJavaMirrored("!"));
            assertFalse(target.findJavaMirrored("#"));
            assertFalse(target.findJavaMirrored("="));
            assertFalse(target.findJavaMirrored("_"));
            assertFalse(target.findJavaMirrored("*"));
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
