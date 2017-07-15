package terminal.ui;

import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import terminal.Main;

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


        return labelListView;
    }

    static TextField buildCommandInput() {
        TextField textField = new TextField();

        textField.setPrefWidth(Main.WIDTH);
        textField.setPrefHeight(50);
        textField.setLayoutX(0);
        textField.setLayoutY((Main.HEIGHT - (Main.HEIGHT / 9)));
        textField.setCursor(Cursor.DEFAULT);

        Font font = Font.font("Perfect DOS VGA 437 Win",14);
        textField.setFont(font);

        return textField;
    }
}
