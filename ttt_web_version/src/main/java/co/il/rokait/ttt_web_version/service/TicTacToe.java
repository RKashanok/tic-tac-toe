package co.il.rokait.ttt_web_version.service;

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


    private static Map<String, char[][]> boards = new HashMap();


//    public static void main(String[] args) {
//        int boardSize = 3;
//        char[][] board = createBoard(boardSize);
//        printBoard(board);
//        boolean emptyCellsExists = checkIsEmptyCellsExists(board);
//
//        while (getGameState(board) == pending && emptyCellsExists) {
//            humanMove(board);
//            printBoard(board);
//            int status = getGameState(board);
//            if (status == 0) {
//                pcMove(board);
//                printBoard(board);
//            }
//            status = getGameState(board);
//            if (status > 0) {
//                if (status == 1) {
//                    System.out.println("It was a contest of two equal!");
//                } else if (status == 2) {
//                    System.out.println("Iron brain sucks!");
//                } else {
//                    System.out.println("Meat bag looooOooooOOoOse :) ");
//                }
//            }
//        }
//    }

    public static char[][] getBoard(String username) {
        return boards.computeIfAbsent(username, k -> createBoard(3));
    }

    public static boolean isValidMove(CellWrapper cell, char[][] board) {
        return getGameState(board) == pending && checkIsEmptyCellsExists(board) && board[cell.row][cell.col] == emptyCell;
    }

//    private static void pcMove(char[][] board) {
//        List<CellWrapper> emptyCells = new ArrayList<>();
//
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[i].length; j++) {
//                if (board[i][j] == emptyCell) {
//                    CellWrapper cw = new CellWrapper();
//                    cw.row = i;
//                    cw.col = j;
//                    emptyCells.add(cw);
//                }
//            }
//        }
//        CellWrapper point = emptyCells.get(random.nextInt(emptyCells.size()));
//        board[point.row][point.col] = pcCell;
//    }

    public static CellWrapper getRandomFreePoint(char[][] board) {
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
        return emptyCells.get(random.nextInt(emptyCells.size()));
    }

    public static int getGameState(char[][] board) {
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

    public static void humanMove(char[][] board, CellWrapper cell) {
        board[cell.row][cell.col] = humanCell;
    }

    public static boolean checkIsEmptyCellsExists(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == emptyCell) {
                    return true;
                }
            }
        }
        return false;
    }

    public static char[][] createBoard(int boardSize) {
        char[][] board = new char[boardSize][boardSize];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], emptyCell);
        }
        return board;
    }

//    public static void printBoard(char[][] board) {
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[i].length; j++) {
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }
}
