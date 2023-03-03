package model;

import util.PairMessageFormatter;

import java.util.List;

public class Pair extends HighCard{
    public Pair(List<Value> valuesToCompare) {
        super(valuesToCompare);
        rank = Rank.Pair;
    }

    @Override
    public void formatReason(int compareResult, Rank rank, List<Value> blackValues,
                             List<Value> whiteValues, int idx) {
        reason = new PairMessageFormatter(compareResult,
                this.getRank(), blackValues, whiteValues, idx).format();
    }
}
