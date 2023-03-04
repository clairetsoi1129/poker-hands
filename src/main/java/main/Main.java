package main;

import model.Hand;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input 5 cards on black side: eg. JH JC TS QD KH");
        String blackSide = scanner.nextLine().trim();
        System.out.println("Please input 5 cards on white side: eg. QC KD 8H AS 8C");
        String whiteSide = scanner.nextLine().trim();

        Hand handBlack = new Hand(blackSide);
        Hand handWhite = new Hand(whiteSide);
        handBlack.compareTo(handWhite);
        System.out.println(handBlack.getRank().getReason());
    }
}
