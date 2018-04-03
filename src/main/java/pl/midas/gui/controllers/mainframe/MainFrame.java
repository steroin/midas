package pl.midas.gui.controllers.mainframe;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

public class MainFrame {

    @FXML
    private MenuItem menuFileOpen;
    @FXML
    private TextArea mainEditorTextArea;

    public String getText() {
        return mainEditorTextArea.getText();
    }

    public void setText(String text) {
        mainEditorTextArea.setText(text);
    }

    public void openFileChooser() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.showOpenDialog(mainEditorTextArea.getScene().getWindow());
    }


}
