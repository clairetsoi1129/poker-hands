package model;

import java.util.List;

public class FourOfAKind extends HighCard implements Comparable<Rank>{
    public FourOfAKind(List<Value> valuesToCompare) {
        super(valuesToCompare);
        rankType = RankType.FourOfAKind;
    }
}
