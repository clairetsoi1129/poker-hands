package criteria;

import core.Hand;
import core.RankType;
import org.junit.jupiter.api.Test;
import rank.Rank;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HighCardCriteriaTest {
    @Test
    void testHasHighCard() {
        Hand handBlack = new Hand("KH 8C 2S AD 9H");
        Criteria criteria = new HighCardCriteria(handBlack.getCards(), handBlack.sortAndGroupByValue());
        Rank rank = criteria.meetCriteria();
        assertEquals(RankType.HighCard, rank.getRankType());
    }
}
