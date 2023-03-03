import java.text.MessageFormat;
import java.util.List;

public class FlushMessageFormatter extends MessageFormatter{
    private final String WIN_REASON_FLUSH_HIGH_CARD = "{0} wins. - {1} with high card: {2}";

    public FlushMessageFormatter(int compare, Rank rank, List<Value> values, int ptr) {
        super(compare, rank, values, ptr);
    }

    public String format(){
        if (this.compare > 0){
            return MessageFormat.format(WIN_REASON_FLUSH_HIGH_CARD,
                    BLACK, this.rank.getName(), values.get(ptr));

        }else if (this.compare < 0){
            return MessageFormat.format(WIN_REASON_FLUSH_HIGH_CARD,
                    WHITE, this.rank.getName(), values.get(ptr));
        }else{
            return TIE;

        }
    }
}
