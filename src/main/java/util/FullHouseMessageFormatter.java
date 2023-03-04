package util;

import model.Rank;
import model.Value;

import java.text.MessageFormat;
import java.util.List;

public class FullHouseMessageFormatter extends MessageFormatter{
    private final String WIN_REASON_FULL_HOUSE = "{0} wins. - with {1}: {2} over {3}";

    public FullHouseMessageFormatter(int compare, Rank rank, List<Value> blackValues, List<Value> whiteValues) {
        super(compare, rank, blackValues, whiteValues, 0);
        message = WIN_REASON_FULL_HOUSE;
    }

    public String format(){
        if (this.compare == 0){
            return TIE;
        }else {
            return MessageFormat.format(message,
                    whoWin, this.rank.getName(), whoseValues.get(0), whoseValues.get(1));
        }
    }
}
