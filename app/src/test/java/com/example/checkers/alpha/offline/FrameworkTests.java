package com.example.checkers.alpha.offline;

import android.util.Pair;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import com.example.game.GameFramework.players.GameComputerPlayer;
import com.example.game.GameFramework.players.GameHumanPlayer;
import com.example.game.GameFramework.players.GamePlayer;
import com.example.game.GameFramework.LocalGame;
import com.example.game.GameFramework.config.GameConfig;
import com.example.game.GameFramework.util.Logger;
import com.example.game.GameFramework.util.Saving;
import com.example.game.R;
import com.example.game.Checkers.CheckersMainActivity;
import com.example.game.Checkers.info.CheckerState;

import static org.junit.Assert.*;

/**
 * @author Alex, Chase, Mohammed
 *
 * This is used to verify the functionality of the Framework
 */

@RunWith(RobolectricTestRunner.class)
public class FrameworkTests {

    public CheckersMainActivity activity;

    @Before
    public void setup() throws Exception {
        activity = Robolectric.buildActivity(CheckersMainActivity.class).create().resume().get();
    }

    //Verifies the default config has the same port number as the activity
    //Also verifies the test_gameConfig returns true
    @Test
    public void test_createDefaultConfig() {
        GameConfig gameConfig = activity.createDefaultConfig();
        Pair<Boolean, String> pair = gameConfig.test_gameConfig();
        assertTrue(pair.second, pair.first);
        assertEquals("Port Num Mismatch: GameConfig=" + gameConfig.getPortNum() +
                " != Activity=" + activity.PORT_NUMBER, gameConfig.getPortNum(), activity.PORT_NUMBER);
    }

    //Verifies a local Game can be created
    @Test
    public void test_createLocalGame(){
        LocalGame localGame = activity.createLocalGame(new CheckerState());
        assertTrue("GameState was null", localGame.getGameState() != null);
    }

    //Verifies the configuration can be saved and loaded
    @Test
    public void test_saveConfig(){
        GameConfig gameConfig = activity.createDefaultConfig();
        gameConfig.removePlayer(1);
        gameConfig.addPlayer("Test", 0);
        String fileName = "savedTestConfig0000.dat";
        assertTrue("Failed to Save GameConfig", gameConfig.saveConfig(fileName, activity));
        GameConfig restoreConfig = activity.createDefaultConfig();
        assertTrue("Failed to Load GameConfig", restoreConfig.saveConfig(fileName, activity));
        assertEquals("Did not properly reload GameConfig", restoreConfig, gameConfig);
    }

    //"Clicks" the save Config Button to verify that it works
    @Test
    public void test_saveConfigButton() {
        GameConfig gameConfig = activity.getConfig();
        ((EditText) activity.tableRows.get(1).findViewById(R.id.playerNameEditText)).setText("Test");
        ((Spinner) activity.tableRows.get(1).findViewById(R.id.playerTypeSpinner)).setSelection(2); //may need to modify
        gameConfig.removePlayer(1);
        gameConfig.addPlayer("Test", 0); //may need to modify
        View view = activity.findViewById(R.id.saveConfigButton);
        activity.onClick(view);
        CheckersMainActivity reloadActivity = Robolectric.buildActivity(CheckersMainActivity.class).create().resume().get();
        assertTrue("Failed to Load GameConfig", reloadActivity != null);
        GameConfig restoreConfig = reloadActivity.getConfig();
        assertEquals("Did not properly reload GameCOnfig", restoreConfig, gameConfig);
    }

    @Test
    public void test_save_game() {
        //TODO: Make a game state here
        //will make it after CheckerState is done
    }

