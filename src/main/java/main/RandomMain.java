package main;

import core.Card;
import core.Hand;
import util.RandomCard;
import util.RandomCardImpl;

import java.util.List;

public class RandomMain {
    public static void main(String[] args){
        RandomCard random = new RandomCardImpl();
        List<Card> cardsBlack = random.generateCardAvoidConflict(5);
        List<Card> cardsWhite = random.generateCardAvoidConflict(5);
        System.out.println("Black:"+cardsBlack);
        System.out.println("White:"+cardsWhite);

        Hand handBlack = new Hand(cardsBlack);
        Hand handWhite = new Hand(cardsWhite);
        handBlack.compareTo(handWhite);

        System.out.println(handBlack.getRank().getReason());
    }
}
