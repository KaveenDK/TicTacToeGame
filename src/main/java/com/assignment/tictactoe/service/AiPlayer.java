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

public class AiPlayer extends Player {
    private Piece opponentPiece;

    public AiPlayer(BoardImpl board, Piece aiPiece, Piece opponentPiece) {
        super(board, aiPiece);
        this.opponentPiece = opponentPiece;
    }

    @Override
    public int[] getMove() {
        return getBestMove();
    }

    public Piece getPiece() {
        return this.piece;
    }

    private int[] getBestMove() {
        int bestScore = Integer.MIN_VALUE;
        int[] bestMove = {-1, -1};

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board.getPiece(row, col) == Piece.EMPTY) {  // Check if cell is empty
                    board.setPiece(row, col, piece);  // Make a temporary move
                    int score = minimax(board, 0, false);  // Call minimax
                    board.setPiece(row, col, Piece.EMPTY);  // Undo the move

                    // Update the best score and best move if a better score is found
                    if (score > bestScore) {
                        bestScore = score;
                        bestMove = new int[]{row, col};
                    }
                }
            }
        }
        return bestMove;
    }

    private int minimax(BoardImpl board, int depth, boolean isMaximizing) {
        if (board.checkWin(piece)) return 10 - depth;            // AI wins
        if (board.checkWin(opponentPiece)) return depth - 10;    // Opponent wins
        if (board.isFull()) return 0;                            // Draw

        int bestScore = isMaximizing ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        Piece currentPiece = isMaximizing ? piece : opponentPiece;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board.getPiece(row, col) == Piece.EMPTY) {  // Only evaluate empty cells
                    board.setPiece(row, col, currentPiece);     // Make a temporary move
                    int score = minimax(board, depth + 1, !isMaximizing); // Recursive call
                    board.setPiece(row, col, Piece.EMPTY);      // Undo the move

                    if (isMaximizing) {
                        bestScore = Math.max(score, bestScore);
                    } else {
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
        }
        return bestScore;
    }
}
