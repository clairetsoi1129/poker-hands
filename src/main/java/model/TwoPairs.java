package model;

import util.TwoPairsMessageFormatter;

import java.util.List;

public class TwoPairs extends HighCard{
    public TwoPairs(List<Card> cards, List<Value> valuesToCompare) {
        super(cards, valuesToCompare);
        rank = Rank.TwoPairs;
    }

    @Override
    public void formatReason(int compareResult, Rank rank, List<Value> blackValues,
                             List<Value> whiteValues, int idx) {
        reason = new TwoPairsMessageFormatter(compareResult,
                this.getRank(), blackValues, whiteValues, idx).format();
    }
}
