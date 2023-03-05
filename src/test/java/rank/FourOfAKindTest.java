package rank;

import core.Hand;
import criteria.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FourOfAKindTest {
    @Test
    void testFourOfAKindvsHighCard() {
        Hand handBlack = new Hand("AH AC AS AD JH");
        Hand handWhite = new Hand("KD QH 9H 8C 2S");

        Rank rankBlack = new FourOfAKindCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new HighCardCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with four of a kind: A", rankBlack.getReason());
    }

    @Test
    void testFourOfAKindvsPair() {
        Hand handBlack = new Hand("AH AC AS AD JH");
        Hand handWhite = new Hand("KD KH 9H 8C 2S");

        Rank rankBlack = new FourOfAKindCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new PairCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with four of a kind: A", rankBlack.getReason());
    }

    @Test
    void testFourOfAKindvsTwoPairs() {
        Hand handBlack = new Hand("AH AC AS AD JH");
        Hand handWhite = new Hand("KD KH 9H 9C 2S");

        Rank rankBlack = new FourOfAKindCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new PairCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with four of a kind: A", rankBlack.getReason());
    }


    @Test
    void testFourOfAKindvsThreeOfAKind() {
        Hand handBlack = new Hand("AH AC AS AD JH");
        Hand handWhite = new Hand("TD TH TC KC 2S");

        Rank rankBlack = new FourOfAKindCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new ThreeOfAKindCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with four of a kind: A", rankBlack.getReason());
    }

    @Test
    void testFourOfAKindvsStraight() {
        Hand handBlack = new Hand("AH AC AS AD JH");
        Hand handWhite = new Hand("KD QH JH TC 9S");

        Rank rankBlack = new FourOfAKindCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new StraightCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with four of a kind: A", rankBlack.getReason());
    }

    @Test
    void testFourOfAKindvsFlush() {
        Hand handBlack = new Hand("AH AC AS AD JH");
        Hand handWhite = new Hand("KH 3H QH JH 9H");

        Rank rankBlack = new FourOfAKindCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new FlushCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with four of a kind: A", rankBlack.getReason());
    }

    @Test
    void testFourOfAKindvsFullHouse() {
        Hand handBlack = new Hand("AH AC AS AD JH");
        Hand handWhite = new Hand("KH KC KS 9D 9H");

        Rank rankBlack = new FourOfAKindCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new FullHouseCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue(),
        new ThreeOfAKindCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()),
                new PairCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue())).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with four of a kind: A", rankBlack.getReason());
    }

    @Test
    void testFourOfAKindvsFourOfAKind() {
        Hand handBlack = new Hand("AH AC AS AD JH");
        Hand handWhite = new Hand("KH KC KS KD 9H");

        Rank rankBlack = new FourOfAKindCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new FourOfAKindCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with four of a kind: A", rankBlack.getReason());
    }
}
