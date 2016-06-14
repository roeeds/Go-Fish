package com.example.user.gofish;

import java.util.Stack;

public class GameDeck {
    private Stack<Integer> deckstack;
    public GameDeck(Deck d) {

        deckstack = d.getCdeck();
    }

    public int takecard(){
        if (deckstack.empty())
            return -1;
        else {
            return deckstack.pop() / 4;  //*********check***************
        }
    }

}
