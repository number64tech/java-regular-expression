package jp.number64.regex.expressions;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * java.lang.Character classes (simple java character type)   <br>
 *  <br>
 * \p{javaLowerCase} Equivalent to java.lang.Character.isLowerCase()  <br>
 * \p{javaUpperCase} Equivalent to java.lang.Character.isUpperCase()  <br>
 * \p{javaWhitespace} Equivalent to java.lang.Character.isWhitespace()  <br>
 * \p{javaMirrored} Equivalent to java.lang.Character.isMirrored()  <br>
 * <br>
 * @see java.lang.Character
 */
public class JavaCharacterClasses {
    private static final Logger LOGGER = LoggerFactory.getLogger(JavaCharacterClasses.class);

    /** \p{javaLowerCase} Equivalent to java.lang.Character.isLowerCase() */
    public static final String EXP_JAVA_LOWER_CASE = "\\p{javaLowerCase}";
    /** \p{javaUpperCase} Equivalent to java.lang.Character.isUpperCase() */
    public static final String EXP_JAVA_UPPER_CASE = "\\p{javaUpperCase}";
    /** \p{javaWhitespace} Equivalent to java.lang.Character.isWhitespace() */
    public static final String EXP_JAVA_WHITE_SPACE = "\\p{javaWhitespace}";
    /** \p{javaMirrored} Equivalent to java.lang.Character.isMirrored() */
    public static final String EXP_JAVA_MIRRORED = "\\p{javaMirrored}";

    // -----------------------------------------------------------------------------------------------

    private static final Pattern PATTERN_JAVA_LOWER_CASE = Pattern.compile(EXP_JAVA_LOWER_CASE);
    private static final Pattern PATTERN_JAVA_UPPER_CASE = Pattern.compile(EXP_JAVA_UPPER_CASE);
    private static final Pattern PATTERN_JAVA_WHITE_SPACE = Pattern.compile(EXP_JAVA_WHITE_SPACE);
    private static final Pattern PATTERN_JAVA_MIRRORED = Pattern.compile(EXP_JAVA_MIRRORED);

    public boolean findJavaLowerCase(String text) {
        boolean result = PATTERN_JAVA_LOWER_CASE.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findJavaUpperCase(String text) {
        boolean result = PATTERN_JAVA_UPPER_CASE.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findJavaWhiteSpace(String text) {
        boolean result = PATTERN_JAVA_WHITE_SPACE.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }

    public boolean findJavaMirrored(String text) {
        boolean result = PATTERN_JAVA_MIRRORED.matcher(text).find();
        LOGGER.debug("{}:{}", result, text);
        return result;
    }
}
