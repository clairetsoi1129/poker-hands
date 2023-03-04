package core;

import util.InvalidCardException;

public class Card implements Comparable<Card>{
    private final Suit suit;
    private final Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public Card(String valueSuit) {
        if (valueSuit.length() != 2)
            throw new InvalidCardException("Invalid Card. Missing suit or values.");
        this.suit = Suit.getSuitForSymbol(valueSuit.charAt(1));
        this.value = Value.getValueForSymbol(valueSuit.charAt(0));
        if (this.suit == null)
            throw new InvalidCardException("Invalid suit. Please input C/D/H/S.");
        if (this.value == null)
            throw new InvalidCardException("Invalid value. Please input 2/3/4/5/6/7/8/9/T/J/Q/K/A.");

    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }

    @Override
    public int compareTo(Card card) {
        return this.value.compareTo(card.value);
    }
}
