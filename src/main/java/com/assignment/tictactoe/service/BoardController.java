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

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

public class BoardController {

    @FXML
    private Button btnExit;

    @FXML
    private Button btnRestart;

    @FXML
    private Button button00;

    @FXML
    private Button button01;

    @FXML
    private Button button02;

    @FXML
    private Button button10;

    @FXML
    private Button button11;

    @FXML
    private Button button12;

    @FXML
    private Button button20;

    @FXML
    private Button button21;

    @FXML
    private Button button22;

    @FXML
    private GridPane gridPane;

    @FXML
    private VBox mainLayout;

    private BoardImpl board;
    private AiPlayer aiPlayer;
    private boolean isPlayerXTurn = true;
    private boolean gameOver = false;

    public BoardController() {
    }

    public void initialize(BoardImpl board, AiPlayer aiPlayer, VBox root) {
        this.board = board;
        this.aiPlayer = aiPlayer;
        resetGame();
    }

    private void aiMove() {
        if (gameOver) return;

        int[] move = aiPlayer.getMove();
        if (move != null && move[0] != -1) {
            board.setPiece(move[0], move[1], aiPlayer.getPiece());

            for (Button button : gridPane.getChildren().filtered(node -> node instanceof Button).stream().map(Button.class::cast).toList()) {
                int row = GridPane.getRowIndex(button);
                int col = GridPane.getColumnIndex(button);
                if (row == move[0] && col == move[1]) {
                    button.setText("O");
                    break;
                }
            }
            isPlayerXTurn = true;
            checkForWinner();
        }
    }

    @FXML
    public void onCellClicked(ActionEvent event) {
        if (gameOver || !isPlayerXTurn) return;

        Button button = (Button) event.getSource();
        int row = GridPane.getRowIndex(button);
        int col = GridPane.getColumnIndex(button);

        if (board.getPiece(row, col) == Piece.EMPTY) {
            board.setPiece(row, col, Piece.X);
            button.setText("X");
            isPlayerXTurn = false;
            checkForWinner();

            if (!gameOver) {
                aiMove();
            }
        }
    }

    private void checkForWinner() {
        Piece winner = board.checkWinner();
        if (winner != null) {
            if (winner == Piece.X) {
                showAlert("You win!");
            } else if (winner == Piece.O) {
                showAlert("AI Player wins!");
            }
            gameOver = true;
        } else if (board.isFull()) {
            showAlert("It's a draw!");
            gameOver = true;
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void onRestartClicked() {
        resetGame();
    }

    @FXML
    private void onExitClicked() {
        Stage stage = (Stage) gridPane.getScene().getWindow();
        stage.close();
    }

    private void resetGame() {
        board.resetBoard();
        isPlayerXTurn = true;
        gameOver = false;

        for (Button button : gridPane.getChildren().filtered(node -> node instanceof Button).stream().map(Button.class::cast).toList()) {
            button.setText("");
        }
    }
}