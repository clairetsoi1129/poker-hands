package criteria;

import model.Card;
import model.Rank;
import model.Value;

import java.util.*;
import java.util.stream.Collectors;

public abstract class Criteria {
    protected final List<Card> cards;
    protected HashMap<Value, Long> sortedGroupByValueMap;
    protected List<Value> valuesToCompare;

    public Criteria(List<Card> cards){
        this.cards = cards;
        sortAndGroupByValue();
    }

    protected void sortAndGroupByValue(){
        if (sortedGroupByValueMap == null) {
            Map<Value, Long> groupByValueMap =
                    cards.stream().collect(
                            Collectors.groupingBy(
                                    Card::getValue, Collectors.counting()
                            )
                    );
            sortedGroupByValueMap = new LinkedHashMap<>();

            //Sort the map by Count and by model.Value, then add to sortedMap
            groupByValueMap.entrySet().stream()
                    .sorted(Map.Entry.<Value, Long>comparingByKey().reversed()) // sort by card's value desc
                    .sorted(Map.Entry.<Value, Long>comparingByValue().reversed()) // sort by card value's count desc
                    .forEachOrdered(e ->
                            sortedGroupByValueMap.put(e.getKey(), e.getValue()));
            System.out.println("sortedGroupByValueMap:" + sortedGroupByValueMap);
        }
        valuesToCompare = new LinkedList<>(sortedGroupByValueMap.keySet());
    }

    public abstract Rank meetCriteria();
}
