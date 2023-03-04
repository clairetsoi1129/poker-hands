package util;

import core.RankType;
import core.Value;

import java.text.MessageFormat;
import java.util.List;

public class MessageFormatter {
    protected int compare;
    protected RankType rankType;
    protected List<Value> blackValues;
    protected List<Value> whiteValues;
    protected int ptr;
    protected String BLACK = "Black";
    protected String WHITE = "White";
    protected final String WIN_REASON = "{0} wins. - with {1}: {2}";
    protected final String TIE = "Tie.";

    protected String whoWin;
    protected List<Value> whoseValues;

    protected RankType whoseRankType;

    protected String message;

    public MessageFormatter(int compare, RankType blackRankType, RankType whiteRankType, List<Value> blackValues,
                            List<Value> whiteValues, int ptr) {
        this.compare = compare;
        this.blackValues = blackValues;
        this.whiteValues = whiteValues;
        this.ptr = ptr;
        message = WIN_REASON;
        if (this.compare > 0) {
            whoWin = BLACK;
            whoseValues = blackValues;
            whoseRankType = blackRankType;
        } else {
            whoWin = WHITE;
            whoseValues = whiteValues;
            whoseRankType = whiteRankType;
        }
    }

    public String format(){
        if (this.compare == 0){
            return TIE;
        }else {
            return MessageFormat.format(message,
                    whoWin, whoseRankType.getName(), whoseValues.get(ptr));
        }
    }
}
