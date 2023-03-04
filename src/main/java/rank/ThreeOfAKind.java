package rank;

import core.RankType;
import core.Value;

import java.util.List;

public class ThreeOfAKind extends HighCard{
    public ThreeOfAKind(List<Value> valuesToCompare) {
        super(valuesToCompare);
        rankType = RankType.ThreeOfAKind;
    }
}
