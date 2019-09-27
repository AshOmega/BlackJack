package com.blackjack.interfaces;

import com.blackjack.models.Card;
import com.blackjack.models.Kind;
import com.blackjack.models.Suite;

import java.util.List;

public interface DeckInterface {

    public void initializeDeck();

    public void createDeck(Kind kind);

    public List<Suite> getFullDeck();

    public Card drawRandomCard();

}
