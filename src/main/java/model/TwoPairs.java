package model;

import util.TwoPairsMessageFormatter;

import java.util.List;

public class TwoPairs extends HighCard implements Comparable<Rank>{
    public TwoPairs(List<Value> valuesToCompare) {
        super(valuesToCompare);
        rankType = RankType.TwoPairs;
    }

    @Override
    public void formatReason(int compareResult, RankType rankType, List<Value> blackValues,
                             List<Value> whiteValues, int idx) {
        reason = new TwoPairsMessageFormatter(compareResult,
                this.getRankType(), blackValues, whiteValues, idx).format();
    }
}
