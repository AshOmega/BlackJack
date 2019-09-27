package com.blackjack.models;

import java.util.ArrayList;
import java.util.List;

public class Suite {

    List<String> values;
    Kind kind;

    public Suite(Kind kind) {
        this.kind = kind;
        values = new ArrayList<>();
        for (CardValues card : CardValues.values())
            values.add(card.toString());
    }

    public Kind getKind() {
        return kind;
    }
}
