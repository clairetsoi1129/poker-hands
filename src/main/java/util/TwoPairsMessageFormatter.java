package util;

import core.RankType;
import core.Value;

import java.util.List;

public class TwoPairsMessageFormatter extends PairMessageFormatter{
    public TwoPairsMessageFormatter(int compare, RankType rankType, List<Value> blackValues,
                                    List<Value> whiteValues, int ptr) {
        super(compare, rankType, blackValues, whiteValues, ptr);
        if (ptr==0 || ptr==1) {
            message = WIN_REASON_PAIR_HIGHER_PAIR;
        }else{
            message = WIN_REASON_PAIR_HIGH_CARD;
        }
    }
}
