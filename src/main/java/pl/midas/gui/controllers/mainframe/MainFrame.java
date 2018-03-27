package pl.midas.gui.controllers.mainframe;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class MainFrame {

    @FXML
    private TextArea mainEditorTextArea;

    public String getText() {
        return mainEditorTextArea.getText();
    }

    public void setText(String text) {
        mainEditorTextArea.setText(text);
    }



}
