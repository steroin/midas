package pl.midas.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Hello World!");
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/mainframe/MainFrame.fxml"));
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}
