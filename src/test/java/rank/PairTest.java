package rank;

import core.Hand;
import criteria.HighCardCriteria;
import criteria.PairCriteria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PairTest {
    @Test
    void testPairvsHighCard() {
        Hand handBlack = new Hand("AD AH 9H 8C 2S");
        Hand handWhite = new Hand("KD QH 9H 8C 2S");

        Rank rankBlack = new PairCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new HighCardCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with pair: A", rankBlack.getReason());
    }

    @Test
    void testPairvsPair_1st_diff() {
        Hand handBlack = new Hand("AD AH TH 8C 2S");
        Hand handWhite = new Hand("KD KH 9H 8C 2S");

        Rank rankBlack = new PairCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new PairCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - pair with higher pair: A", rankBlack.getReason());
    }

    @Test
    void testPairvsPair_samePair_3rd_diff() {
        Hand handBlack = new Hand("AD AH TH 8C 2S");
        Hand handWhite = new Hand("AD AH 9H 8C 2S");

        Rank rankBlack = new PairCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new PairCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - same pair with high card: T", rankBlack.getReason());
    }

    @Test
    void testPairvsPair_samePair_noDiff() {
        Hand handBlack = new Hand("AD AH TH 8C 2S");
        Hand handWhite = new Hand("AD AH TH 8C 2S");

        Rank rankBlack = new PairCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new PairCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertEquals(0, rankBlack.compareTo(rankWhite));
        assertEquals("Tie.", rankBlack.getReason());
    }

    @Test
    void testPairvsHighCard2() {
        Hand handBlack = new Hand("7H 2D AH 9H KS");
        Hand handWhite = new Hand("JS 3H QC QD 5D");

        Rank rankBlack = new HighCardCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new PairCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) < 0);
        assertEquals("White wins. - with pair: Q", rankBlack.getReason());
    }

}
