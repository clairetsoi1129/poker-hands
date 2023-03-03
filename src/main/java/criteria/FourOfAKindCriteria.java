package criteria;

import model.Card;
import model.FourOfAKind;
import model.HighCard;
import model.Value;

import java.util.List;
import java.util.Map;

public class FourOfAKindCriteria extends Criteria{
    public FourOfAKindCriteria(List<Card> cards) {
        super(cards);
    }

    @Override
    public HighCard meetCriteria() {
        HighCard highCard = null;
        for (Map.Entry<Value, Long> s : sortedGroupByValueMap.entrySet()) {
            if (s.getValue() == 4) { // 4 of a kind
                highCard = new FourOfAKind(valuesToCompare);
                break;
            }
        }
        return highCard;
    }
}
