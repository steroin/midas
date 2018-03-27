package pl.midas.core.editor;

public class CursorPosition {
    private int row;
    private int column;

    private CursorPosition(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public static CursorPosition of(int row, int column) {
        return new CursorPosition(row, column);
    }
}
