package rank;

import core.Hand;
import criteria.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StraightFlushTest {
    @Test
    void testStraightFlushvsHighCard() {
        Hand handBlack = new Hand("AC KC TC QC JC");
        Hand handWhite = new Hand("KD QH 9H 8C 2S");

        Rank rankBlack = new StraightFlushCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue(),
                new StraightCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()),
                new FlushCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue())).meetCriteria();
        Rank rankWhite = new HighCardCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with straight flush: A", rankBlack.getReason());
    }

    @Test
    void testStraightFlushvsPair() {
        Hand handBlack = new Hand("AC KC TC QC JC");
        Hand handWhite = new Hand("KD KH 9H 8C 2S");

        Rank rankBlack = new StraightFlushCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue(),
                new StraightCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()),
                new FlushCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue())).meetCriteria();
        Rank rankWhite = new PairCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with straight flush: A", rankBlack.getReason());
    }

    @Test
    void testStraightFlushvsTwoPairs() {
        Hand handBlack = new Hand("AC KC TC QC JC");
        Hand handWhite = new Hand("KD KH 9H 9C 2S");

        Rank rankBlack = new StraightFlushCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue(),
                new StraightCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()),
                new FlushCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue())).meetCriteria();
        Rank rankWhite = new PairCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with straight flush: A", rankBlack.getReason());
    }


    @Test
    void testStraightFlushvsThreeOfAKind() {
        Hand handBlack = new Hand("AC KC TC QC JC");
        Hand handWhite = new Hand("TD TH TC KC 2S");

        Rank rankBlack = new StraightFlushCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue(),
                new StraightCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()),
                new FlushCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue())).meetCriteria();
        Rank rankWhite = new ThreeOfAKindCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with straight flush: A", rankBlack.getReason());
    }

    @Test
    void testStraightFlushvsStraight() {
        Hand handBlack = new Hand("AC KC TC QC JC");
        Hand handWhite = new Hand("KD QH JH TC 9S");

        Rank rankBlack = new StraightFlushCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue(),
                new StraightCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()),
                new FlushCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue())).meetCriteria();
        Rank rankWhite = new StraightCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with straight flush: A", rankBlack.getReason());
    }

    @Test
    void testStraightFlushvsFlush() {
        Hand handBlack = new Hand("AC KC TC QC JC");
        Hand handWhite = new Hand("KH 3H QH JH 9H");

        Rank rankBlack = new StraightFlushCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue(),
                new StraightCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()),
                new FlushCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue())).meetCriteria();
        Rank rankWhite = new FlushCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with straight flush: A", rankBlack.getReason());
    }

    @Test
    void testStraightFlushvsFullHouse() {
        Hand handBlack = new Hand("AC KC TC QC JC");
        Hand handWhite = new Hand("KH KC KS 9D 9H");

        Rank rankBlack = new StraightFlushCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue(),
                new StraightCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()),
                new FlushCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue())).meetCriteria();
        Rank rankWhite = new FullHouseCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue(),
                new ThreeOfAKindCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()),
                new PairCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue())).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with straight flush: A", rankBlack.getReason());
    }

    @Test
    void testStraightFlushvsFourOfAKind() {
        Hand handBlack = new Hand("AC KC TC QC JC");
        Hand handWhite = new Hand("KH KC KS KD 9H");

        Rank rankBlack = new StraightFlushCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue(),
                new StraightCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()),
                new FlushCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue())).meetCriteria();
        Rank rankWhite = new FourOfAKindCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with straight flush: A", rankBlack.getReason());
    }

    @Test
    void testStraightFlushvsStraightFlush() {
        Hand handBlack = new Hand("AC KC TC QC JC");
        Hand handWhite = new Hand("2H 5H 3H 6H 4H");

        Rank rankBlack = new StraightFlushCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue(),
                new StraightCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()),
                new FlushCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue())).meetCriteria();
        Rank rankWhite = new StraightFlushCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue(),
                new StraightCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()),
                new FlushCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue())).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with straight flush: A", rankBlack.getReason());
    }
}
