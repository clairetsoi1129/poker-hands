package model;

import util.PairMessageFormatter;

import java.util.List;

public class Pair extends HighCard implements Comparable<Rank>{
    public Pair(List<Value> valuesToCompare) {
        super(valuesToCompare);
        rankType = RankType.Pair;
    }

    @Override
    public void formatReason(int compareResult, RankType rankType, List<Value> blackValues,
                             List<Value> whiteValues, int idx) {
        reason = new PairMessageFormatter(compareResult,
                this.getRankType(), blackValues, whiteValues, idx).format();
    }
}
