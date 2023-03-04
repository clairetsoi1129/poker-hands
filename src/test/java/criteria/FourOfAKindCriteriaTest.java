package criteria;

import core.Hand;
import core.RankType;
import org.junit.jupiter.api.Test;
import rank.Rank;

import static org.junit.jupiter.api.Assertions.*;

public class FourOfAKindCriteriaTest {
    @Test
    void testHasFourOfAKind() {
        Hand handBlack = new Hand("2H 2C 2S 2D 4H");
        Criteria criteria = new FourOfAKindCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue());
        Rank rank = criteria.meetCriteria();
        assertEquals(RankType.FourOfAKind, rank.getRankType());
    }

    @Test
    void testNoFourOfAKind() {
        Hand handBlack = new Hand("2H 5H 3H 6H 4H");
        Criteria criteria = new FourOfAKindCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue());
        Rank rank = criteria.meetCriteria();
        assertNull(rank);
    }
}
