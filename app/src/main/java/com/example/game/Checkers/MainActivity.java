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
*/
public class MainActivity extends AppCompatActivity {
    public Checker[][] checkerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkers_human_player1);


    }
}
/*
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
}
*/