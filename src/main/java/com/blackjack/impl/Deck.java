package com.blackjack.impl;

import com.blackjack.interfaces.DeckInterface;
import com.blackjack.models.Card;
import com.blackjack.models.CardValues;
import com.blackjack.models.Kind;
import com.blackjack.models.Suite;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class Deck implements DeckInterface {

    private List<Suite> fullDeck = new ArrayList<>();

    @Override
    public void initializeDeck() {
        Stream.of(Kind.values()).forEach(this::createDeck);
    }

    @Override
    public void createDeck(Kind kind) {
        Suite suite = new Suite(kind);
        fullDeck.add(suite);
    }

    @Override
    public List<Suite> getFullDeck() {
        return fullDeck;
    }

    @Override
    public Card drawRandomCard() {
        Integer randomKind = ThreadLocalRandom.current().nextInt(Kind.values().length);
        Integer randomValue = ThreadLocalRandom.current().nextInt(CardValues.values().length);
        return new Card(fullDeck.get(randomKind).getKind().toString(), CardValues.values()[randomValue].toString());
    }
}
