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
        Hand handBlack = new Hand("AD AH AH 9C 2S");
        Hand handWhite = new Hand("KD QH 9H 8C 2S");

        Rank rankBlack = new ThreeOfAKindCriteria(handBlack.getCards()).meetCriteria();
        Rank rankWhite = new HighCardCriteria(handWhite.getCards()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with three of a kind: A", rankBlack.getReason());
    }

    @Test
    void testThreeOfAKindvsPair() {
        Hand handBlack = new Hand("AD AH AH 9C 2S");
        Hand handWhite = new Hand("KD KH 9H 8C 2S");

        Rank rankBlack = new ThreeOfAKindCriteria(handBlack.getCards()).meetCriteria();
        Rank rankWhite = new PairCriteria(handWhite.getCards()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with three of a kind: A", rankBlack.getReason());
    }

    @Test
    void testThreeOfAKindvsTwoPairs() {
        Hand handBlack = new Hand("AD AH AH 9C 2S");
        Hand handWhite = new Hand("KD KH 9H 9C 2S");

        Rank rankBlack = new ThreeOfAKindCriteria(handBlack.getCards()).meetCriteria();
        Rank rankWhite = new TwoPairsCriteria(handWhite.getCards()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with three of a kind: A", rankBlack.getReason());
    }


    @Test
    void testThreeOfAKindvsThreeOfAKind() {
        Hand handBlack = new Hand("AD AH AH QC 3S");
        Hand handWhite = new Hand("TD TH TH KC 2S");

        Rank rankBlack = new ThreeOfAKindCriteria(handBlack.getCards()).meetCriteria();
        Rank rankWhite = new ThreeOfAKindCriteria(handWhite.getCards()).meetCriteria();
        assertTrue(rankBlack.compareTo(rankWhite) > 0);
        assertEquals("Black wins. - with three of a kind: A", rankBlack.getReason());
    }
}
