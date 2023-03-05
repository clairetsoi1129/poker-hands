package criteria;

import core.Card;
import core.Value;
import rank.*;

import java.util.HashMap;
import java.util.List;

public class FullHouseCriteria extends Criteria{
    private final Criteria threeOfAKindCriteria;
    private final Criteria pairCriteria;

    public FullHouseCriteria(List<Card> cards, HashMap<Value, Long> sortedGroupByValueMap,
                             Criteria threeOfAKindCriteria, Criteria pairCriteria) {
        super(cards, sortedGroupByValueMap);
        this.threeOfAKindCriteria = threeOfAKindCriteria;
        this.pairCriteria = pairCriteria;
    }

    @Override
    public Rank meetCriteria() {
        return (threeOfAKindCriteria.meetCriteria() != null && pairCriteria.meetCriteria() != null)
                ?new FullHouse(valuesToCompare):null;
    }
}
