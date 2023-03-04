package model;

import java.util.List;

public class FourOfAKind extends HighCard{
    public FourOfAKind(List<Value> valuesToCompare) {
        super(valuesToCompare);
        rankType = RankType.FourOfAKind;
    }
}
