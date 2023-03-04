package criteria;

import core.Card;
import core.Suit;
import core.Value;
import rank.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FlushCriteria extends Criteria{
    protected Map<Suit, Long> groupBySuitMap;
    public FlushCriteria(List<Card> cards, HashMap<Value, Long> sortedGroupByValueMap) {
        super(cards, sortedGroupByValueMap);
    }

    @Override
    public Rank meetCriteria() {
        Rank rank = null;
        if (isSingleSuit()) {
            rank = new Flush(valuesToCompare);
        }
        return rank;
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
