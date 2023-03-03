package model;

import criteria.*;

import java.util.*;
import java.util.stream.Collectors;

public class Hand implements Comparable<Hand> {
    private final List<Card> cards;
    private HashMap<Value, Long> sortedGroupByValueMap;
    private List<Value> valuesToCompare;
    private HighCard highCard;

    public Hand(List<Card> cards) {
        this.cards = cards;
        evaluateRank();
    }

    public Hand(String playerCards) {
        String[] playerCardsArr = playerCards.split(" ");
        this.cards = new ArrayList<>();
        for (String s : playerCardsArr) {
            this.cards.add(new Card(s));
        }
        evaluateRank();
    }

    private void sortAndGroupByValue(){
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

    public void evaluateRank() {
        sortAndGroupByValue();

        valuesToCompare = new LinkedList<>(sortedGroupByValueMap.keySet());

        List<Criteria> criterias = new ArrayList<>();
        criterias.add(new FourOfAKindCriteria());
        criterias.add(new FullHouseCriteria());
        criterias.add(new ThreeOfAKindCriteria());
        criterias.add(new TwoPairsCriteria());
        criterias.add(new PairCriteria());
        criterias.add(new StraightFlushCriteria(cards));
        criterias.add(new StraightCriteria(cards));
        criterias.add(new FlushCriteria(cards));

        for (Criteria criteria: criterias){
            highCard = criteria.meetCriteria(sortedGroupByValueMap, valuesToCompare);
            if (highCard != null)
                break;
        }
        if (highCard == null){
            highCard = new HighCard(valuesToCompare);
        }
    }

    @Override
    public int compareTo(Hand otherHand) {
        return highCard.compareTo(otherHand.getHighCard());
    }

    public HighCard getHighCard() {
        return highCard;
    }
}
