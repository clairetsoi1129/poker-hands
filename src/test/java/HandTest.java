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

    @Test
    void testHasStraight() {
        Card[] cards = new Card[]{
                new Card(Suit.HEARTS, Value.DEDUCE),
                new Card(Suit.DIAMONDS, Value.FIVE),
                new Card(Suit.CLUBS, Value.THREE),
                new Card(Suit.SPADES, Value.SIX),
                new Card(Suit.CLUBS, Value.FOUR)
        };
        cardBlack = Arrays.asList(cards);
        Hand handBlack = new Hand(cardBlack);

        assertEquals(Value.SIX, handBlack.getStraight());
    }

    @Test
    void testHasFlush() {
        Card[] cards = new Card[]{
                new Card(Suit.HEARTS, Value.DEDUCE),
                new Card(Suit.HEARTS, Value.TEN),
                new Card(Suit.HEARTS, Value.THREE),
                new Card(Suit.HEARTS, Value.SIX),
                new Card(Suit.HEARTS, Value.FOUR)
        };
        cardBlack = Arrays.asList(cards);
        Hand handBlack = new Hand(cardBlack);

        assertEquals(Value.TEN, handBlack.getFlush().get(0));
        assertEquals(Value.SIX, handBlack.getFlush().get(1));
        assertEquals(Value.FOUR, handBlack.getFlush().get(2));
        assertEquals(Value.THREE, handBlack.getFlush().get(3));
        assertEquals(Value.DEDUCE, handBlack.getFlush().get(4));
    }

    @Test
    void testHasFullHouse() {
        Card[] cards = new Card[]{
                new Card(Suit.HEARTS, Value.THREE),
                new Card(Suit.SPADES, Value.THREE),
                new Card(Suit.CLUBS, Value.THREE),
                new Card(Suit.HEARTS, Value.SIX),
                new Card(Suit.CLUBS, Value.SIX)
        };
        cardBlack = Arrays.asList(cards);
        Hand handBlack = new Hand(cardBlack);

        assertEquals(Value.THREE, handBlack.getFullHouse());
    }

    @Test
    void testFindFourOfAKinds() {
        Card[] cards = new Card[]{
                new Card(Suit.HEARTS, Value.FOUR),
                new Card(Suit.DIAMONDS, Value.FOUR),
                new Card(Suit.CLUBS, Value.TEN),
                new Card(Suit.SPADES, Value.FOUR),
                new Card(Suit.CLUBS, Value.FOUR)
        };
        cardBlack = Arrays.asList(cards);
        Hand handBlack = new Hand(cardBlack);
        Value fourOfAKind = handBlack.getFourOfAKind();

        assertEquals(Value.FOUR, fourOfAKind);
    }

    @Test
    void testHasStraightFlush() {
        Card[] cards = new Card[]{
                new Card(Suit.HEARTS, Value.DEDUCE),
                new Card(Suit.HEARTS, Value.FIVE),
                new Card(Suit.HEARTS, Value.THREE),
                new Card(Suit.HEARTS, Value.SIX),
                new Card(Suit.HEARTS, Value.FOUR)
        };
        cardBlack = Arrays.asList(cards);
        Hand handBlack = new Hand(cardBlack);

        assertEquals(Value.SIX, handBlack.getStraightFlush());
    }

}
