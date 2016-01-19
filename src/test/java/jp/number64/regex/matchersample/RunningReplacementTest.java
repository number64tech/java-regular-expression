package jp.number64.regex.matchersample;

import static org.junit.Assert.*;
import jp.number64.regex.matchersample.RunningReplacementTest.TsvTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(Suite.class)
@SuiteClasses({
    TsvTest.class
})
public class RunningReplacementTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(RunningReplacementTest.class);

    /**
     * NOTE: While processing #replaceAll(), replaced strings don't appear in input text.<br>
     * In this sample, TAB chars will appear in return value only. <br>
     * So, Pattern "(?<=\p{Alnum}{3})" works like this -> "AGH J D F "...  <br>
     * First "D" has "GHJ" behind it, not "H\tJ". <br>
     */
    public static final class TsvTest {

        private static final String INPUT_TEXT = "AGHJDFSAKLGHSHJASDKGDSALAHJKLHF";
        private static final String EXPECTED_FROM_FIRST = "AGH\tJDF\tSAK\tLGH\tSHJ\tASD\tKGD\tSAL\tAHJ\tKLH\tF";
        private static final String EXPECTED_FROM_END = "A\tGHJ\tDFS\tAKL\tGHS\tHJA\tSDK\tGDS\tALA\tHJK\tLHF";

        @Test
        public void case01CheckTest() {
            LOGGER.debug("** case01");
            final Replacement target = new Replacement();

            assertTrue(target.checkText("ASDF"));
            assertFalse(target.checkText("!#%&"));
        }

        @Test
        public void case02ConvertToTsvFromFirst() {
            LOGGER.debug("** case02");
            final Replacement target = new Replacement();

            assertEquals(true, target.checkText(INPUT_TEXT));
            String result = target.separateFromFirst(INPUT_TEXT);
            assertEquals(EXPECTED_FROM_FIRST, result);
        }

        @Test
        public void case03ConvertToTsvFromEnd() {
            LOGGER.debug("** case03");
            final Replacement target = new Replacement();

            assertEquals(true, target.checkText(INPUT_TEXT));
            String result = target.separateFromEnd(INPUT_TEXT);
            assertEquals(EXPECTED_FROM_END, result);
        }
    }
}
