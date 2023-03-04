package rank;

import core.RankType;
import core.Value;

import java.util.List;

public class FourOfAKind extends HighCard{
    public FourOfAKind(List<Value> valuesToCompare) {
        super(valuesToCompare);
        rankType = RankType.FourOfAKind;
    }
}
