package criteria;

import model.Card;
import model.ThreeOfAKind;
import model.HighCard;
import model.Value;

import java.util.List;
import java.util.Map;

public class ThreeOfAKindCriteria extends Criteria{
    public ThreeOfAKindCriteria(List<Card> cards) {
        super(cards);
    }

    @Override
    public HighCard meetCriteria() {
        HighCard highCard = null;
        for (Map.Entry<Value, Long> s : sortedGroupByValueMap.entrySet()) {
            if (s.getValue() == 3 && sortedGroupByValueMap.entrySet().size() == 3) { // 3 of a kind
                highCard = new ThreeOfAKind( valuesToCompare);
                break;
            }
        }
        return highCard;
    }
}
