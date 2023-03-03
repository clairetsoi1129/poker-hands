import java.text.MessageFormat;
import java.util.List;

public class FullHouseMessageFormatter extends MessageFormatter{
    private final String WIN_REASON_FULL_HOUSE = "{0} wins. - with {1}: {2} over {3}";

    public FullHouseMessageFormatter(int compare, Rank rank, List<Value> blackValues, List<Value> whiteValues) {
        super(compare, rank, blackValues, whiteValues, 0);
    }

    public String format(){
        if (this.compare > 0){
            return MessageFormat.format(WIN_REASON_FULL_HOUSE,
                    BLACK, this.rank.getName(), blackValues.get(0), blackValues.get(1));

        }else if (this.compare < 0){
            return MessageFormat.format(WIN_REASON_FULL_HOUSE,
                    WHITE, this.rank.getName(), whiteValues.get(0), whiteValues.get(1));
        }else{
            return TIE;

        }
    }
}
