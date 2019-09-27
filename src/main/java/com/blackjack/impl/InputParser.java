package com.blackjack.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputParser {
    private static final Logger log = LoggerFactory.getLogger(InputParser.class);

    public static String readInput() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            return br.readLine();
        } catch (IOException ex) {
            log.error("Caught exception", ex);
            return null;
        }
    }
}
