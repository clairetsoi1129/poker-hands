package criteria;

import model.Card;
import model.HighCard;
import model.Pair;
import model.Value;

import java.util.List;
import java.util.Map;

public class PairCriteria extends Criteria{
    public PairCriteria(List<Card> cards) {
        super(cards);
    }

    @Override
    public HighCard meetCriteria() {
        HighCard highCard = null;
        for (Map.Entry<Value, Long> s : sortedGroupByValueMap.entrySet()) {
            if (s.getValue() == 2) { // 1 pair
                highCard = new Pair(valuesToCompare);
                break;
            }
        }
        return highCard;
    }
}