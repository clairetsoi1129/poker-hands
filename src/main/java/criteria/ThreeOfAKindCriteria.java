package criteria;

import core.Card;
import core.Value;
import rank.*;

import java.util.HashMap;
import java.util.List;

public class ThreeOfAKindCriteria extends Criteria{
    public ThreeOfAKindCriteria(List<Card> cards, HashMap<Value, Long> sortedGroupByValueMap) {
        super(cards, sortedGroupByValueMap);
    }

    @Override
    public Rank meetCriteria() {
        return sortedGroupByValueMap.entrySet()
                .stream()
                .filter(s -> s.getValue() == 3).count() == 1 ? new ThreeOfAKind(valuesToCompare): null;
    }
}
