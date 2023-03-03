package model;

import java.util.List;

public class FourOfAKind extends HighCard{
    public FourOfAKind(List<Card> cards, List<Value> valuesToCompare) {
        super(cards, valuesToCompare);
        rank = Rank.FourOfAKind;
    }
}
