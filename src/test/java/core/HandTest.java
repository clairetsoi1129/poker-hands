package core;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import util.InvalidCardException;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void testInvalidSuit() {
        Exception exception = assertThrows(InvalidCardException.class, () -> {
            Hand handBlack = new Hand("1M 2M 3M 4M 5M");
        });

        String actualMessage = exception.getMessage();
        assertEquals(actualMessage,"Invalid suit. Please input C/D/H/S.");
    }

    @Test
    void testInvalidValue() {
        Exception exception = assertThrows(InvalidCardException.class, () -> {
            Hand handBlack = new Hand("1H 2C 3D 4V 5S");
        });

        String actualMessage = exception.getMessage();
        assertEquals(actualMessage,"Invalid value. Please input 2/3/4/5/6/7/8/9/T/J/Q/K/A.");
    }

    @Test
    void testInvalidLine_MissingSuit() {
        Exception exception = assertThrows(InvalidCardException.class, () -> {
            Hand handBlack = new Hand("1 2C 3D 4V 5S");
        });

        String actualMessage = exception.getMessage();
        assertEquals(actualMessage,"Invalid Card. Missing suit or values.");
    }

    @Test
    void testInvalidLine_repeat() {
        Exception exception = assertThrows(InvalidCardException.class, () -> {
            Hand handBlack = new Hand("AC AC 3D 4H 5S");
        });

        String actualMessage = exception.getMessage();
        assertEquals(actualMessage,"Invalid card. Each card can only used once at a time.");
    }
}
