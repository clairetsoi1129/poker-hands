import java.util.*;

public class Hand implements Comparable<Hand>{
    private final List<Card> cards;
    private HashMap<Value,Integer> cardMap;

    private final List<Value> pairs;

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
            }
        }
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
}
