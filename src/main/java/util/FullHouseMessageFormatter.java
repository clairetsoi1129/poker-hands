package util;

import core.RankType;
import core.Value;

import java.text.MessageFormat;
import java.util.List;

public class FullHouseMessageFormatter extends MessageFormatter{
    private final String WIN_REASON_FULL_HOUSE = "{0} wins. - with {1}: {2} over {3}";

    public FullHouseMessageFormatter(int compare, RankType blackRankType, RankType whiteRankType,
                                     List<Value> blackValues, List<Value> whiteValues) {
        super(compare, blackRankType, whiteRankType, blackValues, whiteValues, 0);
        message = WIN_REASON_FULL_HOUSE;
    }

    public String format(){
        if (this.compare == 0){
            return TIE;
        }else {
            return MessageFormat.format(message,
                    whoWin, whoseRankType.getName(), whoseValues.get(0), whoseValues.get(1));
        }
    }
}
