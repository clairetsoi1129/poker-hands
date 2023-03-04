package rank;

import core.RankType;
import core.Value;

import java.util.List;

public interface Rank{
    int compareTo(RankType blackRankType, RankType whiteRankType,
                  List<Value> blackValues, List<Value> whiteValues);
    void formatReason(int compareResult, RankType blackRankType, RankType whiteRankType,
                             List<Value> blackValues, List<Value> whiteValues, int idx);
    RankType getRankType();

    List<Value> getValuesToCompare();

    String getReason();

    int compareTo(Rank other);
}
