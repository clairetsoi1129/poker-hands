package util;

import core.RankType;
import core.Value;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoPairsMessageFormatterTest {
    @Test
    void testTwoPairsMessageWinMessage_TwoPairsvsTwoPairs_sameTwoPair_5th_diff() {
        MessageFormatter mf = new TwoPairsMessageFormatter(1, RankType.TwoPairs, RankType.TwoPairs,
                Arrays.asList(Value.ACE, Value.JACK, Value.QUEEN),
                Arrays.asList(Value.ACE, Value.JACK, Value.TEN),2);

        assertEquals("Black wins. - same two pairs with high card: Q", mf.format());
    }

    @Test
    void testTwoPairsMessageWinMessage_TwoPairsvsTwoPairs_same1stPair_2ndPairDiff() {
        MessageFormatter mf = new TwoPairsMessageFormatter(1, RankType.TwoPairs, RankType.TwoPairs,
                Arrays.asList(Value.ACE, Value.JACK, Value.QUEEN),
                Arrays.asList(Value.ACE, Value.NINE, Value.TEN),1);

        assertEquals("Black wins. - two pairs with higher pair: J", mf.format());
    }
}
