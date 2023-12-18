package pl.roka;

public class CellWrapper {
    static int movesCounter;

    public CellWrapper() {
        movesCounter++;
    }

    int row;
    int col;
}
