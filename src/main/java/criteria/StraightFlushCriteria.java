package criteria;

import core.Card;
import core.Value;
import rank.*;

import java.util.*;

public class StraightFlushCriteria extends Criteria{
    private final Criteria straightCriteria;
    private final Criteria flushCriteria;

    public StraightFlushCriteria(List<Card> cards, HashMap<Value, Long> sortedGroupByValueMap,
                                 Criteria straightCriteria, Criteria flushCriteria) {
        super(cards, sortedGroupByValueMap);
        this.straightCriteria =straightCriteria;
        this.flushCriteria = flushCriteria;
    }

    @Override
    public Rank meetCriteria() {
        Rank rank = null;

        if (straightCriteria.meetCriteria() != null && flushCriteria.meetCriteria() != null) {
            rank = new StraightFlush(valuesToCompare);
        }

        return rank;
    }
}
