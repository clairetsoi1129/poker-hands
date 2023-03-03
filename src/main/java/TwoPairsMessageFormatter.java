import java.text.MessageFormat;
import java.util.List;

public class TwoPairsMessageFormatter extends PairMessageFormatter{
    public TwoPairsMessageFormatter(int compare, Rank rank, List<Value> values, int ptr) {
        super(compare, rank, values, ptr);
    }

    public String format(){
        if (this.compare > 0){
            if (ptr == 0 || ptr == 1) {
                return MessageFormat.format(WIN_REASON_PAIR_HIGHER_PAIR,
                        BLACK, this.rank.getName(), values.get(ptr));
            }else {
                return MessageFormat.format(WIN_REASON_PAIR_HIGH_CARD,
                        BLACK, this.rank.getName(), values.get(ptr));
            }

        }else if (this.compare < 0){
            if (ptr == 0 || ptr == 1) {
                return MessageFormat.format(WIN_REASON_PAIR_HIGHER_PAIR,
                        WHITE, this.rank.getName(), values.get(ptr));
            }else {
                return MessageFormat.format(WIN_REASON_PAIR_HIGH_CARD,
                        WHITE, this.rank.getName(), values.get(ptr));
            }

        }else{
            return TIE;
        }
    }
}
