package rank;

import core.RankType;
import core.Value;
import util.*;

import java.util.*;

public class HighCard implements Comparable<Rank>, Rank{
    protected RankType rankType;
    protected List<Value> valuesToCompare;
    protected String reason;

    public HighCard(List<Value> valuesToCompare) {
        this.valuesToCompare = valuesToCompare;
        this.rankType = RankType.HighCard;
    }

    public int compareTo(Rank other) {
        int result = this.getRankType().compareTo(other.getRankType());
        if (result == 0) { // if both are same rankType, need to compare by higher card
            result = compareTo(this.getRankType(), other.getRankType(), this.getValuesToCompare(),
                    other.getValuesToCompare());
        } else{ // else compare by rankType
            formatReason(result, this.getRankType(), other.getRankType(),
                    this.getValuesToCompare(), other.getValuesToCompare(),0);
        }
        return result;
    }

    public int compareTo(RankType blackRankType, RankType whiteRankType,
                         List<Value> blackValues, List<Value> whiteValues) {
        int result = 0;
        for (int i = 0; i < blackValues.size(); i++) {
            result = blackValues.get(i).compareTo(whiteValues.get(i));

            if (result != 0) {
                formatReason(result, blackRankType, whiteRankType, blackValues, whiteValues,i);
                break;
            }
        }
        if (result == 0) {
            formatReason(result, blackRankType, whiteRankType, blackValues, whiteValues,0);
        }

        return result;
    }

    public void formatReason(int compareResult, RankType blackRankType, RankType whiteRankType,
                             List<Value> blackValues, List<Value> whiteValues, int idx) {
        reason = new MessageFormatter(compareResult,
                blackRankType, whiteRankType, blackValues, whiteValues, idx).format();
    }

    public RankType getRankType() {
        return rankType;
    }

    public List<Value> getValuesToCompare() {
        return valuesToCompare;
    }

    public String getReason() {
        return reason;
    }
}
