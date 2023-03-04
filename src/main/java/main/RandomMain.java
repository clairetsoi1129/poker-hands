package main;

import core.Hand;
import util.RandomCard;
import util.RandomCardImpl;

public class RandomMain {
    public static void main(String[] args){
        RandomCard random = new RandomCardImpl();
        Hand handBlack = new Hand(random.generateCardAvoidConflict(5));
        System.out.println("handBlack:"+handBlack);
        Hand handWhite = new Hand(random.generateCardAvoidConflict(5));
        System.out.println("handBlack:"+handBlack);
        System.out.println("handWhite:"+handWhite);
        handBlack.compareTo(handWhite);

        System.out.println(handBlack.getRank().getReason());
    }
}
