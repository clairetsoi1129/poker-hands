package criteria;

import model.FullHouse;
import model.HighCard;
import model.Value;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FullHouseCriteria implements Criteria{
    @Override
    public HighCard meetCriteria(HashMap<Value, Long> sortedGroupByValueMap, List<Value> valuesToCompare) {
        HighCard highCard = null;
        for (Map.Entry<Value, Long> s : sortedGroupByValueMap.entrySet()) {
            if (s.getValue() == 3 && sortedGroupByValueMap.entrySet().size() == 2) { // full house
                highCard = new FullHouse(valuesToCompare);
            }
        }
        return highCard;
    }
}
