package com.blackjack.impl;

import com.blackjack.constants.BlackjackConstants;
import com.blackjack.interfaces.DeckInterface;
import com.blackjack.models.Card;
import com.blackjack.models.CardValues;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameRule {
    private static final Logger log = LoggerFactory.getLogger(GameRule.class);

    public Integer play(Integer value) {

        if (value < BlackjackConstants.WIN) {
            System.out.println("You can continue the game :: current score --> " + value);
            return value;
        } else if (value > BlackjackConstants.WIN) {
            System.out.println("YOU LOSE!!!");
            return -1;
        } else {
            System.out.println("CONGRATS !!! You WON !!!");
            return 1;
        }
    }

    public Integer drawCard(DeckInterface deck, Integer value) {
        String input;
        Integer newValue;
        System.out.println("Enter input (y - continue)");
        input = InputParser.readInput();
        if (input == null || !input.equalsIgnoreCase("y")) {
            log.error("Unable to proceed ahead");
            return 0;
        }
        Card randomCard = deck.drawRandomCard();
        System.out.println(randomCard.getKind());
        System.out.println(randomCard.getValue());
        newValue = CardValues.valueOf(randomCard.getValue()).getValue();

        //ACE can be 1 or 11
        if (newValue == 1) {
            if (value + BlackjackConstants.ALT_ACE_VALUE <= BlackjackConstants.WIN)
                newValue = 11;
        }

        value += newValue;

        return value;
    }
}