package criteria;

import model.Card;
import model.HighCard;
import model.Rank;

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