    //Tests players can be added to the max and removed to the min
    public void test_add_delete_player() {
        int before = activity.tableRows.size();
        int maxPlayers = activity.getConfig().getMaxPlayers();
        int minPlayers = activity.getConfig().getMinPlayers();
        View view = activity.findViewById(R.id.addPlayerButton);
        for(int i = before; i < maxPlayers; i++){
            activity.onClick(view);
            assertEquals("Couldn't add player #" + before, before+=1, activity.tableRows.size());
        }
        assertEquals("Couldn't add players to the max player size", before, maxPlayers);
        activity.onClick(view);
        assertEquals("Was able to add above the max player cpunt", maxPlayers, activity.tableRows.size());
        //view = activity.findViewById(R.id.delPlayerButton);
        for(int i = before; i > minPlayers; i--) {
            activity.onClick(activity.tableRows.get(i-1).findViewById(R.id.delPlayerButton));
            assertEquals("Couldn't remove player #" + before, before-=1, activity.tableRows.size());
        }
        activity.onClick(activity.tableRows.get(minPlayers-1).findViewById(R.id.delPlayerButton));
        assertEquals("Was able to remove below the minimum player count",minPlayers,activity.tableRows.size());
    }

    //Verifies a game can be started
    @Test
    public void test_startGame(){
        View view = activity.findViewById(R.id.playGameButton);
        activity.onClick(view);
        assertFalse("Game was null", activity.isGameNull());
    }

    //Verifies Toast can be turned on and off
    @Test
    public void logger_toast_test(){
        Logger.setContext(activity.getApplicationContext());
        Logger.setToastValue(true); //For Testing the switch
        View view = activity.findViewById(R.id.onScreenLogging);
        ((CheckBox)view).setChecked(false);
        activity.onClick(view);
        assertFalse("Toast value of logger was not false",Logger.getToastValue());
        ((CheckBox)view).setChecked(true);
        activity.onClick(view);
        assertTrue("Toast value of logger was not true", Logger.getToastValue());
    }

    // Verifies Debug mode can be turned on and off
    @Test
    public void test_logger_debug() {
        Logger.setContext(activity.getApplicationContext());
        Logger.setDebugValue(true); //For Testing the switch
        View view = activity.findViewById(R.id.debugLogging);
        ((CheckBox)view).setChecked(false);
        activity.onClick(view);
        assertFalse("Debug value of logger was not false",Logger.getDebugValue());
        ((CheckBox)view).setChecked(true);
        activity.onClick(view);
        assertTrue("Debug value of logger was not true", Logger.getDebugValue());
    }

    //Verifies setGameOver still sets the Game as over
    @Test
    public void test_setGameOver(){
        activity.setGameOver(true);
        assertTrue("setGameOver has been overwritten but isGameOver wasn't modified", activity.getGameOver());
        activity.setGameOver(false);
        assertFalse("setGameOver has been overwritten but isGameOver wasn't modified", activity.getGameOver());
    }

    //Verifies that human players support and require a GUI while Computer Players don't
    //Tests if activities are equal
    @Test
    public void test_players() {
        View view = activity.findViewById(R.id.playGameButton);
        activity.onClick(view);
        assertTrue("Game was not an instanceof LocalGame", activity.getGame() instanceof LocalGame);
        LocalGame localGame = (LocalGame) activity.getGame();
        GamePlayer[] gamePlayers = localGame.getPlayers();
        for (GamePlayer gamePlayer : gamePlayers) {
            if (gamePlayer instanceof GameHumanPlayer) {
                assertTrue("Human Player " + gamePlayer.toString() + " does not require a gui.", gamePlayer.requiresGui());
                assertTrue("Human Player " + gamePlayer.toString() + " does not support a gui.", gamePlayer.supportsGui());
                assertEquals("Activities were not equal", activity, gamePlayer.getActivity());
            }
            if (gamePlayer instanceof GameComputerPlayer) {
                assertFalse("Computer Player " + gamePlayer.toString() + " requires a gui.", gamePlayer.requiresGui());
                assertNull("Activity was not null before being set", gamePlayer.getActivity());
                gamePlayer.gameSetAsGui(activity);
                assertEquals("Activities were not equal", activity, gamePlayer.getActivity());
            }
        }
    }


}
