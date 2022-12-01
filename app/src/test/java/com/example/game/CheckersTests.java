package com.example.game;

import android.view.MotionEvent;
import android.view.View;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;


import com.example.game.GameFramework.action.MyNameIsAction;
import com.example.game.GameFramework.action.ReadyAction;
import com.example.game.GameFramework.players.GamePlayer;
import com.example.game.R;
import com.example.game.Checkers.CheckersLocalGame;
import com.example.game.Checkers.CheckersMainActivity;
import com.example.game.Checkers.info.CheckerState;

import static org.junit.Assert.*;

/**
 * @authors Alex, Chase, Mohammed
 */

@RunWith(RobolectricTestRunner.class)
public class CheckersTests {

    public CheckersMainActivity activity;

    @Before
    public void setup() throws Exception {
        activity = Robolectric.buildActivity(CheckersMainActivity.class).create().resume().get();
    }

    @Test
    public void test_checkGamePlay(){
        //starting the game
        View view = activity.findViewById(R.id.playGameButton);
        activity.onClick(view);
        //Getting the created game
        CheckersLocalGame checkersLocalGame = (CheckersLocalGame) activity.getGame();
        //Getting the players
        GamePlayer[] gamePlayers = checkersLocalGame.getPlayers();
        //Sending the names of the players to the game
        for(GamePlayer gp : gamePlayers) {
            checkersLocalGame.sendAction(new MyNameIsAction(gp, gp.getClass().toString()));
        }
        //Telling the game everyone is ready
        for(GamePlayer gp : gamePlayers) {
            checkersLocalGame.sendAction(new ReadyAction(gp));
        }

        GamePlayer player1 = gamePlayers[0];
        GamePlayer player2 = gamePlayers[1];



    }

    //Tests focused on the state: copy constructors and equals
    //This tests the copy constructor when nothing is set
    @Test
    public void test_CopyConstructorOfState_Empty(){
        CheckerState checkerState = new CheckerState();
        CheckerState copyState = new CheckerState(checkerState);
        assertTrue("Copy Constructor did not produce equal States", checkerState.equals(copyState));
    }

    //Make state that looks like a game that'd be in progress
    @Test
    public void test_CopyConstructorOfState_InProgress(){
        CheckerState checkerState = new CheckerState();
        checkerState.setWhoseMove(1);
        checkerState.setPiece(3,0, checkerState.getPiece(2,1));
        checkerState.setPiece(4,1, checkerState.getPiece(5,0));
        checkerState.setPiece(3,4, checkerState.getPiece(2,3));
        CheckerState copyState = new CheckerState(checkerState);
        assertTrue("Copy Constructor did not produce equal States", checkerState.equals(copyState));
    }

    @Test
    public void test_Equals_State_Empty(){
        CheckerState checkerState = new CheckerState();
        CheckerState otherState = new CheckerState();
        assertTrue("Equals method did not agree the States where equal",checkerState.equals(otherState));
    }


}
