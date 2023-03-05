package core;

import criteria.*;
import rank.Rank;
import util.InvalidCardException;

import java.util.*;
import java.util.stream.Collectors;

public class Hand implements Comparable<Hand> {
    private final List<Card> cards;
    private Rank rank;

    public Hand(List<Card> cards) {
        this.cards = cards;
        checkDuplicate();
        evaluateRank();
    }

    public Hand(String playerCards) {
        String[] playerCardsArr = playerCards.split(" ");

        // create the cards list by playerCardsArr String array
        this.cards = Arrays.stream(playerCardsArr)
                .map(Card::new)
                .collect(Collectors.toList());

        checkDuplicate();
        evaluateRank();
    }

    public void checkDuplicate() {
        List<String> duplicates =
                cards.stream().collect(
                                Collectors.groupingBy(
                                        Card::getValueSuit, Collectors.counting()
                                )
                        ).entrySet()
                        .stream()
                        .filter(e -> e.getValue() > 1)
                        .map(Map.Entry::getKey).toList();
        if (duplicates.size() > 0)
            throw new InvalidCardException("Invalid card. Each card can only used once at a time.");
    }

    public void evaluateRank() {
        HashMap<Value, Long> sortedGroupByValueMap = sortAndGroupByValue();
        Criteria pairCriteria = new PairCriteria(cards, sortedGroupByValueMap);
        Criteria threeOfAKindCriteria = new ThreeOfAKindCriteria(cards, sortedGroupByValueMap);
        Criteria straightCriteria = new StraightCriteria(cards, sortedGroupByValueMap);
        Criteria flushCriteria = new FlushCriteria(cards, sortedGroupByValueMap);

        List<Criteria> criterias = new LinkedList<>();
        criterias.add(new StraightFlushCriteria(cards, sortedGroupByValueMap, straightCriteria, flushCriteria));
        criterias.add(new FourOfAKindCriteria(cards, sortedGroupByValueMap));
        criterias.add(new FullHouseCriteria(cards, sortedGroupByValueMap, threeOfAKindCriteria, pairCriteria));
        criterias.add(flushCriteria);
        criterias.add(straightCriteria);
        criterias.add(threeOfAKindCriteria);
        criterias.add(pairCriteria);
        criterias.add(new HighCardCriteria(cards, sortedGroupByValueMap));

        for (Criteria criteria : criterias) {
            rank = criteria.meetCriteria();
            if (rank != null)
                break;
        }
    }

    public HashMap<Value, Long> sortAndGroupByValue() {
        Map<Value, Long> groupByValueMap =
                cards.stream().collect(
                        Collectors.groupingBy(
                                Card::getValue, Collectors.counting()
                        )
                );
        HashMap<Value, Long> sortedGroupByValueMap = new LinkedHashMap<>();

        //Sort the map by Count and by model.Value, then add to sortedMap
        groupByValueMap.entrySet().stream()
                .sorted(Map.Entry.<Value, Long>comparingByKey().reversed()) // sort by card's value desc
                .sorted(Map.Entry.<Value, Long>comparingByValue().reversed()) // sort by card value's count desc
                .forEachOrdered(e ->
                        sortedGroupByValueMap.put(e.getKey(), e.getValue()));
        System.out.println("Group input by value:" + sortedGroupByValueMap);
        return sortedGroupByValueMap;
    }

    @Override
    public int compareTo(Hand otherHand) {
        return rank.compareTo(otherHand.getRank());
    }

    public Rank getRank() {
        return rank;
    }

    public List<Card> getCards() {
        return cards;
    }

    public String toString() {
        return cards.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ", "{", "}"));
    }
}
