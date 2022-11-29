package com.example.game.Checkers;

import com.example.game.Checkers.info.CheckerState;
import com.example.game.GameFramework.LocalGame;
import com.example.game.GameFramework.action.GameAction;
import com.example.game.GameFramework.players.GamePlayer;

/**
 * The local game class of Checkers; handles the sending and receiving
 * of actions to and from the master game state and the players
 * @authors Alex, Chase, Mohammad
 */
public class CheckersLocalGame extends LocalGame {

   //The master game state of which all player game states are copies
    private CheckerState gameState;

    /**
     * Sends the updated game state to the specified player.
     * If the master game state does not exist yet, it is created
     * @param p The player to send the game state to
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        if(this.gameState == null) {
            this.gameState = new CheckerState();
        }
    }

    @Override
    protected boolean canMove(int playerIdx) {
        return false;
    }

    @Override
    protected String checkIfGameOver() {
        return null;
    }

    @Override
    protected boolean makeMove(GameAction action) {
        return false;
    }
}
