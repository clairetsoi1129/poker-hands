package criteria;

import model.*;

import java.util.*;

public class StraightFlushCriteria extends Criteria{
    private final Criteria straightCriteria;
    private final Criteria flushCriteria;

    public StraightFlushCriteria(List<Card> cards, Criteria straightCriteria, Criteria flushCriteria) {
        super(cards);
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
