package model;

import util.FullHouseMessageFormatter;

import java.util.List;

public class FullHouse extends HighCard{
    public FullHouse(List<Value> valuesToCompare) {
        super(valuesToCompare);
        rank = Rank.FullHouse;
    }

    @Override
    public void formatReason(int compareResult, Rank rank, List<Value> blackValues,
                             List<Value> whiteValues, int idx) {
        reason = new FullHouseMessageFormatter(compareResult,
                this.getRank(), blackValues, whiteValues).format();
    }
}
