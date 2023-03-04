package criteria;

import core.Hand;
import core.RankType;
import org.junit.jupiter.api.Test;
import rank.Rank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TwoPairsCriteriaTest {
    @Test
    void testHasTwoPairs() {
        Hand handBlack = new Hand("2H 2C 3S 3D 4H");
        Criteria criteria = new TwoPairsCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue());
        Rank rank = criteria.meetCriteria();
        assertEquals(RankType.TwoPairs, rank.getRankType());
    }

    @Test
    void testNoPair() {
        Hand handBlack = new Hand("5C 3H 7H JS TD");
        Criteria criteria = new TwoPairsCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue());
        Rank rank = criteria.meetCriteria();
        assertNull(rank);
    }
}
