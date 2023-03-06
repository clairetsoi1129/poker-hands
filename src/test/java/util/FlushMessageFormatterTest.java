package util;

import core.RankType;
import core.Value;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlushMessageFormatterTest {
    @Test
    void testFlushMessageWinMessage_FlushvsFlush() {
        MessageFormatter mf = new FlushMessageFormatter(1, RankType.Flush, RankType.Flush,
                Arrays.asList(Value.ACE, Value.KING, Value.QUEEN, Value.JACK,Value.NINE),
                Arrays.asList(Value.KING, Value.QUEEN, Value.JACK, Value.TEN,Value.EIGHT), 0);

        assertEquals("Black wins. - flush with high card: A", mf.format());
    }
}
