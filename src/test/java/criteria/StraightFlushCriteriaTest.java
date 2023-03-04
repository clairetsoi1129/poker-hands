package criteria;

import core.Hand;
import core.RankType;
import org.junit.jupiter.api.Test;
import rank.Rank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StraightFlushCriteriaTest {
    @Test
    void testHasStraightFlush() {
        Hand handBlack = new Hand("2H 5H 3H 6H 4H");
        Criteria straightCriteria = new StraightCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue());
        Criteria flushCriteria = new FlushCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue());
        Criteria criteria = new StraightFlushCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue(), straightCriteria, flushCriteria);
        Rank rank = criteria.meetCriteria();
        assertEquals(RankType.StraightFlush, rank.getRankType());
    }

    @Test
    void testNoStraightFlush() {
        Hand handBlack = new Hand("5C 3H 7H JS TD");
        Criteria straightCriteria = new StraightCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue());
        Criteria flushCriteria = new FlushCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue());
        Criteria criteria = new StraightFlushCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue(), straightCriteria, flushCriteria);
        Rank rank = criteria.meetCriteria();
        assertNull(rank);
    }
}
