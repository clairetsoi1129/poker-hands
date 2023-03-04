package criteria;

import core.Card;
import rank.Rank;
import core.Value;

import java.util.*;

public abstract class Criteria {
    protected final List<Card> cards;
    protected HashMap<Value, Long> sortedGroupByValueMap;
    protected List<Value> valuesToCompare;

    public Criteria(List<Card> cards, HashMap<Value, Long> sortedGroupByValueMap){
        this.cards = cards;
        this.sortedGroupByValueMap = sortedGroupByValueMap;
        this.valuesToCompare = new LinkedList<>(sortedGroupByValueMap.keySet());
    }

    public abstract Rank meetCriteria();
}
