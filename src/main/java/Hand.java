import java.util.*;
import java.util.stream.Collectors;

public class Hand implements Comparable<Hand>{
    private final List<Card> cards;
    private HashMap<Value,Integer> cardMap;

    private final List<Value> pairs;
    private Value threeOfAKind;

    private Value straight;

    public Hand(List<Card> cards) {
        this.cards = cards;

        cardMap = new LinkedHashMap<>();
        for (Card card : cards) {
            cardMap.merge(card.getValue(), 1, Integer::sum);
        }

        pairs = new ArrayList<>();
        for (Value key:cardMap.keySet()){
            if (cardMap.get(key) == 2){
                pairs.add(key);
            }else if (cardMap.get(key) == 3){
                threeOfAKind = key;
            }
        }

        List<Card> sortedCards = this.sort();
        straight = sortedCards.get(0).getValue();
        for (int i=0; i<sortedCards.size()-1; i++) {
            if (sortedCards.get(i + 1).getValue() != sortedCards.get(i).getValue().prev()) {
                straight = null;
                break;
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
}
