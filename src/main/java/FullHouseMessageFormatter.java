import java.text.MessageFormat;
import java.util.List;

public class FullHouseMessageFormatter extends MessageFormatter{
    private final String WIN_REASON_FULL_HOUSE = "{0} wins. - with {1}: {2} over {3}";

    public FullHouseMessageFormatter(int compare, Rank rank, List<Value> values) {
        super(compare, rank, values, 0);
    }

    public String format(){
        if (this.compare > 0){
            return MessageFormat.format(WIN_REASON_FULL_HOUSE,
                    BLACK, this.rank.getName(), values.get(0), values.get(1));

        }else if (this.compare < 0){
            return MessageFormat.format(WIN_REASON_FULL_HOUSE,
                    WHITE, this.rank.getName(), values.get(0), values.get(1));
        }else{
            return TIE;

        }
    }
}
