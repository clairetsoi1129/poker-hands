package model;

import util.FullHouseMessageFormatter;

import java.util.List;

public class FullHouse extends HighCard implements Comparable<Rank>{
    public FullHouse(List<Value> valuesToCompare) {
        super(valuesToCompare);
        rankType = RankType.FullHouse;
    }

    @Override
    public void formatReason(int compareResult, RankType rankType, List<Value> blackValues,
                             List<Value> whiteValues, int idx) {
        reason = new FullHouseMessageFormatter(compareResult,
                this.getRankType(), blackValues, whiteValues).format();
    }
}
