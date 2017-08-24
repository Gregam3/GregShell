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
    private static final Double VERSION_NUMBER = 1.0;
    public static final String NAME = "Greg";

    @Override
    public void start(Stage primaryStage) throws Exception {
        long startTime = System.currentTimeMillis();

        Pane root = new Pane();

        primaryStage.getIcons().add(
                new Image("file:C:/Users/i7676925/IdeaProjects/GregShell/src/main/resources/icon.png")
        );
        //Changed to absolute path as I can't deal with this rn

        root.getStylesheets().add(getClass().getResource("/stylesheet.css").toExternalForm());

        UIController.setUpInterface(root);

        configureStage(primaryStage, root, startTime);

        Console.setupCommands();

    }

    private void configureStage(Stage primaryStage, Pane root, long startTime) {
        primaryStage = addKeyEventsToStage(primaryStage);

        primaryStage.setTitle(NAME + "Shell - BETA " + VERSION_NUMBER);
        primaryStage.setScene(new Scene(root, WIDTH, HEIGHT, Paint.valueOf("black")));

        primaryStage.setMaxHeight(HEIGHT);
        primaryStage.setMaxHeight(WIDTH);

//        primaryStage.setResizable(false);

        UIController.showOpeningMessage(startTime);

        primaryStage.show();
    }

    private Stage addKeyEventsToStage(Stage primaryStage) {
        primaryStage.addEventHandler(KeyEvent.KEY_RELEASED, (key) -> {
            switch (key.getCode()) {
                case ENTER:
                    String command = UIController.getStringFromCommandLine();
                    try {
                        UIController.addToTerminal(command);
                        Console.submitCommand(command);
                    } catch (Exception e) {
                        UIController.addToTerminal("There was an error during the execution of this command - "
                                + e.getClass().getSimpleName() + ": " + e.getMessage());
                        e.printStackTrace();
                    }
                    break;

                case UP:
                    UIController.setUserInputText(Console.getPreviousCommand());
                    break;

                case DOWN:
                    UIController.setUserInputText(Console.getNextCommand());
                    break;
            }
        });

        return primaryStage;
    }

    public static void main(String[] args) {
        launch();
    }
}
