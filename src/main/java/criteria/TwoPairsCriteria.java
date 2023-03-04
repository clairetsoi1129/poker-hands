package criteria;

import core.Card;
import core.Value;
import rank.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoPairsCriteria extends Criteria{
    public TwoPairsCriteria(List<Card> cards, HashMap<Value, Long> sortedGroupByValueMap) {
        super(cards, sortedGroupByValueMap);
    }

    @Override
    public Rank meetCriteria() {
        Rank rank = null;
        for (Map.Entry<Value, Long> s : sortedGroupByValueMap.entrySet()) {
            if (s.getValue() == 2 && sortedGroupByValueMap.entrySet().size() == 3) {  // 2 pairs
                rank = new TwoPairs(valuesToCompare);
                break;
            }
        }
        return rank;
    }
}
