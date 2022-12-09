package com.example.game.Checkers;

import com.example.game.GameFramework.action.GameAction;
import com.example.game.GameFramework.players.GamePlayer;

public class CheckersMoveAction extends GameAction {
    private int fromX, fromY;
    private int toX, toY;

    public CheckersMoveAction(GamePlayer p, int fromXVal, int fromYVal, int toXVal, int toYVal){
        super(p);
        fromX = fromXVal;
        fromY = fromYVal;
        toX = toXVal;
        toY = toYVal;

    }

    public int getToX(){
        return toX;
    }

    public int getFromX(){
        return fromX;
    }

    public int getToY(){
        return toY;
    }

    public int getFromY(){
        return fromY;
    }
}
