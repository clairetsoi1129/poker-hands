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

    public MessageFormatter(int compare, Rank rank, List<Value> blackValues,
                            List<Value> whiteValues, int ptr) {
        this.compare = compare;
        this.rank = rank;
        this.blackValues = blackValues;
        this.whiteValues = whiteValues;
        this.ptr = ptr;
    }

    public String format(){
        if (this.compare > 0){
            return MessageFormat.format(WIN_REASON,
                    BLACK, this.rank.getName(), blackValues.get(ptr));

        }else if (this.compare < 0){
            return MessageFormat.format(WIN_REASON,
                    WHITE, this.rank.getName(), whiteValues.get(ptr));
        }else{
            return TIE;

        }
    }
}
