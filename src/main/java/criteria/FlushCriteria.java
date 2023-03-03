package criteria;

import model.*;

import java.util.List;

public class FlushCriteria extends StraightFlushCriteria{
    public FlushCriteria(List<Card> cards) {
        super(cards);
    }

    @Override
    public HighCard meetCriteria() {
        HighCard highCard = null;
        if (isSingleSuit() && !isStraight()) {
            highCard = new Flush(valuesToCompare);
        }
        return highCard;
    }
}
