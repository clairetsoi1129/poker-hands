package criteria;

import model.*;

import java.util.List;

public class FullHouseCriteria extends Criteria{
    private final Criteria threeOfAKindCriteria;
    private final Criteria pairCriteria;

    public FullHouseCriteria(List<Card> cards, Criteria threeOfAKindCriteria, Criteria pairCriteria) {
        super(cards);
        this.threeOfAKindCriteria = threeOfAKindCriteria;
        this.pairCriteria = pairCriteria;
    }

    @Override
    public HighCard meetCriteria() {
        HighCard highCard = null;

        if (threeOfAKindCriteria.meetCriteria() != null && pairCriteria.meetCriteria() != null) {
            highCard = new FullHouse(valuesToCompare);
        }

        return highCard;
    }
}
