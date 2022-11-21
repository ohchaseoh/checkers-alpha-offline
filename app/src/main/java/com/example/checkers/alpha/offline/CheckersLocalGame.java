package com.example.checkers.alpha.offline;

import com.example.checkers.alpha.offline.GameAction;

/**
 * The local game class of Checkers; handles the sending and receiving
 * of actions to and from the master game state and the players
 *
 * @author Alex
 * @author Chase
 * @author Mohammad
 */
public class CheckersLocalGame extends LocalGame {

   //The master game state of which all player game states are copies
    private CheckersGameState gameState;

    /**
     * Sends the updated game state to the specified player.
     * If the master game state does not exist yet, it is created
     * @param p The player to send the game state to
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        if(this.gameState == null) {
            this.gameState = new CheckersGameState();
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
