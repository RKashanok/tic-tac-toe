package co.il.rokait.ttt_web_version.model;

import co.il.rokait.ttt_web_version.service.CellWrapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class StepResponse {
    char[][] board;
    String error = null;
    boolean isWinner;
    boolean isDraw;
    char currentPlayer;
    CellWrapper point;

    public StepResponse(String error) {
        this.error = error;
    }

    public StepResponse(char[][] board, boolean isWinner, boolean isDraw, char currentPlayer, CellWrapper point) {
        this.board = board;
        this.isWinner = isWinner;
        this.isDraw = isDraw;
        this.currentPlayer = currentPlayer;
        this.point = point;
    }
}
