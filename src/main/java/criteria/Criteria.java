package criteria;

import model.HighCard;
import model.Value;

import java.util.HashMap;
import java.util.List;

public interface Criteria {
    HighCard meetCriteria(HashMap<Value, Long> sortedGroupByValueMap, List<Value> valuesToCompare);
}
