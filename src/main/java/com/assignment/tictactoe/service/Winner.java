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

public class Winner {
    public static Piece checkWinner(Piece[][] board) {
        // Check rows for a winner
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == board[row][1] && board[row][1] == board[row][2] && board[row][0] != Piece.EMPTY) {
                return board[row][0];
            }
        }

        // Check columns for a winner
        for (int col = 0; col < 3; col++) {
            if (board[0][col] == board[1][col] && board[1][col] == board[2][col] && board[0][col] != Piece.EMPTY) {
                return board[0][col];
            }
        }

        // Check diagonals for a winner
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != Piece.EMPTY) {
            return board[0][0];
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != Piece.EMPTY) {
            return board[0][2];
        }

        return Piece.EMPTY;
    }

    public static boolean isDraw(Piece[][] board) {
        for (Piece[] row : board) {
            for (Piece cell : row) {
                if (cell == Piece.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
