import java.util.*;
import java.util.stream.Collectors;

public class Hand implements Comparable<Hand>{
    private final List<Card> cards;
    private HashMap<Value,Integer> cardValueMap;
    private HashMap<Suit,Integer> cardSuitMap;

    private final List<Value> pairs;
    private Value threeOfAKind;

    private Value fourOfAKind;

    private Value straight;

    private List<Value> flush;

    private Value fullHouse;

    private Value straightFlush;

    private String reason;

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
            }else if (cardValueMap.get(key) == 4){
                fourOfAKind = key;
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

        if (straight != null && flush.size() > 0){
            straightFlush = straight;
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
        int result = 0;
        if (this.getStraightFlush() != null && otherHand.getStraightFlush() == null) {
            result = 1;
            reason = "with straight flush value " + this.getStraightFlush();
        }else if (this.getStraightFlush() != null && otherHand.getStraightFlush() != null){
            if (this.getStraightFlush().compareTo(otherHand.getStraightFlush()) > 0){
                result = 1;
                reason = "straight flush value " + this.getStraightFlush()+ " > straight flush value " + otherHand.getStraightFlush();
            }else if (this.getStraightFlush().compareTo(otherHand.getStraightFlush()) == 0){
                result = 0;
                reason = "straight flush value " + this.getStraightFlush()+ " = straight flush value " + otherHand.getStraightFlush();
            }else {
                result = -1;
                reason = "straight flush value " + otherHand.getStraightFlush()+ " = straight flush value " + this.getStraightFlush();
            }
        }else if (this.getStraightFlush() == null && otherHand.getStraightFlush() != null){
            result = -1;
            reason = "with straight flush value " + otherHand.getStraightFlush();
        }else {

        }

        return result;
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

    public Value getFourOfAKind() {
        return fourOfAKind;
    }

    public Value getStraightFlush() {
        return straightFlush;
    }

    public String getReason() {
        return reason;
    }
}
