package util;

import core.Card;
import core.Suit;
import core.Value;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class RandomCardImpl implements RandomCard{
    private List<Card> generatedCards;
    private List<Card> distributedCards;


    public RandomCardImpl() {
        distributedCards = new ArrayList<>();
    }

    private Card generateCard(){
        return new Card(Suit.values()[getRandomSuit()], Value.values()[getRandomValue()]);
    }

    private int getRandomValue() {
        return getRandomNumber(Value.values().length);
    }

    private int getRandomSuit() {
        return getRandomNumber(Suit.values().length);
    }

    private int getRandomNumber(int max) {
        return new SecureRandom().nextInt(0, max);
    }

    public void generateCardAvoidConflict(){
        Card card = generateCard();
        while (hasConflict(card)){
            card = generateCard();
        }
        generatedCards.add(card);
        distributedCards.add(card);
    }

    public List<Card> generateCardAvoidConflict(int times){
        generatedCards = new ArrayList<>();
        for (int i=0; i<times; i++) {
            generateCardAvoidConflict();
        }
        return generatedCards;
    }

    private boolean hasConflict(Card card){
        boolean hasConflict = false;
        for (Card distributedCard : distributedCards) {
            if (card.getValue().equals(distributedCard.getValue())
            && card.getSuit().equals(distributedCard.getSuit()) ) {
                hasConflict = true;
                break;
            }
        }
        return hasConflict;
    }
}
