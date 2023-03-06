package util;

import core.RankType;
import core.Value;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FullHouseMessageFormatterTest {
    @Test
    void testFullHouseMessageWinMessage_FullHousevsFlush() {
        MessageFormatter mf = new FullHouseMessageFormatter(1, RankType.FullHouse, RankType.Flush,
                Arrays.asList(Value.ACE, Value.JACK),
                Arrays.asList(Value.KING, Value.KING, Value.JACK, Value.TEN,Value.EIGHT));

        assertEquals("Black wins. - with full house: A over J", mf.format());
    }

    @Test
    void testFullHouseMessageWinMessage_FullHousevsFullHouse() {
        MessageFormatter mf = new FullHouseMessageFormatter(1, RankType.FullHouse, RankType.FullHouse,
                Arrays.asList(Value.ACE, Value.JACK),
                Arrays.asList(Value.KING, Value.TEN));

        assertEquals("Black wins. - with full house: A over J", mf.format());
    }
}
