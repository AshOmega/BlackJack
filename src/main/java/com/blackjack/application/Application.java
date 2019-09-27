package com.blackjack.application;

import com.blackjack.impl.GameRule;
import com.blackjack.interfaces.DeckInterface;
import com.blackjack.impl.Deck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        log.info("Initializing app");
        DeckInterface deck = new Deck();
        GameRule gameRule = new GameRule();
        deck.initializeDeck();

        Integer cardValue = 0;
        do {
            cardValue = gameRule.drawCard(deck, cardValue);
            if(cardValue != 0) {
                Integer returnValue = gameRule.play(cardValue);
                if (returnValue == -1) {
                    System.out.println("BETTER LUCK NEXT TIME");
                    break;
                } else if (returnValue == 1) {
                    System.out.println("HURRAY!!!!");
                    break;
                }
            }
            else
                break;
        }
        while ("y".equalsIgnoreCase("Y"));
    }
}
