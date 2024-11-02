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

public class BoardImpl implements Board {
    private final Piece[][] board;

    public BoardImpl() {
        board = new Piece[3][3];
        resetBoard();
    }

    @Override
    public boolean isLegalMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == Piece.EMPTY;
    }

    @Override
    public void updateMove(int row, int col, Piece piece) {
        if (isLegalMove(row, col)) {
            board[row][col] = piece;
        }
    }

    @Override
    public Piece checkWinner() {
        // Check rows and columns for a win
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != Piece.EMPTY && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return board[i][0];  // Row win
            }
            if (board[0][i] != Piece.EMPTY && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return board[0][i];  // Column win
            }
        }

        // Check diagonals for a win
        if (board[0][0] != Piece.EMPTY && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0];  // Left-to-right diagonal
        }
        if (board[0][2] != Piece.EMPTY && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][2];  // Right-to-left diagonal
        }

        // No winner yet
        return null;
    }

    @Override
    public void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Piece.EMPTY;
            }
        }
    }

    @Override
    public Piece[][] getBoard() {
        return board;
    }

    @Override
    public Piece getPiece(int row, int col) {
        return board[row][col];
    }

    @Override
    public void setPiece(int row, int col, Piece piece) {
        board[row][col] = piece;
    }

    public boolean isFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == Piece.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    // New method to check if a specific piece has won
    public boolean checkWin(Piece piece) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == piece && board[i][1] == piece && board[i][2] == piece) || // Row
                    (board[0][i] == piece && board[1][i] == piece && board[2][i] == piece)) { // Column
                return true;
            }
        }

        // Check diagonals
        if ((board[0][0] == piece && board[1][1] == piece && board[2][2] == piece) || // Left-to-right diagonal
                (board[0][2] == piece && board[1][1] == piece && board[2][0] == piece)) { // Right-to-left diagonal
            return true;
        }

        return false;
    }
}
