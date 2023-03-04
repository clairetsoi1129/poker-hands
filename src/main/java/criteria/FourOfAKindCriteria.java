package criteria;

import model.*;

import java.util.List;
import java.util.Map;

public class FourOfAKindCriteria extends Criteria{
    public FourOfAKindCriteria(List<Card> cards) {
        super(cards);
    }

    @Override
    public Rank meetCriteria() {
        Rank rank = null;
        for (Map.Entry<Value, Long> s : sortedGroupByValueMap.entrySet()) {
            if (s.getValue() == 4) { // 4 of a kind
                rank = new FourOfAKind(valuesToCompare);
                break;
            }
        }
        return rank;
    }
}
