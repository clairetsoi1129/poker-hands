package criteria;

import model.*;

import java.util.List;
import java.util.Map;

public class PairCriteria extends Criteria{
    public PairCriteria(List<Card> cards) {
        super(cards);
    }

    @Override
    public Rank meetCriteria() {
        Rank rank = null;
        for (Map.Entry<Value, Long> s : sortedGroupByValueMap.entrySet()) {
            if (s.getValue() == 2) { // 1 pair
                rank = new Pair(valuesToCompare);
                break;
            }
        }
        return rank;
    }
}