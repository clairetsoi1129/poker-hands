package util;

import model.Rank;
import model.Value;

import java.util.List;

public class TwoPairsMessageFormatter extends PairMessageFormatter{
    public TwoPairsMessageFormatter(int compare, Rank rank, List<Value> blackValues,
                                    List<Value> whiteValues, int ptr) {
        super(compare, rank, blackValues, whiteValues, ptr);
        if (ptr==0 || ptr==1) {
            message = WIN_REASON_PAIR_HIGHER_PAIR;
        }else{
            message = WIN_REASON_PAIR_HIGH_CARD;
        }
    }
}
