package rank;

import core.Hand;
import criteria.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FullHouseTest {
    @Test
    void testFullHousevsHighCard() {
        Hand handBlack = new Hand("AH AC AD JH JC");
        Hand handWhite = new Hand("KD QH 9H 8C 2S");

        Rank rankBlack = new FullHouseCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue(),
                new ThreeOfAKindCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()),
                new PairCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue())).meetCriteria();
        Rank rankWhite = new HighCardCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with full house: A over J", rankBlack.getReason());
    }

    @Test
    void testFullHousevsPair() {
        Hand handBlack = new Hand("AH AC AD JH JC");
        Hand handWhite = new Hand("KD KH 9H 8C 2S");

        Rank rankBlack = new FullHouseCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue(),
                new ThreeOfAKindCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()),
                new PairCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue())).meetCriteria();
        Rank rankWhite = new PairCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with full house: A over J", rankBlack.getReason());
    }

    @Test
    void testFullHousevsTwoPairs() {
        Hand handBlack = new Hand("AH AC AD JC JH");
        Hand handWhite = new Hand("KD KH 9H 9C 2S");

        Rank rankBlack = new FullHouseCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue(),
                new ThreeOfAKindCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()),
                new PairCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue())).meetCriteria();
        Rank rankWhite = new PairCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with full house: A over J", rankBlack.getReason());
    }


    @Test
    void testFullHousevsThreeOfAKind() {
        Hand handBlack = new Hand("AH AC AD JC JH");
        Hand handWhite = new Hand("TD TH TS KC 2S");

        Rank rankBlack = new FullHouseCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue(),
                new ThreeOfAKindCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()),
                new PairCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue())).meetCriteria();
        Rank rankWhite = new ThreeOfAKindCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with full house: A over J", rankBlack.getReason());
    }

    @Test
    void testFullHousevsStraight() {
        Hand handBlack = new Hand("AH AC AD JC JH");
        Hand handWhite = new Hand("KD QH JH TC 9S");

        Rank rankBlack = new FullHouseCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue(),
                new ThreeOfAKindCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()),
                new PairCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue())).meetCriteria();
        Rank rankWhite = new StraightCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with full house: A over J", rankBlack.getReason());
    }

    @Test
    void testFullHousevsFlush() {
        Hand handBlack = new Hand("AH AC AD JH JC");
        Hand handWhite = new Hand("KH 3H QH JH 9H");

        Rank rankBlack = new FullHouseCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue(),
                new ThreeOfAKindCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()),
                new PairCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue())).meetCriteria();
        Rank rankWhite = new FlushCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with full house: A over J", rankBlack.getReason());
    }

    @Test
    void testFullHousevsFullHouse() {
        Hand handBlack = new Hand("AH AC AD JC JH");
        Hand handWhite = new Hand("KH KC KD 9C 9H");

        Rank rankBlack = new FullHouseCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue(),
                new ThreeOfAKindCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()),
                new PairCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue())).meetCriteria();
        Rank rankWhite = new FullHouseCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue(),
                new ThreeOfAKindCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()),
                new PairCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue())).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with full house: A over J", rankBlack.getReason());
    }

}
