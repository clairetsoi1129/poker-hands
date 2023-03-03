package criteria;

import model.*;

import java.util.HashMap;
import java.util.List;

public class FlushCriteria extends StraightFlushCriteria implements Criteria{
    public FlushCriteria(List<Card> cards) {
        super(cards);
    }

    @Override
    public HighCard meetCriteria(HashMap<Value, Long> sortedGroupByValueMap, List<Value> valuesToCompare) {
        HighCard highCard = null;
        if (isSingleSuit() && !isStraight()) {
            highCard = new Flush(valuesToCompare);
        }
        return highCard;
    }
}
