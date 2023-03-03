package criteria;

import model.FourOfAKind;
import model.HighCard;
import model.Value;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourOfAKindCriteria implements Criteria{
    @Override
    public HighCard meetCriteria(HashMap<Value, Long> sortedGroupByValueMap, List<Value> valuesToCompare) {
        HighCard highCard = null;
        for (Map.Entry<Value, Long> s : sortedGroupByValueMap.entrySet()) {
            if (s.getValue() == 4) { // 4 of a kind
                highCard = new FourOfAKind(valuesToCompare);
                break;
            }
        }
        return highCard;
    }
}
