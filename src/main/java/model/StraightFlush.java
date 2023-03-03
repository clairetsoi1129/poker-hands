package model;

import java.util.List;

public class StraightFlush extends HighCard{
    public StraightFlush(List<Value> valuesToCompare) {
        super(valuesToCompare);
        rank = Rank.StraightFlush;
    }
}
