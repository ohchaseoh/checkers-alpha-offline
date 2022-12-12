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


    /**
     * Sends the updated game state to the specified player.
     * If the master game state does not exist yet, it is created
     * @param p The player to send the game state to
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        if(this.state == null) {
            this.state = new CheckerState();
        }
    }

    @Override
    protected boolean canMove(int playerIdx) {
        CheckerState theState = (CheckerState)state;
        if (theState.getWhoseMove() == playerIdx){
            return true;
        }
        return false;
    }

    @Override
    protected String checkIfGameOver() {
        //return a string if game is over.
        //else return null

        return null;
    }

    @Override
    protected boolean makeMove(GameAction action) {
        //this.state is the GameState
        CheckerState theState = (CheckerState)state;
        if(action instanceof CheckersMoveAction)
        {
            CheckersMoveAction theAction = (CheckersMoveAction) action;
            //if valid, is it this player's turn?
            GamePlayer p = theAction.getPlayer();
            int playerIndex = getPlayerIdx(p);
            if (canMove(playerIndex)) {


                int toX = theAction.getToX();
                int toY = theAction.getToY();
                int fromX = theAction.getFromX();
                int fromY = theAction.getFromY();
                //find piece to be moved
                char thePiece = theState.getPiece(fromX, fromY);
                //check that the piece can move to the toX, toY
                //TODO
                //if yes, then update the state, if not return false

                // TODO: update state
                theState.setPiece(fromX, fromY, ' ');
                theState.setPiece(toX, toY, thePiece);
                return true;
                //return true
            }
        }

        return false;
    }
}
