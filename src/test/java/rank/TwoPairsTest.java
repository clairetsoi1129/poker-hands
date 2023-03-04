package rank;

import core.Hand;
import criteria.HighCardCriteria;
import criteria.PairCriteria;
import criteria.TwoPairsCriteria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TwoPairsTest {
    @Test
    void testTwoPairsvsHighCard() {
        Hand handBlack = new Hand("AD AH 9H 9C 2S");
        Hand handWhite = new Hand("KD QH 9H 8C 2S");

        Rank rankBlack = new TwoPairsCriteria(handBlack.getCards()).meetCriteria();
        Rank rankWhite = new HighCardCriteria(handWhite.getCards()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with two pairs: A", rankBlack.getReason());
    }

    @Test
    void testTwoPairsvsPair() {
        Hand handBlack = new Hand("AD AH 9H 9C 2S");
        Hand handWhite = new Hand("KD KH 9H 8C 2S");

        Rank rankBlack = new TwoPairsCriteria(handBlack.getCards()).meetCriteria();
        Rank rankWhite = new PairCriteria(handWhite.getCards()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with two pairs: A", rankBlack.getReason());
    }

    @Test
    void testTwoPairsvsTwoPairs_sameTwoPair_5th_diff() {
        Hand handBlack = new Hand("AD AH TH TC 3S");
        Hand handWhite = new Hand("AD AH TH TC 2S");

        Rank rankBlack = new TwoPairsCriteria(handBlack.getCards()).meetCriteria();
        Rank rankWhite = new TwoPairsCriteria(handWhite.getCards()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - same two pairs with high card: 3", rankBlack.getReason());
    }

    @Test
    void testTwoPairsvsTwoPairs_same1stPair_2ndPairDiff() {
        Hand handBlack = new Hand("AD AH KH KC 2S");
        Hand handWhite = new Hand("AD AH TH TC 2S");

        Rank rankBlack = new TwoPairsCriteria(handBlack.getCards()).meetCriteria();
        Rank rankWhite = new TwoPairsCriteria(handWhite.getCards()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - two pairs with higher pair: K", rankBlack.getReason());
    }

    @Test
    void testTwoPairsvsTwoPairs_sameTwoPair_no_diff() {
        Hand handBlack = new Hand("AD AH TH TC 2S");
        Hand handWhite = new Hand("AD AH TH TC 2S");

        Rank rankBlack = new PairCriteria(handBlack.getCards()).meetCriteria();
        Rank rankWhite = new PairCriteria(handWhite.getCards()).meetCriteria();
        assertEquals(0, rankBlack.compareTo(rankWhite));
        assertEquals("Tie.", rankBlack.getReason());
    }
}
