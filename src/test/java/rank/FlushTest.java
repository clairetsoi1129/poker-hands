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

        Rank rankBlack = new FlushCriteria(handBlack.getCards()).meetCriteria();
        Rank rankWhite = new HighCardCriteria(handWhite.getCards()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with flush: A", rankBlack.getReason());
    }

    @Test
    void testFlushvsPair() {
        Hand handBlack = new Hand("AH KH QH JH 9H");
        Hand handWhite = new Hand("KD KH 9H 8C 2S");

        Rank rankBlack = new FlushCriteria(handBlack.getCards()).meetCriteria();
        Rank rankWhite = new PairCriteria(handWhite.getCards()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with flush: A", rankBlack.getReason());
    }

    @Test
    void testFlushvsTwoPairs() {
        Hand handBlack = new Hand("AH KH QH JH 9H");
        Hand handWhite = new Hand("KD KH 9H 9C 2S");

        Rank rankBlack = new FlushCriteria(handBlack.getCards()).meetCriteria();
        Rank rankWhite = new TwoPairsCriteria(handWhite.getCards()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with flush: A", rankBlack.getReason());
    }


    @Test
    void testFlushvsThreeOfAKind() {
        Hand handBlack = new Hand("AH KH QH JH 9H");
        Hand handWhite = new Hand("TD TH TC KC 2S");

        Rank rankBlack = new FlushCriteria(handBlack.getCards()).meetCriteria();
        Rank rankWhite = new ThreeOfAKindCriteria(handWhite.getCards()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with flush: A", rankBlack.getReason());
    }

    @Test
    void testFlushvsStraight() {
        Hand handBlack = new Hand("AH KH QH JH 9H");
        Hand handWhite = new Hand("KD QH JH TC 9S");

        Rank rankBlack = new FlushCriteria(handBlack.getCards()).meetCriteria();
        Rank rankWhite = new StraightCriteria(handWhite.getCards()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with flush: A", rankBlack.getReason());
    }

    @Test
    void testFlushvsFlush_1st_diff() {
        Hand handBlack = new Hand("AH 3H QH JH 9H");
        Hand handWhite = new Hand("KH 3H QH JH 9H");

        Rank rankBlack = new FlushCriteria(handBlack.getCards()).meetCriteria();
        Rank rankWhite = new FlushCriteria(handWhite.getCards()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - flush with high card: A", rankBlack.getReason());
    }

    @Test
    void testFlushvsFlush_2nd_diff() {
        Hand handBlack = new Hand("AH 3H QH JH 9H");
        Hand handWhite = new Hand("AH 2H QH JH 9H");

        Rank rankBlack = new FlushCriteria(handBlack.getCards()).meetCriteria();
        Rank rankWhite = new FlushCriteria(handWhite.getCards()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - flush with high card: 3", rankBlack.getReason());
    }

    @Test
    void testFlushvsFlush_3rd_diff() {
        Hand handBlack = new Hand("AH 3H QH JH 9H");
        Hand handWhite = new Hand("AH 3H TH JH 9H");

        Rank rankBlack = new FlushCriteria(handBlack.getCards()).meetCriteria();
        Rank rankWhite = new FlushCriteria(handWhite.getCards()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - flush with high card: Q", rankBlack.getReason());
    }

    @Test
    void testFlushvsFlush_4th_diff() {
        Hand handBlack = new Hand("AH 3H QH JH 9H");
        Hand handWhite = new Hand("AH 3H QH TH 9H");

        Rank rankBlack = new FlushCriteria(handBlack.getCards()).meetCriteria();
        Rank rankWhite = new FlushCriteria(handWhite.getCards()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - flush with high card: J", rankBlack.getReason());
    }

    @Test
    void testFlushvsFlush_5th_diff() {
        Hand handBlack = new Hand("AH 3H QH JH 9H");
        Hand handWhite = new Hand("AH 3H QH JH 8H");

        Rank rankBlack = new FlushCriteria(handBlack.getCards()).meetCriteria();
        Rank rankWhite = new FlushCriteria(handWhite.getCards()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - flush with high card: 9", rankBlack.getReason());
    }

    @Test
    void testFlushvsFlush_noDiff() {
        Hand handBlack = new Hand("AH 3H QH JH 9H");
        Hand handWhite = new Hand("AH 3H QH JH 9H");

        Rank rankBlack = new FlushCriteria(handBlack.getCards()).meetCriteria();
        Rank rankWhite = new FlushCriteria(handWhite.getCards()).meetCriteria();
        assertEquals(0, rankBlack.compareTo(rankWhite));
        assertEquals("Tie.", rankBlack.getReason());
    }
}
