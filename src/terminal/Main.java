package terminal;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import terminal.functionality.Console;
import terminal.ui.UIController;

public class Main extends Application {

    @SuppressWarnings("converted")
    public static int WIDTH = 650;
    public static int HEIGHT = 330;
    public static Double VERSION_NUMBER = 1.0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Console.setupCommands();
        Pane root = new Pane();

        primaryStage.getIcons().add(
                new Image("file:src\\resources\\icon.png")
        );

        root.getStylesheets().add(getClass().getResource("ui\\stylesheet.css").toExternalForm());

        UIController.setUpInterface(root);


        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if (key.getCode() == KeyCode.ENTER) {
                String command = UIController.getStringFromCommandLine();
                UIController.addToTerminal(command);
                Console.submitCommand(command);
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
