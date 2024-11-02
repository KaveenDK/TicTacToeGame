package com.assignment.tictactoe;

/**
 * --------------------------------------------
 * Author: Dimantha Kaveen
 * GitHub: https://github.com/KaveenDK
 * Website: https://www.youtube.com/@KaviYa_69
 * --------------------------------------------
 * Project: TicTacToe
 * --------------------------------------------
 **/

import com.assignment.tictactoe.service.AiPlayer;
import com.assignment.tictactoe.service.BoardController;
import com.assignment.tictactoe.service.BoardImpl;
import com.assignment.tictactoe.service.Piece;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/tictactoe.fxml"));
        VBox root = loader.load();

        BoardImpl board = new BoardImpl();
        AiPlayer aiPlayer = new AiPlayer(board, Piece.O, Piece.X);

        BoardController controller = loader.getController();
        controller.initialize(board, aiPlayer, root);

        Image logo = new Image(getClass().getResourceAsStream("/images/app_logo.png"));
        stage.getIcons().add(logo);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("TicTacToe Game");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}