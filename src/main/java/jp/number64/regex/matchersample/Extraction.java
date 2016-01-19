package jp.number64.regex.matchersample;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Samples of "Matcher" methods <br>
 * <br>
 * @see Matcher
 */
public class Extraction {
    private static final Logger LOGGER = LoggerFactory.getLogger(Extraction.class);

    /** repetition */
    public static final String EXP_REPETITION = "\\w+";
    /** scheme & domain from URL (reinventing the wheel). */
    public static final String EXP_DIVIDE_URL =
        "(?<scheme>http[s]?|ftp|ws[s])://(?<domain>[\\p{ASCII}&&[^./:]]+(\\.[\\p{ASCII}&&[^./:]]+)+)(:(?<port>\\d+))?";

    private static final Pattern PATTERN_REPETITION = Pattern.compile(EXP_REPETITION);
    private static final Pattern PATTERN_DIVIDE_URL = Pattern.compile(EXP_DIVIDE_URL);

    private Matcher matcherRepetition = null;
    private Matcher matcherDivideUrl = null;

    // -----------------------------------------------------------------------------------------------

    public void initRepetition(String inputText) {
        matcherRepetition = PATTERN_REPETITION.matcher(inputText);
        LOGGER.debug("pattern: {}", matcherRepetition.toString());
    }

    public MatchResult findNext() {
        boolean findResult = matcherRepetition.find();
        MatchResult matchResult = matcherRepetition.toMatchResult();
        LOGGER.debug("result: {} pos {}-{} word: {} ", findResult, matchResult.start(), matchResult.end(), matchResult.group());
        return matchResult;
    }

    // -----------------------------------------------------------------------------------------------

    public void initDivideUrl(String inputText) {
        matcherDivideUrl = PATTERN_DIVIDE_URL.matcher(inputText);
        LOGGER.debug("pattern: {}", matcherDivideUrl.toString());
        LOGGER.debug("result: {}", matcherDivideUrl.find());
    }

    public String getUrlPartsScheme() {
        return matcherDivideUrl.group("scheme");
    }

    public String getUrlPartsDomain() {
        return matcherDivideUrl.group("domain");
    }

    public String getUrlPartsPort() {
        return matcherDivideUrl.group("port");
    }
}
