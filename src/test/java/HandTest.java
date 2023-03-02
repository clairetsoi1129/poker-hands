import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandTest {
    private List<Card> cardBlack;

    @Test
    void testFindPair() {
        Card[] cards = new Card[]{
                new Card(Suit.HEARTS, Value.ACE),
                new Card(Suit.DIAMONDS, Value.ACE),
                new Card(Suit.CLUBS, Value.DEDUCE),
                new Card(Suit.CLUBS, Value.JACK),
                new Card(Suit.CLUBS, Value.TEN)
        };
        cardBlack = Arrays.asList(cards);
        Hand handBlack = new Hand(cardBlack);
        List<Value> pairs = handBlack.getPairs();

        assertEquals(1, pairs.size());
        assertEquals(Value.ACE, pairs.get(0));
    }

    @Test
    void testFindPairs() {
        Card[] cards = new Card[]{
                new Card(Suit.HEARTS, Value.FOUR),
                new Card(Suit.DIAMONDS, Value.FOUR),
                new Card(Suit.CLUBS, Value.THREE),
                new Card(Suit.SPADES, Value.THREE),
                new Card(Suit.CLUBS, Value.TEN)
        };
        cardBlack = Arrays.asList(cards);
        Hand handBlack = new Hand(cardBlack);
        List<Value> pairs = handBlack.getPairs();

        assertEquals(2, pairs.size());
        assertEquals(Value.FOUR, pairs.get(0));
        assertEquals(Value.THREE, pairs.get(1));
    }

    @Test
    void testFindThreeOfAKinds() {
        Card[] cards = new Card[]{
                new Card(Suit.HEARTS, Value.FOUR),
                new Card(Suit.DIAMONDS, Value.FOUR),
                new Card(Suit.CLUBS, Value.THREE),
                new Card(Suit.SPADES, Value.TEN),
                new Card(Suit.CLUBS, Value.FOUR)
        };
        cardBlack = Arrays.asList(cards);
        Hand handBlack = new Hand(cardBlack);
        Value threeOfAKind = handBlack.getThreeOfAKind();

        assertEquals(Value.FOUR, threeOfAKind);
    }

}
