package co.il.rokait.ttt_web_version.service;

import lombok.ToString;

@ToString
public class CellWrapper {
    static int movesCounter;

    public CellWrapper() {
        movesCounter++;
    }

    public int row;
    public int col;
}
