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

public interface Board {
    boolean isLegalMove(int row, int col);
    void updateMove(int row, int col, Piece piece);
    Piece checkWinner();
    void resetBoard();
    Piece[][] getBoard();

    // Additional methods needed by AiPlayer
    Piece getPiece(int row, int col);
    void setPiece(int row, int col, Piece piece);
}
