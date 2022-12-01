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


    }


}
