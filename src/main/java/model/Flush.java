package model;

import util.FlushMessageFormatter;

import java.util.List;

public class Flush extends HighCard{
    public Flush(List<Card> cards, List<Value> valuesToCompare) {
        super(cards, valuesToCompare);
        rank = Rank.Flush;
    }

    @Override
    public void formatReason(int compareResult, Rank rank, List<Value> blackValues,
                             List<Value> whiteValues, int idx) {
        reason = new FlushMessageFormatter(compareResult,
                this.getRank(), blackValues, whiteValues, idx).format();
    }
}
