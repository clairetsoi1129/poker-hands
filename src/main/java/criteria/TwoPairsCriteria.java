package criteria;

import model.Card;
import model.HighCard;
import model.TwoPairs;
import model.Value;

import java.util.List;
import java.util.Map;

public class TwoPairsCriteria extends Criteria{
    public TwoPairsCriteria(List<Card> cards) {
        super(cards);
    }

    @Override
    public HighCard meetCriteria() {
        HighCard highCard = null;
        for (Map.Entry<Value, Long> s : sortedGroupByValueMap.entrySet()) {
            if (s.getValue() == 2 && sortedGroupByValueMap.entrySet().size() == 3) {  // 2 pairs
                highCard = new TwoPairs(valuesToCompare);
                break;
            }
        }
        return highCard;
    }
}
