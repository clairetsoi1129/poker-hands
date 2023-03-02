import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Hand implements Comparable<Hand>{
    private final List<Card> cards;
    private HashMap<Value,Integer> cardValueMap;
    private HashMap<Suit,Integer> cardSuitMap;

    private List<Value> pairs;
    private Value threeOfAKind;

    private Value fourOfAKind;

    private Value straight;

    private List<Value> flush;

    private Value fullHouse;

    private Value straightFlush;

    private String reason;

    private Rank rank;

    private Value valueToCompare;

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

    public void evaluateRank(){
        rank = Rank.HighCard; //default is high card

        // Check pairs /  3 of a kind
        cardValueMap = new LinkedHashMap<>();
        for (Card card : cards) {
            cardValueMap.merge(card.getValue(), 1, Integer::sum);
        }
        pairs = new ArrayList<>();
        for (Value key: cardValueMap.keySet()){
            if (cardValueMap.get(key) == 2){
                pairs.add(key);
            }else if (cardValueMap.get(key) == 3){
                threeOfAKind = key;
                rank = Rank.ThreeOfAKind;
                valueToCompare = key;
            }else if (cardValueMap.get(key) == 4){
                fourOfAKind = key;
                rank = Rank.FourOfAKind;
                valueToCompare = key;
            }
        }
        if (pairs.size() == 2)
            rank = Rank.TwoPairs;
        else if (pairs.size() == 1)
            rank = Rank.Pair;


        if (threeOfAKind != null && pairs.size() == 1){
            fullHouse = threeOfAKind;
            rank = Rank.FullHouse;
            valueToCompare = threeOfAKind;
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
        if (straight != null) {
            rank = Rank.Straight;
            valueToCompare = straight;
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
                rank = Rank.Flush;
                valueToCompare = flush.get(0);
            }
        }

        if (straight != null && flush.size() > 0){
            straightFlush = straight;
            rank = Rank.StraightFlush;
            valueToCompare = flush.get(0);
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

    public int compareTo(Rank rank, Value blackValue, Value whiteValue){
        int result = blackValue.compareTo(whiteValue);
        if (result == 0){
            reason = "Tie.";
        }else if (result > 0){
            reason = MessageFormat.format("Black win. - with {0}: {1}",
                    rank.getName(), blackValue);
        }else {
            reason = MessageFormat.format("White win. - with {0}: {1}",
                    rank.getName(), whiteValue);
        }
        return result;
    }

    public int compareTo(Rank rank, List<Value> blackValues, List<Value> whiteValues){
        int result = 0;
        for (int i=0; i<blackValues.size(); i++){
            result = blackValues.get(i).compareTo(whiteValues.get(i));
            if (result != 0){
                if (result > 0){
                    reason = MessageFormat.format("Black win. - with {0}: {1}",
                            rank.getName(), blackValues.get(i));
                }else {
                    reason = MessageFormat.format("White win. - with {0}: {1}",
                            rank.getName(), whiteValues.get(i));
                }
                break;
            }
        }
        if (result == 0){
            reason = "Tie.";
        }

        return result;
    }

    @Override
    public int compareTo(Hand otherHand) {
        int result = this.getRank().compareTo(otherHand.getRank());
        if (result==0){
            if (this.getRank()==Rank.StraightFlush || this.getRank()==Rank.FourOfAKind
            || this.getRank()==Rank.FullHouse || this.getRank() == Rank.Straight
            || this.getRank()==Rank.ThreeOfAKind){
                //compare highest
                result = compareTo(this.getRank(), this.getValueToCompare(), otherHand.getValueToCompare());
            }else if (this.getRank()==Rank.Flush){
                result = compareTo(this.getRank(), this.getFlush(), otherHand.getFlush());

            }
        }else if (result>0) {
            reason = MessageFormat.format("Black win. - with {0}: {1}",
                    this.getRank().getName(), this.getValueToCompare());
        }else {
            reason = MessageFormat.format("White win. - with {0}: {1}",
                    otherHand.getRank().getName(), otherHand.getValueToCompare());
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

    public Rank getRank() {
        return rank;
    }

    public Value getValueToCompare() {
        return valueToCompare;
    }
}
