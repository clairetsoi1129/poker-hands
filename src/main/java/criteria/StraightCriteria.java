package criteria;

import core.Card;
import core.Value;
import rank.*;

import java.util.*;
import java.util.stream.Collectors;

public class StraightCriteria extends Criteria{
    public StraightCriteria(List<Card> cards, HashMap<Value, Long> sortedGroupByValueMap) {
        super(cards, sortedGroupByValueMap);
    }

    @Override
    public Rank meetCriteria() {
        Rank rank = null;
        if (isStraight()) {
            rank = new Straight(valuesToCompare);
        }
        return rank;
    }

    protected boolean isStraight() {
        boolean result = true;

        List<Card> sortedCards = sort();
        for (int i = 0; i < sortedCards.size() - 1; i++) {
            if (sortedCards.get(i + 1).getValue() != sortedCards.get(i).getValue().prev()) {
                result = false;
                break;
            }
        }
        return result;
    }

    protected List<Card> sort() {
        return cards.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
