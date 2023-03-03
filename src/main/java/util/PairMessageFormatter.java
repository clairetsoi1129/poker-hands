package util;

import model.Rank;
import model.Value;

import java.util.List;

public class PairMessageFormatter extends MessageFormatter{
    protected final String WIN_REASON_PAIR_HIGH_CARD = "{0} wins. - same {1} with high card: {2}";
    protected final String WIN_REASON_PAIR_HIGHER_PAIR = "{0} wins. - {1} with higher pair: {2}";

    public PairMessageFormatter(int compare, Rank rank, List<Value> blackValues,
                                List<Value> whiteValues, int ptr) {
        super(compare, rank, blackValues, whiteValues, ptr);
        if (ptr==0) {
            message = WIN_REASON_PAIR_HIGHER_PAIR;
        }else{
            message = WIN_REASON_PAIR_HIGH_CARD;
        }
    }
}
