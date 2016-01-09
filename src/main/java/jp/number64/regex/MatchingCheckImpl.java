package jp.number64.regex;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MatchingCheckImpl
  implements MatchingZeroSize, MatchingCharactorClass  {
    private static final Logger LOGGER = LoggerFactory.getLogger(MatchingCheckImpl.class);

    private static final String LOG_TEMPLATE = "text:{}";

    // Caution: Pattern is thread-safe, but Matcher is not.
    /** @see java.util.regex.Pattern */
    /** @see java.util.regex.Matcher */

    // position
    private static final Pattern EXP_PERFECT_MATCHING = Pattern.compile(PATTERN_PERFECT_MATCHING);
    private static final Pattern EXP_PARTIAL_MATCHING = Pattern.compile(PATTERN_PARTIAL_MATCHING);
    private static final Pattern EXP_PREFIX_MATCHING = Pattern.compile(PATTERN_PREFIX_MATCHING);
    private static final Pattern EXP_SUFFIX_MATCHING = Pattern.compile(PATTERN_SUFFIX_MATCHING);
    private static final Pattern EXP_PREFIX_MATCHING_ESC = Pattern.compile(PATTERN_PREFIX_MATCHING_ESC);
    private static final Pattern EXP_SUFFIX_MATCHING_ESC = Pattern.compile(PATTERN_SUFFIX_MATCHING_ESC);
    // char-class
    private static final Pattern EXP_SPECIFIC_CHARS = Pattern.compile(PATTERN_SPECIFIC_CHARS);
    private static final Pattern EXP_RANGE_CHARS = Pattern.compile(PATTERN_RANGE_CHARS);

    @Override
    public boolean findPerfectMatching(String text) {
        LOGGER.debug(LOG_TEMPLATE, text);
        return EXP_PERFECT_MATCHING.matcher(text).find();
    }

    @Override
    public boolean findPartialMatching(String text) {
        LOGGER.debug(LOG_TEMPLATE, text);
        return EXP_PARTIAL_MATCHING.matcher(text).find();
    }

    @Override
    public boolean findPrefixMatching(String text) {
        LOGGER.debug(LOG_TEMPLATE, text);
        return EXP_PREFIX_MATCHING.matcher(text).find();
    }

    @Override
    public boolean findSuffixMatching(String text) {
        LOGGER.debug(LOG_TEMPLATE, text);
        return EXP_SUFFIX_MATCHING.matcher(text).find();
    }

    @Override
    public boolean findPrefixMatchingEsc(String text) {
        LOGGER.debug(LOG_TEMPLATE, text);
        return EXP_PREFIX_MATCHING_ESC.matcher(text).find();
    }

    @Override
    public boolean findSuffixMatchingEsc(String text) {
        LOGGER.debug(LOG_TEMPLATE, text);
        return EXP_SUFFIX_MATCHING_ESC.matcher(text).find();
    }

    @Override
    public boolean findSpecificChars(String text) {
        LOGGER.debug(LOG_TEMPLATE, text);
        return EXP_SPECIFIC_CHARS.matcher(text).find();
    }

    @Override
    public boolean findRangeChars(String text) {
        LOGGER.debug(LOG_TEMPLATE, text);
        return EXP_RANGE_CHARS.matcher(text).find();
    }
}
