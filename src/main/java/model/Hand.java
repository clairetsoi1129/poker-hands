package model;

import criteria.*;

import java.util.*;

public class Hand implements Comparable<Hand> {
    private final List<Card> cards;
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

    public void evaluateRank() {
        List<Criteria> criterias = new LinkedList<>();
        criterias.add(new FourOfAKindCriteria(cards));
        criterias.add(new FullHouseCriteria(cards));
        criterias.add(new ThreeOfAKindCriteria(cards));
        criterias.add(new TwoPairsCriteria(cards));
        criterias.add(new PairCriteria(cards));
        criterias.add(new StraightFlushCriteria(cards));
        criterias.add(new StraightCriteria(cards));
        criterias.add(new FlushCriteria(cards));
        criterias.add(new HighCardCriteria(cards));

        for (Criteria criteria: criterias){
            highCard = criteria.meetCriteria();
            if (highCard != null)
                break;
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
