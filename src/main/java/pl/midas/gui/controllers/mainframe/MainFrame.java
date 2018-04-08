package pl.midas.gui.controllers.mainframe;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import pl.midas.core.global.language.TextPlaceholderReader;

import java.io.File;

public class MainFrame {

    @FXML
    private ListView<String> mainEditor;
    @FXML
    private Label filePathLabel;

    public void openFileChooser() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(TextPlaceholderReader.readPlaceholder("editor", "MenuItems.openFileTitle"));
        File file = fileChooser.showOpenDialog(mainEditor.getScene().getWindow());
        filePathLabel.setText(file.getAbsolutePath());
    }
}
