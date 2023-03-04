package core;

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
        for (Suit suit : Suit.values())
            if (suit.symbol == symbol)
                return suit;
        return null;
    }
}
