package com.example.game.Checkers;

import java.util.ArrayList;

public class Checker {
    private int row;
    private int column;
    private int colorNum;
    private boolean crownStatus;

    public Checker(int row, int column){
        this.row = row;
        this.column = column;
        this.colorNum = 0;
        this.crownStatus = false;
    }

    public Checker(Checker checker){
        this.row = checker.getRow();
        this.column = checker.getColumn();
        this.colorNum = checker.getColorNum();
        this.crownStatus = checker.isCrownStatus();
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getColorNum() { return colorNum; }

    public void setColorNum(int colorNum) { this.colorNum = colorNum; }

    public boolean isCrownStatus() {
        return crownStatus;
    }

    public void setCrownStatus(boolean crownStatus) {
        this.crownStatus = crownStatus;
    }

    public ArrayList<int[]> getMove(Checker[][] checkerList) {
        return null;
    }

    public ArrayList<int[]> getMove2(Checker[][] checkerList) {
        return null;
    }

    public ArrayList<int[]> getKillList() {
        return null;
    }
}
