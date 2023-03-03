package model;

import util.TwoPairsMessageFormatter;

import java.util.List;

public class TwoPairs extends HighCard{
    public TwoPairs(List<Value> valuesToCompare) {
        super(valuesToCompare);
        rank = Rank.TwoPairs;
    }

    @Override
    public void formatReason(int compareResult, Rank rank, List<Value> blackValues,
                             List<Value> whiteValues, int idx) {
        reason = new TwoPairsMessageFormatter(compareResult,
                this.getRank(), blackValues, whiteValues, idx).format();
    }
}
