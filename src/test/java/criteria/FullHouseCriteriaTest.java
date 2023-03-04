package criteria;

import core.Hand;
import core.RankType;
import org.junit.jupiter.api.Test;
import rank.Rank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FullHouseCriteriaTest {
    @Test
    void testHasFullHouse() {
        Hand handBlack = new Hand("2H 2C 2S 4D 4H");
        Criteria threeOfAKindCriteria = new ThreeOfAKindCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue());
        Criteria pairCriteria = new PairCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue());
        Criteria criteria = new FullHouseCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue(), threeOfAKindCriteria, pairCriteria);
        Rank rank = criteria.meetCriteria();
        assertEquals(RankType.FullHouse, rank.getRankType());
    }

    @Test
    void testNoFullHouse() {
        Hand handBlack = new Hand("2H 5H 3H 6H 4H");
        Criteria threeOfAKindCriteria = new ThreeOfAKindCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue());
        Criteria pairCriteria = new PairCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue());
        Criteria criteria = new FullHouseCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue(), threeOfAKindCriteria, pairCriteria);
        Rank rank = criteria.meetCriteria();
        assertNull(rank);
    }
}
