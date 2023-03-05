package criteria;

import core.Card;
import core.Value;
import rank.*;

import java.util.HashMap;
import java.util.List;

public class FourOfAKindCriteria extends Criteria{
    public FourOfAKindCriteria(List<Card> cards, HashMap<Value, Long> sortedGroupByValueMap) {
        super(cards, sortedGroupByValueMap);
    }

    @Override
    public Rank meetCriteria() {
        return sortedGroupByValueMap.entrySet()
                .stream()
                .filter(s -> s.getValue() == 4).count() == 1 ? new FourOfAKind(valuesToCompare): null;
    }
}
