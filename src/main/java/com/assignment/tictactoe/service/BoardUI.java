package com.assignment.tictactoe.service;

/**
 * --------------------------------------------
 * Author: Dimantha Kaveen
 * GitHub: https://github.com/KaveenDK
 * Website: https://www.youtube.com/@KaviYa_69
 * --------------------------------------------
 * Project: TicTacToe
 * --------------------------------------------
 **/

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class BoardUI {
    private final GridPane boardGrid;
    private final Button[][] buttons;

    public BoardUI(GridPane boardGrid) {
        this.boardGrid = boardGrid;
        this.buttons = new Button[3][3];

        // Initialize buttons from GridPane
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = (Button) boardGrid.getChildren().get(row * 3 + col);
            }
        }
    }

    public void updateButton(int row, int col, Piece piece) {
        buttons[row][col].setText(piece == Piece.X ? "X" : "O");
    }

    public void disableAllButtons() {
        for (Button[] row : buttons) {
            for (Button button : row) {
                button.setDisable(true);
            }
        }
    }

    public void resetUI() {
        for (Button[] row : buttons) {
            for (Button button : row) {
                button.setText("");
                button.setDisable(false);
            }
        }
    }
}
