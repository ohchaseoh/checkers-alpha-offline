package com.example.game.Checkers.info;

import com.example.game.GameFramework.info.GameState;
import java.io.Serializable;

/**
 * Represents the entire game state of Checkers
 * @authors Alex, Chase, Mohammad
 */

public class CheckerState extends GameState implements Serializable {

    private static final String TAG = "CheckerState";
    public static final int MAX_PLAYERS = 2;


    private char[][] board;

    private int playerToMove;

    public CheckerState() {
        super();
        board = new char[8][8];
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                board[i][j] = ' ';
            }
        }
        playerToMove = 0;
    }

    public CheckerState(CheckerState orig) {
        super();
        board = new char[8][8];
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                board[i][j] = orig.board[i][j];
            }
        }

        playerToMove = orig.playerToMove;
        super.numSetupTurns = orig.numSetupTurns;
        super.currentSetupTurn = orig.currentSetupTurn;
    }

    public char getPiece(int row, int col) {
        // if we're out of bounds or anything, return '?';
        if (board == null || row < 0 || col < 0) return '?';
        if (row >= board.length || col >= board[row].length) return '?';

        // return the character that is in the proper position
        return board[row][col];
    }

    public void setPiece(int row, int col, char piece) {
        // if we're out of bounds or anything, return;
        if (board == null || row < 0 || col < 0) return;
        if (row >= board.length || col >= board[row].length) return;

        // return the character that is in the proper position
        board[row][col] = piece;
    }

    //Tells whos move it is
    public int getWhoseMove() {
        return playerToMove;
    }

    //Set whos move it is
    public void setWhoseMove(int id) {
        playerToMove = id;
    }


    public boolean equals(Object object){
        if(! (object instanceof CheckerState)) return false;
        CheckerState checkerState = (CheckerState) object;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(this.board[i][j] != CheckerState.board[i][j]){
                    return false;
                }
            }
        }

        if (this.playerToMove != CheckerState.playerToMove || this.numSetupTurns != CheckerState.numSetupTurns || this.currentSetupTurn != CheckerState.currentSetupTurn){
            return false;
        }
        return true;
    }
}
