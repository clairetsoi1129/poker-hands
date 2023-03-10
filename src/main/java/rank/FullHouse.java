package rank;

import core.RankType;
import core.Value;
import util.FullHouseMessageFormatter;

import java.util.List;

public class FullHouse extends HighCard{
    public FullHouse(List<Value> valuesToCompare) {
        super(valuesToCompare);
        rankType = RankType.FullHouse;
    }

    @Override
    public void formatReason(int compareResult, RankType blackRankType, RankType whiteRankType,
                             List<Value> blackValues,
                             List<Value> whiteValues, int idx) {
        reason = new FullHouseMessageFormatter(compareResult,blackRankType,
                whiteRankType, blackValues, whiteValues).format();
    }
}
