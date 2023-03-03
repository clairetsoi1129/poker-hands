import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Hand implements Comparable<Hand>{
    private final List<Card> cards;
    private HashMap<Value,Long> sortedGroupByValueMap;
    private final String BLACK_WIN = "Black win. - with {0}: {1}";
    private final String WHITE_WIN = "White win. - with {0}: {1}";
    private final String TIE = "Tie.";
    private String reason;
    private Rank rank;

    private List<Value> valuesToCompare;

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
        Map<Value, Long> groupByValueMap =
                cards.stream().collect(
                        Collectors.groupingBy(
                                Card::getValue, Collectors.counting()
                        )
                );

        System.out.println("GroupByValue:"+groupByValueMap);

        sortedGroupByValueMap = new LinkedHashMap<>();

        //Sort the map by Count and by Value, then add to sortedMap
        groupByValueMap.entrySet().stream()
                .sorted(Map.Entry.<Value, Long>comparingByKey().reversed()) // sort by card's value desc
                .sorted(Map.Entry.<Value, Long>comparingByValue().reversed()) // sort by card value's count desc
                .forEachOrdered(e ->
                        sortedGroupByValueMap.put(e.getKey(), e.getValue()));

        System.out.println("sortedGroupByValueMap:"+sortedGroupByValueMap);

        Map<Suit, Long> groupBySuitMap =
                cards.stream().collect(
                        Collectors.groupingBy(
                                Card::getSuit, Collectors.counting()
                        )
                );
        Set<Map.Entry<Suit, Long>> groupBySuitSet = groupBySuitMap.entrySet();

        rank = Rank.HighCard;

        valuesToCompare = new LinkedList<>(sortedGroupByValueMap.keySet());
        Set<Map.Entry<Value, Long>> sortedGroupByEntrySet = sortedGroupByValueMap.entrySet();
        for (Map.Entry<Value, Long> s : sortedGroupByEntrySet) {
            if (s.getValue() == 4) { // 4 of a kind
                rank = Rank.FourOfAKind;
                break;
            }else if (s.getValue() == 3 && sortedGroupByEntrySet.size() == 2) { // full house
                rank = Rank.FullHouse;
                break;
            }else if (s.getValue() == 3 && sortedGroupByEntrySet.size() == 3) { // 3 of a kind
                rank = Rank.ThreeOfAKind;
                break;
            }else if (s.getValue() == 2 && sortedGroupByEntrySet.size() == 3){ // 2 pairs
                rank = Rank.TwoPairs;
                break;
            }else if (s.getValue() == 2 && sortedGroupByEntrySet.size() == 4){ // 1 pair
                rank = Rank.Pair;
                break;
            }else {
                boolean isStraight = isStraight();
                if (groupBySuitSet.size() == 1 && isStraight) { // flush or straight flush
                    rank = Rank.StraightFlush;
                    break;
                }else if (groupBySuitSet.size() == 1 && !isStraight){
                    rank = Rank.Flush;
                    break;
                }else if (groupBySuitSet.size() > 1 && isStraight){//high card or straight
                    rank = Rank.Straight;
                    break;
                }else {
                    rank = Rank.HighCard;
                    break;
                }
            }
        }
    }

    public boolean isStraight(){
        boolean result = true;

        List<Card> sortedCards = this.sort();
        for (int i=0; i<sortedCards.size()-1; i++) {
            if (sortedCards.get(i + 1).getValue() != sortedCards.get(i).getValue().prev()) {
                result = false;
                break;
            }
        }
        return result;
    }

    public List<Card> sort(){
        return cards.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public int compareTo(Rank rank, List<Value> blackValues, List<Value> whiteValues){
        int result = 0;
        for (int i=0; i<blackValues.size(); i++){
            result = blackValues.get(i).compareTo(whiteValues.get(i));
            if (result != 0){
                if (result > 0){
                    reason = MessageFormat.format(BLACK_WIN, rank.getName(), blackValues.get(i));
                }else {
                    reason = MessageFormat.format(WHITE_WIN, rank.getName(), whiteValues.get(i));
                }
                break;
            }
        }
        if (result == 0){
            reason = TIE;
        }

        return result;
    }

    @Override
    public int compareTo(Hand otherHand) {
        int result = this.getRank().compareTo(otherHand.getRank());
        if (result==0){
            result = compareTo(this.getRank(), this.getValuesToCompare(),
                    otherHand.getValuesToCompare());
        }else if (result>0) {
            reason = MessageFormat.format(BLACK_WIN,
                    this.getRank().getName(), this.getValuesToCompare().get(0));
        }else {
            reason = MessageFormat.format(WHITE_WIN,
                    otherHand.getRank().getName(), otherHand.getValuesToCompare().get(0));
        }
        return result;
    }

    public String getReason() {
        return reason;
    }

    public Rank getRank() {
        return rank;
    }
    public List<Value> getValuesToCompare() {
        return valuesToCompare;
    }
}
