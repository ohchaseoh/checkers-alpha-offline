package com.example.game.Checkers;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

import com.example.game.R;

import java.util.ArrayList;

//TODO 1. Edit DisableAllbuttonButOne or update
//TODO 2. Create an alertdialog after either side is winning; asking user to either restart the game or go back to the main menu

//mohammad
public class MainActivity extends AppCompatActivity {

    public ImageButton [][] imageButtonList;
    public Checker [][] checkerList;
    public ArrayList<int[]> possibleMove;
    public ArrayList<int[]> killList;
    public int [] killLocation;
    public boolean turn = true; //true for black's turn, false for white's turn
    public boolean secondClick = false;
    public boolean destroyed = false;
    public int row, column;
    public boolean disableAllButOneButton = false;

    private Button restart;

    //row 1
    public ImageButton ibtn_0_0;
    public ImageButton ibtn_0_1;
    public ImageButton ibtn_0_2;
    public ImageButton ibtn_0_3;
    public ImageButton ibtn_0_4;
    public ImageButton ibtn_0_5;
    public ImageButton ibtn_0_6;
    public ImageButton ibtn_0_7;

    //row 2
    public ImageButton ibtn_1_0;
    public ImageButton ibtn_1_1;
    public ImageButton ibtn_1_2;
    public ImageButton ibtn_1_3;
    public ImageButton ibtn_1_4;
    public ImageButton ibtn_1_5;
    public ImageButton ibtn_1_6;
    public ImageButton ibtn_1_7;

    //row 3
    public ImageButton ibtn_2_0;
    public ImageButton ibtn_2_1;
    public ImageButton ibtn_2_2;
    public ImageButton ibtn_2_3;
    public ImageButton ibtn_2_4;
    public ImageButton ibtn_2_5;
    public ImageButton ibtn_2_6;
    public ImageButton ibtn_2_7;

    //row 4
    public ImageButton ibtn_3_0;
    public ImageButton ibtn_3_1;
    public ImageButton ibtn_3_2;
    public ImageButton ibtn_3_3;
    public ImageButton ibtn_3_4;
    public ImageButton ibtn_3_5;
    public ImageButton ibtn_3_6;
    public ImageButton ibtn_3_7;

    //row 5
    public ImageButton ibtn_4_0;
    public ImageButton ibtn_4_1;
    public ImageButton ibtn_4_2;
    public ImageButton ibtn_4_3;
    public ImageButton ibtn_4_4;
    public ImageButton ibtn_4_5;
    public ImageButton ibtn_4_6;
    public ImageButton ibtn_4_7;

    //row 6
    public ImageButton ibtn_5_0;
    public ImageButton ibtn_5_1;
    public ImageButton ibtn_5_2;
    public ImageButton ibtn_5_3;
    public ImageButton ibtn_5_4;
    public ImageButton ibtn_5_5;
    public ImageButton ibtn_5_6;
    public ImageButton ibtn_5_7;

    //row 7
    public ImageButton ibtn_6_0;
    public ImageButton ibtn_6_1;
    public ImageButton ibtn_6_2;
    public ImageButton ibtn_6_3;
    public ImageButton ibtn_6_4;
    public ImageButton ibtn_6_5;
    public ImageButton ibtn_6_6;
    public ImageButton ibtn_6_7;

