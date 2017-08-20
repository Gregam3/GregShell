package terminal.ui;

import javafx.application.Platform;
import javafx.geometry.Orientation;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import terminal.Main;

import java.util.Objects;

/**
 * Created by i7676925 on 04/07/2017.
 */
class UIBuilder {
    static ListView buildCommandBacklog() {
        ListView<Label> labelListView = new ListView<>();

        labelListView.setPrefSize(Main.WIDTH, Main.HEIGHT - (Main.HEIGHT / 10));
        labelListView.setLayoutX(0);
        labelListView.setLayoutY(0);

        labelListView.setFocusTraversable(false);

        //Auto scroll code from https://gist.github.com/dulanov/0759af6bf62d354028d8
        Platform.runLater(() ->
                labelListView.lookupAll(".scroll-bar").stream()
                        .filter(br -> Objects.equals(Orientation.VERTICAL, ((ScrollBar) br).getOrientation()))
                        .findFirst().ifPresent(br ->
                        br.visibleProperty().addListener((observable, oldValue, newValue) ->
                                labelListView.scrollTo(newValue ? Integer.MAX_VALUE : 0))));

        return labelListView;
    }

    static TextField buildCommandInput() {
        TextField textField = new TextField();

        textField.setPrefWidth(Main.WIDTH);
        textField.setPrefHeight(50);
        textField.setLayoutX(0);
        textField.setLayoutY((Main.HEIGHT - (Main.HEIGHT / 9)));
        textField.setCursor(Cursor.DEFAULT);

        Font font = Font.font("Perfect DOS VGA 437 Win", 14);
        textField.setFont(font);

        return textField;
    }
}
