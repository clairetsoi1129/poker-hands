package criteria;

import model.ThreeOfAKind;
import model.HighCard;
import model.Value;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeOfAKindCriteria implements Criteria{
    @Override
    public HighCard meetCriteria(HashMap<Value, Long> sortedGroupByValueMap, List<Value> valuesToCompare) {
        HighCard highCard = null;
        for (Map.Entry<Value, Long> s : sortedGroupByValueMap.entrySet()) {
            if (s.getValue() == 3 && sortedGroupByValueMap.entrySet().size() == 3) { // 3 of a kind
                highCard = new ThreeOfAKind( valuesToCompare);
                break;
            }
        }
        return highCard;
    }
}
