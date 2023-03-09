package rank;

import core.Hand;
import criteria.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FlushTest {
    @Test
    void testFlushvsHighCard() {
        Hand handBlack = new Hand("AH KH QH JH 9H");
        Hand handWhite = new Hand("KD QH 9H 8C 2S");

        Rank rankBlack = new FlushCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new HighCardCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with flush: A", rankBlack.getReason());
    }

    @Test
    void testFlushvsPair() {
        Hand handBlack = new Hand("AH KH QH JH 9H");
        Hand handWhite = new Hand("KD KC 9C 8C 2S");

        Rank rankBlack = new FlushCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new PairCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with flush: A", rankBlack.getReason());
    }

    @Test
    void testFlushvsTwoPairs() {
        Hand handBlack = new Hand("AH KH QH JH 9H");
        Hand handWhite = new Hand("KD KC 9H 9C 2S");

        Rank rankBlack = new FlushCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new PairCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with flush: A", rankBlack.getReason());
    }


    @Test
    void testFlushvsThreeOfAKind() {
        Hand handBlack = new Hand("AH KH QH JH 9H");
        Hand handWhite = new Hand("TD TH TC KC 2S");

        Rank rankBlack = new FlushCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new ThreeOfAKindCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with flush: A", rankBlack.getReason());
    }

    @Test
    void testFlushvsStraight() {
        Hand handBlack = new Hand("AH KH QH JH 9H");
        Hand handWhite = new Hand("KD QC JC TC 9S");

        Rank rankBlack = new FlushCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new StraightCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with flush: A", rankBlack.getReason());
    }

    @Test
    void testFlushvsFlush_1st_diff() {
        Hand handBlack = new Hand("AH 3H QH JH 9H");
        Hand handWhite = new Hand("KC 3C QC JC 9C");

        Rank rankBlack = new FlushCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new FlushCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - flush with high card: A", rankBlack.getReason());
    }

    @Test
    void testFlushvsFlush_2nd_diff() {
        Hand handBlack = new Hand("AH 3H QH JH 9H");
        Hand handWhite = new Hand("AC 2C QC JC 9C");

        Rank rankBlack = new FlushCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new FlushCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - flush with high card: 3", rankBlack.getReason());
    }

    @Test
    void testFlushvsFlush_3rd_diff() {
        Hand handBlack = new Hand("AH 3H QH JH 9H");
        Hand handWhite = new Hand("AC 3C TC JC 9C");

        Rank rankBlack = new FlushCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new FlushCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - flush with high card: Q", rankBlack.getReason());
    }

    @Test
    void testFlushvsFlush_4th_diff() {
        Hand handBlack = new Hand("AH 3H QH JH 9H");
        Hand handWhite = new Hand("AC 3C QC TC 9C");

        Rank rankBlack = new FlushCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new FlushCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - flush with high card: J", rankBlack.getReason());
    }

    @Test
    void testFlushvsFlush_5th_diff() {
        Hand handBlack = new Hand("AH 3H QH JH 9H");
        Hand handWhite = new Hand("AC 3C QC JC 8C");

        Rank rankBlack = new FlushCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new FlushCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - flush with high card: 9", rankBlack.getReason());
    }

    @Test
    void testFlushvsFlush_noDiff() {
        Hand handBlack = new Hand("AH 3H QH JH 9H");
        Hand handWhite = new Hand("AC 3C QC JC 9C");

        Rank rankBlack = new FlushCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new FlushCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertEquals(0, rankBlack.compareTo(rankWhite));
        assertEquals("Tie.", rankBlack.getReason());
    }
}
