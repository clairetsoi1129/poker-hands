package util;

import core.RankType;
import core.Value;

import java.util.List;

public class TwoPairsMessageFormatter extends PairMessageFormatter{
    public TwoPairsMessageFormatter(int compare, RankType blackRankType, RankType whiteRankType,
                                    List<Value> blackValues,
                                    List<Value> whiteValues, int ptr) {
        super(compare, blackRankType, whiteRankType, blackValues, whiteValues, ptr);
        if (ptr==0 || ptr==1) {
            message = WIN_REASON_PAIR_HIGHER_PAIR;
        }else{
            message = WIN_REASON_PAIR_HIGH_CARD;
        }
    }
}
