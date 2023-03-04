package util;

import core.Card;

import java.util.List;

public interface RandomCard {
    List<Card> generateCardAvoidConflict(int times);
}
