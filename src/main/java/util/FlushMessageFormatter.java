package util;

import model.Rank;
import model.Value;

import java.util.List;

public class FlushMessageFormatter extends MessageFormatter{
    private final String WIN_REASON_FLUSH_HIGH_CARD = "{0} wins. - {1} with high card: {2}";

    public FlushMessageFormatter(int compare, Rank rank, List<Value> blackValues,
                                 List<Value> whiteValues, int ptr) {
        super(compare, rank, blackValues, whiteValues, ptr);
        message = WIN_REASON_FLUSH_HIGH_CARD;
    }
}
