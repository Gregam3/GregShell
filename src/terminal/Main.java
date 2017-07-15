package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application {

    @SuppressWarnings("converted")
    static int WIDTH = 650;
    static int HEIGHT = 330;
    private static Double VERSION_NUMBER = 1.0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Console console = new Console();
        Pane root = new Pane();

        primaryStage.getIcons().add(
                new Image("file:src\\resources\\icon.png")
        );

        root.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());

        UIController uiController = new UIController(root);
        uiController.setUpInterface();


        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if (key.getCode() == KeyCode.ENTER) {
                String command = uiController.getStringFromCommandLine();
                uiController.addCommandToList(command);
                console.submitCommand(command);
            }
        });

        primaryStage.setTitle("Greg Shell " + VERSION_NUMBER);
        primaryStage.setScene(new Scene(root, WIDTH, HEIGHT, Paint.valueOf("black")));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
