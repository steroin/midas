package pl.midas.gui.controllers.controls;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;

import java.io.IOException;

public class TextEditor extends ScrollPane {
    public TextEditor() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/controls/TextEditor.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
