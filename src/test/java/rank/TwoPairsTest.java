package rank;

import core.Hand;
import criteria.HighCardCriteria;
import criteria.PairCriteria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TwoPairsTest {
    @Test
    void testTwoPairsvsHighCard() {
        Hand handBlack = new Hand("AD AH 9H 9C 2S");
        Hand handWhite = new Hand("KD QH 9C 8C 2C");

        Rank rankBlack = new PairCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new HighCardCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with two pairs: A", rankBlack.getReason());
    }

    @Test
    void testTwoPairsvsPair() {
        Hand handBlack = new Hand("AD AH 9H 9C 2S");
        Hand handWhite = new Hand("KD KH 9C 8C 2C");

        Rank rankBlack = new PairCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new PairCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with two pairs: A", rankBlack.getReason());
    }

    @Test
    void testTwoPairsvsTwoPairs_sameTwoPair_5th_diff() {
        Hand handBlack = new Hand("AD AH TH TC 3S");
        Hand handWhite = new Hand("AC AS TS TD 2S");

        Rank rankBlack = new PairCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new PairCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - same two pairs with high card: 3", rankBlack.getReason());
    }

    @Test
    void testTwoPairsvsTwoPairs_same1stPair_2ndPairDiff() {
        Hand handBlack = new Hand("AD AH KH KC 2S");
        Hand handWhite = new Hand("AC AS TH TC 2C");

        Rank rankBlack = new PairCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new PairCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - two pairs with higher pair: K", rankBlack.getReason());
    }

    @Test
    void testTwoPairsvsTwoPairs_sameTwoPair_no_diff() {
        Hand handBlack = new Hand("AD AH TH TC 2S");
        Hand handWhite = new Hand("AC AS TS TD 2C");

        Rank rankBlack = new PairCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new PairCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertEquals(0, rankBlack.compareTo(rankWhite));
        assertEquals("Tie.", rankBlack.getReason());
    }
}
