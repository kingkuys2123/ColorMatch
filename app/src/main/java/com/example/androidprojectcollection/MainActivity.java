package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnReturn, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    int[][] colors = new int[3][3];
    boolean gameEnd = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "Color Matching Game\nQuitco, Kyle Matthew M.\nBSIT - 2 \nCSIT 284 - G4", Toast.LENGTH_LONG).show();

        initBtns();
        randomBtns();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!gameEnd) {
                    changeColor(0, 0);
                    gameWin();
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!gameEnd) {
                    changeColor(0, 1);
                    gameWin();
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!gameEnd) {
                    changeColor(0, 2);
                    gameWin();
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!gameEnd) {
                    changeColor(1, 0);
                    gameWin();
                }
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!gameEnd) {
                    changeColor(1, 1);
                    gameWin();
                }
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!gameEnd) {
                    changeColor(1, 2);
                    gameWin();
                }
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!gameEnd) {
                    changeColor(2, 0);
                    gameWin();
                }
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!gameEnd) {
                    changeColor(2, 1);
                    gameWin();
                }
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!gameEnd) {
                    changeColor(2, 2);
                    gameWin();
                }
            }
        });

        btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameEnd = false; // Reset game state
                randomBtns();
                enableBtns();
            }
        });
    }

    private void initBtns() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
    }

    private void disableBtns(){
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);
    }

    private void enableBtns(){
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
        btn8.setEnabled(true);
        btn9.setEnabled(true);
    }

    private void randomBtns() {
        Random random = new Random();

        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors[i].length; j++) {
                int n = random.nextInt(3);

                switch (n) {
                    case 0:
                        colors[i][j] = Color.RED;
                        break;
                    case 1:
                        colors[i][j] = Color.GREEN;
                        break;
                    case 2:
                        colors[i][j] = Color.BLUE;
                        break;
                    default:
                        colors[i][j] = Color.RED;
                }
            }
        }
        updateBtns();
    }

    private void updateBtns() {
        btn1.setBackgroundColor(colors[0][0]);
        btn2.setBackgroundColor(colors[0][1]);
        btn3.setBackgroundColor(colors[0][2]);
        btn4.setBackgroundColor(colors[1][0]);
        btn5.setBackgroundColor(colors[1][1]);
        btn6.setBackgroundColor(colors[1][2]);
        btn7.setBackgroundColor(colors[2][0]);
        btn8.setBackgroundColor(colors[2][1]);
        btn9.setBackgroundColor(colors[2][2]);
    }

    private void changeColor(int row, int col) {
        int currentColor = colors[row][col];
        colors[row][col] = nextColor(currentColor);

        if (row > 0)
            colors[row - 1][col] = nextColor(colors[row - 1][col]);
        if (row < 2)
            colors[row + 1][col] = nextColor(colors[row + 1][col]);
        if (col > 0)
            colors[row][col - 1] = nextColor(colors[row][col - 1]);
        if (col < 2)
            colors[row][col + 1] = nextColor(colors[row][col + 1]);

        updateBtns();
    }

    private int nextColor(int currentColor) {
        switch (currentColor) {
            case Color.RED:
                return Color.GREEN;
            case Color.GREEN:
                return Color.BLUE;
            case Color.BLUE:
                return Color.RED;
            default:
                return Color.RED;
        }
    }

    private void gameWin() {
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors[i].length; j++) {
                if (colors[i][j] != Color.GREEN) {
                    return;
                }
            }
        }

        gameEnd = true;
        disableBtns();

        Toast.makeText(this, "You won! All green colors matched!\nThanks for playing! :)", Toast.LENGTH_SHORT).show();
    }
}