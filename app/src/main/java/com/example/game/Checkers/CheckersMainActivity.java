package com.example.game.Checkers;

import com.example.game.GameFramework.GameMainActivity;
import com.example.game.GameFramework.players.GamePlayer;
import com.example.game.GameFramework.LocalGame;
import com.example.game.GameFramework.info.GameState;
import com.example.game.GameFramework.util.*;
import com.example.game.GameFramework.config.GameConfig;
import com.example.game.GameFramework.config.GamePlayerType;


import com.example.game.Checkers.info.CheckerState;
import com.example.game.Checkers.players.CheckersComputerPlayer;
import com.example.game.Checkers.players.CheckersHumanPlayer;
import com.example.game.R;

import java.util.ArrayList;

/**
 * Creates the default configuration for the game, the local game controlling the entire game
 * @authors Alex, Chase, Mohammad
 */

public class CheckersMainActivity extends GameMainActivity {

    private static final String TAG = "CheckersMainActivity";
    public static final int PORT_NUMBER = 2278;

    @Override
    public GameConfig createDefaultConfig() {
        //Define the allowed player typed
        ArrayList<GamePlayerType> playerTypes = new ArrayList<>();

        playerTypes.add(new GamePlayerType("Human (Local)") {
            public GamePlayer createPlayer(String name) {
                //return new CheckersHumanPlayer(name);

                return new CheckersHumanPlayer(name, R.layout.checkers_human_player1);

            }
        });

        playerTypes.add(new GamePlayerType("Computer (Dumb)") {

            public GamePlayer createPlayer(String name) {
                return new CheckersComputerPlayer(name, false);
            }
        });

        playerTypes.add(new GamePlayerType("Computer (Smart)") {

            public GamePlayer createPlayer(String name) {
                return new CheckersComputerPlayer(name, true);
            }
        });

        //Create the game configuration object with the max and min number of players
        //and the game name and add the default players to it
        GameConfig defaultConfig = new GameConfig(playerTypes, 2,
                CheckerState.MAX_PLAYERS, "Checkers", PORT_NUMBER);

        defaultConfig.addPlayer("Human", 0);
        defaultConfig.addPlayer("Computer", 2);

        //Set the initial information for the remote player
        defaultConfig.setRemoteData("Remote Player", "", 1);
        return defaultConfig;
    }

    /**
     * createLocalGame
     *
     * Creates a new game that runs on the server tablet
     * @param gameState
     *              The desired gameState to start at or null for new game
     *
     * @return a new, game-specific instance of a sub-class of the LocalGame class
     */
    @Override
    public LocalGame createLocalGame(GameState gameState) {
        if(gameState == null) {
            return new CheckersLocalGame();
        }
        return new CheckersLocalGame((CheckerState) gameState);
    }

    /**
     * saveGame, adds this games prepend to the filename
     *
     * @param gameName
     * 				Desired save name
     * @return String representation of the save
     */

    @Override
    public GameState saveGame(String gameName) {
        return super.saveGame(getGameString(gameName));
    }

    /**
     * loadGame, adds this games prepend to the desire file to open and creates the game specific state
     * @param gameName
     * 				The file to open
     * @return The loaded GameState
     */

    @Override
    public GameState loadGame(String gameName){
        String appName = getGameString(gameName);
        super.loadGame(appName);
        Logger.log(TAG, "Loading: " + gameName);
        return new CheckerState((CheckerState) Saving.readFromFile(appName, this.getApplicationContext()));
    }
}
