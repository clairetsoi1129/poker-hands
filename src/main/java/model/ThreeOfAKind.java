package model;

import java.util.List;

public class ThreeOfAKind extends HighCard{
    public ThreeOfAKind(List<Card> cards, List<Value> valuesToCompare) {
        super(cards, valuesToCompare);
        rank = Rank.ThreeOfAKind;
    }
}
