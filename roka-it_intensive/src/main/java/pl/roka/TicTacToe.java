package pl.roka;

import java.util.*;

public class TicTacToe {

    private static final Scanner sc = new Scanner(System.in);
    private static final Random random = new Random();
    private static final Character emptyCell = '_';
    private static final Character humanCell = 'X';
    private static final Character pcCell = 'O';
    private static final int pending = 0;
    private static final int draw = 1;
    private static final int humanWin = 2;
    private static final int pcWin = 3;

    public static void main(String[] args) {
        int boardSize = 3;
        Character[][] board = createBoard(boardSize);
        printBoard(board);
        boolean emptyCellsExists = checkIsEmptyCellsExists(board);

        while (getGameState(board) == pending && emptyCellsExists) {
            humanMove(board);
            printBoard(board);
            int status = getGameState(board);
            if (status == 0) {
                pcMove(board);
                printBoard(board);
            }
            status = getGameState(board);
            if (status > 0) {
                if (status == 1) {
                    System.out.println("It was a contest of two equal!");
                } else if (status == 2) {
                    System.out.println("Iron brain sucks!");
                } else {
                    System.out.println("Meat bag looooOooooOOoOse :) ");
                }
            }
        }
    }

    private static void pcMove(Character[][] board) {
        List<CellWrapper> emptyCells = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == emptyCell) {
                    CellWrapper cw = new CellWrapper();
                    cw.row = i;
                    cw.col = j;
                    emptyCells.add(cw);
                }
            }
        }
        CellWrapper point = emptyCells.get(random.nextInt(emptyCells.size()));
        board[point.row][point.col] = pcCell;
    }

    private static int getGameState(Character[][] board) {
        // All horizontals check
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != emptyCell) {
                char winner = board[i][0];
                if (winner == humanCell) {
                    return humanWin;
                } else if (winner == pcCell) {
                    return pcWin;
                }
            }
        }

        // All verticals check
        for (int i = 0; i < board.length; i++) {
            if (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] != emptyCell) {
                char winner = board[0][i];
                if (winner == humanCell) {
                    return humanWin;
                } else if (winner == pcCell) {
                    return pcWin;
                }
            }
        }

        // All diagonals check
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[1][1] != emptyCell) {
            char winner = board[0][0];
            if (winner == humanCell) {
                return humanWin;
            } else if (winner == pcCell) {
                return pcWin;
            }
        }
        if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[1][1] != emptyCell) {
            char winner = board[0][2];
            if (winner == humanCell) {
                return humanWin;
            } else if (winner == pcCell) {
                return pcWin;
            }
        }

        return pending;
    }

    private static void humanMove(Character[][] board) {
        int row = enterRow();
        int col = enterCol();
        while (board[row][col] != emptyCell) {
            row = enterRow();
            col = enterCol();
        }
        board[row][col] = humanCell;
    }

    private static int enterRow() {
        System.out.println("Enter row: ");
        return sc.nextInt();
    }

    private static int enterCol() {
        System.out.println("Enter column: ");
        return sc.nextInt();
    }

    public static boolean checkIsEmptyCellsExists(Character[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == emptyCell) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Character[][] createBoard(int boardSize) {
        Character[][] board = new Character[boardSize][boardSize];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], emptyCell);
        }
        return board;
    }

    public static void printBoard(Character[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
