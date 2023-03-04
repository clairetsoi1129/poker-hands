package util;

import model.Rank;
import model.Value;

import java.text.MessageFormat;
import java.util.List;

public class MessageFormatter {
    protected int compare;
    protected Rank rank;
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

    public MessageFormatter(int compare, Rank rank, List<Value> blackValues,
                            List<Value> whiteValues, int ptr) {
        this.compare = compare;
        this.rank = rank;
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
                    whoWin, this.rank.getName(), whoseValues.get(ptr));
        }
    }
}
