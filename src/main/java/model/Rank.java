package model;

import java.util.List;

public abstract class Rank implements Comparable<Rank>{
    public abstract int compareTo(RankType rankType, List<Value> blackValues, List<Value> whiteValues);
    public abstract void formatReason(int compareResult, RankType rankType,
                             List<Value> blackValues, List<Value> whiteValues, int idx);
    public abstract RankType getRankType();

    public abstract List<Value> getValuesToCompare();

    public abstract String getReason();

    public abstract int compareTo(Rank other);
}
