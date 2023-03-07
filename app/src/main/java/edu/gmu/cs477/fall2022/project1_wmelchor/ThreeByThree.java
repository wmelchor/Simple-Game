package edu.gmu.cs477.fall2022.project1_wmelchor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ThreeByThree extends AppCompatActivity {

    private ArrayList<Integer> game;
    private final int rowCount = 3;
    private final int columnCount = 3;
    private Button[] gameButtons;
    private TextView instructions;
    private final int totalTiles = 9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_three_by_three);
        initializeGame();
        buildGuiByCode();
    }

    public void buildGuiByCode() {
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        int w = size.x / 3;
        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(columnCount);
        gridLayout.setRowCount(rowCount + 1);
        gameButtons = new Button[game.size()];
        ButtonHandler bh = new ButtonHandler();
        for (int i = 0; i < game.size(); i++) {
            gameButtons[i] = new Button(this);
            gameButtons[i].setTextSize((float) ((int)w*.2));
            gameButtons[i].setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.teal_200, getTheme())));
            if(game.get(i) != 0)
                gameButtons[i].setText(String.valueOf(game.get(i)));
            gridLayout.addView(gameButtons[i], w, w);
            gameButtons[i].setOnClickListener(bh);
        }
        instructions = new TextView(this);
        instructions.setText("Have fun!");
        gridLayout.addView(instructions, w, w);

        gridLayout.setBackgroundColor(getResources().getColor(R.color.white, getTheme()));
        setContentView(gridLayout);
    }

    /*public ThreeByThree() {
        initializeGame();
    }*/

    private class ButtonHandler implements View.OnClickListener {
        public void onClick(View v) {
            /*for (int i = 0; i < game.size(); i++) {
                //for (int column=0; column < columnCount; column++)
                if (v == gameButtons[i]) {
                    update(i);
                }
            }*/
            int i = 0;
            while (!winGame()) {
                if (v == gameButtons[i]) {
                    update(i);
                    break;
                }
                i++;
                if(i > game.size()) {
                    i = 0;
                }
            }
        }
    }

    public void update(int position) {
        /* A position on the game can only interact with the blank space
         * on the board. This allows for only interactions between the space
         * next to the black space and above/below the blank space. gameButton[0]
         * is the top left corner of the board, so it can only interact with [1] or
         * [3], I need to code it in this way for each position */
        switch(position) {
            case 0:
                if (game.get(1) == 0) {
                    game.set(1, game.get(position));
                    gameButtons[1].setText(String.valueOf(game.get(position)));
                    game.set(position, 0);
                    gameButtons[position].setText("");
                }
                else if(game.get(3) == 0) {
                    game.set(3, game.get(position));
                    gameButtons[3].setText(String.valueOf(game.get(position)));
                    game.set(position, 0);
                    gameButtons[position].setText("");
                }
                else
                    Toast.makeText(ThreeByThree.this, "Touch the tile next to the empty space", Toast.LENGTH_LONG).show();
                break;
            case 1:
                if(game.get(0) == 0) {
                    game.set(0, game.get(position));
                    gameButtons[0].setText(String.valueOf(game.get(position)));
                    game.set(position, 0);
                    gameButtons[position].setText("");
                }
                else if(game.get(2) == 0) {
                    game.set(2, game.get(position));
                    gameButtons[2].setText(String.valueOf(game.get(position)));
                    game.set(position, 0);
                    gameButtons[position].setText("");
                }
                else if(game.get(4) == 0) {
                    game.set(4, game.get(position));
                    gameButtons[4].setText(String.valueOf(game.get(position)));
                    game.set(position, 0);
                    gameButtons[position].setText("");
                }
                else
                    Toast.makeText(ThreeByThree.this, "Touch the tile next to the empty space", Toast.LENGTH_LONG).show();
                break;
            case 2:
                if(game.get(1) == 0) {
                    game.set(1, game.get(position));
                    gameButtons[1].setText(String.valueOf(game.get(position)));
                    game.set(position, 0);
                    gameButtons[position].setText("");
                }
                else if(game.get(5) == 0) {
                    game.set(5, game.get(position));
                    gameButtons[5].setText(String.valueOf(game.get(position)));
                    game.set(position, 0);
                    gameButtons[position].setText("");
                }
                else
                    Toast.makeText(ThreeByThree.this, "Touch the tile next to the empty space", Toast.LENGTH_LONG).show();
                break;
            case 3:
                if(game.get(0) == 0) {
                    game.set(0, game.get(position));
                    gameButtons[0].setText(String.valueOf(game.get(position)));
                    game.set(position, 0);
                    gameButtons[position].setText("");
                }
                else if(game.get(4) == 0) {
                    game.set(4, game.get(position));
                    gameButtons[4].setText(String.valueOf(game.get(position)));
                    game.set(position, 0);
                    gameButtons[position].setText("");
                }
                else if(game.get(6) == 0) {
                    game.set(6, game.get(position));
                    gameButtons[6].setText(String.valueOf(game.get(position)));
                    game.set(position, 0);
                    gameButtons[position].setText("");
                }
                else
                    Toast.makeText(ThreeByThree.this, "Touch the tile next to the empty space", Toast.LENGTH_LONG).show();
                break;
            case 4:
                if(game.get(1) == 0) {
                    game.set(1, game.get(position));
                    gameButtons[1].setText(String.valueOf(game.get(position)));
                    game.set(position, 0);
                    gameButtons[position].setText("");
                }
                else if(game.get(3) == 0) {
                    game.set(3, game.get(position));
                    gameButtons[3].setText(String.valueOf(game.get(position)));
                    game.set(position, 0);
                    gameButtons[position].setText("");
                }
                else if(game.get(5) == 0) {
                    game.set(5, game.get(position));
                    gameButtons[5].setText(String.valueOf(game.get(position)));
                    game.set(position, 0);
                    gameButtons[position].setText("");
                }
                else if(game.get(7) == 0) {
                    game.set(7, game.get(position));
                    gameButtons[7].setText(String.valueOf(game.get(position)));
                    game.set(position, 0);
                    gameButtons[position].setText("");
                }
                else
                    Toast.makeText(ThreeByThree.this, "Touch the tile next to the empty space", Toast.LENGTH_LONG).show();
                break;
            case 5:
                if(game.get(2) == 0) {
                    game.set(2, game.get(position));
                    gameButtons[2].setText(String.valueOf(game.get(position)));
                    game.set(position, 0);
                    gameButtons[position].setText("");
                }
                else if(game.get(4) == 0) {
                    game.set(4, game.get(position));
                    gameButtons[4].setText(String.valueOf(game.get(position)));
                    game.set(position, 0);
                    gameButtons[position].setText("");
                }
                else if(game.get(8) == 0) {
                    game.set(8, game.get(position));
                    gameButtons[8].setText(String.valueOf(game.get(position)));
                    game.set(position, 0);
                    gameButtons[position].setText("");
                }
                else
                    Toast.makeText(ThreeByThree.this, "Touch the tile next to the empty space", Toast.LENGTH_LONG).show();
                break;
            case 6:
                if(game.get(3) == 0) {
                    game.set(3, game.get(position));
                    gameButtons[3].setText(String.valueOf(game.get(position)));
                    game.set(position, 0);
                    gameButtons[position].setText("");
                }
                else if(game.get(7) == 0) {
                    game.set(7, game.get(position));
                    gameButtons[7].setText(String.valueOf(game.get(position)));
                    game.set(position, 0);
                    gameButtons[position].setText("");
                }
                else
                    Toast.makeText(ThreeByThree.this, "Touch the tile next to the empty space", Toast.LENGTH_LONG).show();
                break;
            case 7:
                if(game.get(4) == 0) {
                    game.set(4, game.get(position));
                    gameButtons[4].setText(String.valueOf(game.get(position)));
                    game.set(position, 0);
                    gameButtons[position].setText("");
                }
                else if(game.get(6) == 0) {
                    game.set(6, game.get(position));
                    gameButtons[6].setText(String.valueOf(game.get(position)));
                    game.set(position, 0);
                    gameButtons[position].setText("");
                }
                else if(game.get(8) == 0) {
                    game.set(8, game.get(position));
                    gameButtons[8].setText(String.valueOf(game.get(position)));
                    game.set(position, 0);
                    gameButtons[position].setText("");
                }
                else
                    Toast.makeText(ThreeByThree.this, "Touch the tile next to the empty space", Toast.LENGTH_LONG).show();
                break;
            case 8:
                if(game.get(5) == 0) {
                    game.set(5, game.get(position));
                    gameButtons[5].setText(String.valueOf(game.get(position)));
                    game.set(position, 0);
                    gameButtons[position].setText("");
                }
                else if(game.get(7) == 0) {
                    game.set(7, game.get(position));
                    gameButtons[7].setText(String.valueOf(game.get(position)));
                    game.set(position, 0);
                    gameButtons[position].setText("");
                }
                else
                    Toast.makeText(ThreeByThree.this, "Touch the tile next to the empty space", Toast.LENGTH_LONG).show();
                break;
        }
        winGame();
        return;
    }

    private boolean winGame() {
        boolean gameOver = false;
        boolean winCondition = true;
        for (int i = 0; i < game.size() - 1; i++) {
            if (game.get(i) != (i + 1)) {
                winCondition = false;
            }
        }
        if (winCondition){
            showNewGameDialog();
            gameOver = true;
        }
        return gameOver;
    }

    public void showNewGameDialog() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("You Win!!!");
        alert.setMessage("Play again?");
        PlayDialog playAgain = new PlayDialog();
        alert.setPositiveButton("Yes", playAgain);
        alert.setNegativeButton("No",playAgain);
        alert.show();

    }

    private class PlayDialog implements DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialog, int id) {
            if (id == -1) {  // yes
                initializeGame();
                buildGuiByCode();
            } else if (id == -2)  // no
                finish();
        }
    }

    private void initializeGame() {
        /* Create a list of numbers consisting of 0-8 in random order*/
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int i = 0; i < totalTiles; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        this.game = numbers;
    }
}