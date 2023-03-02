public class Card implements Comparable<Card>{
    private final Suit suit;
    private final Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public int compareTo(Card card) {
        return this.value.compareTo(card.value);
    }
}
