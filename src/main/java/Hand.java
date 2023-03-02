import java.util.*;
import java.util.stream.Collectors;

public class Hand implements Comparable<Hand>{
    private final List<Card> cards;
    private HashMap<Value,Integer> cardValueMap;
    private HashMap<Suit,Integer> cardSuitMap;

    private final List<Value> pairs;
    private Value threeOfAKind;

    private Value straight;

    private List<Value> flush;

    private Value fullHouse;

    public Hand(List<Card> cards) {
        this.cards = cards;

        cardValueMap = new LinkedHashMap<>();
        for (Card card : cards) {
            cardValueMap.merge(card.getValue(), 1, Integer::sum);
        }

        // Check pairs /  3 of a kind
        pairs = new ArrayList<>();
        for (Value key: cardValueMap.keySet()){
            if (cardValueMap.get(key) == 2){
                pairs.add(key);
            }else if (cardValueMap.get(key) == 3){
                threeOfAKind = key;
            }
        }


        if (threeOfAKind != null && pairs.size() == 1){
            fullHouse = threeOfAKind;
        }

        // Check Straight
        List<Card> sortedCards = this.sort();
        straight = sortedCards.get(0).getValue();
        for (int i=0; i<sortedCards.size()-1; i++) {
            if (sortedCards.get(i + 1).getValue() != sortedCards.get(i).getValue().prev()) {
                straight = null;
                break;
            }
        }


        // Check Flush
        cardSuitMap = new LinkedHashMap<>();
        for (Card card : sortedCards) {
            cardSuitMap.merge(card.getSuit(), 1, Integer::sum);
        }
        flush = new ArrayList<>();
        for (Suit key: cardSuitMap.keySet()){
            if (cardSuitMap.get(key) == 5){
                for (Card card : sortedCards) {
                    flush.add(card.getValue());
                }
            }
        }



    }

    public List<Card> sort(){
        return cards.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public int compareTo(Hand otherHand) {
        return 0;
    }

    public List<Value> getPairs(){
        return pairs;
    }

    public Value getThreeOfAKind() {
        return threeOfAKind;
    }

    public Value getStraight() {
        return straight;
    }

    public List<Value> getFlush() {
        return flush;
    }

    public Value getFullHouse() {
        return fullHouse;
    }
}
