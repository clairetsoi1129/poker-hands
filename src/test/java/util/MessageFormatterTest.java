package util;

import core.RankType;
import core.Value;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageFormatterTest {
    @Test
    void testFourOfAKindWinMessage() {
        MessageFormatter mf = new MessageFormatter(1, RankType.FourOfAKind, RankType.FourOfAKind,
                Arrays.asList(Value.ACE, Value.ACE, Value.ACE, Value.ACE,Value.DEDUCE),
                Arrays.asList(Value.KING, Value.KING, Value.KING, Value.KING,Value.DEDUCE), 0);

        assertEquals("Black wins. - with four of a kind: A", mf.format());
    }

    @Test
    void testStraightFlushWinMessage() {
        MessageFormatter mf = new MessageFormatter(1, RankType.StraightFlush, RankType.StraightFlush,
                Arrays.asList(Value.ACE, Value.KING, Value.QUEEN, Value.JACK,Value.TEN),
                Arrays.asList(Value.KING, Value.QUEEN, Value.JACK, Value.TEN,Value.NINE), 0);

        assertEquals("Black wins. - with straight flush: A", mf.format());
    }

    @Test
    void testStraightWinMessage() {
        MessageFormatter mf = new MessageFormatter(1, RankType.Straight, RankType.Straight,
                Arrays.asList(Value.ACE, Value.KING, Value.QUEEN, Value.JACK,Value.TEN),
                Arrays.asList(Value.KING, Value.QUEEN, Value.JACK, Value.TEN,Value.NINE), 0);

        assertEquals("Black wins. - with straight: A", mf.format());
    }

    @Test
    void testHighCardWinMessage() {
        MessageFormatter mf = new MessageFormatter(1, RankType.HighCard, RankType.HighCard,
                Arrays.asList(Value.ACE, Value.KING, Value.QUEEN, Value.JACK,Value.NINE),
                Arrays.asList(Value.KING, Value.QUEEN, Value.JACK, Value.TEN,Value.EIGHT), 0);

        assertEquals("Black wins. - with high card: A", mf.format());
    }
}
