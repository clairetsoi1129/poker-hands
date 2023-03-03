package criteria;

import model.Card;
import model.FullHouse;
import model.HighCard;
import model.Value;

import java.util.List;
import java.util.Map;

public class FullHouseCriteria extends Criteria{
    public FullHouseCriteria(List<Card> cards) {
        super(cards);
    }

    @Override
    public HighCard meetCriteria() {
        HighCard highCard = null;
        for (Map.Entry<Value, Long> s : sortedGroupByValueMap.entrySet()) {
            if (s.getValue() == 3 && sortedGroupByValueMap.entrySet().size() == 2) { // full house
                highCard = new FullHouse(valuesToCompare);
            }
        }
        return highCard;
    }
}
