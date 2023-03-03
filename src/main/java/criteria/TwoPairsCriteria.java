package criteria;

import model.HighCard;
import model.TwoPairs;
import model.Value;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoPairsCriteria implements Criteria{
    @Override
    public HighCard meetCriteria(HashMap<Value, Long> sortedGroupByValueMap, List<Value> valuesToCompare) {
        HighCard highCard = null;
        for (Map.Entry<Value, Long> s : sortedGroupByValueMap.entrySet()) {
            if (s.getValue() == 2 && sortedGroupByValueMap.entrySet().size() == 3) {  // 2 pairs
                highCard = new TwoPairs(valuesToCompare);
                break;
            }
        }
        return highCard;
    }
}
