package criteria;

import model.*;

import java.util.*;
import java.util.stream.Collectors;

public class StraightFlushCriteria implements Criteria{
    protected Map<Suit, Long> groupBySuitMap;
    protected final List<Card> cards;

    public StraightFlushCriteria(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public HighCard meetCriteria(HashMap<Value, Long> sortedGroupByValueMap, List<Value> valuesToCompare) {
        HighCard highCard = null;

        if (isSingleSuit() && isStraight()) {
            highCard = new StraightFlush(valuesToCompare);
        }

        return highCard;
    }

    protected boolean isSingleSuit() {
        if (groupBySuitMap == null) {
            groupBySuitMap =
                    cards.stream().collect(
                            Collectors.groupingBy(
                                    Card::getSuit, Collectors.counting()
                            )
                    );
        }
        Set<Map.Entry<Suit, Long>> groupBySuitSet = groupBySuitMap.entrySet();
        return groupBySuitSet.size()==1;
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
