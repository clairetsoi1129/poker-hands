package model;

import java.util.*;
import java.util.stream.Collectors;

public class Hand implements Comparable<Hand> {
    private final List<Card> cards;
    private HashMap<Value, Long> sortedGroupByValueMap;
    private Map<Suit, Long> groupBySuitMap;
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

    private boolean isSingleSuit() {
        if (groupBySuitMap == null) {
            groupBySuitMap =
                    cards.stream().collect(
                            Collectors.groupingBy(
                                    Card::getSuit, Collectors.counting()
                            )
                    );
        }
        Set<Map.Entry<Suit, Long>> groupBySuitSet = groupBySuitMap.entrySet();
        return groupBySuitSet.size()==1;
    }

    public void evaluateRank() {
        sortAndGroupByValue();

        valuesToCompare = new LinkedList<>(sortedGroupByValueMap.keySet());

        Set<Map.Entry<Value, Long>> sortedGroupByEntrySet = sortedGroupByValueMap.entrySet();

        for (Map.Entry<Value, Long> s : sortedGroupByEntrySet) {
            if (s.getValue() == 4) { // 4 of a kind
                highCard = new FourOfAKind(cards, valuesToCompare);
            } else if (s.getValue() == 3 && sortedGroupByEntrySet.size() == 2) { // full house
                highCard = new FullHouse(cards, valuesToCompare);
            } else if (s.getValue() == 3 && sortedGroupByEntrySet.size() == 3) { // 3 of a kind
                highCard = new ThreeOfAKind(cards, valuesToCompare);
            } else if (s.getValue() == 2 && sortedGroupByEntrySet.size() == 3) { // 2 pairs
                highCard = new TwoPairs(cards, valuesToCompare);
            } else if (s.getValue() == 2 && sortedGroupByEntrySet.size() == 4) { // 1 pair
                highCard = new Pair(cards, valuesToCompare);
            } else {
                if (isStraight()) {
                    if (isSingleSuit()) { // straight or straight flush
                        highCard = new StraightFlush(cards, valuesToCompare);
                    } else {
                        highCard = new Straight(cards, valuesToCompare);
                    }
                } else {
                    if (isSingleSuit()) {//high card or flush
                        highCard = new Flush(cards, valuesToCompare);
                    } else {
                        highCard = new HighCard(cards, valuesToCompare);
                    }
                }
            }
            break;
        }
    }

    public boolean isStraight() {
        boolean result = true;

        List<Card> sortedCards = sort();
        for (int i = 0; i < sortedCards.size() - 1; i++) {
            if (sortedCards.get(i + 1).getValue() != sortedCards.get(i).getValue().prev()) {
                result = false;
                break;
            }
        }
        return result;
    }

    public List<Card> sort() {
        return cards.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    @Override
    public int compareTo(Hand otherHand) {
        return highCard.compareTo(otherHand.getHighCard());
    }

    public String getReason() {
        return highCard.getReason();
    }

    public List<Value> getValuesToCompare() {
        return valuesToCompare;
    }

    public HighCard getHighCard() {
        return highCard;
    }
}
