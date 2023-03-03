package model;

public enum Rank {
    HighCard("high card"),
    Pair("pair"),
    TwoPairs("two pairs"),
    ThreeOfAKind("three of a kind"),
    Straight("straight"),
    Flush("flush"),
    FullHouse("full house"),
    FourOfAKind("four of a kind"),
    StraightFlush("straight flush");

    private final String name;

    Rank(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
