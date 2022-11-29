package com.example.checkers.alpha.offline.Checkers.players;

import com.example.checkers.alpha.offline.GameFramework.info.GameInfo;
import com.example.checkers.alpha.offline.GameFramework.players.GameComputerPlayer;

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

    @Override
    protected void receiveInfo(GameInfo info) {

    }
}
