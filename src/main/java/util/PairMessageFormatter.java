package util;

import core.RankType;
import core.Value;

import java.util.List;

public class PairMessageFormatter extends MessageFormatter{
    protected final String WIN_REASON_PAIR_HIGH_CARD = "{0} wins. - same {1} with high card: {2}";
    protected final String WIN_REASON_PAIR_HIGHER_PAIR = "{0} wins. - {1} with higher pair: {2}";

    public PairMessageFormatter(int compare, RankType blackRankType, RankType whiteRankType,
                                List<Value> blackValues, List<Value> whiteValues, int ptr) {
        super(compare, blackRankType, whiteRankType, blackValues, whiteValues, ptr);
        if (ptr==0) {
            message = WIN_REASON_PAIR_HIGHER_PAIR;
        }else{
            message = WIN_REASON_PAIR_HIGH_CARD;
        }
    }
}
