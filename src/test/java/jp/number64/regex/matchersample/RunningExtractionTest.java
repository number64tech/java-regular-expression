package jp.number64.regex.matchersample;

import static org.junit.Assert.*;
import jp.number64.regex.matchersample.RunningExtractionTest.RepetitionTest;
import jp.number64.regex.matchersample.RunningExtractionTest.UrlTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(Suite.class)
@SuiteClasses({
    RepetitionTest.class,
    UrlTest.class
})
public class RunningExtractionTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(RunningExtractionTest.class);

    /**  */
    public static final class RepetitionTest {

        @Test
        public void case01ExtractSomeWords() {
            LOGGER.debug("** case01");

            final String TARGET_TEXT  = "My name is Mike davis. How are you?";
            final Extraction target = new Extraction();
            target.initRepetition(TARGET_TEXT);

            assertEquals("My", target.findNext().group());
            assertEquals("name", target.findNext().group());
            assertEquals("is", target.findNext().group());
            assertEquals("Mike", target.findNext().group());
            assertEquals("davis", target.findNext().group());
            assertEquals("How", target.findNext().group());
            assertEquals("are", target.findNext().group());
            assertEquals("you", target.findNext().group());
        }
    }

    /**  */
    public static final class UrlTest {

        @Test
        public void case01ExtractUrl() {
            LOGGER.debug("** case01");

            final String TARGET_TEXT  = "http://todo.co.jp/number64tech/";
            final Extraction target = new Extraction();
            target.initDivideUrl(TARGET_TEXT);

            assertEquals("http", target.getUrlPartsScheme());
            assertEquals("todo.co.jp", target.getUrlPartsDomain());
            assertEquals(null, target.getUrlPartsPort());
        }

        @Test
        public void case02ExtractUrl() {
            LOGGER.debug("** case02");

            final String TARGET_TEXT  = "https://192.168.1.1:8080/number64tech/";
            final Extraction target = new Extraction();
            target.initDivideUrl(TARGET_TEXT);

            assertEquals("https", target.getUrlPartsScheme());
            assertEquals("192.168.1.1", target.getUrlPartsDomain());
            assertEquals("8080", target.getUrlPartsPort());
        }
    }

}
