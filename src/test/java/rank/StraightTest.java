package rank;

import core.Hand;
import criteria.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StraightTest {
    @Test
    void testStraightvsHighCard() {
        Hand handBlack = new Hand("AD KH QH JC TS");
        Hand handWhite = new Hand("KD QH 9H 8C 2S");

        Rank rankBlack = new StraightCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new HighCardCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with straight: A", rankBlack.getReason());
    }

    @Test
    void testStraightvsPair() {
        Hand handBlack = new Hand("AD KH QH JC TS");
        Hand handWhite = new Hand("KD KH 9H 8C 2S");

        Rank rankBlack = new StraightCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new PairCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with straight: A", rankBlack.getReason());
    }

    @Test
    void testStraightvsTwoPairs() {
        Hand handBlack = new Hand("AD KH QH JC TS");
        Hand handWhite = new Hand("KD KC 9H 9C 2S");

        Rank rankBlack = new StraightCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new TwoPairsCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with straight: A", rankBlack.getReason());
    }


    @Test
    void testStraightvsThreeOfAKind() {
        Hand handBlack = new Hand("AD KH QH JC TS");
        Hand handWhite = new Hand("TD TH TC KC 2S");

        Rank rankBlack = new StraightCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new ThreeOfAKindCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with straight: A", rankBlack.getReason());
    }

    @Test
    void testStraightvsStraight() {
        Hand handBlack = new Hand("AD KH QH JC TS");
        Hand handWhite = new Hand("KD QH JH TC 9S");

        Rank rankBlack = new StraightCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new StraightCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with straight: A", rankBlack.getReason());
    }
}
