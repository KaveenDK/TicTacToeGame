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

public abstract class Player {
    protected BoardImpl board;
    protected Piece piece;

    public Player(BoardImpl board, Piece piece) {
        this.board = board;
        this.piece = piece;
    }

    // Abstract method for getting a move
    public abstract int[] getMove();
}
