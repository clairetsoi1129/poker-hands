package criteria;

import core.Card;
import core.Value;
import rank.HighCard;
import rank.Rank;

import java.util.HashMap;
import java.util.List;

public class HighCardCriteria extends Criteria{
    public HighCardCriteria(List<Card> cards, HashMap<Value, Long> sortedGroupByValueMap) {
        super(cards, sortedGroupByValueMap);
    }

    @Override
    public Rank meetCriteria() {
        return new HighCard(valuesToCompare);
    }
}
