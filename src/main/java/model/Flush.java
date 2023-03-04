package model;

import util.FlushMessageFormatter;

import java.util.List;

public class Flush extends HighCard{
    public Flush(List<Value> valuesToCompare) {
        super(valuesToCompare);
        rankType = RankType.Flush;
    }

    @Override
    public void formatReason(int compareResult, RankType rankType, List<Value> blackValues,
                             List<Value> whiteValues, int idx) {
        reason = new FlushMessageFormatter(compareResult,
                this.getRankType(), blackValues, whiteValues, idx).format();
    }
}
