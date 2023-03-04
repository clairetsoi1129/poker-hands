package rank;

import core.Hand;
import criteria.HighCardCriteria;
import criteria.PairCriteria;
import criteria.ThreeOfAKindCriteria;
import criteria.TwoPairsCriteria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ThreeOfAKindTest {
    @Test
    void testThreeOfAKindvsHighCard() {
        Hand handBlack = new Hand("AD AH AS 9C 2S");
        Hand handWhite = new Hand("KD QH 9H 8C 2S");

        Rank rankBlack = new ThreeOfAKindCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new HighCardCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with three of a kind: A", rankBlack.getReason());
    }

    @Test
    void testThreeOfAKindvsPair() {
        Hand handBlack = new Hand("AD AH AS 9C 2S");
        Hand handWhite = new Hand("KD KH 9H 8C 2S");

        Rank rankBlack = new ThreeOfAKindCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new PairCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with three of a kind: A", rankBlack.getReason());
    }

    @Test
    void testThreeOfAKindvsTwoPairs() {
        Hand handBlack = new Hand("AD AH AS 9C 2S");
        Hand handWhite = new Hand("KD KH 9H 9C 2S");

        Rank rankBlack = new ThreeOfAKindCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new TwoPairsCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with three of a kind: A", rankBlack.getReason());
    }


    @Test
    void testThreeOfAKindvsThreeOfAKind() {
        Hand handBlack = new Hand("AD AH AS QC 3S");
        Hand handWhite = new Hand("TD TH TC KC 2S");

        Rank rankBlack = new ThreeOfAKindCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue()).meetCriteria();
        Rank rankWhite = new ThreeOfAKindCriteria(handWhite.getCards(), handWhite.sortAndGroupByValue()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with three of a kind: A", rankBlack.getReason());
    }
}
