package criteria;

import core.Hand;
import core.RankType;
import org.junit.jupiter.api.Test;
import rank.Rank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PairCriteriaTest {
    @Test
    void testHasPair() {
        Hand handBlack = new Hand("KH 8C 2S AD 8H");
        Criteria criteria = new PairCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue());
        Rank rank = criteria.meetCriteria();
        assertEquals(RankType.Pair, rank.getRankType());
    }

    @Test
    void testNoPair() {
        Hand handBlack = new Hand("5C 3H 7H JS TD");
        Criteria criteria = new PairCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue());
        Rank rank = criteria.meetCriteria();
        assertNull(rank);
    }
}
