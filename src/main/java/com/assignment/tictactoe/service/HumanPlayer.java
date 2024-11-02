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

public class HumanPlayer extends Player {
    public HumanPlayer(BoardImpl board, Piece piece) {
        super(board, piece);
    }

    @Override
    public int[] getMove() {
        return new int[0]; // Placeholder for human move logic from the UI
    }
}
