package co.il.rokait.ttt_web_version.controllers;

import co.il.rokait.ttt_web_version.model.StepResponse;
import co.il.rokait.ttt_web_version.service.CellWrapper;
import org.springframework.web.bind.annotation.*;

import static co.il.rokait.ttt_web_version.service.TicTacToe.*;

@RestController
public class ActionController {

    public static final char player = 'X';
    public static final char pc = 'O';


    @PostMapping("/player")
    public StepResponse player(@RequestBody CellWrapper cell,
                               @RequestHeader (value = "username", defaultValue = "anonymus") String username) {
        char[][] board = getBoard(username);
        if (isValidMove(cell, board)) {
            humanMove(board, cell);
            int status = getGameState(board);
            if (status > 0) {
                if (status == 1) {
                    return new StepResponse(board, false, true, '_', cell);
                } else if (status == 2) {
                    return new StepResponse(board, true, false, player, cell);
                } else {
                    StepResponse stepResponse = new StepResponse(board, false, false, player, cell);
                    stepResponse.setError("Error processing step: " + cell);
                    return stepResponse;
                }
            }
            return new StepResponse(board, false, false, player, cell);
        } else {
            return new StepResponse("Don't try to full me, pack of bones!!! You move: " + cell);
        }
    }

    @GetMapping("/pc")
    public StepResponse pc(@RequestHeader (value = "username", defaultValue = "anonymus") String username) {
        char[][] board = getBoard(username);
        if(getGameState(board) == 0 && checkIsEmptyCellsExists(board)) {
            CellWrapper cell = getRandomFreePoint(board);
            board[cell.row][cell.col] = pc;
            int status = getGameState(board);
            if (status > 0) {
                if (status == 1) {
                    return new StepResponse(board, false, true, '_', cell);
                } else if (status == 2) {
                    return new StepResponse(board, true, false, pc, cell);
                } else {
                    return new StepResponse("Error processing step: " + cell);
                }
            }
            return new StepResponse(board, false, false, pc, cell);
        } else {
            return new StepResponse("Don't try to full me, AI sublimation!!!");
        }
    }

}
