package criteria;

import core.Hand;
import core.RankType;
import org.junit.jupiter.api.Test;
import rank.Rank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ThreeOfAKindCriteriaTest {
    @Test
    void testHasThreeOfAKind() {
        Hand handBlack = new Hand("2H 2C 2S 3D 4H");
        Criteria criteria = new ThreeOfAKindCriteria(handBlack.getCards());
        Rank rank = criteria.meetCriteria();
        assertEquals(RankType.ThreeOfAKind, rank.getRankType());
    }

    @Test
    void testNoThreeOfAKind() {
        Hand handBlack = new Hand("5C 3H 7H JS TD");
        Criteria criteria = new ThreeOfAKindCriteria(handBlack.getCards());
        Rank rank = criteria.meetCriteria();
        assertNull(rank);
    }
}
