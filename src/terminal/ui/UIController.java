package terminal.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.util.LinkedList;

public class UIController {
    private static Pane root;
    private static ObservableList<String> submittedCommands;


    public static void setUpInterface(Pane newRoot) {
        root = newRoot;
        submittedCommands = FXCollections.observableList(new LinkedList<String>());

        //Refer to TextField with index 0
        root.getChildren().add(UIBuilder.buildCommandInput());

        //Refer to TextField with index 1
        root.getChildren().add(UIBuilder.buildCommandBacklog());
    }

    public static String getStringFromCommandLine() {
        return ((TextField) root.getChildren().get(0)).getText();
    }

    public static ObservableList<String> getSubmittedCommands() {
        return submittedCommands;
    }

    public static void addToTerminal(String command) {
        submittedCommands.add(command);
        ((TextField) root.getChildren().get(0)).setText("");
        ((ListView)root.getChildren().get(1)).setItems(submittedCommands);
    }

    public static void clearCommands() {
        submittedCommands.clear();
    }
}
