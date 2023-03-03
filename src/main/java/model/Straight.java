package model;

import java.util.List;

public class Straight extends HighCard{
    public Straight(List<Card> cards, List<Value> valuesToCompare) {
        super(cards, valuesToCompare);
        rank = Rank.Straight;
    }
}
