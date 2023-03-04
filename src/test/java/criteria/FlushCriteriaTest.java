package criteria;

import core.*;
import org.junit.jupiter.api.Test;
import rank.Rank;

import static org.junit.jupiter.api.Assertions.*;

public class FlushCriteriaTest {
    @Test
    void testHasFlush() {
        Hand handBlack = new Hand("2H 4H 6H 8H JH");
        Criteria criteria = new FlushCriteria(handBlack.getCards());
        Rank rank = criteria.meetCriteria();
        assertEquals(RankType.Flush, rank.getRankType());
    }

    @Test
    void testNoFlush() {
        Hand handBlack = new Hand("2C 5H 3H 6H 4H");
        Criteria criteria = new FlushCriteria(handBlack.getCards());
        Rank rank = criteria.meetCriteria();
        assertNull(rank);
    }
}
