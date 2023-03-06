package util;

import core.RankType;
import core.Value;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PairMessageFormatterTest {
    @Test
    void testPairMessageWinMessage_PairvsPair_1st_diff() {
        MessageFormatter mf = new PairMessageFormatter(1, RankType.Pair, RankType.Pair,
                Arrays.asList(Value.ACE, Value.JACK, Value.TEN, Value.NINE),
                Arrays.asList(Value.KING, Value.NINE, Value.TEN,Value.EIGHT),0);

        assertEquals("Black wins. - pair with higher pair: A", mf.format());
    }

    @Test
    void testPairMessageWinMessage_PairvsPair_samePair_3rd_diff() {
        MessageFormatter mf = new PairMessageFormatter(1, RankType.Pair, RankType.Pair,
                Arrays.asList(Value.ACE, Value.JACK, Value.TEN, Value.NINE),
                Arrays.asList(Value.ACE, Value.NINE, Value.TEN,Value.EIGHT),1);

        assertEquals("Black wins. - same pair with high card: J", mf.format());
    }
}
