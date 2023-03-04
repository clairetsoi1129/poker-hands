package criteria;

import core.Hand;
import core.RankType;
import org.junit.jupiter.api.Test;
import rank.Rank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StraightCriteriaTest {
    @Test
    void testHasStraight() {
        Hand handBlack = new Hand("9H TH QH 8C JH");
        Criteria criteria = new StraightCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue());
        Rank rank = criteria.meetCriteria();
        assertEquals(RankType.Straight, rank.getRankType());
    }

    @Test
    void testNoStraight() {
        Hand handBlack = new Hand("5C 3H 7H JS TD");
        Criteria criteria = new StraightCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue());
        Rank rank = criteria.meetCriteria();
        assertNull(rank);
    }
}
