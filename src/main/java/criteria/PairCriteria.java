package criteria;

import core.Card;
import core.Value;
import rank.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairCriteria extends Criteria{
    public PairCriteria(List<Card> cards, HashMap<Value, Long> sortedGroupByValueMap) {
        super(cards, sortedGroupByValueMap);
    }

    @Override
    public Rank meetCriteria() {
        List<Map.Entry<Value, Long>> pairList = sortedGroupByValueMap.entrySet()
                .stream()
                .filter(s -> s.getValue() == 2).toList();

        return switch (pairList.size()) {
            case 1 -> new Pair(valuesToCompare);
            case 2 -> new TwoPairs(valuesToCompare);
            default -> null;
        };
    }
}