    //row 8
    public ImageButton ibtn_7_0;
    public ImageButton ibtn_7_1;
    public ImageButton ibtn_7_2;
    public ImageButton ibtn_7_3;
    public ImageButton ibtn_7_4;
    public ImageButton ibtn_7_5;
    public ImageButton ibtn_7_6;
    public ImageButton ibtn_7_7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkers_human_player1);

        restart = (Button) findViewById(R.id.restart_button);

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(getIntent());
            }
        });

        initializeBoard();

        imageButtonList = new ImageButton[][]
                {{null, ibtn_0_1, null, ibtn_0_3, null, ibtn_0_5, null, ibtn_0_7},
                        {ibtn_1_0, null, ibtn_1_2, null, ibtn_1_4, null, ibtn_1_6, null},
                        {null, ibtn_2_1, null, ibtn_2_3, null, ibtn_2_5, null, ibtn_2_7},
                        {ibtn_3_0, null, ibtn_3_2, null, ibtn_3_4, null, ibtn_3_6, null},
                        {null, ibtn_4_1, null, ibtn_4_3, null, ibtn_4_5, null, ibtn_4_7},
                        {ibtn_5_0, null, ibtn_5_2, null, ibtn_5_4, null, ibtn_5_6, null},
                        {null, ibtn_6_1, null, ibtn_6_3, null, ibtn_6_5, null, ibtn_6_7},
                        {ibtn_7_0, null, ibtn_7_2, null, ibtn_7_4, null, ibtn_7_6, null}};

        checkerList = new Checker[][]
                {{null, new RedChecker(0,1), null, new RedChecker(0,3), null, new RedChecker(0,5), null, new RedChecker(0,7)},
                        {new RedChecker(1,0), null, new RedChecker(1,2),null, new RedChecker(1,4), null, new RedChecker(1,6), null},
                        {null, new RedChecker(2,1), null, new RedChecker(2,3), null, new RedChecker(2,5), null, new RedChecker(2,7)},
                        {null, null, null, null,null, null,null, null},
                        {null, null, null, null,null, null,null, null},
                        {new BlackChecker(5,0), null, new BlackChecker(5,2),null, new BlackChecker(5,4), null, new BlackChecker(5,6), null},
                        {null, new BlackChecker(6,1), null, new BlackChecker(6,3), null, new BlackChecker(6,5), null, new BlackChecker(6,7)},
                        {new BlackChecker(7,0), null, new BlackChecker(7,2),null, new BlackChecker(7,4), null, new BlackChecker(7,6), null}
                };

        updateAllButtons();
        disableButtons();

    }

    private void initializeBoard() {

        //row 1
        ibtn_0_0 = (ImageButton) findViewById(R.id.ibtn_0_0);
        ibtn_0_1 = (ImageButton) findViewById(R.id.ibtn_0_1);
        ibtn_0_2 = (ImageButton) findViewById(R.id.ibtn_0_2);
        ibtn_0_3 = (ImageButton) findViewById(R.id.ibtn_0_3);
        ibtn_0_4 = (ImageButton) findViewById(R.id.ibtn_0_4);
        ibtn_0_5 = (ImageButton) findViewById(R.id.ibtn_0_5);
        ibtn_0_6 = (ImageButton) findViewById(R.id.ibtn_0_6);
        ibtn_0_7 = (ImageButton) findViewById(R.id.ibtn_0_7);

        //row 2
        ibtn_1_0 = (ImageButton) findViewById(R.id.ibtn_1_0);
        ibtn_1_1 = (ImageButton) findViewById(R.id.ibtn_1_1);
        ibtn_1_2 = (ImageButton) findViewById(R.id.ibtn_1_2);
        ibtn_1_3 = (ImageButton) findViewById(R.id.ibtn_1_3);
        ibtn_1_4 = (ImageButton) findViewById(R.id.ibtn_1_4);
        ibtn_1_5 = (ImageButton) findViewById(R.id.ibtn_1_5);
        ibtn_1_6 = (ImageButton) findViewById(R.id.ibtn_1_6);
        ibtn_1_7 = (ImageButton) findViewById(R.id.ibtn_1_7);

        //row 3
        ibtn_2_0 = (ImageButton) findViewById(R.id.ibtn_2_0);
        ibtn_2_1 = (ImageButton) findViewById(R.id.ibtn_2_1);
        ibtn_2_2 = (ImageButton) findViewById(R.id.ibtn_2_2);
        ibtn_2_3 = (ImageButton) findViewById(R.id.ibtn_2_3);
        ibtn_2_4 = (ImageButton) findViewById(R.id.ibtn_2_4);
        ibtn_2_5 = (ImageButton) findViewById(R.id.ibtn_2_5);
        ibtn_2_6 = (ImageButton) findViewById(R.id.ibtn_2_6);
        ibtn_2_7 = (ImageButton) findViewById(R.id.ibtn_2_7);

        //row 4
        ibtn_3_0 = (ImageButton) findViewById(R.id.ibtn_3_0);
        ibtn_3_1 = (ImageButton) findViewById(R.id.ibtn_3_1);
        ibtn_3_2 = (ImageButton) findViewById(R.id.ibtn_3_2);
        ibtn_3_3 = (ImageButton) findViewById(R.id.ibtn_3_3);
        ibtn_3_4 = (ImageButton) findViewById(R.id.ibtn_3_4);
        ibtn_3_5 = (ImageButton) findViewById(R.id.ibtn_3_5);
        ibtn_3_6 = (ImageButton) findViewById(R.id.ibtn_3_6);
        ibtn_3_7 = (ImageButton) findViewById(R.id.ibtn_3_7);

        //row 5
        ibtn_4_0 = (ImageButton) findViewById(R.id.ibtn_4_0);
        ibtn_4_1 = (ImageButton) findViewById(R.id.ibtn_4_1);
        ibtn_4_2 = (ImageButton) findViewById(R.id.ibtn_4_2);
        ibtn_4_3 = (ImageButton) findViewById(R.id.ibtn_4_3);
        ibtn_4_4 = (ImageButton) findViewById(R.id.ibtn_4_4);
        ibtn_4_5 = (ImageButton) findViewById(R.id.ibtn_4_5);
        ibtn_4_6 = (ImageButton) findViewById(R.id.ibtn_4_6);
        ibtn_4_7 = (ImageButton) findViewById(R.id.ibtn_4_7);

        //row 6
        ibtn_5_0 = (ImageButton) findViewById(R.id.ibtn_5_0);
        ibtn_5_1 = (ImageButton) findViewById(R.id.ibtn_5_1);
        ibtn_5_2 = (ImageButton) findViewById(R.id.ibtn_5_2);
        ibtn_5_3 = (ImageButton) findViewById(R.id.ibtn_5_3);
        ibtn_5_4 = (ImageButton) findViewById(R.id.ibtn_5_4);
        ibtn_5_5 = (ImageButton) findViewById(R.id.ibtn_5_5);
        ibtn_5_6 = (ImageButton) findViewById(R.id.ibtn_5_6);
        ibtn_5_7 = (ImageButton) findViewById(R.id.ibtn_5_7);

        //row 7
        ibtn_6_0 = (ImageButton) findViewById(R.id.ibtn_6_0);
        ibtn_6_1 = (ImageButton) findViewById(R.id.ibtn_6_1);
        ibtn_6_2 = (ImageButton) findViewById(R.id.ibtn_6_2);
        ibtn_6_3 = (ImageButton) findViewById(R.id.ibtn_6_3);
        ibtn_6_4 = (ImageButton) findViewById(R.id.ibtn_6_4);
        ibtn_6_5 = (ImageButton) findViewById(R.id.ibtn_6_5);
        ibtn_6_6 = (ImageButton) findViewById(R.id.ibtn_6_6);
        ibtn_6_7 = (ImageButton) findViewById(R.id.ibtn_6_7);

        //row 8
        ibtn_7_0 = (ImageButton) findViewById(R.id.ibtn_7_0);
        ibtn_7_1 = (ImageButton) findViewById(R.id.ibtn_7_1);
        ibtn_7_2 = (ImageButton) findViewById(R.id.ibtn_7_2);
        ibtn_7_3 = (ImageButton) findViewById(R.id.ibtn_7_3);
        ibtn_7_4 = (ImageButton) findViewById(R.id.ibtn_7_4);
        ibtn_7_5 = (ImageButton) findViewById(R.id.ibtn_7_5);
        ibtn_7_6 = (ImageButton) findViewById(R.id.ibtn_7_6);
        ibtn_7_7 = (ImageButton) findViewById(R.id.ibtn_7_7);

    }

    public void myOnClick(View view) {
        if (turn) {//BlackChecker's turn
            if(secondClick == false) {//(first click)
                for (int r = 0; r < imageButtonList.length; r++) {
                    for (int c = 0; c < imageButtonList[r].length; c++) {
                        if (imageButtonList[r][c] != null) {//if imageButtonList[r][c] is not null
                            if (view.getId() == imageButtonList[r][c].getId()) {//get the r and c of the ibtn clicked
                                if (checkerList[r][c] != null) {//if the corresponding location in the checkerList has a checker
                                    if (checkerList[r][c] instanceof BlackChecker) {//if clicked checker is a blackChecker
                                        row = r;
                                        column = c;
                                        Log.d("NoteSaveRow",String.valueOf(row));
                                        Log.d("NoteSaveColumn",String.valueOf(column));
                                        if (destroyed == false) {
                                            possibleMove = checkerList[r][c].getMove(checkerList);//get the possibleMove from BlackChecker class
                                            killList = checkerList[r][c].getKillList();//get the corresponding killList
                                            if (disableAllButOneButton == false) {
                                                updateAllButtons();
                                                disableButtons();
                                            }
                                            for (int i = 0; i < possibleMove.size(); i++) {//go through the possibleMove
                                                int row = possibleMove.get(i)[0];//get each row
                                                int column = possibleMove.get(i)[1];//get each column
                                                imageButtonList[row][column].setClickable(true);//make the possible places clickable
                                                imageButtonList[row][column].setBackgroundColor(Color.WHITE);
                                            }
                                            secondClick = true;
                                        }
                                        else {
                                            destroyed = false;
                                            possibleMove = checkerList[r][c].getMove2(checkerList);//get the possibleMove from BlackChecker class
                                            killList = checkerList[r][c].getKillList();
                                            if (possibleMove.size() != 0) {
                                                for (int i = 0; i < possibleMove.size(); i++) {//go through the possibleMove
                                                    int row = possibleMove.get(i)[0];//get each row
                                                    int column = possibleMove.get(i)[1];//get each column
                                                    disableAllButPossible(possibleMove);
                                                }
                                                secondClick = true;
                                            }
                                            else {
                                                secondClick = false;
                                                turn = false;
                                                updateAllButtons();
                                                disableAllButOneButton(r, c);
                                                disableAllButOneButton = true;
                                            }
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            else {//BlackChecker's turn (Second Click)
                for (int r = 0; r < imageButtonList.length; r++) {
                    for (int c = 0; c < imageButtonList[r].length; c++) {
                        if (imageButtonList[r][c] != null) {
                            if (!(checkerList[r][c] instanceof RedChecker)) {
                                if (view.getId() == imageButtonList[r][c].getId()) {
                                    if (checkerList[r][c] == null) {
                                        checkerList[r][c] = new BlackChecker(checkerList[row][column]);//row and column are the position of the new position, copy the checker to the new position
                                        checkerList[r][c].setRow(r);
                                        checkerList[r][c].setColumn(c);
                                        if(checkerList[r][c].getRow() == 0){
                                            checkerList[r][c].setCrownStatus(true);
                                        }
                                        checkerList[row][column] = null;//delete the checker in the old location
                                        killLocation = getKillCheckerLocation(r, c);
                                        Log.d("NoteKillRow",String.valueOf(r));
                                        Log.d("NoteKillColumn",String.valueOf(c));
                                        if (killLocation != null) {
                                            Log.d("Note",String.valueOf(killLocation.length));
                                            checkerList[killLocation[0]][killLocation[1]] = null;
                                            Log.d("NoteRow",String.valueOf(killLocation[0]));
                                            Log.d("NoteColumn",String.valueOf(killLocation[1]));
                                            destroyed = true;
                                            secondClick = false;
                                            updateAllButtons();
                                            possibleMove = checkerList[r][c].getMove2(checkerList);
                                            Log.d("NotePossible",String.valueOf(possibleMove.size()));
                                            if(possibleMove.size() == 0){
                                                disableAllButOneButton = false;
                                                destroyed = false;
                                                turn = false;
                                                disableButtons();
                                            }
                                            else{
                                                turn = true;
                                                disableAllButOneButton(r, c);
                                                disableAllButOneButton = true;
                                            }
                                        }
                                        else{
                                            disableAllButOneButton = false;
                                            destroyed = false;
                                            secondClick = false;
                                            turn = false;
                                            updateAllButtons();
                                            disableButtons();
                                        }
                                        break;
                                    }
                                    else {//**for the user who wants to change his/her moves
                                        updateAllButtons();//update the layout and made all the buttons clickable
                                        disableButtons();
                                        secondClick = false;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        else {//RedChecker's turn
            if (secondClick == false) {//(First Click)
                for (int r = 0; r < imageButtonList.length; r++) {
                    for (int c = 0; c < imageButtonList[r].length; c++) {
                        if (imageButtonList[r][c] != null) {//if imageButtonList[r][c] is not null
                            if (view.getId() == imageButtonList[r][c].getId()) {//get the r and c of the ibtn clicked
                                if (checkerList[r][c] != null) {//if the corresponding location in the checkerList has a checker
                                    Log.d("Type", checkerList[r][c].getClass().toString());
                                    if (checkerList[r][c] instanceof RedChecker) {//if clicked checker is a blackChecker
                                        row = r;
                                        column = c;
                                        if (destroyed == false) {
                                            possibleMove = checkerList[r][c].getMove(checkerList);//get the possibleMove from BlackChecker class
                                            killList = checkerList[r][c].getKillList();//get the corresponding killList
                                            Log.d("PossibleMove", String.valueOf(possibleMove.size()));
                                            if (disableAllButOneButton == false) {
                                                updateAllButtons();
                                                disableButtons();
                                            }
                                            for (int i = 0; i < possibleMove.size(); i++) {//go through the possibleMove
                                                int row = possibleMove.get(i)[0];//get each row
                                                int column = possibleMove.get(i)[1];//get each column
                                                imageButtonList[row][column].setClickable(true);//make the possible places clickable
                                                imageButtonList[row][column].setBackgroundColor(Color.WHITE);
                                            }
                                            secondClick = true;
                                        }
                                        else {
                                            destroyed = false;
                                            possibleMove = checkerList[r][c].getMove2(checkerList);//get the possibleMove from BlackChecker class
                                            killList = checkerList[r][c].getKillList();
                                            if (possibleMove.size() != 0) {
                                                for (int i = 0; i < possibleMove.size(); i++) {//go through the possibleMove
                                                    int row = possibleMove.get(i)[0];//get each row
                                                    int column = possibleMove.get(i)[1];//get each column
                                                    disableAllButPossible(possibleMove);
                                                }
                                                secondClick = true;
                                            }
                                            else {
                                                secondClick = false;
                                                turn = true;
                                                updateAllButtons();
                                                disableAllButOneButton(r, c);
                                                disableAllButOneButton = true;
                                            }
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            else {//RedChecker's turn (Second Click)
                for (int r = 0; r < imageButtonList.length; r++) {
                    for (int c = 0; c < imageButtonList[r].length; c++) {
                        if (imageButtonList[r][c] != null) {//if imageButtonList[r][c] is not null
                            if (!(checkerList[r][c] instanceof BlackChecker)) {
                                if (view.getId() == imageButtonList[r][c].getId()) {//get the r and c of the ibtn clicked
                                    if(checkerList[r][c] == null) {
                                        checkerList[r][c] = new RedChecker(checkerList[row][column]);//row and column are the position of the new position, copy the checker to the new position
                                        checkerList[r][c].setRow(r);
                                        checkerList[r][c].setColumn(c);
                                        if(checkerList[r][c].getRow() == 7){
                                            checkerList[r][c].setCrownStatus(true);
                                        }
                                        checkerList[row][column] = null;//delete the check in the old location
                                        killLocation = getKillCheckerLocation(r,c);
                                        if(killLocation != null) {
                                            checkerList[killLocation[0]][killLocation[1]] = null;
                                            destroyed = true;
                                            secondClick = false;
                                            updateAllButtons();
                                            possibleMove = checkerList[r][c].getMove2(checkerList);
                                            if(possibleMove.size() == 0){
                                                disableAllButOneButton = false;
                                                destroyed = false;
                                                secondClick = false;
                                                turn = true;
                                                disableButtons();
                                            }
                                            else{
                                                disableAllButOneButton(r, c);
                                                disableAllButOneButton = true;
                                            }
                                        }
                                        else{
                                            disableAllButOneButton = false;
                                            destroyed = false;
                                            secondClick = false;
                                            turn = true;
                                            updateAllButtons();
                                            disableButtons();
                                        }
                                        break;
                                    }
                                    else {
                                        updateAllButtons();//update the layout and made all the buttons clickable
                                        disableButtons();
                                        secondClick = false;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void disableButtons(){//disable unmovable checkers
        if(turn) {//if it is black checkers turn
            for (int r = 0; r < checkerList.length; r++) {
                for (int c = 0; c < checkerList[r].length; c++) {
                    if (checkerList[r][c] instanceof RedChecker) {//if the checker is red (disable all the redCheckers)
                        imageButtonList[r][c].setClickable(false);
                        //imageButtonList[r][c].setBackgroundColor(Color.BLACK);
                    }
                    else if(checkerList[r][c] instanceof BlackChecker){//disable the unmovable blackCheckers
                        if(r == 0){//if the blackChecker is at row 0 (crown)
                            imageButtonList[r][c].setClickable(true);
                        }
                        else {
                            if (c == 0) {
                                if (checkerList[r - 1][c + 1] instanceof BlackChecker) { //if the blackChecker is at column 0 and there is one blackChecker at upper right
                                    imageButtonList[r][c].setClickable(false);
                                    //imageButtonList[r][c].setBackgroundColor(Color.BLACK);
                                }
                            } else if (c == 7) {
                                if (checkerList[r - 1][c - 1] instanceof BlackChecker) {//if the blackChecker is at column 7 and there is one blackChecker at upper left
                                    imageButtonList[r][c].setClickable(false);
                                    //imageButtonList[r][c].setBackgroundColor(Color.BLACK);
                                }
                            } else {//if the blackChecker is located at column 1 - 6
                                if (checkerList[r - 1][c - 1] instanceof BlackChecker && checkerList[r - 1][c + 1] instanceof BlackChecker) {//if there are blackCheckers on both upper left and right
                                    imageButtonList[r][c].setClickable(false);
                                    //imageButtonList[r][c].setBackgroundColor(Color.BLACK);
                                }
                            }
                        }
                    } else {//if the checkerList updates ex: one black checker died, need to update the corresponding image button to not clickable
                        if(imageButtonList[r][c] != null) {
                            imageButtonList[r][c].setClickable(false);
                            //imageButtonList[r][c].setBackgroundColor(Color.BLACK);
                        }
                    }
                }
            }
        } else {//if it is red checkers turn

            for (int r = 0; r < checkerList.length; r++) {
                for (int c = 0; c < checkerList[r].length; c++) {

                    if (checkerList[r][c] instanceof BlackChecker) {//if the checker is black (disable all the blackCheckers)
                        imageButtonList[r][c].setClickable(false);
                        //imageButtonList[r][c].setBackgroundColor(Color.BLACK);
                    }
                    else if(checkerList[r][c] instanceof RedChecker) {//disable the unmovable red Checkers
                        if (r == 7) { //if the red checker is at row 7 (crown)
                            imageButtonList[r][c].setClickable(true);
                        } else {
                            if (c == 0) {
                                if (checkerList[r + 1][c + 1] instanceof RedChecker) { //if the red Checker is at column 0 and there is one redChecker at upper right
                                    imageButtonList[r][c].setClickable(false);
                                    //imageButtonList[r][c].setBackgroundColor(Color.BLACK);
                                }
                            } else if (c == 7) {
                                if (checkerList[r + 1][c - 1] instanceof RedChecker) {//if the blackChecker is at column 7 and there is one blackChecker at upper left
                                    imageButtonList[r][c].setClickable(false);
                                    //imageButtonList[r][c].setBackgroundColor(Color.BLACK);
                                }
                            } else {//if the blackChecker is located at column 1 - 6
                                if (checkerList[r + 1][c - 1] instanceof RedChecker && checkerList[r + 1][c + 1] instanceof RedChecker) {//if there are redCheckers on both upper left and right
                                    imageButtonList[r][c].setClickable(false);
                                    //imageButtonList[r][c].setBackgroundColor(Color.BLACK);
                                }
                            }
                        }

                    } else {//if the checkerList updates ex: one red checker died, need to update the corresponding image button to not clickable
                        if (imageButtonList[r][c] != null) {
                            imageButtonList[r][c].setClickable(false);
                            //imageButtonList[r][c].setBackgroundColor(Color.BLACK);
                        }
                    }
                }
            }
        }
    }

    public void disableAllButOneButton(int row, int column){
        updateAllButtons();
        Log.d("DisableAllButOneButton","called");
        for (int r = 0; r < imageButtonList.length; r++) {
            for (int c = 0; c < imageButtonList[r].length; c++) {
                if(imageButtonList[r][c] != null) {
                    imageButtonList[r][c].setClickable(false);
                }
            }
        }
        imageButtonList[row][column].setClickable(true);
    }

    public void disableAllButPossible(ArrayList <int[]> possiblemove){
        updateAllButtons();
        for (int r = 0; r < imageButtonList.length; r++) {
            for (int c = 0; c < imageButtonList[r].length; c++) {
                if(imageButtonList[r][c] != null) {
                    imageButtonList[r][c].setClickable(false);
                }
            }
        }
        for (int i = 0; i < possibleMove.size(); i++) {//go through the possibleMove
            int row = possibleMove.get(i)[0];//get each row
            int column = possibleMove.get(i)[1];//get each column
            imageButtonList[row][column].setClickable(true);//make the possible places clickable
            imageButtonList[row][column].setBackgroundColor(Color.WHITE);
        }
    }

    public void updateAllButtons(){//update the whole layout based on the contents in checkerList, also make all the imageButtons clickable
        for(int r = 0; r < imageButtonList.length; r++) {
            for (int c = 0; c < imageButtonList[r].length; c++) {
                if (imageButtonList[r][c] != null) {//if the imageButton is not null
                    imageButtonList[r][c].setClickable(true);//make all the imageButtons clickable
                    imageButtonList[r][c].setImageDrawable(null);//Erase all the drawables and background color

                    if (checkerList[r][c] != null) {//in the movable location if the checker in the checkerList is not null
                        if (checkerList[r][c] instanceof BlackChecker) {//if its a BlackChecker
                            if(checkerList[r][c].isCrownStatus() == false) {
                                imageButtonList[r][c].setImageResource(R.drawable.black_dot);//change the image to black dot
                            }
                            else{
                                imageButtonList[r][c].setImageResource(R.drawable.black_crown);
                            }
                        }
                        if (checkerList[r][c] instanceof RedChecker) {//if its a RedChecker
                            if(checkerList[r][c].isCrownStatus() == false) {
                                imageButtonList[r][c].setImageResource(R.drawable.red_dot);//change the image to red dot
                            }
                            else{
                                imageButtonList[r][c].setImageResource(R.drawable.red_crown);
                            }
                        }
                    }
                    imageButtonList[r][c].setBackgroundColor(getResources().getColor(R.color.checker_tan));//set the desirable background color
                }
            }
        }
    }

    public int [] getKillCheckerLocation(int rIndex, int cIndex){
        int [] location = new int [2];
        for (int i = 0; i < possibleMove.size(); i++){
            if(possibleMove.get(i)[0] == rIndex && possibleMove.get(i)[1] == cIndex){
                location = killList.get(i);
                break;
            }
        }
        return location;
    }
}
