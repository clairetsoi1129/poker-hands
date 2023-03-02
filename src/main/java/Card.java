public class Card implements Comparable<Card>{
    private final Suit suit;
    private final Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public Card(String valueSuit) {
        this.suit = Suit.getSuitForSymbol(valueSuit.charAt(1));
        this.value = Value.getValueForSymbol(valueSuit.charAt(0));
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
