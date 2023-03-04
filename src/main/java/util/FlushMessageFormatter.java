package util;

import core.RankType;
import core.Value;

import java.util.List;

public class FlushMessageFormatter extends MessageFormatter{
    private final String WIN_REASON_FLUSH_HIGH_CARD = "{0} wins. - {1} with high card: {2}";

    public FlushMessageFormatter(int compare, RankType rankType, List<Value> blackValues,
                                 List<Value> whiteValues, int ptr) {
        super(compare, rankType, blackValues, whiteValues, ptr);
        message = WIN_REASON_FLUSH_HIGH_CARD;
    }
}
