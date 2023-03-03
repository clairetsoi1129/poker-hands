package model;

import java.util.List;

public class StraightFlush extends HighCard{
    public StraightFlush(List<Card> cards, List<Value> valuesToCompare) {
        super(cards, valuesToCompare);
        rank = Rank.StraightFlush;
    }
}
