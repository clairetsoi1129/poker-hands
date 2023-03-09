package rank;

import core.Hand;
import criteria.HighCardCriteria;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HighCardTest {
    @Test
    void testHighCardvsHighCard_1st_diff() {
        Hand handBlack = new Hand("AD QH 9H 8C 2S");
        Hand handWhite = new Hand("KD QS 9S 8S 2C");

        Rank rankBlack = new HighCardCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new HighCardCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with high card: A", rankBlack.getReason());
    }
    @Test
    void testHighCardvsHighCard_2nd_diff() {
        Hand handBlack = new Hand("AD KH 9H 8C 2S");
        Hand handWhite = new Hand("AS QS 9S 8S 2C");

        Rank rankBlack = new HighCardCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new HighCardCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with high card: K", rankBlack.getReason());
    }

    @Test
    void testHighCardvsHighCard_3rd_diff() {
        Hand handBlack = new Hand("AD KH TH 8C 2S");
        Hand handWhite = new Hand("AS KS 9S 8S 2C");

        Rank rankBlack = new HighCardCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new HighCardCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with high card: T", rankBlack.getReason());
    }

    @Test
    void testHighCardvsHighCard_4th_diff() {
        Hand handBlack = new Hand("AD KH 9H 8C 2S");
        Hand handWhite = new Hand("AS KS 9S 7C 2C");

        Rank rankBlack = new HighCardCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new HighCardCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with high card: 8", rankBlack.getReason());
    }

    @Test
    void testHighCardvsHighCard_5th_diff() {
        Hand handBlack = new Hand("AD KH 9H 8C 3S");
        Hand handWhite = new Hand("AS KS 9S 8S 2C");

        Rank rankBlack = new HighCardCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new HighCardCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with high card: 3", rankBlack.getReason());
    }

    @Test
    void testHighCardvsHighCard_noDiff() {
        Hand handBlack = new Hand("AD KH 9H 8C 2S");
        Hand handWhite = new Hand("AS KS 9S 8S 2C");

        Rank rankBlack = new HighCardCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new HighCardCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertEquals(0, rankBlack.compareTo(rankWhite));
        assertEquals("Tie.", rankBlack.getReason());
    }

}
