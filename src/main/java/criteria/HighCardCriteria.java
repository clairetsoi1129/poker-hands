package criteria;

import core.Card;
import rank.HighCard;
import rank.Rank;

import java.util.List;

public class HighCardCriteria extends Criteria{
    public HighCardCriteria(List<Card> cards) {
        super(cards);
    }

    @Override
    public Rank meetCriteria() {
        return new HighCard(valuesToCompare);
    }
}
