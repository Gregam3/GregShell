package terminal.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.util.LinkedList;

class UIController {
    private Pane root;
    private ObservableList<String> submittedCommands;

    UIController(Pane root) {
        this.root = root;
        submittedCommands = FXCollections.observableList(new LinkedList<String>());
    }

    void setUpInterface() {
        //Refer to TextField with index 0
        root.getChildren().add(UIBuilder.buildCommandInput());

        //Refer to TextField with index 1
        root.getChildren().add(UIBuilder.buildCommandBacklog());
    }

    String getStringFromCommandLine() {
        return ((TextField) root.getChildren().get(0)).getText();
    }

    void addCommandToList(String command) {
        submittedCommands.add(command);
        ((TextField) root.getChildren().get(0)).setText("");
        ((ListView)root.getChildren().get(1)).setItems(submittedCommands);
    }
}
