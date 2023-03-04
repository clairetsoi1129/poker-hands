package criteria;

import model.*;

import java.util.List;
import java.util.Map;

public class TwoPairsCriteria extends Criteria{
    public TwoPairsCriteria(List<Card> cards) {
        super(cards);
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
