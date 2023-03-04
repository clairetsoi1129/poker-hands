package rank;

import core.RankType;
import core.Value;
import util.FlushMessageFormatter;
import util.MessageFormatter;

import java.util.List;

public class Flush extends HighCard{
    public Flush(List<Value> valuesToCompare) {
        super(valuesToCompare);
        rankType = RankType.Flush;
    }

    @Override
    public int compareTo(Rank other) {
        int result = this.getRankType().compareTo(other.getRankType());
        if (result == 0) { // if both are same rankType, need to compare by higher card
            result = compareTo(this.getRankType(), other.getRankType(), this.getValuesToCompare(),
                    other.getValuesToCompare());
        } else{ // else compare by rankType
            reason = new MessageFormatter(result,
                    this.getRankType(), other.getRankType(), this.getValuesToCompare(),
                    other.getValuesToCompare(), 0).format();
        }
        return result;
    }

    @Override
    public void formatReason(int compareResult, RankType blackRankType, RankType whiteRankType,
                             List<Value> blackValues, List<Value> whiteValues, int idx) {
        reason = new FlushMessageFormatter(compareResult,
                blackRankType, whiteRankType, blackValues, whiteValues, idx).format();
    }
}
