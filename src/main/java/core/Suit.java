package core;

import java.util.stream.Stream;

public enum Suit {
    CLUBS('C'),
    DIAMONDS('D'),
    HEARTS('H'),
    SPADES('S');

    private final char symbol;

    Suit(char symbol)
    {
        this.symbol = symbol;
    }

    public char getSymbol()
    {
        return this.symbol;
    }

    public static Suit getSuitForSymbol(final char symbol)
    {
        return Stream.of(Suit.values())
                .filter(s->s.symbol == symbol)
                .toList()
                .stream().findFirst().orElse(null);
    }
}
