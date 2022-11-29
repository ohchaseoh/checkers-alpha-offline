package com.example.game.Checkers.info;

import com.example.game.GameFramework.info.GameState;
import java.io.Serializable;

/**
 * Represents the entire game state of Checkers
 * @authors Alex, Chase, Mohammad
 */

public class CheckerState extends GameState implements Serializable{
    public static final int MAX_PLAYERS = 2;

    public CheckerState() {
        super();
    }

    public CheckerState(CheckerState orig) {
        super();
    }
}
