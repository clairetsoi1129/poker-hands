import java.text.MessageFormat;
import java.util.List;

public class MessageFormatter {
    protected int compare;
    protected Rank rank;
    protected List<Value> values;
    protected int ptr;
    protected String BLACK = "Black";
    protected String WHITE = "White";
    protected final String WIN_REASON = "{0} wins. - with {1}: {2}";
    protected final String TIE = "Tie.";

    public MessageFormatter(int compare, Rank rank, List<Value> values, int ptr) {
        this.compare = compare;
        this.rank = rank;
        this.values = values;
        this.ptr = ptr;
    }

    public String format(){
        if (this.compare > 0){
            return MessageFormat.format(WIN_REASON,
                    BLACK, this.rank.getName(), values.get(ptr));

        }else if (this.compare < 0){
            return MessageFormat.format(WIN_REASON,
                    WHITE, this.rank.getName(), values.get(ptr));
        }else{
            return TIE;

        }
    }
}
