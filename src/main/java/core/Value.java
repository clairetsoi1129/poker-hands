package core;

import java.util.stream.Stream;

public enum Value {
    DEDUCE('2'),
    THREE('3'),
    FOUR('4'),
    FIVE('5'),
    SIX('6'),
    SEVEN('7'),
    EIGHT('8'),
    NINE('9'),
    TEN('T'),
    JACK('J'),
    QUEEN('Q'),
    KING('K'),
    ACE('A');

    private final char symbol;

    Value(char symbol)
    {
        this.symbol = symbol;
    }

    public char getSymbol()
    {
        return this.symbol;
    }

    private static final Value[] values = values();

    public Value next() {
        int ordinal = this.ordinal();
        if (ordinal == values.length-1){
            return null;
        }
        return values[(ordinal + 1) % values.length];
    }

    public Value prev() {
        int ordinal = this.ordinal();
        if (ordinal == 0) {
            return null;
        }
        return values[(ordinal - 1) % values.length];
    }

    public String toString(){
        return String.valueOf(getSymbol());
    }

    public static Value getValueForSymbol(final char symbol)
    {
        return Stream.of(Value.values())
                .filter(s->s.symbol == symbol)
                .toList()
                .stream().findFirst().orElse(null);
    }
}
