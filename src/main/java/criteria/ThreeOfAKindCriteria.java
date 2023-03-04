package criteria;

import core.Card;
import core.Value;
import rank.*;

import java.util.List;
import java.util.Map;

public class ThreeOfAKindCriteria extends Criteria{
    public ThreeOfAKindCriteria(List<Card> cards) {
        super(cards);
    }

    @Override
    public Rank meetCriteria() {
        Rank rank = null;
        for (Map.Entry<Value, Long> s : sortedGroupByValueMap.entrySet()) {
            if (s.getValue() == 3) { // 3 of a kind
                rank = new ThreeOfAKind( valuesToCompare);
                break;
            }
        }
        return rank;
    }
}
