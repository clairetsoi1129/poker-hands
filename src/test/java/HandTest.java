import model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

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

        assertEquals(RankType.Pair, handBlack.getRank().getRankType());
        assertEquals(Value.ACE, handBlack.getRank().getValuesToCompare().get(0));
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

        assertEquals(RankType.TwoPairs, handBlack.getRank().getRankType());
        assertEquals(Value.FOUR, handBlack.getRank().getValuesToCompare().get(0));
        assertEquals(Value.THREE, handBlack.getRank().getValuesToCompare().get(1));
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

        assertEquals(RankType.ThreeOfAKind, handBlack.getRank().getRankType());
        assertEquals(Value.FOUR, handBlack.getRank().getValuesToCompare().get(0));
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
        assertEquals(RankType.Straight, handBlack.getRank().getRankType());
        assertEquals(Value.SIX, handBlack.getRank().getValuesToCompare().get(0));
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
        assertEquals(RankType.Flush, handBlack.getRank().getRankType());
        assertEquals(Value.TEN, handBlack.getRank().getValuesToCompare().get(0));
        assertEquals(Value.SIX, handBlack.getRank().getValuesToCompare().get(1));
        assertEquals(Value.FOUR, handBlack.getRank().getValuesToCompare().get(2));
        assertEquals(Value.THREE, handBlack.getRank().getValuesToCompare().get(3));
        assertEquals(Value.DEDUCE, handBlack.getRank().getValuesToCompare().get(4));
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

        assertEquals(RankType.FullHouse, handBlack.getRank().getRankType());
        assertEquals(Value.THREE, handBlack.getRank().getValuesToCompare().get(0));
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

        assertEquals(RankType.FourOfAKind, handBlack.getRank().getRankType());
        assertEquals(Value.FOUR, handBlack.getRank().getValuesToCompare().get(0));
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

        assertEquals(RankType.StraightFlush, handBlack.getRank().getRankType());
        assertEquals(Value.SIX, handBlack.getRank().getValuesToCompare().get(0));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testcase.csv", numLinesToSkip = 1)
    void testCompare2HandsValidCase(
            String player1CardsStr, String player2CardsStr, String expectedReason) {

        Hand handBlack = new Hand(player1CardsStr);
        Hand handWhite = new Hand(player2CardsStr);
        handBlack.compareTo(handWhite);
        assertEquals(expectedReason, handBlack.getRank().getReason());
    }
}
