package util;

import model.RankType;
import model.Value;

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

    protected String message;

    public MessageFormatter(int compare, RankType rankType, List<Value> blackValues,
                            List<Value> whiteValues, int ptr) {
        this.compare = compare;
        this.rankType = rankType;
        this.blackValues = blackValues;
        this.whiteValues = whiteValues;
        this.ptr = ptr;
        message = WIN_REASON;
        if (this.compare > 0) {
            whoWin = BLACK;
            whoseValues = blackValues;
        } else {
            whoWin = WHITE;
            whoseValues = whiteValues;
        }
    }

    public String format(){
        if (this.compare == 0){
            return TIE;
        }else {
            return MessageFormat.format(message,
                    whoWin, this.rankType.getName(), whoseValues.get(ptr));
        }
    }
}
