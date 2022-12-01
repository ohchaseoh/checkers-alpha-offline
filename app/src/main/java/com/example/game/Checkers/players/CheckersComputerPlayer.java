package com.example.game.Checkers.players;

import com.example.game.Checkers.BlackChecker;
import com.example.game.Checkers.Checker;
import com.example.game.Checkers.RedChecker;
import com.example.game.Checkers.info.CheckerState;
import com.example.game.GameFramework.info.GameInfo;
import com.example.game.GameFramework.players.GameComputerPlayer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents the Checkers AI computer player and contains all the logic for it to
 * make its moves in the game
 * @author Alex
 * @author Chase
 * @author Mohammad
 */
public class CheckersComputerPlayer extends GameComputerPlayer {

    // Defines whether this is the smart AI or the dumb AI
    private boolean isSmart;
    /**
     * Creates a new computer player with the specified name and smartness.
     *
     * @param name The name of the computer player
     * @param isSmart True if the AI is to be smart, false otherwise
     *
     */
    public CheckersComputerPlayer(String name,  boolean isSmart) {
        super(name);
        this.isSmart =  isSmart;
    }

    //black = 0
    //red = 1
    @Override
    protected void receiveInfo(GameInfo info) {
        //all the pieces that can move on the computer side of the game
        /*

        ArrayList<Object> availablePieces = new ArrayList<>();
        for (int i = 0; i < 8; i++){
            for(int k = 0; k < 8; k++){
                if (CheckerState.checkerList(i, k) == 1){
                    return;
                }
                if (CheckerState.board(i, k) == 3){
                    sleep(1);
                }
                Checker c = CheckerState.getPiece(i, k);
                if (playerNum == 0 && c.pieceColor() == Piece.ColorType.RED){
                    availablePieces.add(c);
                } else if (playerNum == 1 && c.pieceColor() == Piece.ColorType.BLACK) {
                    availablePieces.add(c);
                }
                    //black and red each checker doesn't have attached color assigned to it. both red and black are checkers don't have colors assigned to them.
                    //reference image button,
            }
        }

        //shuffles checkers in the array
        Collections.shuffle(availablePieces);
        selection = availablePieces.get(0);
        for (int i = 1; i < availablePieces.size(); i++){
            if (checkMove(selection, CheckerState)){
                selection = availablePieces.get(i);
            }
        }

        int xVal = selection.getX();
        int yVal = selection.getY();

        xVal = BlackChecker.getX().get(ints.get(0));
        yVal = RedChecker.getY().get(ints.get(0));
        if (selection.getPieceColor() == Piece.ColorType.BLACK){
            if (yVal == 7){
                sendPromotionAction(xVal, yVal, Piece.ColorType.BLACK);
            }
        } else if (selection.getPieceColor() == Piece.ColorType.RED){
            if (yVal == 0) {
                sendPromotionAction(xVal, yVal, Piece.ColorType.RED);
            }
        }
        game.sendAction(new CheckerMoveAction(this, xVal, yVal));

         */
    }
}
