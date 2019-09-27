package com.blackjack.models;

public class Card {

    String kind;
    String value;

    public Card(String kind, String value) {
        this.kind = kind;
        this.value = value;
    }

    public String getKind() {
        return kind;
    }

    public String getValue() {
        return value;
    }
}
