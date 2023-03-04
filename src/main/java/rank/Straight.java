package rank;

import core.RankType;
import core.Value;

import java.util.List;

public class Straight extends HighCard{
    public Straight(List<Value> valuesToCompare) {
        super(valuesToCompare);
        rankType = RankType.Straight;
    }
}
