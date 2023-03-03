package criteria;

import model.HighCard;
import model.Pair;
import model.Value;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairCriteria implements Criteria{
    @Override
    public HighCard meetCriteria(HashMap<Value, Long> sortedGroupByValueMap, List<Value> valuesToCompare) {
        HighCard highCard = null;
        for (Map.Entry<Value, Long> s : sortedGroupByValueMap.entrySet()) {
            if (s.getValue() == 2 && sortedGroupByValueMap.entrySet().size() == 4) { // 1 pair
                highCard = new Pair(valuesToCompare);
                break;
            }
        }
        return highCard;
    }
}