package pl.midas.core.editor.model;

import pl.midas.core.editor.CursorPosition;

public class Editor {
    private int totalRows;
    private CursorPosition cursorPosition;

    public Editor(int rows) {
        totalRows = rows;
        cursorPosition = CursorPosition.of(0, 0);
    }

    public int getTotalRows() {
        return totalRows;
    }

    public CursorPosition getCursorPosition() {
        return cursorPosition;
    }

    public void setCursorPosition(CursorPosition cursorPosition) {
        this.cursorPosition = cursorPosition;
    }
}
