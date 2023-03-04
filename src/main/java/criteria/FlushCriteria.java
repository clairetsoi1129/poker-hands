package criteria;

import model.*;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FlushCriteria extends Criteria{
    protected Map<Suit, Long> groupBySuitMap;
    public FlushCriteria(List<Card> cards) {
        super(cards);
    }

    @Override
    public HighCard meetCriteria() {
        HighCard highCard = null;
        if (isSingleSuit()) {
            highCard = new Flush(valuesToCompare);
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
}
