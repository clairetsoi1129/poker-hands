package model;

import util.*;

import java.util.*;

public class HighCard implements Comparable<HighCard>{
    protected Rank rank;
    protected List<Value> valuesToCompare;
    protected String reason;

    public HighCard(List<Value> valuesToCompare) {
        this.valuesToCompare = valuesToCompare;
        this.rank = Rank.HighCard;
    }

    public int compareTo(HighCard other) {
        int result = this.getRank().compareTo(other.getRank());
        if (result == 0) { // if both are same rank, need to compare by higher card
            result = compareTo(this.getRank(), this.getValuesToCompare(),
                    other.getValuesToCompare());
        } else{ // else compare by rank
            formatReason(result, this.getRank(), this.getValuesToCompare(), other.getValuesToCompare(),0);
        }
        return result;
    }

    public int compareTo(Rank rank, List<Value> blackValues, List<Value> whiteValues) {
        int result = 0;
        for (int i = 0; i < blackValues.size(); i++) {
            result = blackValues.get(i).compareTo(whiteValues.get(i));

            if (result != 0) {
                formatReason(result, rank, blackValues, whiteValues,i);
                break;
            }
        }
        if (result == 0) {
            formatReason(result, rank, blackValues, whiteValues,0);
        }

        return result;
    }

    public void formatReason(int compareResult, Rank rank,
                             List<Value> blackValues, List<Value> whiteValues, int idx) {
        reason = new MessageFormatter(compareResult,
                this.getRank(), blackValues, whiteValues, idx).format();
    }

    public Rank getRank() {
        return rank;
    }

    public List<Value> getValuesToCompare() {
        return valuesToCompare;
    }

    public String getReason() {
        return reason;
    }
}
